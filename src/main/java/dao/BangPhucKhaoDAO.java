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


    public static boolean themBangPhucKhao(BangPhucKhao bpk) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (BangPhucKhaoDAO.getBangPhucKhao(bpk.getId()) != null) {
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
}