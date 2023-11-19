package in.ineuron.Test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;


public class InsertRecord {

	public static void main(String[] args) {
		
		Session session = null;
		boolean flag = false; 
		Transaction transaction = null; 
		int id = 0;
		
		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				transaction = session.beginTransaction();
			}
			
			if(transaction != null) {
				BankAccount account = new BankAccount();
				account.setHoldername("Keshav");
				account.setBalance(1001425.45f);
				account.setStatus("active");
				
				flag = true; 
				id = (Integer) session.save(account);
			}
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object Entered in the DB with pk:: " + id);
			}
			else {
				transaction.rollback();
				System.out.println("Object failed to enter in the DB");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}