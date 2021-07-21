package gun5odev1.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.ls.LSOutput;

import gun5odev1.business.abstracts.CustomerCheckService;
import gun5odev1.business.abstracts.RegexEMailService;
import gun5odev1.dataAccess.abstracts.CustomerDao;
import gun5odev1.entities.concretes.Customer;

public class CustomerCheckManager implements CustomerCheckService {

	private CustomerDao productDao;
	private RegexEMailService eMailService;

	public CustomerCheckManager(CustomerDao productDao, RegexEMailService eMailService) {
		this.productDao = productDao;
		this.eMailService = eMailService;
	}
	
	@Override
	public void checkPassword(Customer customer) {
		
		if (customer.getPassword().length() < 6) {
			System.out.println("�ifre en az 6 karakter uzunlu�unda olmal�d�r.");
			System.exit(0);
		}
		
	}

	@Override
	public void checkFirstNameLastName(Customer customer) {
		
		if (customer.getFirstName().length() < 2 || customer.getLastName().length() < 2) {
			System.out.println("Ad ve soyad en az 2 karakter uzunlu�unda olmal�d�r.");
			System.exit(0);
		}
		
	}

	@Override
	public void checkIfEmailUsed(Customer customer) {
		
		for (Customer customers : productDao.getAll()) {
			if (customer.geteMail().equals(customers.geteMail())) {
				System.out.println("Bu E-Mail daha �nce kullan�lm��.");
				System.exit(0);
			}
		}

	}

	@Override
	public void checkIfVerificated(Customer customer) {
		
		if (!customer.isVerificated()) {
			System.out.println("E-Mail do�rulanmam��.");
			System.exit(0);
		}
		
	}

	@Override
	public void checkEMail(Customer customer) {
		
		if (!eMailService.valEMail(customer.geteMail())) {
			System.out.println("E-Mail format� yanl��.");
			System.exit(0);
		}
	}
	
}
