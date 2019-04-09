package UserOperation;

import TableOperation.Insert;
import TableOperation.Update;

import java.sql.Date;
import java.sql.SQLException;

public class EducationExperience {

    public static void addExperience(int idUser,String level, Date date,String school,String degree) throws SQLException {
        Insert.InsertIntoEducationalExperience(idUser, level, date, school, degree);
    }

    public static void modifyExperience(int idEducation,int idUser,String level, Date date,String school,String degree) throws SQLException {
        Update.UpdateEducationExperience(idEducation,idUser, level, date, school, degree);
    }



}
