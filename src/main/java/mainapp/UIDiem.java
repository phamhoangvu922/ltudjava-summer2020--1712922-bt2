package mainapp;

import dao.SinhVienDAO;
import pojo.SinhVien;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UIDiem  extends JPanel implements ActionListener {
    JPanel pnScore;
    JButton btnSelect, btnImport, btnCreate;
    JTable table;
    JScrollPane jspDSLop;
    JTextField txtClassImp,txtSubjectImp, txtClassCre, txtStudentIDCre, txtStudentNameCre, txtGenderCre, txtCMNDCre;
    File selectedFile;

    public JPanel Import() {
        //Class
        pnScore = new JPanel();
        TitledBorder titleClass = new TitledBorder("Danh sách lớp");
        pnScore.setBorder(titleClass);
        pnScore.setLayout(new GridLayout(2, 2));

       // JPanel pnInput = new JPanel();
        //pnInput.setLayout(new GridLayout(1, 1));


        JPanel pnImport = new JPanel();
        pnImport.setLayout(new GridLayout(10, 2, 2, 2));
        TitledBorder titleImport = new TitledBorder("Import");
        pnImport.setBorder(titleImport);

        //JLabel lblClassImp = new JLabel("Tên lớp");
        //txtClassImp = new JTextField(20);
        //JLabel lblSubjectImp = new JLabel("Tên môn học");
        //txtSubjectImp = new JTextField(20);
        btnSelect = new JButton("Chọn file");
        btnSelect.setBackground(Color.lightGray);
        btnImport = new JButton("Import");
        btnImport.setBackground(Color.lightGray);
        //pnImport.add(lblClassImp);
        //pnImport.add(txtClassImp);
        //pnImport.add(lblSubjectImp);
        //pnImport.add(txtSubjectImp);
        pnImport.add(btnSelect);
        pnImport.add(btnImport);
        //pnInput.add(pnImport);

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
        btnCreate.setBackground(Color.lightGray);
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
        //pnInput.add(pnCreate);

        pnScore.add(pnImport);
        pnScore.add(pnCreate);

        //Add function
        btnSelect.addActionListener(this);
        btnImport.addActionListener(this);
        btnCreate.addActionListener(this);
        return pnScore;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSelect){
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = jfc.showOpenDialog(UIDiem.this);
            // int returnValue = jfc.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = jfc.getSelectedFile();
                System.out.println(selectedFile.getAbsolutePath());
            }
        }
        if(e.getSource() == btnImport){
            if (selectedFile != null) {
                String pathInput = selectedFile.getAbsolutePath();
                try {
                    DocFile df = new DocFile();
                    df.readFileDiem(pathInput);
//                    getDanhSachSV(txtClassImp.getText());
                } catch (IOException ex) {
                    Logger.getLogger(UITrangChu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin !!!");
            }
        }
        if(e.getSource() == btnCreate){
            if (!txtStudentIDCre.getText().isEmpty() && !txtStudentNameCre.getText().isEmpty() && !txtClassCre.getText().isEmpty()) {
                SinhVien sv = new SinhVien(txtStudentIDCre.getText(), txtStudentNameCre.getText(),
                        txtGenderCre.getText(), txtCMNDCre.getText(), txtClassCre.getText(), null, null);
                boolean create = SinhVienDAO.themSinhVien(sv);
                if(create){
                    //getDanhSachDiem(txtClassCre.getText(),txtSubjectImp.getText());
                    JOptionPane.showMessageDialog(null, "Thêm thành công !!!");
                }else{
                    JOptionPane.showMessageDialog(null, "Thêm thất bại !!!");
                }
            }
        }
    }
}
