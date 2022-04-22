package entity;

public class Order1 {

    // 1 khách hàng có thể mua 1 hoặc nhiều mẫu điện thoại với số lượng khác nhau

    // --> tư duy hướng đối tượng (OOP thinking)

    Customer customer;// 1 khách hàng
    Phone[] phones;// nhiều điện thoại mà khách hàng đó mua
    int[] quantity; // số lượng tương ứng của từng chiếc điện thoại

    /**
     * phones = [iphone, samsung, oppo]
     * quantity = [2, 1, 3]
     *
     *  ==> cùng chỉ số
     *
     *  khách hàng này mua điện thoại phones[i] với số lượng quantity[i]
     */

}
