package UserOperation;

import TableOperation.Drop;
import TableOperation.Insert;
import TableOperation.Select;

import java.sql.SQLException;

public class LogShare {

    public static void addLogShare(int idUser,int idLog) throws SQLException {
        Insert.InsertIntoLogShare(idUser, idLog);
    }

    public static void addLogShare(int idUser,int idLog,String comment) throws SQLException {
        Insert.InsertIntoLogShare(idUser, idLog, comment);
    }

    public static void dropLogShare(int idLogShare) throws SQLException {
        Drop.dropLogShare(idLogShare);
    }

    public static void displayLogShare(int idUser) throws SQLException {
        Select.selectLogShare(idUser);
    }
}
