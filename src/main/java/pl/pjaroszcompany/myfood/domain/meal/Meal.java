package pl.pjaroszcompany.myfood.domain.meal;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Meal {

    private Long id;
    @NotBlank(message = "Podaje nazwe posiłku")
    private String nameFood;
    @NotBlank(message = "Podaj produkty")
    private String products;
    @NotBlank(message = "Napisz w jaki sposób przygotować posiłek")
    private String howToPrepareMeal;

}

