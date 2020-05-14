package ru.netology.layers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product book1 = new Book(1, "Мастер и Маргарита", 250, "Булгаков");
    private Product book2 = new Book(4, "Java для чайников", 850, "Берд");
    private Product book3 = new Book(3, "Собачье сердце", 150, "Булгаков");
    private Product phone1 = new Smartphone(2, "6T", 25000, "OnePlus");
    private Product phone2 = new Smartphone(5, "test", 25000, "Берд");


    @BeforeEach
    public void manageAdd() {
        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone2);
    }

    @Test
    public void shouldSearchByBook() {
        Product[] actual = manager.searchBy("Булгаков");
        Product[] expected = new Product[]{book1, book3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByPhone() {
        Product[] actual = manager.searchBy("oneplus");
        Product[] expected = new Product[]{phone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByPhoneAndBook() {
        Product[] actual = manager.searchBy("Берд");
        Product[] expected = new Product[]{book2, phone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldStringToString() {
        Product expected = new Book(1, "Мастер и Маргарита", 250, "Булгаков");
        assertEquals(expected, book1);
    }

}