package mainapp;

import dao.BangPhucKhaoDAO;
import dao.PhucKhaoDAO;
import dao.SinhVienDAO;
import pojo.BangPhucKhao;
import pojo.PhucKhao;
import pojo.SinhVien;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UIPhucKhao extends JPanel implements ActionListener {
    List<BangPhucKhao> bpk;
    private JComboBox jCbbID;
    private JComboBox jComboBox1;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9;
    private JPanel jPannelViewReexamine;
    private JScrollPane jScrollPane2;
    private JButton jbtnCapNhat;
    private JTextArea jtxLyDo;
    private JTextField jtxtCotDiem, jtxtDiemDeNghi, jtxtHoTen, jtxtMSSV, jtxtMonHoc, jtxtNgayKT;


    public JPanel Import(String mssv) {
        JPanel pnPhucKhao = new JPanel();
        pnPhucKhao.setLayout(new GridLayout(1, 2));

        JPanel pnImport = new JPanel();
        pnImport.setLayout(new GridLayout(10, 2, 2, 2));
        TitledBorder titleSelect = new TitledBorder("Nộp phúc khảo");
        pnImport.setBorder(titleSelect);
       // pnImport.setLayout(null);

        jLabel1 = new JLabel("MSSV:");
        jLabel2 = new JLabel("Họ và tên");
        jLabel3 = new JLabel("Môn học");
        jtxtMSSV = new JTextField(20);
        jtxtHoTen = new JTextField(20);
        jtxtMonHoc = new JTextField(20);
        jLabel4 = new JLabel("Cột điểm");
        jLabel5 = new JLabel("Điểm đề nghị");
        jtxtCotDiem = new JTextField(20);
        jtxtDiemDeNghi = new JTextField(20);
        jScrollPane2 = new JScrollPane();
        jtxLyDo = new JTextArea();
        jLabel6 = new JLabel("Đăng kí phúc khảo");
        jLabel7 = new JLabel("Lí do");
        jbtnCapNhat = new JButton("Đăng kí");
        jbtnCapNhat.setBounds(500, 20, 100, 30);
        jtxtNgayKT = new JTextField(20);

        pnImport.add(jLabel1);
        pnImport.add(jtxtMSSV);
        pnImport.add(jLabel2);
        pnImport.add(jtxtHoTen);
        pnImport.add(jLabel3);
        pnImport.add(jtxtMonHoc);
        pnImport.add(jLabel4);
        pnImport.add(jtxtCotDiem);
        pnImport.add(jLabel5);
        pnImport.add(jtxtDiemDeNghi);
        pnImport.add(jLabel7);
        pnImport.add(jtxLyDo);
        pnImport.add(jbtnCapNhat);

        pnImport.setBounds(20, 40, 565, 100);

        pnPhucKhao.add(pnImport);

        jbtnCapNhat.addActionListener(this);
        return pnPhucKhao;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbtnCapNhat)
        {
            String TenMH = jtxtMonHoc.getText();
            String MSSV = jtxtMSSV.getText();
            String HoTen = jtxtHoTen.getText();
            int ID = Integer.parseInt(jtxtMSSV.getText());
            String CotDiem = jtxtCotDiem.getText();
            Double Diem = Double.parseDouble(jtxtDiemDeNghi.getText());
            String LyDo = jtxLyDo.getText();

            PhucKhao pk = new PhucKhao(MSSV,  HoTen,  TenMH,  CotDiem,  Diem,  LyDo,ID);
            if(PhucKhaoDAO.createPhucKhao(pk))
                JOptionPane.showMessageDialog(null, "!!! Đăng ký phúc khảo thành công");
        }
    }
}