package entity;

public class OrderDetail {
    /**
     * chi tiết đơn hàng
     */
    private Phone phone;
    private int quantity;

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "phone=" + phone +
                ", quantity=" + quantity +
                '}';
    }
}
