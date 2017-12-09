package dbexperiment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ProductJpaController {

    private EntityManagerFactory emf = null;

    public ProductJpaController(EntityManagerFactory emf) {

        this.emf = emf;
    }

    public EntityManager getEntityManager() {

        return emf.createEntityManager();
    }

    public List<Product> findProductEntities(boolean all, int maxResults, int firstResult) {

        EntityManager em = getEntityManager();

        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Product.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

}
