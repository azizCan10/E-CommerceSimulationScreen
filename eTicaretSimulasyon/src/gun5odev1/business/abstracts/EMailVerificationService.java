package gun5odev1.business.abstracts;

import gun5odev1.entities.concretes.Customer;

public interface EMailVerificationService {
	
	void sendVerification(Customer customer);
	void clickVerification(Customer customer);
}
