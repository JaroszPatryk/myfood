package pl.pjaroszcompany.myfood.domain.meal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Meal {
    @Setter
    private Long id;
    @NotBlank(message = "Podaje nazwe posiłku")
    private String nameFood;
    @NotBlank(message = "Podaj produkty")
    private String products;
    @NotBlank(message = "Napisz w jaki sposób przygotować posiłek")
    private String howToPrepareMeal;

}
