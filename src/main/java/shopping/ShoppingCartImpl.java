package shopping;

import item.Item;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by sony on 9/7/2016.
 */
public class ShoppingCartImpl implements ShoppingCart{

    private BigDecimal finalBill = new BigDecimal(BigInteger.ZERO);

    private Map<String,Item> itemCart ;

    /*
        initialise Shopping cart
     */
    public ShoppingCartImpl (){
        itemCart = new HashMap<String, Item>();
    }

    /*
        Add the List of item in shopping cart as per req.
     */
    public void addItems(List<Item> itemList) {

    }
/*
    Check the number if Items in the cart
 */
    public int checkItem() {
        int count=0 ;

        Iterator<Item> itemIterator = itemCart.values().iterator();
        while (itemIterator.hasNext()){
            count=count+itemIterator.next().getQuantity();
        }

        return count;
    }
}
