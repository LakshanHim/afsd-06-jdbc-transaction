package lk.ACPT.dto;

import java.util.ArrayList;

public class OrderDto {
    private String orderDate;
    private Double subTotal;
    private ArrayList<OrderDetailDto> orderDetailDtos;

    public OrderDto(String orderDate, Double subTotal, ArrayList<OrderDetailDto> orderDetailDtos) {
        this.orderDate = orderDate;
        this.subTotal = subTotal;
        this.orderDetailDtos = orderDetailDtos;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public ArrayList<OrderDetailDto> getOrderDetailDtos() {
        return orderDetailDtos;
    }

    public void setOrderDetailDtos(ArrayList<OrderDetailDto> orderDetailDtos) {
        this.orderDetailDtos = orderDetailDtos;
    }
}
