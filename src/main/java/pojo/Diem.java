package pojo;

import java.io.Serializable;

public class Diem implements Serializable {
    private IDDiem id;
    private String hoTen;
    private float diemGK;
    private float diemCK;
    private float diemKhac;
    private float diemTong;

    public Diem(IDDiem id, String hoTen, Float diemGk, Float diemCk, Float diemKhac, Float diemTong) {
        this.id = id;
        this.hoTen = hoTen;
        this.diemGK = diemGk;
        this.diemCK = diemCk;
        this.diemKhac = diemKhac;
        this.diemTong = diemTong;
    }

    public IDDiem getId() {
        return this.id;
    }

    public void setId(IDDiem id) {
        this.id = id;
    }
    public String getHoTen() {
        return this.hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public Float getDiemGk() {
        return this.diemGK;
    }

    public void setDiemGk(Float diemGk) {
        this.diemGK = diemGk;
    }
    public Float getDiemCk() {
        return this.diemCK;
    }

    public void setDiemCk(Float diemCk) {
        this.diemCK = diemCk;
    }
    public Float getDiemKhac() {
        return this.diemKhac;
    }

    public void setDiemKhac(Float diemKhac) {
        this.diemKhac = diemKhac;
    }
    public Float getDiemTong() {
        return this.diemTong;
    }

    public void setDiemTong(Float diemTong) {
        this.diemTong = diemTong;
    }

}
