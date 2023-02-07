package sg.edu.nus.iss.app.workshop24.models;

import java.math.BigDecimal;

public class LineItem {
    
    // fields to store the various.
    private Integer itemId;
    private Integer quantity;
    private String product;
    // field to store order id associated with this line item
    private String orderId;
    private BigDecimal unitPrice;
    private BigDecimal discount;


    // default constructor
    public LineItem() {
        
    }

    // constructor to set product and quantity
    public LineItem(String product, Integer quantity){
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and setters
    public Integer getItemId() {
        return itemId;
    }


    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }


    public Integer getQuantity() {
        return quantity;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public String getProduct() {
        return product;
    }


    public void setProduct(String product) {
        this.product = product;
    }


    public String getOrderId() {
        return orderId;
    }


    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    public BigDecimal getUnitPrice() {
        return unitPrice;
    }


    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }


    public BigDecimal getDiscount() {
        return discount;
    }


    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    
    

}
