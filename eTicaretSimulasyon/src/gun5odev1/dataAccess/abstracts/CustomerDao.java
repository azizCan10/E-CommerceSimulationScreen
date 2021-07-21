package gun5odev1.dataAccess.abstracts;

import java.util.ArrayList;

import gun5odev1.entities.concretes.Customer;

public interface CustomerDao {
	
	void add(Customer customer);
	Customer get(int id);
	ArrayList<Customer> getAll();
	
}
