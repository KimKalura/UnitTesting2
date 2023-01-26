import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ShoppingCartTest {

    @Test
    void testComputeTotalPrice_ShouldReturnCorrectPrice() throws InvalidPriceException {
        //given
        Product product1 = new Product("lapte", 23);
        Product product2 = new Product("oua", 12);
        Product[] productList = new Product[]{product1, product2};
        ShoppingCart shoppingCart = new ShoppingCart(productList);
        //when
        int result = shoppingCart.computeTotalPrice();
        //then
        assertEquals(35, result);
    }

    @Test
    void testComputeTotalPrice_ShouldThrowException() {
        //given
        Product product1 = new Product("lapte" , -23);
        Product product2 = new Product("oua", 12);
        Product[] productList = new Product[]{product1, product2};
        ShoppingCart shoppingCart = new ShoppingCart(productList);
        //when
        try {
            shoppingCart.computeTotalPrice();
            fail ("exception not thrown");
        } catch(InvalidPriceException e) {
            assertEquals("price is negative ", e.getMessage());
        }
        //then
    }
}
