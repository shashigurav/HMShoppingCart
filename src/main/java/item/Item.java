package item;

import java.math.BigDecimal;

/**
 * Created by sony on 9/7/2016.
 */
public class Item {

    private String fruitName ;
    private int quantity ;
    private BigDecimal price ;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
