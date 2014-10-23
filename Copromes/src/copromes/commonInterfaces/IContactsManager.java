package copromes.commonInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import copromes.domainLayer.*;

public interface IContactsManager extends Remote {
	List<User> getUsersOnline() throws RemoteException;

	void addFriend(User friend) throws RemoteException;

	void deleteFriend(User friend) throws RemoteException;

	List<User> findUser(String name) throws RemoteException;
}
