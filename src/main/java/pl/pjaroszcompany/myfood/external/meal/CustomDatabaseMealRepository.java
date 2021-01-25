package pl.pjaroszcompany.myfood.external.meal;


import pl.pjaroszcompany.myfood.search.SearchParam;

import java.util.List;

public interface CustomDatabaseMealRepository {

    List<MealEntity> findBasedOnSearchParams(SearchParam searchParam);
}
