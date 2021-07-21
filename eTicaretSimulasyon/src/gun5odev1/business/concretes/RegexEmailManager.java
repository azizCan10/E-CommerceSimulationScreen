package gun5odev1.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gun5odev1.business.abstracts.RegexEMailService;

public class RegexEmailManager implements RegexEMailService {

	@Override
	public boolean valEMail(String eMail) {
		String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPat.matcher(eMail);
		return matcher.find();
	}

}
