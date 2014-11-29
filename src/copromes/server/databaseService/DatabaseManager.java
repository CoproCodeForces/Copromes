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

    public void addFriend(User user, User friend) {
        
//        PreparedStatement addFriend = null;
//        try{
//            addFriend = con.prepareStatement(insertContact);
//            addFriend.setInt(1, user.getId());
//            addFriend.setInt(2, friend.getId());
//        }

    }

    public void deleteFriend(User friend) {
        // TODO Auto-generated method stub

    }

    public List<User> findUser(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    public User doLogin(String loginOremail, String passwordHash)
            throws InvalidLoginException {
        // For debug purposes only; there should be some database-related code
//        if ((name.equals("Mitya") && passwordHash.equals("kek"))
//                || (name.equals("Mikhail") && passwordHash.equals("lel"))) {
//            return new User(1, name, passwordHash, name, "Silly Idiot");
//        } else {
//            throw new InvalidLoginException("Invalid credentials entered");
//        }

        
        PreparedStatement doLoginStmt = null;
        User usr = null;
        try{
            con.setAutoCommit(false);
            
            //TODO: parsing of loginOrEmail string to determine is it login or email
            //Now let it be login
            doLoginStmt=con.prepareStatement(selectByLoginPswd);
            doLoginStmt.setString(1, loginOremail);
            doLoginStmt.setString(2, passwordHash);
            ResultSet rs = doLoginStmt.executeQuery();
            con.commit();
            if(!rs.next()) throw new InvalidLoginException("no results");
            if(rs.getInt(1)>1) throw new InvalidLoginException("have been found few profiles with equal logins/emails");
            usr = new User(rs.getInt("user_id"),
                                rs.getString("login"),
                                rs.getString("password"),
                                rs.getString("name"),
                                rs.getString("bio")
                                );

                    
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
            if (doLoginStmt != null) {
                try {
                    doLoginStmt.close();
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
        return usr;
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
        User usr = null;
        try {
            con.setAutoCommit(false);
            userInsert = con.prepareStatement(insertUser);
            userInsert.setString(1, name);
            userInsert.setString(2, login);
            userInsert.setString(3, passwordHash);
            userInsert.setString(4, email);
            userInsert.setString(5, Bio);
            userInsert.executeUpdate();
            
            userInsert = con.prepareStatement(GetUserId);
            userInsert.setString(1, login);
            ResultSet rs = userInsert.executeQuery();
            if(!rs.next()) throw new InvalidRegistrationException("can not get user's id");
            if(rs.getInt(1)>1)throw new InvalidRegistrationException("have been found few profiles with equal logins/emails");
            
            con.commit();
            
            
            usr = new User(rs.getInt("user_id"), login, passwordHash, name, Bio);
            
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
        return usr;
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
