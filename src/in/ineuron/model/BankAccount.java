package in.ineuron.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;


@Entity
@FilterDef(name = "FILTER_BANK_ACCOUNT_STATUS", 
			parameters = {
					@ParamDef(type = "string", name = "accType1"),
					@ParamDef(type = "string", name = "accType2")
			}
)
@Filter(name = "FILTER_BANK_ACCOUNT_STATUS", condition = "status not in (:accType1, :accType2)")
public class BankAccount implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accno; 
	
	private String holdername;
	private Float balance;
	private String status;
	
	
	public Integer getAccno() {
		return accno;
	}

	public void setAccno(Integer accno) {
		this.accno = accno;
	}

	public String getHoldername() {
		return holdername;
	}

	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BankAccount [accno=" + accno + ", holdername=" + holdername + ", balance=" + balance + ", status="
				+ status + "]";
	}
	
}
