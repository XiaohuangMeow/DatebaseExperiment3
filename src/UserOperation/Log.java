package UserOperation;

import TableOperation.Drop;
import TableOperation.Insert;
import TableOperation.Select;
import TableOperation.Update;

import java.sql.SQLException;

public class Log {

    public static void publishLog(int idUser,String content) throws SQLException {
        Insert.InsertIntoLog(idUser, content);
    }

    public static void modifyLog(int idLog,String content) throws SQLException {
        Update.UpdateLog(idLog, content);
    }

    public static void dropLog(int idLog) throws SQLException {
        Drop.dropLog(idLog);
    }

    public static void displayLog(int idUser) throws SQLException {
        Select.selectLog(idUser);
    }

    public static void displayLogTime(int idLog) throws SQLException {
        Select.selectLogTime(idLog);
    }


}
