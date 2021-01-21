package pl.pjaroszcompany.myfood.external.meal;

import org.hibernate.annotations.ManyToAny;
import pl.pjaroszcompany.myfood.domain.meal.Meal;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<MealEntity> products;
}
