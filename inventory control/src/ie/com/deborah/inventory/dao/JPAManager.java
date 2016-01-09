package ie.com.deborah.inventory.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * JPA Manager is responsible for get the connection with database and encapsulate the main methods.
 * 
 * @author Deborah Lima
 * @email deborah.infor@gmail.com
 * @since 06/01/2016
 */
public class JPAManager {

	private static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("inventory");
	private static EntityManager entityManager;

	public EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

}
