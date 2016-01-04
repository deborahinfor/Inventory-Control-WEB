/**
 * 
 */
package ie.com.deborah.inventory.bean;

import java.util.ArrayList;
import java.util.List;

import ie.com.deborah.inventory.model.Category;

import javax.faces.bean.ManagedBean;

/**
 * @author Deborah Lima
 * @email deborah.infor@gmail.com
 * @since 28/12/2015
 */
@ManagedBean
public class CategoryBean {
	
	private Category category = new Category();
	
	public Category getCategory(){
		return category;
	}
	
	public String save(){
		return "category?faces-redirect=true";
	}
	
	public List<Category> getCategories(){
		List<Category> categories = new ArrayList<Category>();
		
		return categories;
	}
}
