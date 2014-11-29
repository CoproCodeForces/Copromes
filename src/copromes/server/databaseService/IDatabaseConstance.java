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
    final static String insertUser              = "INSERT INTO user VALUES( default, ?, ?, ?, CURDATE(), CURDATE(), ?, ?);";
    final static String insertCgatRoom          = "INSERT INTO chatroom VALUES ( ?, ?);";
    final static String insertContact           = "INSERT INTO contact VALUES ( ?, ?);";
    final static String insertMessage           = "INSER INTO message VALUE ( ?, ?, ?, ?);";
    final static String insertUserToChatroom    = "INSERT INTO user_to_chat VALUES (?, ?);";
    final static String selectByLoginPswd       = "SELECT COUNT(*), * FROM user WHERE login = ? and password = ?;";
    final static String selectByEmailPswd       = "SELECT COUNT(*), * FROM user WHERE email= ? and password = ?;";
    final static String selectByName            = "SELECT COUNT(*), * FROM user WHERE name = ?;";
    final static String GetUserId               = "SELECT COUNT(user_id), user_id FROM  user WHERE login = ?;";
    final static String deleteUserFromChatroom  = "DELETE FOROM user_to_chat WHERE user_id = ? and chatroom_id = ?;";
    final static String deleteContact           = "DELETE FROM TABLE contact WHERE user_id = ? and contact_id = ?;"; 
    final static String deleteChatRoom          = "DELETE FROM chatroom WHERE chatroom_id = ?;";
    
}
