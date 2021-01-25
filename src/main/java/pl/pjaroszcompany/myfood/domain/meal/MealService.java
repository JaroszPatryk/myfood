package pl.pjaroszcompany.myfood.domain.meal;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pjaroszcompany.myfood.Exception.AlreadyExistException;
import pl.pjaroszcompany.myfood.search.SearchParam;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MealService {


    private final MealRepository mealRepository;

    public void create(Meal meal) {
        if (mealRepository.existsByNameFood(meal.getNameFood())) {
            throw new AlreadyExistException(String.format("Car with vin %s already exists", meal.getNameFood()));
        }

        mealRepository.create(meal);
    }


    public void update(Meal meal) {
        mealRepository.update(meal);
    }


    public Optional<Meal> getMealById(Long id) {
        return mealRepository.findOne(id);
    }

    public List<Meal> getAll() {
        return mealRepository.findAll();
    }

    public void delete(Long id) {
        mealRepository.delete(id);
    }

    public List<Meal> searchByParams(SearchParam searchParam) {
        return mealRepository.findByParams(searchParam);
    }
}
