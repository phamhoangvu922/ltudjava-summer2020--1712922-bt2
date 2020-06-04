package pojo;

import java.io.Serializable;

public class ThoiKhoaBieu implements Serializable {
    private IDThoiKhoaBieu id;
    private String tenMonHoc;
    private String phongHoc;

    public ThoiKhoaBieu(IDThoiKhoaBieu id, String tenMonHoc, String phongHoc) {
        this.id = id;
        this.tenMonHoc = tenMonHoc;
        this.phongHoc = phongHoc;
    }

    public IDThoiKhoaBieu getId() {
        return this.id;
    }

    public void setId(IDThoiKhoaBieu id) {
        this.id = id;
    }
    public String getTenMonHoc() {
        return this.tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }
    public String getPhongHoc() {
        return this.phongHoc;
    }

    public void setPhongHoc(String phongHoc) {
        this.phongHoc = phongHoc;
    }


}
