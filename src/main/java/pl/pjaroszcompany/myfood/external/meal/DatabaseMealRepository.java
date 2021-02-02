package pl.pjaroszcompany.myfood.external.meal;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pjaroszcompany.myfood.domain.meal.Meal;
import pl.pjaroszcompany.myfood.domain.meal.MealRepository;
import pl.pjaroszcompany.myfood.products.SearchParams;

import java.util.*;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
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
        if (!jpaMealRepository.existsById(meal.getId())) {
            throw new IllegalStateException("Updated object not exist");
        }
        jpaMealRepository.save(toEntity(meal));
    }

    @Override
    public void delete(Long id) {
        jpaMealRepository.deleteById(id);
    }

    @Override
    public List<Meal> findByParams(SearchParams searchParams) {
        return jpaMealRepository.findBasedOnSearchParams(searchParams)
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private Meal toDomain(MealEntity entity) {
        List<String> listProduct = new ArrayList<>();
        for (var product:entity.getProducts()) {
            listProduct.add(product.getNameProduct());
        }
        return Meal.builder()
                .id(entity.getId())
                .nameFood(entity.getNameFood())
                .products(listProduct)
                .howToPrepareMeal(entity.getHowToPrepareMeal())
                .build();
    }

    private MealEntity toEntity(Meal meal) {
        return MealEntity.builder()
                .id(meal.getId())
                .nameFood(meal.getNameFood())
                .products(Arrays.stream(meal.getProducts().toArray())
                        .map(p -> ProductsEntity.builder().nameProduct((String) p).build()).collect(Collectors.toList()))
                .howToPrepareMeal(meal.getHowToPrepareMeal())
                .build();
    }
}
