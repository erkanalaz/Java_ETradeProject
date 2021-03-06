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
			System.out.println("Kullanıcı parolası minimum 6 karakterden oluşmalıdır!");
		}else if(!emailValidation) {
			System.out.println("Girilen e-posta gereksinimleri karşılamıyor!");
		}else if(!firstNameValidation) {
			System.out.println("Girilen kullanıcı ismi gereksinimleri karşılamıyor!");
		}else if(!lastNameValidation) {
			System.out.println("Girilen kullanıcı soyismi gereksinimleri karşılamıyor!");
		}else		
			this.userDao.register(user);
			
		//this.jGoogleUserService.registerToSystem("KAYIT BAŞARILI");
		
		if (userEmailCheck.getEmailCheckYesOrNo()!=null) {
			System.out.println("Doğrulama başarısız!");
		}else
			System.out.println("Doğrulama başarılı bir şekilde gerçekleştirildi.");
			
		
		
		
	}

	@Override
	public void login(User user) {
		if (user.getEmail()==null || user.getPassword()==null) {
			System.out.println("Kullanıcı girişi başarısız!");
		}else
			this.userDao.login(user);
		
	}
	
}
