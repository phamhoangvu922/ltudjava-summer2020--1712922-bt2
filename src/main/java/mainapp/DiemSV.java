package mainapp;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiemSV  extends JPanel implements ActionListener {
    JPanel pnScore;
    JButton btnSelect, btnImport, btnCreate;
    JTable table;
    JScrollPane jspDSLop;
    JTextField txtClassImp,txtSubjectImp, txtClassCre, txtStudentIDCre, txtStudentNameCre, txtGenderCre, txtCMNDCre;

    public JPanel Import() {
        //Class
        pnScore = new JPanel();
        TitledBorder titleClass = new TitledBorder("Danh sách lớp");
        pnScore.setBorder(titleClass);
        pnScore.setLayout(new GridLayout(2, 1));

        JPanel pnInput = new JPanel();
        pnInput.setLayout(new GridLayout(1, 2));


        JPanel pnImport = new JPanel();
        pnImport.setLayout(new GridLayout(10, 2, 2, 2));
        TitledBorder titleImport = new TitledBorder("Import");
        pnImport.setBorder(titleImport);

        JLabel lblClassImp = new JLabel("Tên lớp");
        txtClassImp = new JTextField(20);
        JLabel lblSubjectImp = new JLabel("Tên môn học");
        txtSubjectImp = new JTextField(20);
        btnSelect = new JButton("Chọn file");
        btnImport = new JButton("Import");
        pnImport.add(lblClassImp);
        pnImport.add(txtClassImp);
        pnImport.add(lblSubjectImp);
        pnImport.add(txtSubjectImp);
        pnImport.add(btnSelect);
        pnImport.add(btnImport);
        pnInput.add(pnImport);

        JPanel pnCreate = new JPanel();
        pnCreate.setLayout(new GridLayout(11, 2, 2, 2));
        TitledBorder titleCreate = new TitledBorder("Thêm mới");
        pnCreate.setBorder(titleCreate);
        JLabel lblClassCre = new JLabel("Tên lớp");
        txtClassCre = new JTextField(20);
        JLabel lblStudentIDCre = new JLabel("Mã sinh viên");
        txtStudentIDCre = new JTextField(20);
        JLabel lblStudentNameCre = new JLabel("Họ tên");
        txtStudentNameCre = new JTextField(20);
        JLabel lblGenderCre = new JLabel("Giới tính");
        txtGenderCre = new JTextField(20);
        JLabel lblCMNDCre = new JLabel("CMND");
        txtCMNDCre = new JTextField(20);
        btnCreate = new JButton("Lưu");
        pnCreate.add(lblClassCre);
        pnCreate.add(txtClassCre);
        pnCreate.add(lblStudentIDCre);
        pnCreate.add(txtStudentIDCre);
        pnCreate.add(lblStudentNameCre);
        pnCreate.add(txtStudentNameCre);
        pnCreate.add(lblGenderCre);
        pnCreate.add(txtGenderCre);
        pnCreate.add(lblCMNDCre);
        pnCreate.add(txtCMNDCre);
        pnCreate.add(btnCreate);
        pnInput.add(pnCreate);

        JPanel pnListScore = new JPanel();
        TitledBorder titleLitsScore = new TitledBorder("Danh sách điểm");
        pnListScore.setBorder(titleLitsScore);
        pnListScore.setLayout(new GridLayout(1, 1));
        table = new JTable();
        jspDSLop = new JScrollPane(table);
        pnListScore.add(jspDSLop);

        pnScore.add(pnInput);
        pnScore.add(pnListScore);

        //Add function
        btnSelect.addActionListener(this);
        btnImport.addActionListener(this);
        btnCreate.addActionListener(this);
        return pnScore;
    }
    public void actionPerformed(ActionEvent e) {

    }
}
