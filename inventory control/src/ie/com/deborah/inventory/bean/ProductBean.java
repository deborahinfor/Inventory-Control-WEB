package ie.com.deborah.inventory.bean;

import ie.com.deborah.inventory.dao.CategoryDAO;
import ie.com.deborah.inventory.dao.ProductDAO;
import ie.com.deborah.inventory.model.Category;
import ie.com.deborah.inventory.model.Product;

import java.util.List;

import javax.faces.bean.ManagedBean;

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
}
