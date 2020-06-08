package dao;

import connection.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.SinhVien;

public class SinhVienDAO {
    public static List<SinhVien> layDanhSachSinhVien() {
        List<SinhVien> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select sv from SinhVien sv";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    public static List<SinhVien> layDanhSachSinhVienTheoLop(String tenLop) {
        List<SinhVien> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select sv from SinhVien sv where sv.lop=:lop";
            Query query = session.createQuery(hql);
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

    public static SinhVien layThongTinSinhVien(String maSinhVien) {
        SinhVien sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sv = (SinhVien) session.get(SinhVien.class, maSinhVien);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }


    public static SinhVien kiemTraDangNhap(String maSinhVien, String matKhau) {
        SinhVien sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String query = "select sv.mssv from SinhVien sv where sv.mssv='" + maSinhVien + "' and sv.matkhau='" + matKhau + "'";
            sv = (SinhVien) session.get(query,sv);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }

    public static boolean themSinhVien(SinhVien sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SinhVienDAO.layThongTinSinhVien(sv.getMssv())!=null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(sv);
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

    public static boolean capNhatThongTinSinhVien(SinhVien sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SinhVienDAO.layThongTinSinhVien(sv.getMssv()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(sv);
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

    public static boolean xoaSinhVien(String maSinhVien) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        SinhVien sv = SinhVienDAO.layThongTinSinhVien(maSinhVien);
        if(sv==null){
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(sv);
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
