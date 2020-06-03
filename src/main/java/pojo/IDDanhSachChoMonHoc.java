package pojo;

import java.io.Serializable;

public class IDDanhSachChoMonHoc implements Serializable {
    private String mssv;
    private String monHoc;


    public IDDanhSachChoMonHoc(String mssv, String monHoc) {
        this.mssv = mssv;
        this.monHoc = monHoc;
    }

    public String getMssv() {
        return this.mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }
    public String getMonHoc() {
        return this.monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

}
