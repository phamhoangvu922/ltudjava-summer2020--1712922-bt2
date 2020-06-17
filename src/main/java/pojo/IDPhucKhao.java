package pojo;

import java.io.Serializable;

public class IDPhucKhao implements Serializable  {
    private String mssv;
    private String monHoc;
    private String ngay;


    public IDPhucKhao(String mssv, String monHoc, String ngay) {
        this.mssv = mssv;
        this.monHoc = monHoc;
        this.ngay = ngay;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
}
