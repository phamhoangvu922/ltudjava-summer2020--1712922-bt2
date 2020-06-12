package mainapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TrangChu extends JFrame {
    JMenuBar jmbMain;
    JMenu jmClass, jmSchedule, jmLogout,jmClassSubject, jmScore;
    JMenuItem jmiImport, jmiTKB, jmiClSub,jmiClassList, jmiClSubList, jmiTKBList, jimScoreImp, jimScoreList;
    JPanel pnMain;
    JLabel lbFile;
    JButton btnSelect, btnImport, btnExit;
    public TrangChu(String tieuDe){
        super(tieuDe);
        jmbMain = new JMenuBar();
        jmClass = new JMenu("Lớp học");
        jmSchedule = new JMenu("Thời Khoá Biểu");
        jmClassSubject = new JMenu("Lớp Môn Học");
        jmScore = new JMenu("Điểm");
        jmLogout = new JMenu(new AbstractAction("Đăng xuất") {
            public void actionPerformed(ActionEvent e) {
                DangNhap login = new DangNhap("Login");
                login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                login.setVisible(true);
                login.setSize(400, 200);
            }
        });
//        //Class
        Lop lp = new Lop();
        JPanel pnClass = lp.Import();

        DSLop dsl = new DSLop();
        JPanel pnClassList = dsl.ListSV();

        //Schedule
        ThoiKhoaBieu tkb = new ThoiKhoaBieu();
        JPanel pnSchedule = tkb.Import();

        DSThoiKhoaBieu dstkb = new DSThoiKhoaBieu();
        JPanel pnScheduleList = dstkb.ListTKB();

        //Class Subject
        DanhSachChoMonHoc lmh = new DanhSachChoMonHoc();
        JPanel pnClassSubject = lmh.QLLMH();

        DSDanhSachChoMonHoc dsls = new DSDanhSachChoMonHoc();
        JPanel pnClassSubjectList = dsls.ListSVMH();

        //Score
        DiemSV d = new DiemSV();
        JPanel pnScore = d.Import();

        DSDiem dsd = new DSDiem();
        JPanel pnScoreList = dsd.ListDiem();

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

        jmClass.add(jmiImport);
        jmClass.add(jmiClassList);
        jmSchedule.add(jmiTKB);
        jmSchedule.add(jmiTKBList);
        jmClassSubject.add(jmiClSub);
        jmClassSubject.add(jmiClSubList);
        jmScore.add(jimScoreImp);
        jmScore.add(jimScoreList);

        jmbMain.add(jmClass);
        jmbMain.add(jmSchedule);
        jmbMain.add(jmClassSubject);
        jmbMain.add(jmScore);
        this.setJMenuBar(jmbMain);
        this.add(pnMain);

//        Container con = getContentPane();
//        con.add(BorderLayout.NORTH, jmbMain);
    }
}
