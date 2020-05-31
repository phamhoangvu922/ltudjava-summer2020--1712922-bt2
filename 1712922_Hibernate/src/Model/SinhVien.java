package Model;
import java.io.Serializable;

public class SinhVien implements Serializable {
    private String mssv;
    private int stt;
    private String hoTen;
    private String gioiTinh;
    private String cmnd;
    private String lop;
    private String matKhauMacDinh;
    private String matKhau;

    public SinhVien(String mssv, Integer stt, String hoTen, String gioiTinh, String cmnd, String lop,
                    String matKhauMacDinh, String matKhau) {
        this.mssv = mssv;
        this.stt = stt;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.lop = lop;
        this.matKhauMacDinh = matKhauMacDinh;
        this.matKhau = matKhau;
    }
    public String getMssv() {
        return this.mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }
    public Integer getStt() {
        return this.stt;
    }

    public void setStt(Integer stt) {
        this.stt = stt;
    }
    public String getHoTen() {
        return this.hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getGioiTinh() {
        return this.gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getCmnd() {
        return this.cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }
    public String getLop() {
        return this.lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
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
