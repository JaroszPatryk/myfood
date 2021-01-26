package pl.pjaroszcompany.myfood.products;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pjaroszcompany.myfood.external.meal.MealEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SearchParams {

    private String nameFood;
    private MealEntity products;
    private String howToPrepareMeal;

}
