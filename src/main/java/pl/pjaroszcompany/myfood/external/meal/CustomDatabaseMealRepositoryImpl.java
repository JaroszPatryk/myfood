package pl.pjaroszcompany.myfood.external.meal;

import pl.pjaroszcompany.myfood.products.SearchParams;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomDatabaseMealRepositoryImpl implements CustomDatabaseMealRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MealEntity> findBasedOnSearchParams(SearchParams searchParams) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MealEntity> query = criteriaBuilder.createQuery(MealEntity.class);
        Root<MealEntity> root = query.from(MealEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        if (searchParams.getNameFood() != null) {
            predicates.add(criteriaBuilder.equal(root.get("nameFood"), searchParams.getNameFood()));
        }
        if (searchParams.getProducts() != null) {
            predicates.add(criteriaBuilder.equal(root.get("products"), searchParams.getProducts()));
        }

        query.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }
}
