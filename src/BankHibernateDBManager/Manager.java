package BankHibernateDBManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import BankHibernateEntity.UserPojoEntity;

public class Manager {
	public static Session establishConnection() {
		//READING the hibernate.cfg.xml  from the classpath 
		StandardServiceRegistry registry =  new StandardServiceRegistryBuilder().configure().build();
		// Create MetadataSources
		MetadataSources sources = new MetadataSources(registry);
		// Create Metadata
		Metadata metadata = sources.getMetadataBuilder().build();
		// Create SessionFactory
		SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession(); // start a transaction
		return session;
	} //end of establishConnection();


	public boolean addUser(UserPojoEntity user) {
		try {
			Session session = establishConnection();
			user.setBalance(user.getStartAmt());
			session.beginTransaction();
				session.save(user);
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			System.out.println(e);
		} //end of try-catch block
		return false;
	} //end of addUser();

	public boolean loginUser(UserPojoEntity user) {
		try {
			Session session = establishConnection();
			Query<UserPojoEntity> list = session.createQuery("from BankHibernateEntity.UserPojoEntity as user where user.userName = :UserName and user.password = : UserPassword");
			list.setParameter("UserName", user.getUserName());
			list.setParameter("UserPassword", user.getPassword());
			List<UserPojoEntity> userList = list.list();
			for(UserPojoEntity u : userList) {
				System.out.println("FIRSTNAME : "+u.getFirstName());
				System.out.println("UserNAME : "+u.getUserName());
				System.out.println("password : "+u.getPassword());
				System.out.println("UserID : "+u.getId());
				System.out.println("FROM INPUT UserNAME : "+user.getUserName());
				System.out.println("FROM INPUT password : "+user.getPassword());
				HashMap<String, String> hashUser = new HashMap<String, String>();
				hashUser.put(u.getUserName(), u.getPassword());
				if(hashUser.containsKey(user.getUserName())) {
					System.out.println("USERNAME CORRECT");
					if(hashUser.get(user.getUserName()).contains(user.getPassword())) {
						System.out.println("User Authenticated");
						user.setId(u.getId());
						user.setAge(u.getAge());
						user.setFirstName(u.getFirstName());
						user.setLastName(user.getLastName());
						user.setUserName(u.getUserName());
						return true;
					}
				} //end of outer if
			} //end of for loop
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	} //end of loginUser;

	public UserPojoEntity findUser(UserPojoEntity user) {
		try {
			Session session = establishConnection();
			session.beginTransaction();
			UserPojoEntity findUser = session.find(UserPojoEntity.class, user.getId());
			session.getTransaction().commit();
			return findUser;
		} catch(Exception e) {
			System.out.println(e);
		}
		UserPojoEntity errorUser = null;
		return errorUser;
	} //end of findUser;

	public int showBalance(UserPojoEntity user) {
		try {
			UserPojoEntity showUser = findUser(user);
			int balance = Integer.parseInt(showUser.getBalance());
			System.out.println(balance);
			return balance;
		}catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	} //end of showBalance method;

	public boolean depositMoney(UserPojoEntity user, int amount) {
		try {
			Session session = establishConnection();
			session.beginTransaction();
			UserPojoEntity updateBalance = session.find(UserPojoEntity.class, user.getId());
			System.out.println(updateBalance.getFirstName());
			int newBalance = Integer.parseInt(updateBalance.getBalance()) + amount;
			String Balance = String.valueOf(newBalance);
			System.out.println(Balance);
			updateBalance.setBalance(Balance);
			session.getTransaction().commit();
			return true;
		}catch(Exception e) {
			System.out.println("Exception in deposit : "+e);
		} //end of try-catch
		return false;
	} //end of deposit Money method

	public boolean withdrawMoney(UserPojoEntity user, int amount) {
		try {
		Session session = establishConnection();
		session.beginTransaction();
				UserPojoEntity updateBalance = session.find(UserPojoEntity.class, user.getId());
				System.out.println(updateBalance.getFirstName());
				int newBalance = Integer.parseInt(updateBalance.getBalance()) - amount;
				String Balance = String.valueOf(newBalance);
				System.out.println(Balance);
				updateBalance.setBalance(Balance);
				session.getTransaction().commit();
			return true;
		}catch(Exception e) {
			System.out.println("Exception in deposit : "+e);
		} //end of try-catch
		return false;
	} //end of deposit Money method

	public boolean transferMoney(UserPojoEntity sender, int userId2, int amount) {
		try {
			Session session = establishConnection();
			session.beginTransaction();
			if(withdrawMoney(sender, amount)) {
				UserPojoEntity transeferAmt = session.find(UserPojoEntity.class, userId2);
				if(depositMoney(transeferAmt, amount)) {
					return true;
				} //end of inner if;
			} //end of outer if;
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception in Transfer Money : "+e);
		} //end of try-catch block;
	return false;
	} //end of transferMoney method
} //end of Manager Class
