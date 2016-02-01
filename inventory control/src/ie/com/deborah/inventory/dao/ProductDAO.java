package ie.com.deborah.inventory.dao;

import ie.com.deborah.inventory.model.Product;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * @author Deborah Lima
 * @email deborah.infor@gmail.com
 * @since 07/01/2016
 */
public class ProductDAO extends JPAManager{
private EntityManager em = new JPAManager().getEntityManager();
	
	public void persiste(Product product){
		try {

			em.getTransaction().begin();

			if(product.getProdId() == null){
				em.persist(product);
			}else {
				em.merge(product);
			}
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> products(){
		
		List<Product> products = 
				em.createQuery("FROM " + Product.class.getSimpleName()).getResultList();
		return products;
	}

	public void remove(Product product){

		em.getTransaction().begin();
		em.remove(product);
		em.getTransaction().commit();

	}
}
