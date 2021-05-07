package hwETradeProject.dataAccess.concretes;

import java.util.List;

import hwETradeProject.dataAccess.abstracts.UserDao;
import hwETradeProject.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void register(User user) {
		System.out.println(user.getFirstName()+" "+user.getLastName()+" kullanýcýsý baþarýlý bir þekilde kaydedildi!");
		System.out.println(user.getEmail()+" adresine doðrulama bilgileri gönderildi. Lütfen kontrol ediniz!");
		System.out.println("Doðrulama iþlemini gerçekleþtirdiniz mi? (E) : evet    (H): hayýr");
		
	}

	@Override
	public void login(User user) {
		System.out.println(user.getFirstName()+" "+user.getLastName()+" HOÞGELDÝNÝZ");
		
	}

	@Override
	public List<User> getAll() {
		
		return null;
	}

}
