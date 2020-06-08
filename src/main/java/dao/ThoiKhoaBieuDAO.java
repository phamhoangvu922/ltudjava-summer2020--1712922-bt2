package dao;
import connection.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.ThoiKhoaBieu;
import pojo.IDThoiKhoaBieu;

public class ThoiKhoaBieuDAO {
    public static List<ThoiKhoaBieu> layDanhSachThoiKhoaBieuTheoLop(String tenLop) {
        List<ThoiKhoaBieu> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select tkb from ThoiKhoaBieu tkb where tkb.id.lop=:lop";
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

    public static ThoiKhoaBieu layThongTinThoiKhoaBieu(String maLop, String maMonHoc) {
        ThoiKhoaBieu tkb = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            IDThoiKhoaBieu tkbId = new IDThoiKhoaBieu(maMonHoc, maLop);
            tkb = (ThoiKhoaBieu) session.get(ThoiKhoaBieu.class, tkbId);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return tkb;
    }

    public static boolean themThoiKhoaBieu(ThoiKhoaBieu tkb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (ThoiKhoaBieuDAO.layThongTinThoiKhoaBieu(tkb.getId().getLop(),tkb.getId().getMaMonHoc())!=null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(tkb);
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
