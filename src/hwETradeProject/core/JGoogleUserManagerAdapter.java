package hwETradeProject.core;

import hwETradeProject.jUser.JGoogleUserManager;

public class JGoogleUserManagerAdapter implements JGoogleUserService {

	@Override
	public void registerToSystem(String message) {
		JGoogleUserManager manager=new JGoogleUserManager();
		manager.register(message);
		
	}
	

}
