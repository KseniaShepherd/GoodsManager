package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void shouldAddProductToEmptyRepository() {
        ProductRepository repository = new ProductRepository();
        ProductManager productManager = new ProductManager(repository);
        Product book = new Book("harry potter and the philosopher's stone", "J. K. Rowling");
        productManager.add(book);

        Product[] expected = new Product[]{book};
        assertArrayEquals(expected, repository.getProducts());
    }

    @Test
    void shouldAddProductToRepositoryWithOtherProducts() {
        ProductRepository repository = new ProductRepository();
        Product hpFirst = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling");
        Product hpSecond = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling");
        Product hpThird = new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling");
        Product hpFourth = new Book("Harry Potter and the Goblet of Fire", "J. K. Rowling");
        Product hpFifth = new Book("Harry Potter and the Order of the Phoenix", "J. K. Rowling");
        Product hpSixth = new Book("Harry Potter and the Half-Blood Prince", "J. K. Rowling");
        repository.save(hpFirst);
        repository.save(hpSecond);
        repository.save(hpThird);
        repository.save(hpFourth);
        repository.save(hpFifth);
        repository.save(hpSixth);

        ProductManager productManager = new ProductManager(repository);
        Product hpSeventh = new Book("Harry Potter and the Deathly Hallows", "J. K. Rowling");
        productManager.add(hpSeventh);

        Product[] expected = new Product[]{hpFirst, hpSecond, hpThird, hpFourth, hpFifth, hpSixth, hpSeventh};
        assertArrayEquals(expected, repository.getProducts());
    }

    @Test
    void shouldSearchByTheEnteredText() {
        ProductRepository repository = new ProductRepository();
        ProductManager productManager = new ProductManager(repository);
        Book bookFirst = new Book("Harry Potter and the Deathly Hallows", "J. K. Rowling");
        Book bookSecond = new Book("Heritage Apples", "Caroline Ball");
        Smartphone smartphone = new Smartphone("IPhone 13 Pro", "Apple");

        productManager.add(bookFirst);
        productManager.add(bookSecond);
        productManager.add(smartphone);

        Product[] expected = new Product[]{bookSecond, smartphone};

        assertArrayEquals(expected, productManager.searchBy("Apple"));
    }

    @Test
    void shouldMatches() {
        ProductRepository repository = new ProductRepository();
        ProductManager productManager = new ProductManager(repository);
        Book bookFirst = new Book("Harry Potter and the Deathly Hallows", "J. K. Rowling");
        boolean expected = true;

        assertEquals(expected, productManager.matches(bookFirst, "Potter"));
    }
}