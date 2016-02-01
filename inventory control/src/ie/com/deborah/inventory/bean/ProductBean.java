package ie.com.deborah.inventory.bean;

import ie.com.deborah.inventory.dao.CategoryDAO;
import ie.com.deborah.inventory.dao.ProductDAO;
import ie.com.deborah.inventory.model.Category;
import ie.com.deborah.inventory.model.Product;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

/**
 * @author Deborah Lima
 * @email deborah.infor@gmail.com
 * @since 06/01/2016
 */
@ManagedBean
public class ProductBean {

	private ProductDAO dao = new ProductDAO();
	private CategoryDAO catDao = new CategoryDAO();
	private Product product = new Product();
	
	public Product getProduct() {
		return product;
	}
	
	public String save(){
		dao.persiste(product);
		return "product?faces-redirect=true";
	}
	
	public List<Category> getCategories(){
		return catDao.categories();
	}
	
	public List<Product> getProducts(){
		return dao.products();
	}
	
	public void remove(Product product){
		dao.remove(product);
	}
	
	public void onRowEdit(RowEditEvent event) {
		Product prod = (Product) event.getObject();
		dao.persiste(prod);
        FacesMessage msg = new FacesMessage("Product Edited", ((Product) event.getObject()).getProdName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
    	FacesMessage msg = new FacesMessage("Edit Cancelled", ((Product) event.getObject()).getProdName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
