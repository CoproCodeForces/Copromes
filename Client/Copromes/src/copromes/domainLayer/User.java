package copromes.domainLayer;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
//import java.sql.*;

public class User implements Serializable {

	private int id;
	private String login;
	private String password;
	private String name;
	private String bio;
	private List<ChatRoom> chatRooms;
	private Date registrationDate;
	private Date lastSeenDate;
}
