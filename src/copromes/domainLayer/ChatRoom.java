package copromes.domainLayer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.sql.*;

public class ChatRoom {
	private int id;
	private String name;
	private Date creationDate;
	private List<User> users;
	
	public ChatRoom(int id, String name) {
		this.id = id;
		this.name = name;
		creationDate = new Date();
		users = new ArrayList<User>();
	}
	public int getId(){
                return id;
        }
        
	public String getName() {
		return name;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public List<User> getUsers() {
		return users;
	}

}
