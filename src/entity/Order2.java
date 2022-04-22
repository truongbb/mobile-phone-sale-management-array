package entity;

import java.util.Arrays;

public class Order2 {

    // 1 khách hàng có thể mua 1 hoặc nhiều mẫu điện thoại với số lượng khác nhau

    // --> tư duy hướng đối tượng (OOP thinking)

    private Customer customer;// 1 khách hàng
    private OrderDetail[] orderDetails;// mua nhiều sản phẩm với số lượng tương ứng
//    private int cost; // lưu tổng số tiền phải trả cho đơn hàng này

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderDetail[] getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetail[] orderDetails) {
        this.orderDetails = orderDetails;
    }
//
//    public int getCost() {
//        return cost;
//    }
//
//    public void setCost(int cost) {
//        this.cost = cost;
//    }
}
