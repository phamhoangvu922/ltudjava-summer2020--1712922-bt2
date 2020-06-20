package pojo;

import java.io.Serializable;

public class PhucKhao  implements Serializable {
    private IDPhucKhao id;
    private String hoTen;
    private String cotDiem;
    private Double diemMongMuon;
    private String lyDo;
    private String tinhTrang;
    private String date;


    public PhucKhao()
    {

    }
    public PhucKhao(IDPhucKhao id, String hoTen,String cotDiem, Double diemMongMuon, String lyDo, String tinhTrang, String date) {
        this.id = id;
        this.hoTen = hoTen;
        this.cotDiem = cotDiem;
        this.diemMongMuon = diemMongMuon;
        this.lyDo = lyDo;
        this.tinhTrang = tinhTrang;
        this.date = date;
    }

    public IDPhucKhao getId() {
        return id;
    }

    public void setId(IDPhucKhao id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getCotDiem() {
        return cotDiem;
    }

    public void setCotDiem(String cotDiem) {
        this.cotDiem = cotDiem;
    }

    public Double getDiemMongMuon() {
        return diemMongMuon;
    }

    public void setDiemMongMuon(Double diemMongMuon) {
        this.diemMongMuon = diemMongMuon;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
