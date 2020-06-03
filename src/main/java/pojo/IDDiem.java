package pojo;
import java.io.Serializable;

public class IDDiem implements Serializable {
    private String mssv;
    private String lop;
    private String monHoc;


    public IDDiem(String mssv, String lop, String monHoc) {
        this.mssv = mssv;
        this.lop = lop;
        this.monHoc = monHoc;
    }

    public String getMssv() {
        return this.mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }
    public String getLop() {
        return this.lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
    public String getMonHoc() {
        return this.monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }
}
