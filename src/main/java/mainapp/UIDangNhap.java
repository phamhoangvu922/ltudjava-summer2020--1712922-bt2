package mainapp;
import dao.SinhVienDAO;
import pojo.SinhVien;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UIDangNhap extends JFrame implements ActionListener {
    JPanel dangNhap;
    JLabel lbtenTaiKhoan,lbpassWord;
    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton buttonDangNhap;
    public UIDangNhap(String tieuDe){
        super(tieuDe);
        dangNhap = new JPanel();
        TitledBorder title = new TitledBorder("Đăng nhập");
        title.setTitleColor(Color.red);
        dangNhap.setBorder(title);
        dangNhap.setLayout(null);

        lbtenTaiKhoan = new JLabel();
        lbtenTaiKhoan.setText("Tên đăng nhập: ");
        lbtenTaiKhoan.setForeground(Color.blue);
        lbtenTaiKhoan.setBounds(15, 20, 100, 30);
        lbpassWord = new JLabel();
        lbpassWord.setText("Mật khẩu: ");
        lbpassWord.setForeground(Color.blue);
        lbpassWord.setBounds(15, 60, 100, 30);

        //text field
        txtUsername = new JTextField();
        txtUsername.setText("ví dụ: 1712001");
        txtUsername.setBounds(115, 20, 250, 30);
        txtPassword = new JPasswordField();
        txtPassword.setText("ví dụ: 123456");
        txtPassword.setBounds(115, 60, 250, 30);

        buttonDangNhap = new JButton();
        buttonDangNhap.setText("Đăng nhập");
        buttonDangNhap.setBounds(100, 110, 100, 30);

        dangNhap.add(lbtenTaiKhoan);
        dangNhap.add(lbpassWord);
        dangNhap.add(txtUsername);
        dangNhap.add(txtPassword);
        dangNhap.add(buttonDangNhap);

        Container con = getContentPane();
        con.add(dangNhap);

        buttonDangNhap.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonDangNhap){
            String tk = txtUsername.getText().toString();
            char[] pass = txtPassword.getPassword();
            String mk = new String(pass);
            SinhVien sv = SinhVienDAO.layThongTinSinhVien(tk);
            if(sv!= null){
                if( mk.equals(sv.getMatKhau())){
                    System.out.println("Đăng nhập thành công");
//                    JOptionPane.showMessageDialog(null,"Đăng nhập thành công !!!");
                    //main
                    UITrangChu swing = new UITrangChu("Main");
                    swing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    swing.setVisible(true);
                    swing.setSize(800, 700);
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Đăng nhập thất bại !!!");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Tài khoản không tồn tại !!!");
                System.out.println("Tài khoản không tồn tại");
            }
        }
    }
}

