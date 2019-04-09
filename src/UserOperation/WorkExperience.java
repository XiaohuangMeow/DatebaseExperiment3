package UserOperation;

import TableOperation.Insert;
import TableOperation.Update;

import java.sql.Date;
import java.sql.SQLException;

public class WorkExperience {

    public static void addExperience(int idUser, String workplace, Date date, String position) throws SQLException {
        Insert.InsertIntoWorkExperience(idUser, workplace, date, position);
    }

    public static void modifyExperience(int idWork,int idUser, String workplace, Date date, String position) throws SQLException {
        Update.UpdateWorkExperience(idWork,idUser, workplace, date, position);
    }

}
