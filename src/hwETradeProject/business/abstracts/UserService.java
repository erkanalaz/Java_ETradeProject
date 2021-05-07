package hwETradeProject.business.abstracts;

import hwETradeProject.entities.concretes.User;

public interface UserService {
	void register(User user);
	void login(User user);
}
