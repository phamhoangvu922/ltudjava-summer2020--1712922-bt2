package mainapp;
import dao.DanhSachChoMonHocDAO;
import dao.SinhVienDAO;
import dao.ThoiKhoaBieuDAO;
import pojo.DanhSachChoMonHoc;
import pojo.IDDanhSachChoMonHoc;
import pojo.SinhVien;
import pojo.ThoiKhoaBieu;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class UIDanhSachChoMonHoc extends JPanel implements ActionListener {
    JPanel pnClass;
    JButton btnCreate, btnDelete, btnAdd;
    JTable table;
    JScrollPane jspDSLop;
    JTextField txtClassCre, txtStudentIDCre, txtStudentNameCre, txtGenderCre, txtCMNDCre, txtSubjectCre, txtClassDel, txtMSSVDel, txtSubjectDel;

    public JPanel QLLMH() {
        //Class
        pnClass = new JPanel();
        TitledBorder titleClass = new TitledBorder("Danh sách lớp môn học");
        pnClass.setBorder(titleClass);
        pnClass.setLayout(new GridLayout(2, 2));

        //JPanel pnInput = new JPanel();
        //pnInput.setLayout(new GridLayout(1, 2));

        JPanel pnCreate = new JPanel();
        pnCreate.setLayout(new GridLayout(15, 2, 2, 2));
        TitledBorder titleCreate = new TitledBorder("Thêm mới");
        pnCreate.setBorder(titleCreate);
        btnAdd = new JButton("Thêm tự động");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        JLabel lblClassCre = new JLabel("Tên lớp");
        txtClassCre = new JTextField(20);
        JLabel lblSubjectCre = new JLabel("Môn học");
        txtSubjectCre = new JTextField(20);
        JLabel lblStudentIDCre = new JLabel("Mã sinh viên");
        txtStudentIDCre = new JTextField(20);
        JLabel lblStudentNameCre = new JLabel("Họ tên");
        txtStudentNameCre = new JTextField(20);
        JLabel lblGenderCre = new JLabel("Giới tính");
        txtGenderCre = new JTextField(20);
        JLabel lblCMNDCre = new JLabel("CMND");
        txtCMNDCre = new JTextField(20);
        btnCreate = new JButton("Lưu");
        btnCreate.setBackground(Color.lightGray);
        pnCreate.add(btnAdd);
        pnCreate.add(lblClassCre);
        pnCreate.add(txtClassCre);
        pnCreate.add(lblSubjectCre);
        pnCreate.add(txtSubjectCre);
        pnCreate.add(lblStudentIDCre);
        pnCreate.add(txtStudentIDCre);
        pnCreate.add(lblStudentNameCre);
        pnCreate.add(txtStudentNameCre);
        pnCreate.add(lblGenderCre);
        pnCreate.add(txtGenderCre);
        pnCreate.add(lblCMNDCre);
        pnCreate.add(txtCMNDCre);
        pnCreate.add(btnCreate);
        //pnInput.add(pnCreate);

        JPanel pnDelete = new JPanel();
        pnDelete.setLayout(new GridLayout(15, 2, 2, 2));
        TitledBorder titleDelete = new TitledBorder("Xoá sinh viên");
        pnDelete.setBorder(titleDelete);
        JLabel lblClassDel = new JLabel("Tên lớp");
        txtClassDel = new JTextField(20);
        JLabel lblSubjectDel = new JLabel("Mã môn học");
        txtSubjectDel = new JTextField(20);
        JLabel lblMSSVDel = new JLabel("Mã sinh viên");
        txtMSSVDel = new JTextField(20);
        btnDelete = new JButton("Xoá");
        btnDelete.setBackground(Color.lightGray);
        pnDelete.add(lblClassDel);
        pnDelete.add(txtClassDel);
        pnDelete.add(lblSubjectDel);
        pnDelete.add(txtSubjectDel);
        pnDelete.add(lblMSSVDel);
        pnDelete.add(txtMSSVDel);
        pnDelete.add(btnDelete);
        //pnInput.add(pnDelete);


        //pnClass.add(pnInput);
        pnClass.add(pnCreate);
        pnClass.add(pnDelete);

        //Add function
        btnCreate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnCreate.addActionListener(this);
        return pnClass;
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnCreate){
            if (!txtSubjectCre.getText().isEmpty() &&!txtStudentIDCre.getText().isEmpty() && !txtStudentNameCre.getText().isEmpty()
                    && !txtClassCre.getText().isEmpty()) {
                IDDanhSachChoMonHoc svId = new IDDanhSachChoMonHoc(txtStudentIDCre.getText(), txtSubjectCre.getText(), txtClassCre.getText()) ;
                DanhSachChoMonHoc svmh = new DanhSachChoMonHoc(svId, txtStudentNameCre.getText(), txtGenderCre.getText(),
                        txtCMNDCre.getText());
                boolean create = DanhSachChoMonHocDAO.themSinhVienMonHoc(svmh);
                if(create){
                //    getDanhSachLopMonHoc(txtSubjectCre.getText());
                    JOptionPane.showMessageDialog(null, "Thêm thành công !!!");
                }else{
                    JOptionPane.showMessageDialog(null, "Thêm thất bại !!!");
                }
            }
        }

        if(e.getSource() == btnDelete){
            if (!txtMSSVDel.getText().isEmpty() &&!txtSubjectDel.getText().isEmpty() &&!txtClassDel.getText().isEmpty()) {
                boolean del = DanhSachChoMonHocDAO.xoaSinhVienMonHoc(txtSubjectDel.getText(), txtMSSVDel.getText(),txtClassDel.getText());
                if(del){
                   // getDanhSachLopMonHoc(txtSubjectDel.getText());
                    JOptionPane.showMessageDialog(null, "Xoá thành công !!!");
                }else{
                    JOptionPane.showMessageDialog(null, "Xoá thất bại !!!");
                }
            }
        }
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        List<ThoiKhoaBieu> lop = ThoiKhoaBieuDAO.layDanhSachThoiKhoaBieu();
        boolean create = false;
        for (int i=0; i< lop.size(); i++) {
            List<ThoiKhoaBieu> listtkb = ThoiKhoaBieuDAO.layDanhSachThoiKhoaBieuTheoLop(lop.get(i).getId().getLop());
            for (int j = 0; j< listtkb.size(); j++)
            {
                List<SinhVien> lsv = SinhVienDAO.layDanhSachSinhVienTheoLop(lop.get(i).getId().getLop());
                for (int l=0; l<lsv.size(); l++)
                {
                    IDDanhSachChoMonHoc id =  new IDDanhSachChoMonHoc(lsv.get(l).getMssv(),listtkb.get(j).getId().getMaMonHoc(),
                            lop.get(i).getId().getLop());
                    DanhSachChoMonHoc dsmh = new DanhSachChoMonHoc(id, lsv.get(l).getHoTen(), lsv.get(l).getGioiTinh(),
                            lsv.get(l).getCmnd());
                    create = DanhSachChoMonHocDAO.themSinhVienMonHoc(dsmh);
                }
            }
        }
        if(create){
            //    getDanhSachLopMonHoc(txtSubjectCre.getText());
            JOptionPane.showMessageDialog(null, "Thêm thành công !!!");
        }else{
            JOptionPane.showMessageDialog(null, "Thêm thất bại !!!");
        }
    }
}
