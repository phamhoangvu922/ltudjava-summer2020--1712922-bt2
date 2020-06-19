package mainapp;

import dao.DiemDAO;
import dao.SinhVienDAO;
import pojo.Diem;
import pojo.IDDiem;
import pojo.SinhVien;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UIDiem  extends JPanel implements ActionListener {
    JPanel pnScore;
    JButton btnSelect, btnImport, btnCreate;
    JTable table;
    JScrollPane jspDSLop;
    JTextField txtClassImp,txtSubjectImp, txtStudentID, txtScoreGK, txtScoreCK,txtScoreKhac, txtScoreTong,txtStudentIDMon, txtClassCre,
    txtStudentName;
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
        TitledBorder titleCreate = new TitledBorder("Cập nhật điểm");
        pnCreate.setBorder(titleCreate);
        JLabel lblClassCre = new JLabel("Tên lớp");
        txtClassCre = new JTextField(20);
        JLabel lblStudentIDMon = new JLabel("Mã môn");
        txtStudentIDMon = new JTextField(20);
        JLabel lblStudentID = new JLabel("Mã số sinh viên");
        txtStudentID = new JTextField(20);
        JLabel lblStudentName = new JLabel("Họ tên sinh viên");
        txtStudentName = new JTextField(20);
        JLabel lblScoreGK = new JLabel("Điểm GK");
        txtScoreGK = new JTextField(20);
        JLabel lblScoreCK = new JLabel("Điểm CK");
        txtScoreCK = new JTextField(20);
        JLabel lblScoreKhac = new JLabel("Điểm Khác");
        txtScoreKhac = new JTextField(20);
        JLabel lblScoreTong = new JLabel("Điểm tổng");
        txtScoreTong = new JTextField(20);
        btnCreate = new JButton("Lưu");
        btnCreate.setBackground(Color.lightGray);
        pnCreate.add(lblClassCre);
        pnCreate.add(txtClassCre);
        pnCreate.add(lblStudentIDMon);
        pnCreate.add(txtStudentIDMon);
        pnCreate.add(lblStudentID);
        pnCreate.add(txtStudentID);
        pnCreate.add(lblStudentName);
        pnCreate.add(txtStudentName);
        pnCreate.add(lblScoreGK);
        pnCreate.add(txtScoreGK);
        pnCreate.add(lblScoreCK);
        pnCreate.add(txtScoreCK);
        pnCreate.add(lblScoreKhac);
        pnCreate.add(txtScoreKhac);
        pnCreate.add(lblScoreTong);
        pnCreate.add(txtScoreTong);
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
                DocFile df = new DocFile();
                try {
                    boolean done=false;
                    List<Diem> diem = df.readFileDiem(pathInput);
                    for (int i = 0; i < diem.size(); i++) {
                        done = DiemDAO.themDiem(diem.get(i));
                    }
                    if (done == false)
                    {
                        JOptionPane.showMessageDialog(null, "Thêm điếm thất bại !!!");                        }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Thêm điểm thành công !!!");
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
            if (!txtClassCre.getText().isEmpty() && !txtStudentIDMon.getText().isEmpty() && !txtStudentID.getText().isEmpty())
            {
                IDDiem id = new IDDiem(txtStudentID.getText(),txtClassCre.getText(), txtStudentIDMon.getText());
                Diem sv = new Diem(id, txtStudentName.getText(), Float.parseFloat(txtScoreGK.getText()),
                        Float.parseFloat(txtScoreCK.getText()),Float.parseFloat(txtScoreKhac.getText()),
                        Float.parseFloat(txtScoreTong.getText()));
                boolean create = DiemDAO.capNhatDiem(sv);
                if(create){
                    //getDanhSachDiem(txtClassCre.getText(),txtSubjectImp.getText());
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công !!!");
                }else{
                    JOptionPane.showMessageDialog(null, "Cập nhật thất bại !!!");
                }
            }
        }
    }
}
