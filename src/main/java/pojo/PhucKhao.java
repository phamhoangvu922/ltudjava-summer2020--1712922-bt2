package pojo;

public class PhucKhao {
    private IDPhucKhao id;
    private String hoTen;
    private String cotDiem;
    private Double diemMongMuon;
    private String lyDo;



    public PhucKhao(IDPhucKhao id, String hoTen,String cotDiem, Double diemMongMuon, String lyDo) {
        this.id = id;
        this.hoTen = hoTen;
        this.cotDiem = cotDiem;
        this.diemMongMuon = diemMongMuon;
        this.lyDo = lyDo;
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

}
