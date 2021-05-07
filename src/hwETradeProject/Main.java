package hwETradeProject;

import java.util.ArrayList;
import java.util.List;

import hwETradeProject.business.abstracts.UserService;
import hwETradeProject.business.concretes.UserManager;
import hwETradeProject.core.JGoogleUserManagerAdapter;
import hwETradeProject.dataAccess.concretes.HibernateUserDao;
import hwETradeProject.entities.concretes.User;
import hwETradeProject.entities.concretes.UserEmailCheck;

public class Main {

	public static void main(String[] args) {
		
		UserService user=new UserManager(new HibernateUserDao(), new UserEmailCheck());
		//UserService user=new UserManager(new JGoogleUserManagerAdapter());

		
		User user1=new User(1,"Erkan","Alaz","erkanalaz@gmail.com","123456");
		User user2=new User(2,"Ercan","Alaz","ercanalaz@gmail.com","654321");
		User user3=new User(3,"Erman","Alaz","ermanalaz@gmail.com","123465");
		User user4=new User(4,"Erhan","Alaz","erhanalaz@gmail.com","123456");
		User user5=new User(5,"Ersan","Alaz","erdkanalaz@gmail.com","123456");
		
		user.register(user1);
		
		UserEmailCheck userEmailCheck=new UserEmailCheck("Evet");
		
		user.login(user1);
		
	}

}
