package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager productManager = new ProductManager(repository);
    private Product hpFirst = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling");
    private Product hpSecond = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling");
    private Product hpThird = new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling");
    private Product hpFourth = new Book("Harry Potter and the Goblet of Fire", "J. K. Rowling");
    private Product hpFifth = new Book("Harry Potter and the Order of the Phoenix", "J. K. Rowling");
    private Product hpSixth = new Book("Harry Potter and the Half-Blood Prince", "J. K. Rowling");
    private Product hpSeventh = new Book("Harry Potter and the Deathly Hallows", "J. K. Rowling");
    private Product bookFirst = new Book("Harry Potter and the Deathly Hallows", "J. K. Rowling");
    private Product bookSecond = new Book("Heritage Apples", "Caroline Ball");
    private Product smartphoneFirst = new Smartphone("IPhone 13 Pro", "Apple");
    private Product smartphoneSecond = new Smartphone("Galaxy s21", "Samsung");

    @Test
    void shouldAddProductToEmptyRepository() {
        productManager.add(hpFirst);
        Product[] expected = new Product[]{hpFirst};
        assertArrayEquals(expected, repository.getProducts());
    }

    @Test
    void shouldAddProductToRepositoryWithOtherProducts() {
        repository.save(hpFirst);
        repository.save(hpSecond);
        repository.save(hpThird);
        repository.save(hpFourth);
        repository.save(hpFifth);
        repository.save(hpSixth);

        productManager.add(hpSeventh);

        Product[] expected = new Product[]{hpFirst, hpSecond, hpThird, hpFourth, hpFifth, hpSixth, hpSeventh};
        assertArrayEquals(expected, repository.getProducts());
    }

    @Test
    void shouldSearchByTheEnteredText() {
        productManager.add(bookFirst);
        productManager.add(bookSecond);
        productManager.add(smartphoneFirst);

        Product[] expected = new Product[]{bookSecond, smartphoneFirst};

        assertArrayEquals(expected, productManager.searchBy("Apple"));
    }

    @Test
    void shouldMatches() {
        boolean expected = true;
        assertEquals(expected, productManager.matches(bookFirst, "Potter"));
    }

    @Test
    void shouldFindBookByAuthor() {
        productManager.add(bookFirst);
        productManager.add(bookSecond);

        Product[] expected = new Product[]{bookFirst};
        assertArrayEquals(expected, productManager.searchBy("J. K. Rowling"));

    }

    @Test
    void shouldFindSmartphoneByName() {
        productManager.add(smartphoneFirst);
        productManager.add(smartphoneSecond);

        Product[] expected = new Product[]{smartphoneFirst};
        assertArrayEquals(expected, productManager.searchBy("IPhone 13 Pro"));
    }

    @Test
    void shouldNotFindAnything() {
        productManager.add(smartphoneFirst);
        productManager.add(smartphoneSecond);

        Product[] expected = new Product[0];
        assertArrayEquals(expected, productManager.searchBy("J. K. Rowling"));
    }
}