package com.hexbee.usermanagement.dto;

import java.util.List;

public class OrderNotificationDTO {
    
    private String orderId;
    private String orderDate;
    private String totalAmount;
    private List<OrderItemDTO> items;

    public OrderNotificationDTO() {
        super();
    }

    public OrderNotificationDTO(String orderId, String orderDate, String totalAmount, List<OrderItemDTO> items) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderNotificationDTO [orderId=" + orderId + ", orderDate=" + orderDate + 
               ", totalAmount=" + totalAmount + ", items=" + items + "]";
    }
}

