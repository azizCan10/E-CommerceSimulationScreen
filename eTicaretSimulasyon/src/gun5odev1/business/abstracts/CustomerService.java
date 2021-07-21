package gun5odev1.business.abstracts;

import gun5odev1.entities.concretes.Customer;

public interface CustomerService {
	
	
	void register(Customer customer);
	void signIn(Customer customer);
	
}
