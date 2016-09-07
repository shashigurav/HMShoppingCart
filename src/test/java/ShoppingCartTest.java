import item.Item;
import org.junit.Before;
import org.junit.Test;
import shopping.ShoppingCart;
import shopping.ShoppingCartImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by sony on 9/7/2016.
 */
public class ShoppingCartTest {

    ShoppingCart shoppingCart ;

    private static BigDecimal APPLE_PRICE = new BigDecimal(.60);
    private static BigDecimal ORANGE_PRICE = new BigDecimal(.25);

    @Before
    public void SetUp(){

        shoppingCart = new ShoppingCartImpl();
    }
    @Test
    public void checkShoppingCartEmpty(){
        assertEquals(0,shoppingCart.checkItem());
    }

    @Test
    public void testAddShoopingItem(){
        List<Item> items= new ArrayList<Item>();
        items.add(new Item("Apple",1,APPLE_PRICE));
        shoppingCart.addItems(items);
        assertEquals(1,shoppingCart.checkItem());

    }

    @Test
    public void testAddShoopingItems(){
        List<Item> items= new ArrayList<Item>();
        items.add(new Item("Orange",1,ORANGE_PRICE));
        items.add(new Item("Apple",1,APPLE_PRICE));
        shoppingCart.addItems(items);
        assertEquals(2,shoppingCart.checkItem());

    }

    @Test
    public void testCheckout(){
        List<Item> items= new ArrayList<Item>();
        items.add(new Item("Orange",1,ORANGE_PRICE));
        items.add(new Item("Apple",1,APPLE_PRICE));
        items.add(new Item("Apple",1,APPLE_PRICE));
        items.add(new Item("Apple",1,APPLE_PRICE));
        shoppingCart.addItems(items);
        assertEquals(4,shoppingCart.checkItem());
        assertEquals(new BigDecimal(2.05).setScale(2, RoundingMode.HALF_UP),shoppingCart.checkOut());

    }

    @Test
    public void testDiscountCheckout(){
        List<Item> items= new ArrayList<Item>();
        items.add(new Item("Orange",1,ORANGE_PRICE));
        items.add(new Item("Apple",1,APPLE_PRICE));
        items.add(new Item("Apple",1,APPLE_PRICE));
        items.add(new Item("Apple",1,APPLE_PRICE));
        shoppingCart.addItems(items);
        assertEquals(4,shoppingCart.checkItem());
        assertEquals(new BigDecimal(1.45).setScale(2, RoundingMode.HALF_UP),shoppingCart.checkOutDiscount());

    }











}
