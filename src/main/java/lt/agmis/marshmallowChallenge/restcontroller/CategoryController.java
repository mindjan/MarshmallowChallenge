package lt.agmis.marshmallowChallenge.restcontroller;

import lt.agmis.marshmallowChallenge.domain.Category;
import lt.agmis.marshmallowChallenge.dto.CategoryListWrapper;
import lt.agmis.marshmallowChallenge.dto.CreateResult;
import lt.agmis.marshmallowChallenge.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = {"/categories"})
@Controller 
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

	@RequestMapping(produces = {"application/json"}, method = RequestMethod.GET)
	@ResponseBody
	public CategoryListWrapper getCategories() {
        CategoryListWrapper categoryListDto = new CategoryListWrapper();
        categoryListDto.setCategories(categoryService.getCategories());
		return categoryListDto;
    }

    @RequestMapping(produces = {"application/json"},  method = RequestMethod.POST)
    @ResponseBody
    public CreateResult addCategory(@RequestBody Category category) {
        CreateResult result = new CreateResult();
        result.setSuccess(true);
        result.setId(categoryService.storeCategory(category));
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateCategory(@RequestBody Category category, @PathVariable("id") int id) {
        categoryService.updateCategory(id, category);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);

    }
}
