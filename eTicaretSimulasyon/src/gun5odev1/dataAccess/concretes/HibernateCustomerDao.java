package gun5odev1.dataAccess.concretes;

import java.util.ArrayList;

import gun5odev1.dataAccess.abstracts.CustomerDao;
import gun5odev1.entities.concretes.Customer;

public class HibernateCustomerDao implements CustomerDao {
	
	ArrayList<Customer> customers;
	
	public HibernateCustomerDao(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public void add(Customer customer) {
		customers.add(customer);
		System.out.println("Sisteme eklendi: " + customer.getFirstName() + " " + customer.getLastName());
	}

	@Override
	public Customer get(int id) {
		return customers.get(id);
	}

	@Override
	public ArrayList<Customer> getAll() {
		return customers;
	}

}
