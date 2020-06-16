package mainapp;

import pojo.IDThoiKhoaBieu;
import pojo.ThoiKhoaBieu;

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

public class UIThoiKhoaBieu extends JPanel implements ActionListener {
    JPanel pnClass;
    JButton btnSelect, btnImport, btnCreate;
    JTable table;
    JScrollPane jspDSLop;
    JTextField txtClassImp;
    File selectedFile;



    public JPanel Import() {
        //Class
        pnClass = new JPanel();
        TitledBorder titleClass = new TitledBorder("Danh sách thời khoá biểu");
        pnClass.setBorder(titleClass);
       // pnClass.setLayout(new GridLayout(1, 1));
        pnClass.setLayout(null);


        JPanel pnInput = new JPanel();
        pnInput.setLayout(new GridLayout(1, 1));


        JPanel pnImport = new JPanel();
        //pnImport.setLayout(new GridLayout(10, 2, 2, 2));
        TitledBorder titleImport = new TitledBorder("Import");
        pnImport.setBorder(titleImport);
       // pnImport.setLayout(null);
       // JLabel lblClassImp = new JLabel("Tên lớp");
        //txtClassImp = new JTextField(20);
        btnSelect = new JButton("Chọn file");
        btnSelect.setBackground(Color.lightGray);
        btnImport = new JButton("Import");
        btnImport.setBackground(Color.lightGray);
        //pnImport.add(lblClassImp);
        //pnImport.add(txtClassImp);
        pnImport.add(btnSelect);
        pnImport.add(btnImport);
        pnInput.add(pnImport);



        pnInput.setBounds(10, 20, 765, 80);
        pnClass.add(pnInput);

        //Add function
        btnSelect.addActionListener(this);
        btnImport.addActionListener(this);
        return pnClass;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSelect){
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = jfc.showOpenDialog(UIThoiKhoaBieu.this);
            // int returnValue = jfc.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = jfc.getSelectedFile();
                System.out.println(selectedFile.getAbsolutePath());
            }
        }
        if(e.getSource() == btnImport){
            if (!txtClassImp.getText().isEmpty() && selectedFile != null) {
                String pathInput = selectedFile.getAbsolutePath();
                DocFile rf = new DocFile();
                try {
                    rf.readFileTKB(pathInput);
//                    getDanhSachTKB(txtClassImp.getText());
                } catch (IOException ex) {
                    Logger.getLogger(UITrangChu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin !!!");
            }
        }
    }
}
