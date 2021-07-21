package gun5odev1.business.concretes;

import javax.sound.midi.Soundbank;

import gun5odev1.business.abstracts.CustomerCheckService;
import gun5odev1.business.abstracts.CustomerService;
import gun5odev1.business.abstracts.EMailVerificationService;
import gun5odev1.dataAccess.abstracts.CustomerDao;
import gun5odev1.entities.concretes.Customer;

public class CustomerManager implements CustomerService {

	private CustomerDao productDao;
	private CustomerCheckService checkService;
	private EMailVerificationService verificationService;

	public CustomerManager(CustomerDao productDao, CustomerCheckService checkService, EMailVerificationService verificationService) {
		this.productDao = productDao;
		this.checkService = checkService;
		this.verificationService = verificationService;
	}

	@Override
	public void register(Customer customer) {
		
		checkService.checkPassword(customer);
		checkService.checkFirstNameLastName(customer);
		checkService.checkIfEmailUsed(customer);
		checkService.checkEMail(customer);
		
		productDao.add(customer);
		verificationService.sendVerification(customer);
		
	}

	@Override
	public void signIn(Customer customer) {
		
		checkService.checkIfVerificated(customer);
		
		for (Customer customers : productDao.getAll()) {
			if (customer.geteMail().equals(customers.geteMail()) && customer.getPassword().equals(customers.getPassword())) {
				System.out.println("Sisteme giriþ baþarýlý.");
			}
			else {
				System.out.println("Kullanýcý adý veya parola hatalý.");
			}
		}
		
		
	}

}
