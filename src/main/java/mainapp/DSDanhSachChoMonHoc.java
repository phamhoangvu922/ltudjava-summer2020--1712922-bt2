package mainapp;

import dao.DanhSachChoMonHocDAO;
import pojo.DanhSachChoMonHoc;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DSDanhSachChoMonHoc  extends JPanel implements ActionListener {
    JPanel pnClass;
    JButton btnSelect;
    JTable table;
    JScrollPane jspDSLop;
    JTextField txtClass, txtSubject;

    public JPanel ListSVMH() {
        //Class
        pnClass = new JPanel();
        TitledBorder titleClass = new TitledBorder("Danh sách lớp");
        pnClass.setBorder(titleClass);
//        pnClass.setLayout(new GridLayout(2, 1));
        pnClass.setLayout(null);

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
        lblSubject.setText("Tên môn học: ");
        lblSubject.setBounds(320, 20, 100, 30);
        txtSubject = new JTextField();
        txtSubject.setBounds(420, 20, 200, 30);

        btnSelect = new JButton("Tìm kiếm");
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
        jspDSLop = new JScrollPane(table);
        pnListSV.add(jspDSLop);


        pnInput.setBounds(10, 20, 765, 150);
        pnListSV.setBounds(10, 180, 765, 450);
        pnClass.add(pnInput);
        pnClass.add(pnListSV);

        //Add function
        btnSelect.addActionListener(this);
        return pnClass;
    }

    public void getDanhSachLopMonHocLop(String subjectName, String className) {
        //sp.setVisible(true);
        String[] columns = new String[]{"Mã sinh viên", "Họ tên", "Giới tính", "CMND", "Lớp", "Môn học"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        List<pojo.DanhSachChoMonHoc> listStudentsSubject = null;
        listStudentsSubject = DanhSachChoMonHocDAO.layDanhSachSinhVienTheoMonHoc(subjectName);
        for (pojo.DanhSachChoMonHoc dsmh : listStudentsSubject)
        {
            model.addRow(new Object[]{dsmh.getId().getMssv(), dsmh.getHoTen(), dsmh.getGioiTinh(), dsmh.getCmnd(),
                    dsmh.getLop(),dsmh.getId().getMonHoc()});
        }
        table.setModel(model);

    }


    public void actionPerformed(ActionEvent e) {

    }
}
