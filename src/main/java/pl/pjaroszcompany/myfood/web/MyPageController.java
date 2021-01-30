package pl.pjaroszcompany.myfood.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.pjaroszcompany.myfood.domain.meal.Meal;
import pl.pjaroszcompany.myfood.domain.meal.MealService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class MyPageController {

    private MealService mealService;

    @GetMapping("/")
    ModelAndView displayMainPage() {
        List<String> nameFood = mealService.getAll().stream()
                .map(Meal::getNameFood).distinct().collect(Collectors.toList());
        ModelAndView mav = new ModelAndView();
        mav.addObject("date", LocalDate.now().toString());
        mav.addObject("nameFoods", nameFood);
        mav.setViewName("main.html");
        return mav;
    }

}
