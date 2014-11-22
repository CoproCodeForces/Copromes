package copromes.server.databaseService;

import java.util.Date;
import java.util.List;
import java.sql.*;

import copromes.commonInterfaces.InvalidLoginException;
import copromes.commonInterfaces.InvalidRegistrationException;
import copromes.domainLayer.ChatRoom;
import copromes.domainLayer.Message;
import copromes.domainLayer.User;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseManager implements IDatabaseConstance {

    private Connection con;

    public DatabaseManager() {
        try {
            con = DriverManager.getConnection(
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
            String passwordConfirmationHash, String name, String Bio, String email)
            throws InvalidRegistrationException {

        PreparedStatement userInsert = null;
        try {
            con.setAutoCommit(false);
            userInsert = con.prepareStatement(insertUser);
            userInsert.setString(1, name);
            userInsert.setString(2, login);
            userInsert.setString(3, passwordHash);
            userInsert.setString(4, email);
            userInsert.setString(5, Bio);
            userInsert.executeUpdate();
            con.commit();
            
        } catch (SQLException e) {
            e.printStackTrace();
            if (con != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                } catch (SQLException excep) {
                       excep.printStackTrace();
                }
            }
        } finally {
            if (userInsert != null) {
                try {
                    userInsert.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

    public void getContacts(User user) {
        // TODO
    }
}
