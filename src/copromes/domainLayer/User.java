package copromes.domainLayer;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.sql.*;

public class User implements Serializable {

	private int id;
	private String login;
	private String password;
	private String name;
	private String bio; // TODO add in database 
	private List<ChatRoom> chatRooms;
	private Date registrationDate;
	private Date lastSeenDate;
	
	public User (int id, String login, String password, String name, String bio) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
		this.bio = bio;
		
		chatRooms = new ArrayList<ChatRoom>();
		registrationDate = new Date();
		lastSeenDate = registrationDate;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBio() {
		return bio;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	
	public Date getLastSeenDate() {
		return lastSeenDate;
	}
	
	public List<ChatRoom> getChatRooms() {
		return chatRooms;
	}
	
	public void setLastSeenDate(Date date) {
		lastSeenDate = date;
	}
}
