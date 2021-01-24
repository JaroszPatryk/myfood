package pl.pjaroszcompany.myfood.external.meal;

import org.springframework.stereotype.Component;
import pl.pjaroszcompany.myfood.domain.meal.Meal;
import pl.pjaroszcompany.myfood.domain.meal.MealRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DatabaseMealRepository implements MealRepository {

    private JpaMealRepository jpaMealRepository;

    @Override
    public Optional<Meal> findOne(Long id) {
        return jpaMealRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public boolean existsByNameFood(String nameFood) {
        return jpaMealRepository.findByNameFood(nameFood).isPresent();
    }

    @Override
    public List<Meal> findAll() {
        return jpaMealRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void create(Meal meal) {
        jpaMealRepository.save(toEntity(meal));
    }

    @Override
    public void update(Meal meal) {
        if (jpaMealRepository.existsById(meal.getId())) {
            throw new IllegalStateException("Updated object not exist");
        }
        jpaMealRepository.save(toEntity(meal));
    }

    @Override
    public void delete(Long id) {
        jpaMealRepository.deleteById(id);
    }

    private Meal toDomain(MealEntity entity) {
        return Meal.builder()
                .id(entity.getId())
                .nameFood(entity.getNameFood())
                .products(entity.getProducts().toString())//sprawdzic
                .howToPrepareMeal(entity.getHowToPrepareMeal())
                .build();
    }

    private MealEntity toEntity(Meal meal) {
        return MealEntity.builder()
                .id(meal.getId())
                .nameFood(meal.getNameFood())
                .products(ProductsEntity.builder().nameProduct(meal.getProducts()).build())//sprawdzic
                .howToPrepareMeal(meal.getHowToPrepareMeal())
                .build();
    }
}
