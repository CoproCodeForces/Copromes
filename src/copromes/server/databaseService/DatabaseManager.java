package copromes.server.databaseService;

import java.util.Date;
import java.util.List;

import copromes.commonInterfaces.InvalidRegistrationException;
import copromes.domainLayer.ChatRoom;
import copromes.domainLayer.Message;
import copromes.domainLayer.User;

public class DatabaseManager {
	
	public DatabaseManager() {
		
	}

	public List<User> getUsersOnline() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addFriend(User friend) {
		// TODO Auto-generated method stub
		
	}

	public void deleteFriend(User friend) {
		// TODO Auto-generated method stub
		
	}

	public List<User> findUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public User doLogin(String name, String passwordHash) {
		// TODO Auto-generated method stub
		return null;
	}

	public void doLogout(User user) {
		//Some database related code
		//SELECT INSERT UPDATE WHERE
		
		user.setLastSeenDate(new Date());
	}

	public User registerUser(String login, String passwordHash,
			String passwordConfirmationHash, String name, String Bio)
			throws InvalidRegistrationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Message sendMessage(String message, ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		return null;
	}

	public ChatRoom createChatRoom(User user, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public ChatRoom addUserToChatRoom(User user, ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		return null;
	}

	public ChatRoom deleteUserFromChatRoom(User user, ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteChatRoom(ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		
	}
}
