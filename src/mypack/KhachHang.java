package mypack;
import java.io.Serializable;
import java.util.Date;
public class KhachHang implements Serializable{
    private int ma;
    private String ten;
    private Date namSinh;
    private int phone;

    public KhachHang(int ma, String ten, Date namSinh, int phone) {
        super();
        this.ma = ma;
        this.ten = ten;
        this.namSinh = namSinh;
        this.phone = phone;
    }
    public int getMa() {
        return ma;
    }
    public void setMa(int ma) {
        this.ma = ma;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public Date getNamSinh() {
        return namSinh;
    }
    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public KhachHang() {
        super();
    }
    public String toString() {
        return
                "     "+this.ma +"              "
                +this.ten+"                "
                +DateConverter.fromDate(this.namSinh)+"      "
                +this.phone;

    }
}
