package dao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.BangPhucKhao;
import connection.HibernateUtil;

public class BangPhucKhaoDAO {
    public static BangPhucKhao getBangPhucKhao(String idBang) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        BangPhucKhao result = null;

        try {
            result = (BangPhucKhao) session.get(BangPhucKhao.class, idBang);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return result;
    }

    public static List<BangPhucKhao> getListBangPhucKhao() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<BangPhucKhao> result = null;

        try {
            String hql = "select tr from BangPhucKhao tr";
            Query query = session.createQuery(hql);
            result = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return result;
    }
    public static List<BangPhucKhao> getListBangPhucKhaoMo() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<BangPhucKhao> result = null;

        try {
            String hql = "select tr from BangPhucKhao tr where TrangThai = 1";
            Query query = session.createQuery(hql);
            result = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return result;
    }


    public static boolean themBangPhucKhao(BangPhucKhao bpk) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (BangPhucKhaoDAO.getBangPhucKhao(bpk.getId())!= null)
        {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(bpk);
            transaction.commit();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return true;
    }

    public static boolean updateTableReeaxamine(BangPhucKhao tReexamine) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(tReexamine);
            transaction.commit();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return true;
    }
    public static BangPhucKhao kiemTraBangPhucKhao(int idTableReeaxamine) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        BangPhucKhao result = null;

        try {
            result = (BangPhucKhao) session.get(BangPhucKhao.class, idTableReeaxamine);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return result;
    }

}
