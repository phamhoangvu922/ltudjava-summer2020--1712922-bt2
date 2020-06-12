package mainapp;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DangNhap extends JFrame implements ActionListener {
    JPanel dangNhap;
    JLabel lbtenTaiKhoan,lbpassWord;
    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton buttonDangNhap;
    public DangNhap(String tieuDe){
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

    }
}
