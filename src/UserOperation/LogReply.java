package UserOperation;

import TableOperation.Drop;
import TableOperation.Insert;
import TableOperation.Select;

import java.sql.SQLException;

public class LogReply {

    public static void addLogReply(int idUser,int idLog,String content) throws SQLException {
        Insert.InsertIntoLogReply(idUser, idLog, content);
    }

    public static void dropLogReply(int idLogReply) throws SQLException {
        Drop.dropLogReply(idLogReply);
    }

    public static void displayLogReply(int idLog) throws SQLException {
        Select.selectLogReply(idLog);
    }

}
