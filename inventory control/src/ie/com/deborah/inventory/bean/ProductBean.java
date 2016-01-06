package ie.com.deborah.inventory.bean;

import ie.com.deborah.inventory.model.Category;
import ie.com.deborah.inventory.model.Product;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

/**
 * @author Deborah Lima
 * @email deborah.infor@gmail.com
 * @since 06/01/2016
 */
@ManagedBean
public class ProductBean {
	private Product product = new Product();
	
	public Product getProduct() {
		return product;
	}
	
	public String save(){
		return "product?faces-redirect=true";
	}
	
	public List<Category> getCategories(){
		List<Category> categories = new ArrayList<Category>();
		return categories;
	}
	
	public List<Product> getProducts(){
		List<Product> products = new ArrayList<Product>();
		return products;
	}
}
