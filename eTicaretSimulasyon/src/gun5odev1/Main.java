package gun5odev1;

import java.util.ArrayList;

import gun5odev1.business.concretes.CustomerCheckManager;
import gun5odev1.business.concretes.CustomerManager;
import gun5odev1.business.concretes.EMailVerificationManager;
import gun5odev1.business.concretes.RegexEmailManager;
import gun5odev1.dataAccess.concretes.HibernateCustomerDao;
import gun5odev1.entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {
		
		Customer customer = new Customer(1, "Aziz Can", "ÖZ", "azizcanoz@gmail.com", "azizcanoz");
		
		ArrayList<Customer> customers = new ArrayList<>();
		
		EMailVerificationManager verificationManager = new EMailVerificationManager();
		
		CustomerManager customerManager = new CustomerManager(new HibernateCustomerDao(customers), new CustomerCheckManager(new HibernateCustomerDao(customers), new RegexEmailManager()), new EMailVerificationManager());
		
		customerManager.register(customer);
		
		verificationManager.clickVerification(customer);
		
		customerManager.signIn(customer);
		
		Customer customer2 = new Customer(1, "Aziz Cann", "ÖZ", "azizcannoz@gmail.com", "azizcanoz1");
		
		customerManager.register(customer2);
		
		customerManager.signIn(customer2);
	}

}
