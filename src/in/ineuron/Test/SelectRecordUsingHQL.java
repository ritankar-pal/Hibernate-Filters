package in.ineuron.Test;
import java.util.List;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;


public class SelectRecordUsingHQL {

	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			
			Filter filter = session.enableFilter("FILTER_BANK_ACCOUNT_STATUS");
			filter.setParameter("accType1", "blocked");
			filter.setParameter("accType2", "closed");
			
			Query<BankAccount> query = session.createQuery("from in.ineuron.model.BankAccount where balance >= :amt");
			
			query.setParameter("amt", 50000f);
			
			List<BankAccount> list = query.list();
			list.forEach(System.out::println);
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}