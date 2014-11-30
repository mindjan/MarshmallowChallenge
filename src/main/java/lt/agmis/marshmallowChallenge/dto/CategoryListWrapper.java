package lt.agmis.marshmallowChallenge.dto;

import lt.agmis.marshmallowChallenge.domain.Category;

import java.util.List;

import javax.validation.constraints.NotNull;

public class CategoryListWrapper {
	
	@NotNull
	private List<Category> categories;


    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
