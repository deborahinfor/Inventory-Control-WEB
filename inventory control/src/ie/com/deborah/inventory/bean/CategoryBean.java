package ie.com.deborah.inventory.bean;

import ie.com.deborah.inventory.dao.CategoryDAO;
import ie.com.deborah.inventory.model.Category;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

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
	
	public String remove(Category catg){
		dao.remove(catg);
		return "category?faces-redirect=true";
	}
	
	public void onRowEdit(RowEditEvent event) {
		Category catg = (Category) event.getObject();
		dao.persiste(catg);
        FacesMessage msg = new FacesMessage("Category Edited", ((Category) event.getObject()).getCatgName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
    	FacesMessage msg = new FacesMessage("Edit Cancelled", ((Category) event.getObject()).getCatgName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
