package mainapp;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UITrangChu extends JFrame {
    JMenuBar jmbMain;
    JMenu jmClass, jmSchedule,jmClassSubject, jmScore, jmPhucKhao;
    JMenuItem jmiImport, jmiTKB, jmiClSub,jmiClassList, jmiClSubList, jmiTKBList, jimScoreImp, jimScoreList, jimBangPK,
            jimDSBangPK;
    JPanel pnMain;
    JLabel lbFile;
    JButton btnLogout;
    public UITrangChu(String tieuDe){
        super(tieuDe);
        jmbMain = new JMenuBar();
        jmClass = new JMenu("Quản lí Lớp");
        jmSchedule = new JMenu("Quản lí Thời Khoá Biểu");
        jmClassSubject = new JMenu("Quản lí Lớp Môn Học");
        jmScore = new JMenu("Quản lí Điểm");
        jmPhucKhao = new JMenu("Quản lí Phúc khảo");

        btnLogout = new JButton("Đăng xuất");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

//        //Class
        UILop lp = new UILop();
        JPanel pnClass = lp.Import();

        UIDSLop dsl = new UIDSLop();
        JPanel pnClassList = dsl.ListSV();

        //Schedule
        UIThoiKhoaBieu tkb = new UIThoiKhoaBieu();
        JPanel pnSchedule = tkb.Import();

        UIDSThoiKhoaBieu dstkb = new UIDSThoiKhoaBieu();
        JPanel pnScheduleList = dstkb.ListTKB();

        //Class Subject
        UIDanhSachChoMonHoc lmh = new UIDanhSachChoMonHoc();
        JPanel pnClassSubject = lmh.QLLMH();

        UIDSDanhSachChoMonHoc dsls = new UIDSDanhSachChoMonHoc();
        JPanel pnClassSubjectList = dsls.ListSVMH();

        //Score
        UIDiem d = new UIDiem();
        JPanel pnScore = d.Import();

        UIDSDiem dsd = new UIDSDiem();
        JPanel pnScoreList = dsd.ListDiem();

        UIBangPhucKhao bpk = new UIBangPhucKhao();
        JPanel pnBangPK = bpk.Import();

        UIDSBangPhucKhao dspk = new UIDSBangPhucKhao();
        JPanel pnDSPK = dspk.Import();

        // add vào card chung
        pnMain = new JPanel(new CardLayout());
        pnMain.add(pnClass, "Class");
        pnMain.add(pnSchedule, "Schedule");
        pnMain.add(pnClassSubject, "ClassSubject");
        pnMain.add(pnClassList, "ClassList");
        pnMain.add(pnClassSubjectList, "ClassSubjectList");
        pnMain.add(pnScheduleList, "ScheduleList");
        pnMain.add(pnScore, "Score");
        pnMain.add(pnScoreList, "ScoreList");
        pnMain.add(pnBangPK, "BangPK");
        pnMain.add(pnDSPK,"DSBangPK");

        final CardLayout cl = (CardLayout) (pnMain.getLayout());


        jmiImport = new JMenuItem(new AbstractAction("Import danh sách lớp") {
            public void actionPerformed(ActionEvent e) {
                cl.show(pnMain, "Class");
            }
        });
        jmiTKB = new JMenuItem(new AbstractAction("Import thời khoá biểu") {
            public void actionPerformed(ActionEvent e) {
                cl.show(pnMain, "Schedule");
            }
        });

        jmiClSub = new JMenuItem(new AbstractAction("Quản lý lớp môn học") {
            public void actionPerformed(ActionEvent e) {
                cl.show(pnMain, "ClassSubject");
            }
        });

        jmiClassList = new JMenuItem(new AbstractAction("Danh sách lớp") {
            public void actionPerformed(ActionEvent e) {
                cl.show(pnMain, "ClassList");
            }
        });

        jmiClSubList = new JMenuItem(new AbstractAction("Danh sách lớp môn học") {
            public void actionPerformed(ActionEvent e) {
                cl.show(pnMain, "ClassSubjectList");
            }
        });

        jmiTKBList = new JMenuItem(new AbstractAction("Danh sách thời khoá biểu") {
            public void actionPerformed(ActionEvent e) {
                cl.show(pnMain, "ScheduleList");
            }
        });

        jimScoreImp = new JMenuItem(new AbstractAction("Import Điểm") {
            public void actionPerformed(ActionEvent e) {
                cl.show(pnMain, "Score");
            }
        });

        jimScoreList = new JMenuItem(new AbstractAction("Danh sách điểm") {
            public void actionPerformed(ActionEvent e) {
                cl.show(pnMain, "ScoreList");
            }
        });

        jimBangPK = new JMenuItem(new AbstractAction("Tạo phúc khảo") {
            public void actionPerformed(ActionEvent e) {
                cl.show(pnMain, "BangPK");
            }
        });

        jimDSBangPK = new JMenuItem(new AbstractAction("Danh sách phúc khảo") {
            public void actionPerformed(ActionEvent e) {
                cl.show(pnMain, "DSBangPK");
            }
        });

        jmClass.add(jmiImport);
        jmClass.add(jmiClassList);
        jmSchedule.add(jmiTKB);
        jmSchedule.add(jmiTKBList);
        jmClassSubject.add(jmiClSub);
        jmClassSubject.add(jmiClSubList);
        jmScore.add(jimScoreImp);
        jmScore.add(jimScoreList);
        jmPhucKhao.add(jimBangPK);
        jmPhucKhao.add(jimDSBangPK);

        jmbMain.add(jmClass);
        jmbMain.add(jmSchedule);
        jmbMain.add(jmClassSubject);
        jmbMain.add(jmScore);
        jmbMain.add(jmPhucKhao);
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
