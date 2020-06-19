package mainapp;

import com.sun.deploy.security.SelectableSecurityManager;
import dao.BangPhucKhaoDAO;
import dao.PhucKhaoDAO;
import dao.SinhVienDAO;
import pojo.BangPhucKhao;
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

    JTextField txtPhucKhao;
    JButton btnSelect;
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
        pnInput.setLayout(new GridLayout(1, 1));

        JPanel pnSelect = new JPanel();
        TitledBorder titleSelect = new TitledBorder("Tìm kiếm");
        pnSelect.setBorder(titleSelect);
        pnSelect.setLayout(null);

        JLabel lblPhucKhao = new JLabel();
        lblPhucKhao.setText("Mã phúc khảo: ");
        lblPhucKhao.setBounds(20, 20, 100, 30);
        txtPhucKhao = new JTextField();
        txtPhucKhao.setBounds(120, 20, 250, 30);

        btnSelect = new JButton("Tìm kiếm");
        btnSelect.setBackground(Color.lightGray);
        btnSelect.setBounds(500, 20, 100, 30);


        pnSelect.add(lblPhucKhao);
        pnSelect.add(txtPhucKhao);
        pnSelect.add(btnSelect);
        pnInput.add(pnSelect);

        JPanel pnListPK = new JPanel();
        TitledBorder titleLitsPK = new TitledBorder("Danh sách các đơn phúc khảo");
        pnListPK.setBorder(titleLitsPK);
        pnListPK.setLayout(new GridLayout(1, 1));
        table = new JTable();
        jspDSPK = new JScrollPane(table);
        pnListPK.add(jspDSPK);


        pnInput.setBounds(10, 20, 765, 80);
        pnListPK.setBounds(10, 100, 765, 500);
        pnDSPK.add(pnInput);
        pnDSPK.add(pnListPK);

        btnSelect.addActionListener(this);

        return  pnDSPK;
    }

    public void getDanhSachPK(Date ngayBD, Date ngayKT) {
        //sp.setVisible(true);
        String[] columns = new String[]{"Mã sinh viên", "Môn học", "Ngày","Họ tên", "Cột điểm", "Điểm mong muốn", "Lý do", "Tình trạng"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        List<PhucKhao> listPhucKhao = PhucKhaoDAO.getListPhucKhao(ngayBD,ngayKT);
        for (PhucKhao pk : listPhucKhao)
        {
            model.addRow(new Object[]{pk.getId().getMssv(), pk.getId().getMonHoc(), pk.getId().getNgay(), pk.getHoTen(),
            pk.getCotDiem(), pk.getDiemMongMuon(), pk.getLyDo(), pk.getTinhTrang()});
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
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date beginDate = formatter.parse(dayBegin);
                    Date endDate = formatter.parse(dayEnd);
                    getDanhSachPK(beginDate, endDate);

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }
}
