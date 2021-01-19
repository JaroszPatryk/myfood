package pl.pjaroszcompany.myfood.external.meal;

import org.springframework.stereotype.Component;
import pl.pjaroszcompany.myfood.domain.meal.Meal;
import pl.pjaroszcompany.myfood.domain.meal.MealRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryMealRepository implements MealRepository {

    private List<Meal> meals = new ArrayList<>();
    private Long id = 0L;

    @Override
    public Optional<Meal> findOne(Long id) {
        return meals.stream().filter(meal -> meal.getId().equals(id)).findFirst();
    }

    @Override
    public boolean existsByNameFood(String nameFood) {
        return meals.stream().anyMatch(meal -> meal.getNameFood().equalsIgnoreCase(nameFood));
    }

    @Override
    public List<Meal> findAll() {
        return meals;
    }

    @Override
    public void create(Meal meal) {
        meal.setId(++id);
        meals.add(meal);
    }

    @Override
    public void update(Meal meal) {
        delete(meal.getId());
        meals.add(meal);
    }

    @Override
    public void delete(Long id) {
        meals.removeIf(existingMeal -> existingMeal.getId().equals(id));
    }
}
