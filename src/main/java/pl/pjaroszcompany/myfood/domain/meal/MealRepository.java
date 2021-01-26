package pl.pjaroszcompany.myfood.domain.meal;

import pl.pjaroszcompany.myfood.products.SearchParams;

import java.util.List;
import java.util.Optional;

public interface MealRepository {

    Optional<Meal> findOne(Long id);

    boolean existsByNameFood(String nameFood);

    List<Meal> findAll();

    void create(Meal meal);

    void update(Meal meal);

    void delete(Long id);

    List<Meal> findByParams(SearchParams searchParams);
}
