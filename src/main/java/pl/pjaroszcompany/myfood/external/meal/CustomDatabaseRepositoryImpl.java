package pl.pjaroszcompany.myfood.external.meal;

import pl.pjaroszcompany.myfood.domain.meal.Meal;
import pl.pjaroszcompany.myfood.search.SearchParam;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomDatabaseRepositoryImpl implements CustomDatabaseMealRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MealEntity> findBasedOnSearchParams(SearchParam searchParam) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MealEntity> query = criteriaBuilder.createQuery(MealEntity.class);
        Root<MealEntity> root = query.from(MealEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        if (searchParam.getNameFood() != null) {
            predicates.add(criteriaBuilder.equal(root.get("nameFood"), searchParam.getNameFood()));
        }
        if (searchParam.getProducts() != null) {
            predicates.add(criteriaBuilder.equal(root.get("products"), searchParam.getProducts()));
        }

        query.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }
}
