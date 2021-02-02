package pl.pjaroszcompany.myfood.external.meal;

import pl.pjaroszcompany.myfood.products.SearchParams;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


public class CustomDatabaseMealRepositoryImpl implements CustomDatabaseMealRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MealEntity> findBasedOnSearchParams(SearchParams searchParams) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MealEntity> query = criteriaBuilder.createQuery(MealEntity.class);
        Root<MealEntity> rootFirst = query.from(MealEntity.class);

        query.select(rootFirst);
        List<Predicate> predicates = new ArrayList<>();
        if (searchParams.getNameFood() != null && !searchParams.getNameFood().isEmpty()) {
            predicates.add(criteriaBuilder.equal(rootFirst.get("nameFood"), searchParams.getNameFood()));
        }
        if (searchParams.getProducts() != null && !searchParams.getProducts().isEmpty()) {
            Join<ProductsEntity, MealEntity> products = rootFirst.join("products");
            predicates.add(criteriaBuilder.equal(products.get("nameProduct"), searchParams.getProducts()));
        }

        query.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();

    }
}
