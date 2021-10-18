package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product hpFirst = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling");
    private Product hpSecond = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling");
    private Product hpThird = new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling");
    private Product hpFourth = new Book("Harry Potter and the Goblet of Fire", "J. K. Rowling");
    private Product hpFifth = new Book("Harry Potter and the Order of the Phoenix", "J. K. Rowling");
    private Product hpSixth = new Book("Harry Potter and the Half-Blood Prince", "J. K. Rowling");
    private Product hpSeventh = new Book("Harry Potter and the Deathly Hallows", "J. K. Rowling");

    @Test
    void shouldSaveOneProduct() {

        repository.save(hpFirst);
        Product[] expected = new Product[]{hpFirst};
        assertArrayEquals(expected, repository.getProducts());
    }

    @Test
    void findAll() {
        repository.save(hpFirst);
        repository.save(hpSecond);
        repository.save(hpThird);
        repository.save(hpFourth);
        repository.save(hpFifth);
        repository.save(hpSixth);
        repository.save(hpSeventh);

        Product[] expected = new Product[]{hpFirst, hpSecond, hpThird, hpFourth, hpFifth, hpSixth, hpSeventh};
        assertArrayEquals(expected, repository.findAll());
    }
}