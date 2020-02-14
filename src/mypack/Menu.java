package mypack;
import java.util.*;

public class Menu {

    static HashMap<Integer, KhachHang>dsKH=new HashMap<Integer, KhachHang>();
    public static void menu()
    {
        System.out.println("-------------------------");
        System.out.println("1.Thêm khách hàng mới");
        System.out.println("2.Hiện thị dữ liệu vừa nhập");
        System.out.println("3.Sửa thông tin khách hàng");
        System.out.println("4.Xóa dữ liệu khách hàng");
        System.out.println("5.Tìm khách hàng");
        System.out.println("6.Sắp xếp theo tên");
        System.out.println("7.Lưu File");
        System.out.println("8.Đọc File");
        System.out.println("9.Thoát");
        System.out.println("-------------------------");
        System.out.print("Chọn chức năng (theo số ) để tiếp tục : ");
      try{
          int n=new Scanner(System.in).nextInt();
        switch(n)
        {
            case 1:
                nhap();
                break;
            case 2:
                xuat();
                break;
            case 3:
                sua();
                break;
            case 4:
                xoa();
                break;
            case 5:
                tim();
                break;
            case 6:
                sapxep();
                break;
            case 7:
                luu();
                break;
            case 8:
                mo();
                break;
            case 9:
                System.err.println("Tạm biệt!");
                System.exit(0);
                break;
            default:
                System.err.println("Nhập chưa đúng, vui lòng nhập lại ");
                menu();
        }
    }catch (InputMismatchException e){
          System.out.println("Nhập vào số tương ứng để tiếp tục " );
          menu();
      }
    }

    private static void sua() {
        System.out.println("Nhập mã muốn sửa:");
        int ma=new Scanner(System.in).nextInt();
        if(dsKH.containsKey(ma))
        {
            System.out.println("Mời bạn nhập tên:");
            String ten=new Scanner(System.in).nextLine();
            System.out.println("Mời bạ nhập năm sinh(dd/MM/yyyy):");
            Date ns=DateConverter.fromString(new Scanner(System.in).nextLine());
            System.out.println("Moi Ban Nhap So Dien Thoat");
            int phone=new Scanner(System.in).nextInt();

            KhachHang kh=new KhachHang(ma, ten, ns,phone);
            dsKH.put(ma,kh);
        }
        else
        {
            System.out.println("mã "+ma+" không tồn tại");
        }

    }

    private static void xoa() {
        System.out.println("Nhập mã:");
        int ma=new Scanner(System.in).nextInt();
        if(dsKH.containsKey(ma))
        {
            dsKH.remove(ma);
        }
        else
        {
            System.out.println("Không tìm thấy mã "+ma+" để xóa");
        }

    }

    private static void sapxep() {
    }

    private static void tim() {
        System.out.println("Nhập ten:");
        String ten=new Scanner(System.in).nextLine();
        for(Map.Entry<Integer, KhachHang> item: dsKH.entrySet())
        {
            if(item.getValue().getTen().startsWith(ten)) {
                System.out.println(item.getValue());
            }
        }

    }


    private static void mo() {
        dsKH=IOFile.readFile("/home/mr97/Desktop/CaseStudyModule2/quanli.txt");
    }

    private static void luu() {;
        IOFile.saveFile(dsKH, "/home/mr97/Desktop/CaseStudyModule2/quanli.txt");
    }
    private static void xuat() {
        for(Map.Entry<Integer, KhachHang> item: dsKH.entrySet())
        {
            System.out.println(item.getValue());
        }
    }

    private static void nhap() {
        System.out.print("Nhập số lượng khách hàng : ");
        int n = new Scanner(System.in).nextInt();
        for (int i=1;i<=n;i++)
        {
            System.out.print("Nhập mã khách hàng thứ " + i +" : ");
            int ma=new Scanner(System.in).nextInt();
            System.out.print("Nhập tên khách hàng thứ " + i+" : ");
            String ten=new Scanner(System.in).nextLine();
            System.out.print("Nhập ngày sinh khách hàng thứ " + i +" (dd/MM/yyyy) : ");
            Date ns= DateConverter.fromString(new Scanner(System.in).nextLine());
            System.out.print("Nhập số điện thoại khách hàng thứ " +i+" : ");
             int phone=new Scanner(System.in).nextInt();
             KhachHang kh=new KhachHang(ma, ten, ns,phone);
        dsKH.put(ma,kh);
        }
    }
    public static void main(String[] args) {
        while(true)
        {
            menu();
        }
    }

}