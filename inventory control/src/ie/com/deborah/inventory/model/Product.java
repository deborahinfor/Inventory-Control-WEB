package ie.com.deborah.inventory.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This class representing the product table.
 * @author Deborah Lima
 * @email deborah.infor@gmail
 * @since 25/12/2015
 */
@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "prod_id")
	private Integer prodId;
	
	@Column(name="prod_name")
	private String prodName;
	
	@Column(name="prod_description")
	private String prodDescription;
	
	@Column(name="prod_quantity")
	private Integer prodQuantity;
	
	@Column(name="prod_unitary_value")
	private double prodUnitaryValue;
	
	@Temporal(TemporalType.DATE)
	@Column(name="prod_edition_date")
	private Calendar prodEditionDate = Calendar.getInstance();
	
	@ManyToOne
	@JoinColumn(name="catg_id")
	private Category category;

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDescription() {
		return prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}

	public Integer getProdQuantity() {
		return prodQuantity;
	}

	public void setProdQuantity(Integer prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	public double getProdUnitaryValue() {
		return prodUnitaryValue;
	}

	public void setProdUnitaryValue(double prodUnitaryValue) {
		this.prodUnitaryValue = prodUnitaryValue;
	}

	public Calendar getProdEditionDate() {
		return prodEditionDate;
	}

	public void setProdEditionDate(Calendar prodEditionDate) {
		this.prodEditionDate = prodEditionDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
