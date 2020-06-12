package mainapp;

import pojo.*;
import dao.*;

import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Lop login = new Lop();
        login.setVisible(true);
        login.setSize(400, 200);

        /*DocFile df = new DocFile();
        List<ThoiKhoaBieu> lsv = df.readFileTKB("tkb_17hcb.csv");
        for (int i = 0; i < lsv.size(); i++) {
            boolean done;
            done = ThoiKhoaBieuDAO.themThoiKhoaBieu(lsv.get(i));
            if (done == false)
            {
                System.out.println("Thêm TKB thất bại");
            }
        }
//<editor-fold defaultstate="collapsed" desc="1. Lấydanh sách sinh viên">
        List<ThoiKhoaBieu> ds = ThoiKhoaBieuDAO.layDanhSachThoiKhoaBieuTheoLop("17hcb");
        for (int i = 0; i < ds.size(); i++) {
            ThoiKhoaBieu tkb = ds.get(i);
            System.out.println("mã môn: " + tkb.getId().getMaMonHoc());
            System.out.println("tên môn: " + tkb.getTenMonHoc());
            System.out.println("phòng học: " + tkb.getPhongHoc());
            System.out.println("lớp: " + tkb.getId().getLop());
        }*/
    }
//</editor-fold>
}
