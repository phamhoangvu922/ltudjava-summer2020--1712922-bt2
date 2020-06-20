package mainapp;

import com.sun.deploy.security.SelectableSecurityManager;
import dao.BangPhucKhaoDAO;
import dao.PhucKhaoDAO;
import dao.SinhVienDAO;
import pojo.BangPhucKhao;
import pojo.IDPhucKhao;
import pojo.PhucKhao;
import pojo.SinhVien;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UIDSBangPhucKhao extends JPanel implements ActionListener {

    JTextField txtPhucKhao, txtUpdate, txtMSSV, txtMaMon,txtTinhTrang,txtNgay;
    JButton btnSelect, btnUpdate;
    JTable table;
    JScrollPane jspDSPK;

    public JPanel Import()
    {
        JPanel pnDSPK = new JPanel();
        TitledBorder titleClass = new TitledBorder("Danh sách phúc khảo đã gửi");
        pnDSPK.setBorder(titleClass);
//        pnClass.setLayout(new GridLayout(2, 1));
        pnDSPK.setLayout(null);

        JPanel pnInput = new JPanel();
        pnInput.setLayout(new GridLayout(1, 2));

        JPanel pnSelect = new JPanel();
        TitledBorder titleSelect = new TitledBorder("Tìm kiếm");
        pnSelect.setBorder(titleSelect);
        pnSelect.setLayout(new GridLayout(10, 2, 2, 2));

        JLabel lblPhucKhao = new JLabel();
        lblPhucKhao.setText("Mã phúc khảo: ");
        txtPhucKhao = new JTextField(10);

        btnSelect = new JButton("Tìm kiếm");
        btnSelect.setBackground(Color.lightGray);


        pnSelect.add(lblPhucKhao);
        pnSelect.add(txtPhucKhao);
        pnSelect.add(btnSelect);
        pnInput.add(pnSelect);


        JPanel pnUpdate = new JPanel();
        TitledBorder titleUpdate = new TitledBorder("Cập nhật tình trạng");
        pnUpdate.setBorder(titleUpdate);
        pnUpdate.setLayout(new GridLayout(10, 2, 2, 2));

        JLabel lblUpdate = new JLabel();
        lblUpdate.setText("Mã số sinh viên: ");
        txtMSSV = new JTextField(10);
        JLabel lblMaMon = new JLabel("Mã môn");
        txtMaMon = new JTextField(10);
        JLabel lblNgayThi = new JLabel("Ngày thi (nhập theo định dạng dd/mm/yyyy): ");
        txtNgay = new JTextField(10);
        JLabel lblTinhTrang = new JLabel("Tình trạng: ");
        txtTinhTrang = new JTextField(10);

        btnUpdate = new JButton("Cập nhật");
        btnUpdate.setBackground(Color.lightGray);


        pnUpdate.add(lblUpdate);
        pnUpdate.add(txtMSSV);
        pnUpdate.add(lblMaMon);
        pnUpdate.add(txtMaMon);
        pnUpdate.add(lblNgayThi);
        pnUpdate.add(txtNgay);
        pnUpdate.add(lblTinhTrang);
        pnUpdate.add(txtTinhTrang);
        pnUpdate.add(btnUpdate);
        pnInput.add(pnUpdate);


        JPanel pnListPK = new JPanel();
        TitledBorder titleLitsPK = new TitledBorder("Danh sách các đơn phúc khảo");
        pnListPK.setBorder(titleLitsPK);
        pnListPK.setLayout(new GridLayout(1, 1));
        table = new JTable();
        jspDSPK = new JScrollPane(table);
        pnListPK.add(jspDSPK);


        pnInput.setBounds(10, 20, 765, 250);
        pnListPK.setBounds(10, 300, 765, 500);
        pnDSPK.add(pnInput);
        pnDSPK.add(pnListPK);

        btnSelect.addActionListener(this);
        btnUpdate.addActionListener(this);

        return  pnDSPK;
    }

    public void getDanhSachPK(Date ngayBD, Date ngayKT) {
        //sp.setVisible(true);
        String[] columns = new String[]{"Mã sinh viên", "Môn học", "Ngày thi","Họ tên", "Cột điểm", "Điểm mong muốn", "Lý do", "Tình trạng", "Ngày gửi"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        List<PhucKhao> listPhucKhao = PhucKhaoDAO.getListPhucKhao(ngayBD,ngayKT);
        for (PhucKhao pk : listPhucKhao)
        {
            model.addRow(new Object[]{pk.getId().getMssv(), pk.getId().getMonHoc(), pk.getId().getNgay(), pk.getHoTen(),
            pk.getCotDiem(), pk.getDiemMongMuon(), pk.getLyDo(), pk.getTinhTrang(), pk.getDate()});
        }
        table.setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSelect){
            BangPhucKhao bpk = BangPhucKhaoDAO.getBangPhucKhao(txtPhucKhao.getText());
            if (bpk == null)
            {
                System.out.println("Không tồn tại");
            }
            else{
                String dayBegin = bpk.getNgayBatDau();
                String dayEnd = bpk.getNgayKetThuc();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date beginDate = formatter.parse(dayBegin);
                    Date endDate = formatter.parse(dayEnd);
                    getDanhSachPK(beginDate, endDate);

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        }

        if(e.getSource() == btnUpdate) {
            if(!txtMSSV.getText().isEmpty() && !txtMaMon.getText().isEmpty() && !txtNgay.getText().isEmpty())
            {
                IDPhucKhao id = new IDPhucKhao(txtMSSV.getText(), txtMaMon.getText(), txtNgay.getText());
                PhucKhao pk1 = PhucKhaoDAO.getPhucKhao(id);
                System.out.println(pk1.getHoTen());
                pk1.setTinhTrang(txtTinhTrang.getText());
                boolean create = PhucKhaoDAO.updatePhucKhao(pk1);
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
