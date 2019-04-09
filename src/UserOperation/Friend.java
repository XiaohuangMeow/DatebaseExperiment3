package UserOperation;

import TableOperation.Drop;
import TableOperation.Insert;
import TableOperation.Select;
import TableOperation.Update;

import java.sql.SQLException;

public class Friend {

    public static void addFriend(int idUser,int idGroup,String FriendName) throws SQLException {
        Insert.InsertIntoFriendGroup(idUser, idGroup, FriendName);
    }

    public static void addFriend(int idUser,String FriendName) throws SQLException {
        Insert.InsertIntoFriendGroup(idUser, 0, FriendName);
    }

    public static void dropFriend(int idUser,String FriendName) throws SQLException {
        Drop.dropFriend(idUser, FriendName);
    }

    public static void displayFriend(int idUser) throws SQLException {
        Select.selectFriend(idUser);
    }

    public static void modifyGroup(int idGroup,int newidGroup) throws SQLException {
        Update.UpdateidGroup(idGroup, newidGroup);
    }

    public static void dropGroup(int idGroup) throws SQLException {
        Drop.dropFriendGroup(idGroup);
    }

    public static void displayGroup(int idUser,int idGroup) throws SQLException {
        Select.selectFriendGroup(idUser, idGroup);
    }

}
