package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductRepositoryTest {

    @Test
    void shouldSaveOneProduct() {
        ProductRepository repository = new ProductRepository();
        Product product = new Book("harry potter and the philosopher's stone", "J. K. Rowling");
        repository.save(product);

        Product[] expected = new Product[]{product};
        assertArrayEquals(expected, repository.getProducts());
    }

    @Test
    void findAll() {
        ProductRepository repository = new ProductRepository();
        Product hpFirst = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling");
        Product hpSecond = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling");
        Product hpThird = new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling");
        Product hpFourth = new Book("Harry Potter and the Goblet of Fire", "J. K. Rowling");
        Product hpFifth = new Book("Harry Potter and the Order of the Phoenix", "J. K. Rowling");
        Product hpSixth = new Book("Harry Potter and the Half-Blood Prince", "J. K. Rowling");
        Product hpSeventh = new Book("Harry Potter and the Deathly Hallows", "J. K. Rowling");
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