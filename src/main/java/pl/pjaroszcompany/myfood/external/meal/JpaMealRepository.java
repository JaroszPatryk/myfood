package pl.pjaroszcompany.myfood.external.meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.pjaroszcompany.myfood.domain.meal.Meal;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaMealRepository extends JpaRepository<MealEntity, Long>, CustomDatabaseMealRepository {

    Optional<MealEntity> findByNameFood(String nameFood);

    List<MealEntity> findByProducts(ProductsEntity nameProduct);


}
