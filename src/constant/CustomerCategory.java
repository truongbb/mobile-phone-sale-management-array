package constant;

public enum CustomerCategory {
    MUA_LE("Mua lẻ"),
    MUA_BUON("Mua buôn"),
    MUA_QUA_MANG("Mua qua mạng");

    public final String value;

    CustomerCategory(String value) {
        this.value = value;
    }
}
