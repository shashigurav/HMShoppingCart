import org.junit.Before;
import org.junit.Test;
import shopping.ShoppingCart;
import shopping.ShoppingCartImpl;

import static org.junit.Assert.assertEquals;

/**
 * Created by sony on 9/7/2016.
 */
public class ShoppingCartTest {

    ShoppingCart shoppingCart ;

    @Before
    public void SetUp(){

        shoppingCart = new ShoppingCartImpl();
    }
    @Test
    public void checkShoppingCartEmpty(){
        assertEquals(shoppingCart.checkItem(),0);
    }

}
