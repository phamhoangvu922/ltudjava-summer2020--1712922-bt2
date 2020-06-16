package pojo;

import java.io.Serializable;

public class TaiKhoan implements Serializable {
    private String mssv;
    private String matKhauMacDinh;
    private String matKhau;

    public TaiKhoan()
    {

    }

    public TaiKhoan(String mssv, String matKhauMacDinh, String matKhau) {
        this.mssv = mssv;
        this.matKhauMacDinh = matKhauMacDinh;
        this.matKhau = matKhau;
    }
    public String getMssv() {
        return this.mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }
    public String getMatKhauMacDinh() {
        return this.matKhauMacDinh;
    }

    public void setMatKhauMacDinh(String matKhauMacDinh) {
        this.matKhauMacDinh = matKhauMacDinh;
    }
    public String getMatKhau() {
        return this.matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

}
