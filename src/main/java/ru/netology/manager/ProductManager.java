package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void add(Product product) {
        productRepository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] tmp = new Product[productRepository.findAll().length];
        int foundBooksQuantity = 0;

        for (Product product : productRepository.findAll()) {
            if (matches(product, text)) {
                tmp[foundBooksQuantity] = product;
                foundBooksQuantity++;
            }
        }
        Product[] result = new Product[foundBooksQuantity];
        for (int i = 0; i < foundBooksQuantity; i++) {
            result[i] = tmp[i];
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().contains(search) || book.getName().contains(search)) {
                return true;
            }
        } else if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getProducer().contains(search) || smartphone.getName().contains(search)) {
                return true;
            }
        }
        return false;
    }
}