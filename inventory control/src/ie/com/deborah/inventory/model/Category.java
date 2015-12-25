package ie.com.deborah.inventory.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * This class representing the category table.<br>
 * Category is a classification of Product.
 * @author Deborah Lima
 * @email deborah.infor@gmail
 * @since 25/12/2015
 */
@Entity
public class Category {

	@Id
	@GeneratedValue
	@Column(name = "catg_id")
	private Integer catgId;
	
	@Column(name="catg_name")
	private String catgName;
	
	@OneToMany(mappedBy="category", targetEntity = Product.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Product> products;

	public Integer getCatgId() {
		return catgId;
	}

	public void setCatgId(Integer catgId) {
		this.catgId = catgId;
	}

	public String getCatgName() {
		return catgName;
	}

	public void setCatgName(String catgName) {
		this.catgName = catgName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
