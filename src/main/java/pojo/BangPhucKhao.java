package pojo;

public class BangPhucKhao  {
    private String id;
    private String ngayBatDau;
    private String ngayKetThuc;

    public BangPhucKhao(String id) {
        this.id = id;
    }
    public BangPhucKhao(String id, String ngayBatDau, String ngayKetThuc) {
        this.id = id;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }


    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
