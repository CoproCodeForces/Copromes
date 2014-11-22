/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copromes.server.databaseService;

/**
 *
 * @author baski
 */
public interface IDatabaseConstance {
    final static String insertUser              = "INSERT INTO user VALUES( default, ?, ?, ?, ?, ?, ?);";
    final static String insertCgatRoom          = "INSERT INTO chatroom VALUES ( ?, ?);";
    final static String inserContact            = "INSERT INTO contact VALUES ( ?, ?);";
    final static String insertMessage           = "INSER INTO message VALUE ( ?, ?, ?, ?);";
    final static String insertUserToChatroom    = "INSERT INTO user_to_chat VALUES (?, ?);";
    final static String selectByName            = "SELECT * FROM user WHERE name = ?;";
    final static String selectById              = "SELECT * FROM user WHERE user_id = ?;";
    final static String deleteUserFromChatroom  = "DELETE FOROM user_to_chat WHERE user_id = ?;";
    final static String deleteContact           = "DELETE FROM TABLE contact WHERE user_id = ?;"; 
    final static String deleteChatRoom          = "DELETE FROM chatroom WHERE chatroom_id = ?;";
    
}
