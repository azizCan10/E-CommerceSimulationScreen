package gun5odev1.core.concretes;

import gun5odev1.core.abstracts.RegisterService;

public class GoogleRegisterAdapter implements RegisterService {

	@Override
	public void register() {
		System.out.println("Google ile üye olundu");
		
	}

}
