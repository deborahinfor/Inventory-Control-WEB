package ie.com.deborah.inventory.converter;

import ie.com.deborah.inventory.dao.CategoryDAO;
import ie.com.deborah.inventory.model.Category;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * CategoryConverter is a class responsible for converting the value of itemValue of selected item.
 * @author Deborah Lima
 * @email deborah.infor@gmail.com
 * @since 07/01/2016
 */
@FacesConverter(value = "categoryConverter", forClass = Category.class)
public class CategoryConverter implements Converter {
	
	private CategoryDAO categoryDAO = new CategoryDAO();

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string != null && !string.isEmpty()) {
            return categoryDAO.getById(Integer.parseInt(string));
        }
        return null;
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		if(object != null && (object instanceof Category)) {
            return String.valueOf(((Category) object).getCatgId());
        }
        else {
            return null;
        }
	}

}
