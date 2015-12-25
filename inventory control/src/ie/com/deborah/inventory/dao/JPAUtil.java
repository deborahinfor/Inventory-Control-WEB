package ie.com.deborah.inventory.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Deborah Lima
 * @email deborah.infor@gmail
 * @since 25/12/2015
 */
public class JPAUtil {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("inventory");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void close(EntityManager em) {
		em.close();
	}
}
