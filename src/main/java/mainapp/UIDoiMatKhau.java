package mainapp;

import dao.SinhVienDAO;
import javafx.scene.control.Labeled;
import pojo.SinhVien;
import pojo.TaiKhoan;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIDoiMatKhau extends JPanel implements ActionListener {

    private JLabel jLabel1, jLabel2, jLabel3;
    private JTextField jtxtOldPass, jtxtNewPass, jtxtAgain;
    private JButton jbtnLuu;
    private String mssv;

    public JPanel Import(String mssv) {
        this.mssv = mssv;
        JPanel pnDoiMK = new JPanel();
        pnDoiMK.setLayout(new GridLayout(1, 2));

        JPanel pnImport = new JPanel();
        pnImport.setLayout(new GridLayout(15, 2, 2, 2));
        TitledBorder titleSelect = new TitledBorder("Đổi mật khẩu");
        pnImport.setBorder(titleSelect);

        jLabel1 = new JLabel("Mật Khẩu Cũ");
        jtxtOldPass = new JTextField(20);

        jLabel2 = new JLabel("Nhập mật khẩu mới:");
        jtxtNewPass = new JTextField(20);

        jLabel3 = new JLabel("Nhập Lại mật khẩu mới:");
        jtxtAgain = new JTextField(20);

        jbtnLuu = new JButton("Lưu");
        pnImport.add(jLabel1);
        pnImport.add(jtxtOldPass);
        pnImport.add(jLabel2);
        pnImport.add(jtxtNewPass);
        pnImport.add(jLabel3);
        pnImport.add(jtxtAgain);
        pnImport.add(jbtnLuu);

        pnDoiMK.add(pnImport);
        jbtnLuu.addActionListener(this);
        return pnDoiMK;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtnLuu) {
            boolean checked = kiemTraDoiMK();
            if(!checked) {
                SinhVien sv = SinhVienDAO.layThongTinSinhVien(mssv);
                sv.setMatKhau(jtxtNewPass.getText());
                boolean updateTaiKhoan = SinhVienDAO.capNhatThongTinSinhVien(sv);
                if (updateTaiKhoan == true) {
                    JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "!!! Đồi mật khẩu không thành công");
                }
            }
        }
    }
    private boolean kiemTraDoiMK()
    {
        boolean valid = false;
        String oldPass = jtxtOldPass.getText();
        String newPass = jtxtNewPass.getText();
        String passAgain = jtxtAgain.getText();
        SinhVien sv = SinhVienDAO.layThongTinSinhVien(mssv);

        if(oldPass.equals("") || newPass.equals("") || passAgain.equals("")){
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Mật Khẩu Đầy Đủ !!!", "Error", JOptionPane.ERROR_MESSAGE);
            valid = true;
        } else {
            if(!sv.getMatKhau().equals(oldPass)){
                JOptionPane.showMessageDialog(null, "Mật Khẩu Cũ Không Chính Xác!!!", "Error", JOptionPane.ERROR_MESSAGE);
                valid = true;
            } else if(!passAgain.equals(newPass)){
                JOptionPane.showMessageDialog(null, "Mật Khẩu Xác Nhận Không Chính Xác!!!", "Error", JOptionPane.ERROR_MESSAGE);
                valid = true;
            } else{
                valid = false;
            }
        }
        return valid;
    }
}