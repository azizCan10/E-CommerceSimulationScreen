package gun5odev1.business.abstracts;

import gun5odev1.entities.concretes.Customer;

public interface CustomerCheckService {

	void checkPassword(Customer customer);
	void checkFirstNameLastName(Customer customer);
	void checkIfEmailUsed(Customer customer);
	void checkIfVerificated(Customer customer);
	void checkEMail(Customer customer);
	
}
