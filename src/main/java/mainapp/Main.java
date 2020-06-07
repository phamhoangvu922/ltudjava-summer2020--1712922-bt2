package mainapp;

import pojo.*;
import dao.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//<editor-fold defaultstate="collapsed" desc="1. Lấydanh sách sinh viên">
        List<SinhVien> ds = SinhVienDAO.layDanhSachSinhVien();
        for (int i = 0; i < ds.size(); i++) {
            SinhVien sv = ds.get(i);
            System.out.println("MSSV: " + sv.getMssv());
            System.out.println("Họ và tên: " + sv.getHoTen());
            System.out.println("Giới tính: " + sv.getGioiTinh());
            System.out.println("CMND: " + sv.getCmnd());
        }
    }
//</editor-fold>
}
