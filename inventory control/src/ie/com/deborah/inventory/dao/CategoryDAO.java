package ie.com.deborah.inventory.dao;

import ie.com.deborah.inventory.model.Category;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * @author Deborah Lima
 * @email deborah.infor@gmail.com
 * @since 06/01/2016
 */
public class CategoryDAO {
	
private EntityManager em = new JPAManager().getEntityManager();
	
	public void persiste(Category category){
		try {

			em.getTransaction().begin();

			if(category.getCatgId() == null){
				em.persist(category);
			}else {
				em.merge(category);
			}
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> categories(){
		
		List<Category> categories = 
				em.createQuery("FROM " + Category.class.getSimpleName()).getResultList();
		return categories;
	}

	public Category getById(Integer id){

		return em.find(Category.class, id);
	}

	public void remove(Category category) {
		
		em.getTransaction().begin();
		em.remove(category);
		em.getTransaction().commit();

	}

}
