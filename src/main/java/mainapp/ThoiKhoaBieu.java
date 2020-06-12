package mainapp;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThoiKhoaBieu extends JPanel implements ActionListener {
    JPanel pnClass;
    JButton btnSelect, btnImport, btnCreate;
    JTable table;
    JScrollPane jspDSLop;
    JTextField txtClassImp;
    public JPanel Import() {
        //Class
        pnClass = new JPanel();
        TitledBorder titleClass = new TitledBorder("Danh sách thời khoá biểu");
        pnClass.setBorder(titleClass);
        pnClass.setLayout(new GridLayout(2, 1));

        JPanel pnInput = new JPanel();
        pnInput.setLayout(new GridLayout(1, 1));


        JPanel pnImport = new JPanel();
        pnImport.setLayout(new GridLayout(10, 2, 2, 2));
        TitledBorder titleImport = new TitledBorder("Import");
        pnImport.setBorder(titleImport);
        JLabel lblClassImp = new JLabel("Tên lớp");
        txtClassImp = new JTextField(20);
        btnSelect = new JButton("Chọn file");
        btnImport = new JButton("Import");
        pnImport.add(lblClassImp);
        pnImport.add(txtClassImp);
        pnImport.add(btnSelect);
        pnImport.add(btnImport);
        pnInput.add(pnImport);


        JPanel pnListSV = new JPanel();
        TitledBorder titleLitsSV = new TitledBorder("Danh sách thời khoá biểu");
        pnListSV.setBorder(titleLitsSV);
        pnListSV.setLayout(new GridLayout(1, 1));
        table = new JTable();
        jspDSLop = new JScrollPane(table);
        pnListSV.add(jspDSLop);

        pnClass.add(pnInput);
        pnClass.add(pnListSV);

        //Add function
        btnSelect.addActionListener(this);
        btnImport.addActionListener(this);
        return pnClass;
    }

    public void actionPerformed(ActionEvent e) {

    }
}
