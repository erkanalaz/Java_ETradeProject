package hwETradeProject.dataAccess.concretes;

import java.util.List;

import hwETradeProject.dataAccess.abstracts.UserDao;
import hwETradeProject.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void register(User user) {
		System.out.println(user.getFirstName()+" "+user.getLastName()+" kullan�c�s� ba�ar�l� bir �ekilde kaydedildi!");
		System.out.println(user.getEmail()+" adresine do�rulama bilgileri g�nderildi. L�tfen kontrol ediniz!");
		System.out.println("Do�rulama i�lemini ger�ekle�tirdiniz mi? (E) : evet    (H): hay�r");
		
	}

	@Override
	public void login(User user) {
		System.out.println(user.getFirstName()+" "+user.getLastName()+" HO�GELD�N�Z");
		
	}

	@Override
	public List<User> getAll() {
		
		return null;
	}

}
