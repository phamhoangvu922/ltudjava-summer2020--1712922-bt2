package mainapp;

import dao.BangPhucKhaoDAO;
import pojo.BangPhucKhao;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIBangPhucKhao extends JPanel implements ActionListener {
    private JLabel jLabel1, jLabel2, jLabel3;
    private JTextField jtxtIDPK, jtxtNgayBD, jtxtNgayKT;
    private JButton jbtnCreate;

    public JPanel Import() {
        JPanel pnTaoPhucKhao = new JPanel();
        pnTaoPhucKhao.setLayout(new GridLayout(1, 2));

        JPanel pnImport = new JPanel();
        pnImport.setLayout(new GridLayout(15, 2, 2, 2));
        TitledBorder titleSelect = new TitledBorder("Tạo phúc khảo điểm");
        pnImport.setBorder(titleSelect);
        // pnImport.setLayout(null);

        jLabel1 = new JLabel("Mã phúc khảo:");
        jLabel2 = new JLabel("Ngày bắt đầu (nhập theo định dạng dd/mm/yyyy)");
        jLabel3 = new JLabel("Ngày kết thúc (nhập theo định dạng dd/mm/yyyy)");
        jtxtIDPK = new JTextField(20);
        jtxtNgayBD = new JTextField(20);
        jtxtNgayKT = new JTextField(20);
        jbtnCreate = new JButton("Tạo");
        jbtnCreate.setBounds(500, 20, 100, 30);

        pnImport.add(jLabel1);
        pnImport.add(jtxtIDPK);
        pnImport.add(jLabel2);
        pnImport.add(jtxtNgayBD);
        pnImport.add(jLabel3);
        pnImport.add(jtxtNgayKT);
        pnImport.add(jbtnCreate);

        pnTaoPhucKhao.add(pnImport);
        jbtnCreate.addActionListener(this);

        return pnTaoPhucKhao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbtnCreate) {
            if(!jtxtIDPK.getText().isEmpty() && !jtxtNgayBD.getText().isEmpty() && !jtxtNgayKT.getText().isEmpty())
            {
                BangPhucKhao bpk = new BangPhucKhao(jtxtIDPK.getText(), jtxtNgayBD.getText(), jtxtNgayKT.getText());
                boolean create = BangPhucKhaoDAO.themBangPhucKhao(bpk);
                if (create)
                {
                    JOptionPane.showMessageDialog(null, "!!! Tạo thành công");
                }
                else {
                    JOptionPane.showMessageDialog(null, "!!! Tạo thất bại");
                }
            }
        }

    }
}
