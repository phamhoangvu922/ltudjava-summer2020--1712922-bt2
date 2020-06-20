package dao;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.IDPhucKhao;
import pojo.PhucKhao;
import connection.HibernateUtil;
import pojo.SinhVien;

public class PhucKhaoDAO {
    public static List<PhucKhao> getListPhucKhao(Date ngayBD, Date ngayKT) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PhucKhao> finalResult = new ArrayList<PhucKhao>();

        try {
            List<PhucKhao> result = null;
            String hql = "select re";
            hql += " from PhucKhao re";
            Query query = session.createQuery(hql);
            result = (List<PhucKhao>) query.list();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            for (int i=0; i<result.size(); i++)
            {
                Date date = formatter.parse(result.get(i).getDate());
                if(date.after(ngayBD)&&date.before(ngayKT))
                {
                    finalResult.add(result.get(i));
                }
            }
        } catch(HibernateException | ParseException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return finalResult;
    }

    public static PhucKhao getPhucKhao(IDPhucKhao id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PhucKhao> result = null;

        try {
            String hql = "select pk from PhucKhao pk where pk.id.mssv=:mssv and pk.id.monHoc=:monHoc and pk.id.ngay=:ngay";
            Query query = session.createQuery(hql);
            query.setString("mssv", id.getMssv());
            query.setString("monHoc", id.getMonHoc());
            query.setString("ngay", id.getNgay());
            result = query.list();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        if(result.get(0) == null)
        {
            System.out.println("ko có");
        }
        return result.get(0);

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
