package mainapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pojo.*;

public class DocFile {
    private static final String COMMA_DELIMITER = ",";
    private static final String COMMA_DELIMITER1 = "-";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static List<String> parseCsvLine(String line) {
        List<String> result = new ArrayList<String>();
        if (line != null) {
            String[] splitData = line.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static List<String> parseCsvLine1(String line) {
        List<String> result = new ArrayList<String>();
        if (line != null) {
            String[] splitData = line.split(COMMA_DELIMITER1);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }


    public List<SinhVien> readFileSinhVien(String filePath) {
        BufferedReader br = null;
        List<SinhVien> studentList =  new ArrayList<SinhVien>();
        try {
            String line;
            br = new BufferedReader(new FileReader(filePath));
            line = br.readLine();
            String lop = parseCsvLine(line).get(0);
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                List<String> result = new ArrayList<String>();
                result = parseCsvLine(line);
                String mssv = result.get(0);
                int stt = Integer.parseInt(result.get(1));
                String hoTen = result.get(2);
                String gioiTinh = result.get(3);
                String cmnd = result.get(4);
                String matKhauMacDinh = result.get(4);
                String matkhau = "";
                int i =0;
                SinhVien temp = new SinhVien(mssv,stt,hoTen,gioiTinh,cmnd,lop,matKhauMacDinh,matkhau);
                studentList.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
        return studentList;
    }
    public List<ThoiKhoaBieu> readFileTKB(String filePath) {
        BufferedReader br = null;
        List<ThoiKhoaBieu> tkbList =  new ArrayList<ThoiKhoaBieu>();
        try {
            String line;
            br = new BufferedReader(new FileReader(filePath));
            line = br.readLine();
            String lop = parseCsvLine(line).get(0);
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                List<String> result = new ArrayList<String>();
                result = parseCsvLine(line);
                String maMon = result.get(1);
                String tenMon = result.get(2);
                String phongHoc = result.get(3);
                IDThoiKhoaBieu id = new IDThoiKhoaBieu(maMon, lop);
                ThoiKhoaBieu temp = new ThoiKhoaBieu(id, tenMon, phongHoc);
                tkbList.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
        return tkbList;
    }

    public List<Diem> readFileDiem(String filePath) {
        BufferedReader br = null;
        List<Diem> diemList =  new ArrayList<Diem>();
        try {
            String line;
            br = new BufferedReader(new FileReader(filePath));
            line = br.readLine();
            String lop = parseCsvLine1(line).get(0);
            String maMonHoc = parseCsvLine1(line).get(1);
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                List<String> result = new ArrayList<String>();
                result = parseCsvLine(line);
                String mssv = result.get(1);
                String hoTen = result.get(2);
                float diemGK = Float.parseFloat(result.get(3));
                float diemCK = Float.parseFloat(result.get(4));
                float diemKhac = Float.parseFloat(result.get(5));
                float tongDiem = Float.parseFloat(result.get(6));
                IDDiem id = new IDDiem(mssv, lop, maMonHoc);
                Diem temp = new Diem(id,hoTen,diemGK,diemCK,diemKhac,tongDiem);
                diemList.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
        return diemList;
    }
}
