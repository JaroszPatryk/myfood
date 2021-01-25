package pl.pjaroszcompany.myfood.external.meal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "meals")
public class MealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 30)
    private String nameFood;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "meals_products")
    private List<ProductsEntity> products;
    @Column(nullable = false)
    private String howToPrepareMeal;
}
