package pojo;

import java.io.Serializable;

public class IDDanhSachChoMonHoc implements Serializable {
    private String mssv;
    private String maMonHoc;
    private  String lop;


    public  IDDanhSachChoMonHoc()
    {

    }
    public IDDanhSachChoMonHoc(String mssv, String maMonHoc, String lop) {
        this.mssv = mssv;
        this.maMonHoc = maMonHoc;
        this.lop = lop;
    }

    public String getMssv() {
        return this.mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }
    public String getMaMonHoc() {
        return this.maMonHoc;
    }

    public void setMaMonHoc(String monHoc) {
        this.maMonHoc = monHoc;
    }

    public String getLop() {
        return this.lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

}
