package dao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.IDPhucKhao;
import pojo.PhucKhao;
import connection.HibernateUtil;

public class PhucKhaoDAO {
    public static List<PhucKhao> getListPhucKhao(int idBangPhucKhao) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PhucKhao> result = null;

        try {
            String hql = "select re";
            hql += " from PhucKhao re";
            hql += " where re.idBangPhucKhao=:idBangPhucKhao";
            Query query = session.createQuery(hql);
            query.setParameter("idBangPhucKhao", idBangPhucKhao);
            result = (List<PhucKhao>) query.list();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return result;
    }

    public static PhucKhao getPhucKhao(IDPhucKhao id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PhucKhao> result = null;

        try {
            String hql = "select re from PhucKhao re where d.id.mssv=:mssv and d.id.monHoc=:monHoc and d.id.ngay = ngay";
            Query query = session.createQuery(hql);
            query.setParameter("mssv", id.getMssv());
            query.setString("monhoc", id.getMonHoc());
            query.setString("ngay", id.getNgay());
            result = (List<PhucKhao>) query.list();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        if(result.size() > 0) {
            return result.get(0);
        }

        return null;
    }

    public static PhucKhao checkPhucKhao(PhucKhao pk) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PhucKhao> result = null;

        try {
            String hql = "select pk";
            hql += " from PhucKhao pk";
            hql += " where re.mssv=:mssv and pk.monHoc=:monHoc and pk.cotDiem=:cotDiem and pk.idBangPhucKhao=:idBangPhucKhao";
            Query query = session.createQuery(hql);
            query.setParameter("mssv", pk.getId().getMssv());
            query.setParameter("MonHoc", pk.getId().getMonHoc());
            query.setParameter("cotDiem", pk.getCotDiem());
            result = (List<PhucKhao>) query.list();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        if(result.size() > 0) {
            return result.get(0);
        }

        return null;
    }

    public static boolean updatePhucKhao(PhucKhao re) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(PhucKhaoDAO.getPhucKhao(re.getId()) == null) {
            return false;
        }

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(re);
            transaction.commit();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return true;
    }

    public static boolean createPhucKhao(PhucKhao re) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(re);
            transaction.commit();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
}
