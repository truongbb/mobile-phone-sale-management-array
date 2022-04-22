import entity.Customer;
import entity.Order2;
import entity.OrderDetail;
import entity.Phone;

import java.util.Scanner;

public class MainRun {

    //    int[] arr = new int[10];// một tập hợp các số
    private static Customer[] CUSTOMERS = new Customer[100]; // một tập hợp các khách hàng
    private static Phone[] PHONES = new Phone[100]; // một tập hợp các điện thoại trong cửa hàng
    private static Order2[] ORDERS = new Order2[100];// một tập hợp các hóa đơn trong cửa hàng

    public static void main(String[] args) {
        showMenu();// menu console
    }

    private static void showMenu() {
        while (true) {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    inputNewCustomer();
                    break;
                case 2:
                    showAllCustomer();
                    break;
                case 3:
                    inputNewPhone();
                    break;
                case 4:
                    showAllPhone();
                    break;
                case 5:
                    createOrder();
                    showAllOrder();
                    break;
                case 6:
                    sortOrderByCustomerName();
                    break;
                case 7:
                    lapBangThongKe();
                    break;
                case 8:
                    System.out.println("Xin cảm ơn đã sử dụng phần mềm của chúng tôi!");
                    return;
            }
        }
    }

    private static int functionChoice() {
        System.out.println("\n\n===== PHẦN MỀM QUẢN LÝ BÁN ĐIỆN THOẠI DI ĐỘNG =====\n\n");
        System.out.println("1. Nhập danh sách khách hàng mới.");
        System.out.println("2. In ra danh sách khách hàng trong hệ thống.");
        System.out.println("3. Nhập danh sách điện thoại mới.");
        System.out.println("4. In ra danh sách điện thoại trong hệ thống.");
        System.out.println("5. Lập hóa đơn mua hàng cho các khách hàng.");
        System.out.println("6. Sắp xếp danh sách mua hàng theo họ tên khách hàng.");
        System.out.println("7. Lập bảng thống kê số tiền phải trả của mỗi khách hàng.");
        System.out.println("8. Thoát chương trình");
        System.out.println("--------------------------------------");
        System.out.print("Xin mời nhập lựa chọn của bạn: ");
        int functionChoice = -1;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 8) {
                break;
            }
            System.out.print("Chức năng được chọn không hợp lệ, vui lòng chọn lại: ");
        } while (functionChoice > 8 || functionChoice < 1);
        return functionChoice;
    }

    private static void inputNewCustomer() {
        // xử lý nhập khách hàng mới
        System.out.print("Nhập số lượng khách hàng mới muốn thêm: ");
        int newCustomerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < newCustomerNumber; i++) {
            System.out.println("Nhập thông tin cho khách hàng thứ " + (i + 1));
            // thực hiện nhập thông tin cho customer
            Customer customer = new Customer();
            customer.inputInfo();

            // lưu vào hệ thống ==> thêm vào mảng CUSTOMERS đã khai báo bên trên
            saveCustomer(customer);
        }
    }

    private static void saveCustomer(Customer customer) {
        for (int j = 0; j < CUSTOMERS.length; j++) {
            if (CUSTOMERS[j] == null) {
                CUSTOMERS[j] = customer;
                break;
            }
        }
    }

    private static void showAllCustomer() {
        for (int i = 0; i < CUSTOMERS.length; i++) {
            if (CUSTOMERS[i] == null) {
                continue;
            }
            System.out.println(CUSTOMERS[i]);
        }
    }

    private static void inputNewPhone() {
        // xử lý nhập điện thoại mới
        System.out.print("Nhập số lượng điện thoại mới muốn thêm: ");
        int newPhoneNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < newPhoneNumber; i++) {
            System.out.println("Nhập thông tin cho điện thoại thứ " + (i + 1));
            // thực hiện nhập thông tin cho phone
            Phone phone = new Phone();
            phone.inputInfo();

            // lưu vào hệ thống ==> thêm vào mảng PHONES đã khai báo bên trên
            savePhone(phone);
        }
    }

    private static void savePhone(Phone phone) {
        for (int i = 0; i < PHONES.length; i++) {
            if (PHONES[i] == null) {
                PHONES[i] = phone;
                break;
            }
        }
    }

    private static void showAllPhone() {
        for (int i = 0; i < PHONES.length; i++) {
            if (PHONES[i] == null) {
                continue;
            }
            System.out.println(PHONES[i]);
        }
    }

    private static void createOrder() {
        // kiểm tra xem danh sách khách hàng và điện thoại có dữ liệu hay chưa
        if (!checkData()) {
            System.out.println("Chưa có dữ liệu về khách hàng hoặc điện thoại để thao tác, vui lòng nhập khách hàng và điện thoại trước đã!");
            return;
        }

        // 0. nhập số lượng khách hàng muốn mua hàng
        System.out.print("Nhập số lượng khách hàng muốn mua hàng: ");
        int customerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < customerNumber; i++) {
            Order2 order = new Order2();
            // 1. xác định được xem là khách hàng nào là người mua
            // ==> bắt người dùng nhập ID của khách hàng
            Customer customer = nhapKhachHang(i);
            // lưu khách hàng vào hóa đơn
            order.setCustomer(customer);

            // 2. xác định xem khách hàng này mua những điện thoại nào
            OrderDetail[] orderDetails = createOrderDetail();
            order.setOrderDetails(orderDetails);

            // lưu luôn vào danh sách order của cửa hàng
            saveOrder(order);
        }
    }

    private static boolean checkData() {
        boolean coDuLieuKhachHang = false;
        for (int i = 0; i < CUSTOMERS.length; i++) {
            if (CUSTOMERS[i] != null) {
                coDuLieuKhachHang = true;
                break;
            }
        }
        boolean coDuLieuDienThoai = false;
        for (int i = 0; i < PHONES.length; i++) {
            if (PHONES[i] != null) {
                coDuLieuDienThoai = true;
                break;
            }
        }
        return coDuLieuDienThoai && coDuLieuKhachHang;
    }


    private static OrderDetail[] createOrderDetail() {
        System.out.print("Nhập số lượng điện thoại mà khách hàng này muốn mua: ");
        int phoneQuantity = new Scanner(System.in).nextInt();
        OrderDetail[] orderDetails = new OrderDetail[phoneQuantity];
        for (int j = 0; j < phoneQuantity; j++) {
            OrderDetail orderDetail = new OrderDetail();
            // 2.1. xác định được xem là khách hàng mua điện thoại nào
            // ==> bắt người dùng nhập ID của điện thoại muốn mua

            Phone phone = nhapDienThoai(j);
            // lưu điện thoại tìm được vào chi tiết đơn hàng (orderDetail)
            orderDetail.setPhone(phone);

            System.out.print("Nhập số lượng muốn mua: ");
            int quantity;
            do {
                quantity = new Scanner(System.in).nextInt();
                if (quantity > 0) {
                    break;
                }
                System.out.print("Số lượng muốn mua phải là số dương, vui lòng nhập lại: ");
            } while (true);
            orderDetail.setQuantity(quantity);

            // lưu chi tiết đơn hàng vừa nhập vào đơn hàng
            for (int i = 0; i < orderDetails.length; i++) {
                if (orderDetails[i] == null) {
                    orderDetails[i] = orderDetail;
                    break;
                }
            }
        }
        return orderDetails;
    }


    private static Customer nhapKhachHang(int index) {
        System.out.print("Xin mời nhập mã khách hàng thứ " + (index + 1) + " muốn mua hàng: ");
        int idCustomer;
        Customer customer;
        do {
            idCustomer = new Scanner(System.in).nextInt();
            // thực hiện tìm kiếm khách hàng theo id vừa nhập xem có khách hàng trong hệ thống hay không
            // nếu có thì oke, nếu KHÔNG thì bắt người dùng nhập lại
            customer = searchCustomerById(idCustomer);
            if (customer != null) {
                break;
            }
            System.out.print("Không tồn tại người dùng có ID là " + idCustomer + ", vui lòng nhập lại: ");
        } while (true);
        return customer;
    }

    private static Phone nhapDienThoai(int index) {
        System.out.print("Xin mời nhập ID của chiếc điện thoại thứ " + (index + 1) + " mà người dùng này muốn mua: ");
        int idPhone;
        Phone phone;
        do {
            idPhone = new Scanner(System.in).nextInt();
            // thực hiện tìm kiếm khách hàng theo id vừa nhập xem có khách hàng trong hệ thống hay không
            // nếu có thì oke, nếu KHÔNG thì bắt người dùng nhập lại
            phone = searchPhoneById(idPhone);
            if (phone != null) {
                break;
            }
            System.out.print("Không tồn tại điện thoại có ID là " + idPhone + ", vui lòng nhập lại: ");
        } while (true);
        return phone;
    }

    private static void saveOrder(Order2 order) {
        for (int i = 0; i < ORDERS.length; i++) {
            if (ORDERS[i] == null) {
                ORDERS[i] = order;
                return;
            }
        }
    }

    private static Phone searchPhoneById(int idPhone) {
        for (int i = 0; i < PHONES.length; i++) {
            Phone phone = PHONES[i];
            if (phone != null && phone.getId() == idPhone) {
                return phone;
            }
        }
        return null;
    }

    private static Customer searchCustomerById(int idCustomer) {
        for (int i = 0; i < CUSTOMERS.length; i++) {
            Customer customer = CUSTOMERS[i];
            if (customer != null && customer.getId() == idCustomer) {
                return customer;
            }
        }
        return null;
    }

    private static void showAllOrder() {
        for (int i = 0; i < ORDERS.length; i++) {
            Order2 order = ORDERS[i];
            if (order != null) {
                System.out.println("Khách hàng " + order.getCustomer().getName() + " đã mua các điện thoại sau: ");
                for (int j = 0; j < order.getOrderDetails().length; j++) {
                    System.out.println(order.getOrderDetails()[j]);
                }
                System.out.println("-------------------------------");
            }
        }

    }

    private static void lapBangThongKe() {
        // kiểm tra xem trong ORDER đã có dữ liệu hay chưa
        boolean coDuLieuHoaDon = false;
        for (int i = 0; i < ORDERS.length; i++) {
            if (ORDERS[i] != null) {
                coDuLieuHoaDon = true;
            }
        }
        if (!coDuLieuHoaDon) {
            System.out.println("Chưa có hóa đơn nào trong hệ thống, vui lòng tạo hóa đơn trước khi thực hiện tính năng này.");
            return;
        }

        for (int i = 0; i < ORDERS.length; i++) {
            Order2 order = ORDERS[i];
            if (order == null) {
                continue;
            }
            int sum = 0;
            OrderDetail[] orderDetails = order.getOrderDetails();
            for (int j = 0; j < orderDetails.length; j++) {
                OrderDetail orderDetail = orderDetails[j];
                sum += orderDetail.getPhone().getUnitPrice() * orderDetail.getQuantity();
            }
            System.out.println("Khách hàng " + order.getCustomer().getName() + " phải trả " + sum + "VND");
//            System.out.println("Khách hàng " + order.getCustomer().getName() + " phải trả " + order.getCost() + "VND");
        }
    }


    private static void sortOrderByCustomerName() {
        // kiểm tra xem trong ORDER đã có dữ liệu hay chưa
        boolean coDuLieuHoaDon = false;
        for (int i = 0; i < ORDERS.length; i++) {
            if (ORDERS[i] != null) {
                coDuLieuHoaDon = true;
            }
        }
        if (!coDuLieuHoaDon) {
            System.out.println("Chưa có hóa đơn nào trong hệ thống, vui lòng tạo hóa đơn trước khi thực hiện tính năng này.");
            return;
        }
        sapXepHoaDon();
        showAllOrder();
    }

    private static void sapXepHoaDon() {
        for (int i = 0; i < ORDERS.length - 1; i++) {
            Order2 order1 = ORDERS[i];
            for (int j = i+1; j < ORDERS.length; j++) {
                Order2 order2 = ORDERS[j];
                if (order1.getCustomer().getName().compareTo(order2.getCustomer().getName()) > 0){
                    Order2 temp = order1;
                    order1= order2;
                    order2= temp;
                }
            }
        }
    }

}
