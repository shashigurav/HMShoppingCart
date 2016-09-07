package shopping;

import item.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by sony on 9/7/2016.
 */
public interface ShoppingCart {

    public void addItems(List<Item> itemList);
    public int checkItem();

    public BigDecimal checkOut();
}
