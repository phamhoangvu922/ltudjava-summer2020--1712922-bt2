package mainapp;

import dao.DanhSachChoMonHocDAO;
import dao.DiemDAO;
import pojo.Diem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UIDiemCaNhan  extends JPanel implements ActionListener  {

    private JLabel jLabel1;
    private JScrollPane jScrollPane;
    private  JTable jsvTableDiem;
    private String mssv;
    private  JButton btnSelect;
    private  JPanel pnDiemCaNhan;

    public JPanel Import(String mssv) {
        pnDiemCaNhan = new JPanel();
        TitledBorder titleDiemCN = new TitledBorder("Xem điểm cá nhân");
        pnDiemCaNhan.setBorder(titleDiemCN);
        pnDiemCaNhan.setLayout(null);

        this.mssv = mssv;
        JPanel pnInput = new JPanel();
        pnInput.setLayout(new GridLayout(1, 1));

        btnSelect = new JButton("Xem điểm");
        btnSelect.setBackground(Color.lightGray);

        pnInput.add(btnSelect);

        JPanel pnListDiem = new JPanel();
        TitledBorder titleLitsDiem = new TitledBorder("Danh sách điểm các môn");
        pnListDiem.setBorder(titleLitsDiem);
        pnListDiem.setLayout(new GridLayout(1, 1));

        jsvTableDiem = new JTable();
        jScrollPane = new JScrollPane(jsvTableDiem);
        pnListDiem.add(jScrollPane);

        pnInput.setBounds(10, 20, 765, 40);
        pnListDiem.setBounds(10, 100, 765, 500);
        pnDiemCaNhan.add(pnInput);
        pnDiemCaNhan.add(pnListDiem);
        btnSelect.addActionListener(this);


        return pnDiemCaNhan;
    }
        @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSelect){
            getDiemTheoMSSV();
        }

    }
    public void getDiemTheoMSSV() {
        String[] columns = new String[]{"Mã sinh viên", "Họ tên", "Mã môn học", "Điểm GK", "Điểm CK", "Điểm Khác","Điểm Tổng"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        List<pojo.Diem> listStudentsScore = null;
        listStudentsScore = DiemDAO.layDanhSachDiemTheoMSSV(mssv);
        for (pojo.Diem diem : listStudentsScore)
        {
            model.addRow(new Object[]{diem.getId().getMssv(), diem.getHoTen(), diem.getId().getMonHoc(),diem.getDiemGk(),
                    diem.getDiemCk(),diem.getDiemKhac(),diem.getDiemTong()});
        }
        jsvTableDiem.setModel(model);
    }
}
