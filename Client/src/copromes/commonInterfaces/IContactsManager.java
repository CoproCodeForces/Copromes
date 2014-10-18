package copromes.commonInterfaces;

import java.rmi.Remote;
import java.util.List;
import copromes.domainLayer.*;

public interface IContactsManager extends Remote {
	List<User> getUsersOnline();

	void addFriend(User friend);

	void deleteFriend(User friend);

	List<User> findUser(String name);
}
