package UserOperation;

import TableOperation.Drop;
import TableOperation.Insert;
import TableOperation.Select;
import TableOperation.Update;
import com.company.Main;

import java.sql.Date;
import java.sql.SQLException;

public class PersonalInformation {

    public static void register(String Username,String name, String sex, Date birth, String address, String password) throws SQLException {
//        Insert.InsertIntoPersonalInformation(Username, name, sex, birth, address, password, Main.cnt);
//        Insert.InsertIntoEmail(Main.cnt,Username);
        Insert.Register(Username, name, sex, birth, address, password, Main.cnt,Main.cnt,Username);
        Main.cnt++;
    }

    public static void modifyBasic(String Username,String name, String sex, Date birth, String address, String password) throws SQLException {
        Update.UpdatePersonalInformation(Username, name, sex, birth, address, password);
    }

    public static void addEmail(int idUser,String Email) throws SQLException {
//        int idUser= Select.selectidUserFromUsername(Username);
        Insert.InsertIntoEmail(idUser,Email);
    }

    public static void deleteEmail(String Username,String Email) throws SQLException {
        int idUser= Select.selectidUserFromUsername(Username);
        Drop.dropEmail(idUser,Username,Email);
    }

    public static void displayEmail(int idUser) throws SQLException {
        Select.selectEmail(idUser);
    }

    public static boolean match(String Username,String password) throws SQLException {
        return Select.match(Username, password);
    }
}
