package mainapp;

import dao.DiemDAO;
import pojo.Diem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class UIDSDiem  extends JPanel implements ActionListener  {
    JPanel pnScore;
    JButton btnSelect;
    JTable table;
    JScrollPane jspDSDiem;
    JTextField txtClass, txtSubject;
    int countPass = 0, countFailed = 0;
    JLabel lblPercentFailed, lblPercentPass;
    public JPanel ListDiem() {
        //Class
        pnScore = new JPanel();
        TitledBorder titleScore = new TitledBorder("Danh sách điểm");
        pnScore.setBorder(titleScore);
        pnScore.setLayout(null);

        JPanel pnInput = new JPanel();
        pnInput.setLayout(new GridLayout(1, 1));

        JPanel pnSelect = new JPanel();
        TitledBorder titleSelect = new TitledBorder("Tìm kiếm");
        pnSelect.setBorder(titleSelect);
        pnSelect.setLayout(null);

        JLabel lblClass = new JLabel();
        lblClass.setText("Tên lớp: ");
        lblClass.setBounds(20, 20, 100, 30);
        txtClass = new JTextField();
        txtClass.setBounds(120, 20, 200, 30);

        JLabel lblSubject = new JLabel();
        lblSubject.setText("Mã môn học: ");
        lblSubject.setBounds(320, 20, 100, 30);
        txtSubject = new JTextField();
        txtSubject.setBounds(420, 20, 200, 30);

        btnSelect = new JButton("Tìm kiếm");
        btnSelect.setBackground(Color.lightGray);
        btnSelect.setBounds(650, 20, 100, 30);

        pnSelect.add(lblClass);
        pnSelect.add(txtClass);
        pnSelect.add(lblSubject);
        pnSelect.add(txtSubject);
        pnSelect.add(btnSelect);
        pnInput.add(pnSelect);

        JPanel pnListSV = new JPanel();
        TitledBorder titleLitsSV = new TitledBorder("Danh sách lớp");
        pnListSV.setBorder(titleLitsSV);
        pnListSV.setLayout(new GridLayout(1, 1));
        table = new JTable();
        jspDSDiem = new JScrollPane(table);
        pnListSV.add(jspDSDiem);


        pnInput.setBounds(10, 20, 765, 80);
        pnListSV.setBounds(10, 100, 765, 500);
        pnScore.add(pnInput);
        pnScore.add(pnListSV);

        lblPercentPass = new JLabel();
        lblPercentPass.setBounds(300, 600, 200, 30);
        lblPercentFailed = new JLabel();
        lblPercentFailed.setBounds(500, 600, 200, 30);
        pnScore.add(lblPercentPass);
        pnScore.add(lblPercentFailed);

        //Add function
        btnSelect.addActionListener(this);
        return pnScore;
    }

    public void getDanhSachDiem(String className, String subjectName) {
        //sp.setVisible(true);
        String[] columns = new String[]{"Mã sinh viên", "Họ tên", "Điểm GK", "Điểm CK", "Điểm khác", "Điểm tổng", "Lớp",
                "Môn học", "Kết quả"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        List<Diem> listScores = null;
        listScores = DiemDAO.layDanhSachDiemTheoLopMonHoc(className,subjectName);
        countPass = 0;
        countFailed = 0;
        for (pojo.Diem diem : listScores)
        {
            String result = "";
            if(diem.getDiemTong()>=5)
            {
                result = "Đậu";
                countPass = countPass+1;
            }
            else
            {
                result = "Rớt";
                countFailed = countFailed+1;
            }
            model.addRow(new Object[]{diem.getId().getMssv(), diem.getHoTen(), diem.getDiemGk(), diem.getDiemCk(),diem.getDiemKhac(),
                    diem.getDiemTong(),diem.getId().getLop(), diem.getId().getMonHoc(),result});
        }
        table.setModel(model);
        lblPercentFailed.setText("Số lượng rớt: " + countFailed + "   Tỉ lệ: " + ((double)Math.round((((float) countFailed / listScores.size()) * 100)*10)/10) + "%");
        lblPercentPass.setText("Số lượng đậu: " + countPass + "   Tỉ lệ: " + ((double)Math.round((((float) countPass / listScores.size()) * 100)*10)/10) + "%");
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSelect){
            getDanhSachDiem(txtClass.getText(), txtSubject.getText());
        }
    }
}
