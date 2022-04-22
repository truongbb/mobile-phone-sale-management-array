package entity;

import java.util.Scanner;

public class Phone {// Ctrl + Alt + L

    private static int AUTO_ID = -1;

    private int id;
    private String manufacturer;
    private String model;
    private int unitPrice;

    public Phone() {
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "entity.Phone{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public void inputInfo() {
        System.out.print("Nhập hãng sản xuất: ");
        this.manufacturer = new Scanner(System.in).nextLine();// Ctrl + D ==> nhân đôi dòng
        System.out.print("Nhập model: ");// Alt + Shift + mũi tên lên/xuống
        this.model = new Scanner(System.in).nextLine(); // Ctrl + Z (hoàn tác hành động vừa thực hiện)


        System.out.print("Nhập đơn giá: ");
        this.unitPrice = new Scanner(System.in).nextInt();
    }

}
