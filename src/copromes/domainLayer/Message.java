package copromes.domainLayer;

import java.io.Serializable;
import java.util.Date;
//import java.sql.*;

public class Message implements Serializable {
	private int id;
	private String message;
	private User author;
	private ChatRoom chatRoom;
	private Date date;
	
	public Message (int id, String message, User author, ChatRoom chatRoom, Date date) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.chatRoom = chatRoom;
		this.date = date;
	}
	
	public String getMessage() {
		return message;
	}
	
	public User getAuthor() {
		return author;
	}
	
	public ChatRoom getChatRoom() {
		return chatRoom;
	}
	
	public Date getDate() {
		return date;
	}
}
