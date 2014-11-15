package copromes.server.databaseService;

import java.util.Date;
import java.util.List;
import java.sql.*;

import copromes.commonInterfaces.InvalidLoginException;
import copromes.commonInterfaces.InvalidRegistrationException;
import copromes.domainLayer.ChatRoom;
import copromes.domainLayer.Message;
import copromes.domainLayer.User;

public class DatabaseManager {

	public DatabaseManager() {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/coprobase", "test", "12345");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

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

	public User doLogin(String name, String passwordHash)
			throws InvalidLoginException {
		// For debug purposes only; there should be some database-related code
		if ((name.equals("Mitya") && passwordHash.equals("kek"))
				|| (name.equals("Mikhail") && passwordHash.equals("lel"))) {
			return new User(1, name, passwordHash, name, "Silly Idiot");
		} else {
			throw new InvalidLoginException("Invalid credentials entered");
		}
	}

	public void doLogout(User user) {
		// Some database related code
		// SELECT INSERT UPDATE WHERE

		user.setLastSeenDate(new Date());
	}

	public User registerUser(String login, String passwordHash,
			String passwordConfirmationHash, String name, String Bio)
			throws InvalidRegistrationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Message createMessage(User author, String message, ChatRoom chatRoom) {
		// TODO reimplement with db
		return new Message(1, message, author, chatRoom, new Date());
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
