package pl.pjaroszcompany.myfood.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.pjaroszcompany.myfood.domain.meal.Meal;
import pl.pjaroszcompany.myfood.domain.meal.MealService;
import pl.pjaroszcompany.myfood.products.SearchParams;

import java.util.Optional;


@Controller
@RequestMapping("mvc/meal")
@AllArgsConstructor
public class MealController {

    private final MealService mealService;

    @GetMapping
    ModelAndView displayMealsPage() {
        ModelAndView mav = new ModelAndView("meals.html");
//        var productResponse = mealService.getAll();
        mav.addObject("meals", mealService.getAll());
        mav.addObject("params", new SearchParams());

        return mav;
    }

    @PostMapping("/search")
    ModelAndView handleMealFiltering(@ModelAttribute("params") SearchParams params) {
        ModelAndView mav = new ModelAndView("meals.html");
        mav.addObject("meals", mealService.searchByParams(params));
        mav.addObject("params", params);

        return mav;
    }

    @GetMapping("/add")
    ModelAndView displayAddMealPage() {
        ModelAndView mav = new ModelAndView("addMeal.html");
        mav.addObject("meal", new Meal());

        return mav;
    }

    @GetMapping("/edit/{id}")
    ModelAndView displayEditMealPage(@PathVariable Long id) {
        Optional<Meal> meal = mealService.getMealById(id);
        ModelAndView mav = new ModelAndView();
        if (meal.isPresent()) {
            mav.addObject("meal", meal.get());
            mav.setViewName("addMeal.html");
        } else {
            mav.addObject("message", String.format("Posiłek z id %d nie istnieje", id));
            mav.setViewName("error.html");
        }
        return mav;
    }

    @GetMapping("/delete/{id}")
    String handleDeleteMeal(@PathVariable Long id) {
        mealService.delete(id);
        return "redirect:/mvc/meal";
    }

    @PostMapping("/addOrEdit")
    String handleAddMeal(@ModelAttribute("meal") Meal meal) {
        if (meal.getId() != null) {
            mealService.update(meal);
        } else {
            mealService.create(meal);
        }
        return "redirect:/mvc/meal";
    }
}
