package ie.com.deborah.inventory.dao;

import ie.com.deborah.inventory.model.Category;
import ie.com.deborah.inventory.model.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This class is responsible for creating the tables in the database, and insert initial data.
 * 
 * @author Deborah Lima
 * @email deborah.infor@gmail
 * @since 25/12/2015
 */
public class SettingsDatabase {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("inventory");
		
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		Category category = addCategory("Pen");
		em.persist(category);
		
		Product coloredPen = addProduct("Package colored pen", "Contains 4 pens in the colors: blue, green, pink and orange.", 
				5, 1.5, parseDate("25/12/2015"), category);
		
		em.persist(coloredPen);
		
		Product fountainPen = addProduct("Fountain pen", "Fountain pen in chromed steel.", 
				4, 25.0, parseDate("25/12/2015"), category);
		
		em.persist(fountainPen);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	private static Category addCategory(String catgName){
		Category category = new Category();
		category.setCatgName(catgName);
		return category;
	}
	
	private static Product addProduct(String prodName, String prodDescription, Integer prodQuantity, double prodUnitaryValue, Calendar prodEditionDate, Category category){

		Product product = new Product();
		product.setProdName(prodName);
		product.setProdDescription(prodDescription);
		product.setProdQuantity(prodQuantity);
		product.setProdUnitaryValue(prodUnitaryValue);
		product.setProdEditionDate(prodEditionDate);
		product.setCategory(category);
		
		return product;
	}
	
	private static Calendar parseDate(String date) {
		try {
			Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dt);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
