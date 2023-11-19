package in.ineuron.Test;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;


public class SelectRecordUsingCriterianApi {

	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			
			Filter filter = session.enableFilter("FILTER_BANK_ACCOUNT_STATUS");
			filter.setParameter("accType1", "blocked");
			filter.setParameter("accType2", "closed");
			
			Criteria criteria = session.createCriteria(BankAccount.class);
			Criterion cond = Restrictions.ge("balance", 50000.0f);
			criteria.add(cond);
			
			List<BankAccount> list = criteria.list();
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