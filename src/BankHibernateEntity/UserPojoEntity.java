package BankHibernateEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BankServletHibernate")
public class UserPojoEntity {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int age;
	private String firstName, lastName, startAmt, userName, password, balance;

	public UserPojoEntity() {

	}
	public UserPojoEntity(int age, int id, String balance, String firstName, String lastName, String startAmt, String userName,
			String password) {
		super();
		this.age = age;
		this.id = id;
		this.balance = balance;
		this.firstName = firstName;
		this.lastName = lastName;
		this.startAmt = startAmt;
		this.userName = userName;
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStartAmt() {
		return startAmt;
	}
	public void setStartAmt(String startAmt) {
		this.startAmt = startAmt;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
