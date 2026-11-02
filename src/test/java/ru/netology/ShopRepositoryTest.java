package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveExistingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Книга", 500);
        Product product2 = new Product(2, "Ручка", 100);
        repository.add(product1);
        repository.add(product2);

        repository.remove(1);

        Product[] expected = {product2};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionWhenProductNotFound() {
        ShopRepository repository = new ShopRepository();
        Product product = new Product(1, "Книга", 500);
        repository.add(product);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.remove(999);
        });
    }
}