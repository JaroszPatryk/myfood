package pl.pjaroszcompany.myfood.domain.meal;

import lombok.*;
import pl.pjaroszcompany.myfood.external.meal.ProductsEntity;

import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Meal {

    private Long id;
    @NotBlank(message = "Podaje nazwe posiłku")
    private String nameFood;
    private List<String> products;
    @NotBlank(message = "Napisz w jaki sposób przygotować posiłek")
    private String howToPrepareMeal;

}

