import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserTest {
    User user;
    @Mock
    ShoppingCart shoppingCart;

    public UserTest() {
        System.out.println("Apelul constructorului");
    }

    @BeforeEach
    void createUser() {
        System.out.println("inaintea fiecarei metode");
//        Product product1 =new Product("lapte", 10);
//        Product product2 =new Product("paine", 7);
//        Product[] products = new Product[] {product1, product2};
//        ShoppingCart shoppingCart = new ShoppingCart(products);
        user = new User("Kalura", "santaclaus", shoppingCart );
    }
    @BeforeAll
    static void beforeAll() {
        System.out.println("inainte de toate metodele");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("dupa toate metodele");
    }
    @AfterEach
    void afterEach() {
        System.out.println("dupa fiecare metoda");
    }


    @Test
    void testUserPassword_ShouldBeStrong() {
        System.out.println("TEST 1");
        //User user = new User("Kalura", "santaclaus");
        boolean result = user.hasStrongPassword();
        assertTrue(result);
    }

    @Test
    void testUserName_ShouldBeValid() {
        System.out.println("TEST 2");
        //User user = new User("Kalura", "santaclaus");
        boolean result = user.hasValidUserName();
        assertTrue(result);
    }

    @Test
    void testUser_ShouldBeValid() {
        System.out.println("TEST 3");
        //User user = new User("Kalura", "santaclaus");
        boolean result = user.isValid();
        assertTrue(result);
    }


    @Test
    void testGenerateInvoice_CouldReturnInvoiceText() throws InvalidPriceException{
        when(shoppingCart.computeTotalPrice()).thenReturn(50);
        String result = user.generateInvoice();
        assertEquals("Kalura has paid 50", result);
    }

    @Test
    void testGenerateInvoice_ShouldThrowException() throws InvalidPriceException {
        when(shoppingCart.computeTotalPrice()).thenThrow(new InvalidPriceException("price is negative"));
        try{
            String result = user.generateInvoice();
            fail("exception not throw");
        } catch(InvalidPriceException e) {
            assertEquals("price is negative", e.getMessage());
        }

        //String result = user.generateInvoice();
        //assertEquals("Kalura has paid 50", result);
    }
}
