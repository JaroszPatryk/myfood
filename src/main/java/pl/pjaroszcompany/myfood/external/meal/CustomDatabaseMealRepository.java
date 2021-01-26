package pl.pjaroszcompany.myfood.external.meal;


import pl.pjaroszcompany.myfood.products.SearchParams;

import java.util.List;

public interface CustomDatabaseMealRepository {

    List<MealEntity> findBasedOnSearchParams(SearchParams searchParams);
}
