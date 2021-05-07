package hwETradeProject.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hwETradeProject.business.abstracts.UserService;
import hwETradeProject.core.JGoogleUserManagerAdapter;
import hwETradeProject.core.JGoogleUserService;
import hwETradeProject.dataAccess.abstracts.UserDao;
import hwETradeProject.entities.concretes.User;
import hwETradeProject.entities.concretes.UserEmailCheck;


public class UserManager implements UserService {

	private UserDao userDao;
	private UserEmailCheck userEmailCheck;
	
	
	public UserManager(UserDao userDao, UserEmailCheck userEmailCheck) {
		super();
		this.userDao = userDao;
		this.userEmailCheck = userEmailCheck;
	}
	
	
	
	//private JGoogleUserService jGoogleUserService;
		
	//public UserManager(JGoogleUserService jGoogleUserService) {
	//	super();
		//this.jGoogleUserService = jGoogleUserService;
	//}
	
	
	

	@Override
	public void register(User user) {
		
		boolean emailValidation = Pattern.matches("[a-zA-Z0-9]{1,}[@]{1}[a-z]{5,}[.]{1}+[a-z]{3}", user.getEmail());
		boolean firstNameValidation = Pattern.matches("^[a-zA-Z]{2,100}$", user.getFirstName());
		boolean lastNameValidation = Pattern.matches("^[a-zA-Z]{2,100}$", user.getLastName());

		if (user.getPassword().length()<6) {
			System.out.println("Kullanýcý parolasý minimum 6 karakterden oluþmalýdýr!");
		}else if(!emailValidation) {
			System.out.println("Girilen e-posta gereksinimleri karþýlamýyor!");
		}else if(!firstNameValidation) {
			System.out.println("Girilen kullanýcý ismi gereksinimleri karþýlamýyor!");
		}else if(!lastNameValidation) {
			System.out.println("Girilen kullanýcý soyismi gereksinimleri karþýlamýyor!");
		}else		
			this.userDao.register(user);
			
		//this.jGoogleUserService.registerToSystem("KAYIT BAÞARILI");
		
		if (userEmailCheck.getEmailCheckYesOrNo()!=null) {
			System.out.println("Doðrulama baþarýsýz!");
		}else
			System.out.println("Doðrulama baþarýlý bir þekilde gerçekleþtirildi.");
			
		
		
		
	}

	@Override
	public void login(User user) {
		if (user.getEmail()==null || user.getPassword()==null) {
			System.out.println("Kullanýcý giriþi baþarýsýz!");
		}else
			this.userDao.login(user);
		
	}
	
}
