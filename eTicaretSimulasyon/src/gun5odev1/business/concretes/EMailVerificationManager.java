package gun5odev1.business.concretes;

import gun5odev1.business.abstracts.EMailVerificationService;
import gun5odev1.entities.concretes.Customer;

public class EMailVerificationManager implements EMailVerificationService {

	@Override
	public void sendVerification(Customer customer) {
		System.out.println(customer.geteMail() + " adresine doðrulama e-mail'i gönderildi.");
		
	}

	@Override
	public void clickVerification(Customer customer) {
		customer.setVerificated(true);
	}

}
