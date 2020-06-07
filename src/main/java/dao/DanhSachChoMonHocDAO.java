package dao;
import connection.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.DanhSachChoMonHoc;
import pojo.IDDanhSachChoMonHoc;

public class DanhSachChoMonHocDAO {
    public static List<DanhSachChoMonHoc> layDanhSachSinhVienTheoMonHoc(String tenMonhoc) {
        List<DanhSachChoMonHoc> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select dscmh from DanhSachChoMonHoc dscmh "; //where dscmh.monHoc=:monhoc
            Query query = session.createQuery(hql);
//            query.setString("monhoc", tenMonhoc);
            ds = query.list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    public static List<DanhSachChoMonHoc> layDanhSachSinhVienTheoMonHocLop(String tenMonhoc, String tenLop) {
        List<DanhSachChoMonHoc> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select dscmh from DanhSachChoMonHoc dscmh where dscmh.id.monHoc=:monHoc and dscmh.lop=:lop";
            //where dscmh.monHoc=:monHoc and dscmh.lop=:lop
            Query query = session.createQuery(hql);
            query.setString("monHoc", tenMonhoc);
            query.setString("lop", tenLop);
            ds = query.list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    public static DanhSachChoMonHoc layThongTinSinhVien(String maMonHoc, String maMSSV) {
        DanhSachChoMonHoc tkb = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            IDDanhSachChoMonHoc svmhId = new IDDanhSachChoMonHoc(maMSSV, maMonHoc);
            tkb = (DanhSachChoMonHoc) session.get(DanhSachChoMonHoc.class, svmhId);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return tkb;
    }

    public static boolean themSinhVienMonHoc(DanhSachChoMonHoc svmh) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (DanhSachChoMonHocDAO.layThongTinSinhVien(svmh.getId().getMssv(),svmh.getId().getMonHoc())!=null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(svmh);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
    public static boolean xoaSinhVienMonHoc(String maMonHoc, String maMSSV) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        DanhSachChoMonHoc svmh = DanhSachChoMonHocDAO.layThongTinSinhVien(maMonHoc,maMSSV);
        if(svmh==null){
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(svmh);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
}
