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

}
