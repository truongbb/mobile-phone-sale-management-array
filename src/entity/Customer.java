package entity;

import java.util.Scanner;

// KHÁCH HÀNG
public class Customer {

    // dùng hằng số static final
    public static final String MUA_LE = "Mua lẻ";
    public static final String MUA_BUON = "Mua buôn";
    public static final String MUA_QUA_MANG = "Mua qua mạng";

    private static int AUTO_ID = -1;

    private int id;
    private String name;
    private String address;
    private String phoneNumber; // "0925687136"
    //    private constant.CustomerCategory customerCategory; // dùng enum
    private String customerCategory;

    public Customer() {
        if (AUTO_ID == -1) {
            AUTO_ID = 10000;
            this.id = AUTO_ID;
            return;
        }
        this.id = ++AUTO_ID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(String customerCategory) {
        this.customerCategory = customerCategory;
    }

    @Override
    public String toString() {
        return "entity.Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customerCategory='" + customerCategory + '\'' +
                '}';
    }

    public void inputInfo() {
        System.out.print("Nhập tên cho khách hàng: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("Nhập địa chỉ cho khách hàng: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.print("Nhập SĐT cho khách hàng: ");
        this.phoneNumber = new Scanner(System.in).nextLine();
        System.out.println("Nhập nhóm khách hàng là 1 trong các lựa chọn dưới đây: ");
        System.out.println("1. Mua lẻ");
        System.out.println("2. Mua buôn");
        System.out.println("3. Mua qua mạng");
        System.out.print("Xin mời nhập lựa chọn của bạn: ");
        int choice = -1;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 3) {
                break;
            }
            System.out.print("Lựa chọn loại khách hàng không hợp lệ, vui lòng chọn lại: ");
        } while (choice > 3 || choice < 1);
        switch (choice) {
            case 1:
                this.customerCategory = Customer.MUA_LE;
                break;
            case 2:
                this.customerCategory = Customer.MUA_BUON;
                break;
            case 3:
                this.customerCategory = Customer.MUA_QUA_MANG;
                break;
        }
    }

}
