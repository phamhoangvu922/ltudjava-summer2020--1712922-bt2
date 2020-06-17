package mainapp;

import dao.SinhVienDAO;
import pojo.SinhVien;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UILop extends JPanel implements ActionListener {
    JPanel pnClass;
    JButton btnSelect, btnImport, btnCreate;
    JTable table;
    JScrollPane jspDSLop;
    JTextField txtClassImp, txtClassCre, txtStudentIDCre, txtStudentNameCre, txtGenderCre, txtCMNDCre;
    File selectedFile;
    public JPanel Import() {
        //Class
        pnClass = new JPanel();
        //TitledBorder titleClass = new TitledBorder("Danh sách lớp");
       // pnClass.setBorder(titleClass);
        pnClass.setLayout(new GridLayout(2, 2));

        //JPanel pnInput = new JPanel();
        //pnInput.setLayout(new GridLayout(1, 2));


        JPanel pnImport = new JPanel();
        pnImport.setLayout(new GridLayout(10, 2, 2, 2));
        TitledBorder titleImport = new TitledBorder("Import danh sách lớp mới");
        pnImport.setBorder(titleImport);

        //JLabel lblClassImp = new JLabel("Đường dẫn");
        //txtClassImp = new JTextField(20);
        btnSelect = new JButton("Chọn file");
        btnSelect.setBackground(Color.lightGray);
        btnImport = new JButton("Import");
        btnImport.setBackground(Color.lightGray);
        //pnImport.add(lblClassImp);
        //pnImport.add(txtClassImp);
        pnImport.add(btnSelect);
        pnImport.add(btnImport);
        //pnInput.add(pnImport);

        JPanel pnCreate = new JPanel();
        pnCreate.setLayout(new GridLayout(11, 2, 2, 2));
        TitledBorder titleCreate = new TitledBorder("Thêm sinh viên mới");
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


        //pnClass.add(pnInput);
        pnClass.add(pnImport);
        pnClass.add(pnCreate);

        //Add function
        btnSelect.addActionListener(this);
        btnImport.addActionListener(this);
        btnCreate.addActionListener(this);
        return pnClass;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSelect){
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = jfc.showOpenDialog(UILop.this);
            // int returnValue = jfc.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = jfc.getSelectedFile();
                System.out.println(selectedFile.getAbsolutePath());
            }
        }
        if(e.getSource() == btnImport){
            if (selectedFile != null) {
                String pathInput = selectedFile.getAbsolutePath();
                DocFile rf = new DocFile();
                try {
                    List <SinhVien> lsv = rf.readFileSinhVien(pathInput);
                    for (int i = 0; i < lsv.size(); i++) {
                        boolean done;
                        done = SinhVienDAO.themSinhVien(lsv.get(i));
                        if (done == false)
                        {
                            JOptionPane.showMessageDialog(null, "Thêm thất bại !!!");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Thêm thành công !!!");
                        }
                    }
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
                SinhVien sv = new SinhVien(txtStudentIDCre.getText(), txtStudentNameCre.getText(), txtGenderCre.getText(),
                        txtCMNDCre.getText(),txtClassCre.getText(),  txtCMNDCre.getText(),  txtCMNDCre.getText());
                boolean create = SinhVienDAO.themSinhVien(sv);
                if(create){
                  //  getDanhSachSV(txtClassCre.getText());
                    JOptionPane.showMessageDialog(null, "Thêm thành công !!!");
                }else{
                    JOptionPane.showMessageDialog(null, "Thêm thất bại !!!");
                }
            }
        }
    }
}
