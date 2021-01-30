package pl.pjaroszcompany.myfood.web;

import lombok.AllArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.pjaroszcompany.myfood.domain.meal.MealService;

@Controller
@RequestMapping("mvc/meal")
@AllArgsConstructor
public class MealController {

    private MealService mealService;

    @GetMapping
    ModelAndView displayMealsPage() {
        ModelAndView mav = new ModelAndView("meals.html");
        mav.addObject("meals", mealService.getAll());

        return mav;
    }

}
