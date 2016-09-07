package shopping;

import item.Item;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
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

        Iterator<Item> itemIterator = itemList.iterator();
        while (itemIterator.hasNext()){
            Item item = itemIterator.next();
            if (!itemCart.containsKey(item.getFruitName())){
                itemCart.put(item.getFruitName(),item);
            }else {
                Item exitingItem = itemCart.get(item.getFruitName());
                exitingItem.setQuantity(exitingItem.getQuantity()+item.getQuantity());
                itemCart.put(exitingItem.getFruitName(),exitingItem);
            }

        }

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

    /*
        This method will be called once use check from cart
     */
    public BigDecimal checkOut() {

        Iterator<Item> itemIterator = itemCart.values().iterator();
        while (itemIterator.hasNext()){
            Item item = itemIterator.next();
            finalBill = finalBill.add(new BigDecimal(item.getQuantity()).multiply(item.getPrice()).setScale(2, RoundingMode.HALF_UP));
        }

        return finalBill ;
    }
    /*
        This is checkout with Discount Method .
     */
    public BigDecimal checkOutDiscount() {

        Iterator<Item> itemIterator = itemCart.values().iterator();

        while (itemIterator.hasNext()){
            Item item = itemIterator.next();
            /*
                Apple are buy one get one free so div by 2
             */
            if("Apple".equalsIgnoreCase(item.getFruitName()))
                if (item.getQuantity()>1) {
                    BigDecimal billingQty = new BigDecimal(item.getQuantity() - item.getQuantity() /2 );
                    finalBill = finalBill.add(billingQty.multiply(item.getPrice()).setScale(2, RoundingMode.HALF_UP));
                }
                else{
                    finalBill = finalBill.add(new BigDecimal(item.getQuantity()).multiply(item.getPrice()).setScale(2, RoundingMode.HALF_UP));
                }
                /*
                    Orange are buy 3 pay for 2 is discount so div /3
                 */
            else if("Orange".equalsIgnoreCase(item.getFruitName()))
                if (item.getQuantity()>2){
                    BigDecimal billingQty = new BigDecimal(item.getQuantity() - item.getQuantity() /3 );
                    finalBill = finalBill.add((billingQty.multiply(item.getPrice()).setScale(2, RoundingMode.HALF_UP)));
                }else{
                    finalBill = finalBill.add(new BigDecimal(item.getQuantity()).multiply(item.getPrice()).setScale(2, RoundingMode.HALF_UP));
                }

        }
        return finalBill;

    }
}
