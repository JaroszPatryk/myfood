package pl.pjaroszcompany.myfood.domain.meal;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@AllArgsConstructor
@Transactional
public class MealTask {

    private final MealService mealService;

    @Scheduled(cron = "0 19 23 * * ?")
    public void checkMeal(){
        List<Meal> all = mealService.getAll();
        all.forEach(meal -> System.out.println(meal.getNameFood()));
    }

}
