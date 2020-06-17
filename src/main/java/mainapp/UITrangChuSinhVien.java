package mainapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UITrangChuSinhVien extends JFrame {
    JMenuBar jmbMain;
    JMenu jmAccount, jmPersonalScore,jmPhucKhao;
    JMenuItem jmiImport, jmiPassword;
    JPanel pnMain;
    JButton btnLogout;

    public UITrangChuSinhVien(String tieuDe, String mssv){
        super(tieuDe);
        jmbMain = new JMenuBar();
        jmAccount = new JMenu("Thay đổi thông tin tài khoản");
        jmPersonalScore = new JMenu("Xem điểm cá nhân");
        jmPhucKhao = new JMenu("Phúc khảo");
        btnLogout = new JButton("Đăng xuất");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });


        UIPhucKhao pk = new UIPhucKhao();
        JPanel pnPhucKhao = pk.Import(mssv);

        UIDoiMatKhau mk = new UIDoiMatKhau();
        JPanel pnMK = mk.Import(mssv);

        pnMain = new JPanel(new CardLayout());
        pnMain.add(pnPhucKhao, "PhucKhao");
        pnMain.add(pnMK, "DoiMK");

        final CardLayout cl = (CardLayout) (pnMain.getLayout());

        jmiImport = new JMenuItem(new AbstractAction("Nộp đơn phúc khảo") {
            public void actionPerformed(ActionEvent e) {
                cl.show(pnMain, "PhucKhao");
            }
        });
        jmiPassword = new JMenuItem(new AbstractAction("Thay đồi mật khẩu") {
            public void actionPerformed(ActionEvent e) {
                cl.show(pnMain, "DoiMK");
            }
        });

        jmPhucKhao.add(jmiImport);
        jmAccount.add(jmiPassword);

        jmbMain.add(jmPhucKhao);
        jmbMain.add(jmPersonalScore);
        jmbMain.add(jmAccount);
        jmbMain.add(btnLogout);

        this.setJMenuBar(jmbMain);
        this.add(pnMain);
    }


    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        UIDangNhap login = new UIDangNhap("Login");
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setVisible(true);
        login.setSize(400, 200);
        this.dispose();
    }
}
