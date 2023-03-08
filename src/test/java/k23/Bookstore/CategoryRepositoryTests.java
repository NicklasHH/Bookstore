package k23.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import k23.Bookstore.domain.Category;
import k23.Bookstore.domain.CategoryRepository;

@DataJpaTest
class CategoryRepositoryTests {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Test
public void findCategory() {
		List<Category> category = categoryRepository.findByName("kategoria1");
		assertThat(category.get(0).getName().equals("kategoria1"));
	}
	
	@Test
	public void saveCategory() {
		Category category = new Category();
		categoryRepository.save(category);
		assertNotEquals(category.getId(),null);
	}
	
	@Test
	public void deleteCategory() {
		List<Category> categories = categoryRepository.findByName("kategoria1");
		Category category = categories.get(0);
		
		categoryRepository.delete(category);

		List<Category> newCategory = categoryRepository.findByName("kategoria1");
		assertThat(newCategory).hasSize(0);
     }
	}

