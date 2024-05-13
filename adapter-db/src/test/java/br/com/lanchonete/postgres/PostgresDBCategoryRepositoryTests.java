package br.com.lanchonete.postgres;

import br.com.lanchonete.exception.category.CategoryFoundException;
import br.com.lanchonete.model.Category;
import br.com.lanchonete.postgres.repository.PostgresDBCategoryRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes={br.com.lanchonete.postgres.TestApplication.class})
public class PostgresDBCategoryRepositoryTests {

    @Autowired
    private PostgresDBCategoryRepository categoryRepository;
    private static EasyRandom easyRandom;

    @BeforeAll
    public static void beforeTests() {
        easyRandom = new EasyRandom();
    }

    @Test
    public void saveTest() throws Exception {
        Category categoryInput = easyRandom.nextObject(Category.class);
        categoryInput.setId(null);

        Category categoryOutput = categoryRepository.save(categoryInput);
        Optional<Category> optionalCategory = categoryRepository.findByName(categoryOutput.getName());
        assertThat(optionalCategory).isPresent();
    }

    @Test
    public void saveExistsCategoryTest() throws Exception {
        Category categoryInput = easyRandom.nextObject(Category.class);
        categoryInput.setId(null);

        Category categoryOutput = categoryRepository.save(categoryInput);
        Optional<Category> optionalCategory = categoryRepository.findByName(categoryOutput.getName());
        assertThat(optionalCategory).isPresent();

        Category categoryExists = easyRandom.nextObject(Category.class);
        categoryExists.setId(null);
        categoryExists.setName(categoryOutput.getName());

        assertThatThrownBy(() -> categoryRepository.save(categoryExists))
                .isInstanceOf(CategoryFoundException.class)
                .hasMessage(String.format("Categoria já existente com base no %s: %s", "name", categoryExists.getName()));

    }

    @Test
    public void existByNameTest() throws Exception {
        Category categoryInput = easyRandom.nextObject(Category.class);
        categoryInput.setId(null);

        Category categoryOutput = categoryRepository.save(categoryInput);
        assertThat(categoryRepository.existsByName(categoryOutput.getName())).isTrue();
        assertThat(categoryRepository.existsByName("msdofjaosdflaksnmd")).isFalse();
    }

    @Test
    public void findAllTest() throws Exception {
        Category categoryInput = easyRandom.nextObject(Category.class);
        categoryInput.setId(null);

        categoryRepository.save(categoryInput);

        assertThat(categoryRepository.findAll()).isNotEmpty();
    }

    @Test
    public void findByNameTest() throws Exception {
        Category categoryInput = easyRandom.nextObject(Category.class);
        categoryInput.setId(null);

        Category categoryOutput = categoryRepository.save(categoryInput);
        assertThat(categoryRepository.findByName(categoryOutput.getName())).isPresent();
        assertThat(categoryRepository.findByName("msdofjaosdflaksnmd")).isNotPresent();
    }

}
