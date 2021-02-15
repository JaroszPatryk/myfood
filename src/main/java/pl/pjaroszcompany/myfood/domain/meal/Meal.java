package pl.pjaroszcompany.myfood.domain.meal;

import lombok.*;


import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Meal {

    private Long id;
    @NotBlank(message = "Podaj nazwe posiłku")
    private String nameFood;
    @NotBlank
    private List<String> products;
    @NotBlank(message = "Napisz w jaki sposób przygotować posiłek")
    private String howToPrepareMeal;

}

