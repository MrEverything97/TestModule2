package mypack;

import java.io.*;
import java.util.HashMap;


public class IOFile{
    public static boolean saveFile(HashMap<Integer, KhachHang> dsKH,String path)
    {
        try
        {
            FileOutputStream fos=new FileOutputStream(path);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(dsKH);
            oos.close();
            fos.close();
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public static HashMap<Integer, KhachHang> readFile(String path)
    {
        HashMap<Integer, KhachHang> dsKH=new HashMap<Integer, KhachHang>();
        try
        {
            FileInputStream fis=new FileInputStream(path);
            ObjectInputStream ois=new ObjectInputStream(fis);
            Object data=ois.readObject();
            ois.close();
            fis.close();
            dsKH=(HashMap<Integer,KhachHang>) data;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dsKH;
    }


}