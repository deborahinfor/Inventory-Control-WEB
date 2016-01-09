package ie.com.deborah.inventory.bean;

import ie.com.deborah.inventory.dao.CategoryDAO;
import ie.com.deborah.inventory.model.Category;

import java.util.List;

import javax.faces.bean.ManagedBean;

/**
 * @author Deborah Lima
 * @email deborah.infor@gmail.com
 * @since 28/12/2015
 */
@ManagedBean
public class CategoryBean {
	
	private CategoryDAO dao = new CategoryDAO();
	private Category category = new Category();
	
	public Category getCategory(){
		return category;
	}
	
	public String save(){
		dao.persiste(category);
		return "category?faces-redirect=true";
	}
	
	public List<Category> getCategories(){
		return dao.categories();
	}
}
