package TableOperation;

import com.company.Main;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Update {

    private static String sql=null;
    private static PreparedStatement pstmt;

    public static void UpdatePersonalInformation(String Username, String name, String sex, Date birth, String address, String password) throws SQLException {
        sql="update personalinformation set Name=?,Sex=?,DateofBirth=?,Address=?,Password=? where Username=?;";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,sex);
        pstmt.setDate(3,birth);
        pstmt.setString(4,address);
        pstmt.setString(5,password);
        pstmt.setString(6,Username);
        int judge=pstmt.executeUpdate();
        if (judge>0){
            Main.conn.commit();
        }
        else {
            Main.conn.rollback();
        }    }

    public static void UpdateEducationExperience(int idEducation,int idUser, String level, Date date,String school,String degree) throws SQLException {
        sql="update educationalexperience set level=?,date=?,school=?,degree=? where idEducation=?;";
        pstmt= Main.conn.prepareStatement(sql);
        if (level.equals("")) level=null;
        if (school.equals("")) school=null;
        if (degree.equals("")) degree=null;
        if (level==null||school==null||degree==null||date==null){
            System.err.println("Warning:输入的信息存在空值");
        }
        pstmt.setString(1,level);
        pstmt.setDate(2,date);
        pstmt.setString(3,school);
        pstmt.setString(4,degree);
        pstmt.setInt(5,idEducation);
        int judge=pstmt.executeUpdate();
        if (judge>0){
            Main.conn.commit();
        }
        else {
            Main.conn.rollback();
        }    }

    public static void UpdateWorkExperience(int idWork,int idUser, String workplace, Date date, String position) throws SQLException {
        sql="update workexperience set WorkPlace=?,Date=?,Position=? where idWork=?;";
        pstmt= Main.conn.prepareStatement(sql);
        if (workplace.equals("")) workplace=null;
        if (position.equals("")) position=null;
        if (workplace==null||date==null||position==null){
            System.err.println("Warning:输入的信息存在空值");
        }
        pstmt.setString(1,workplace);
        pstmt.setDate(2,date);
        pstmt.setString(3,position);
        pstmt.setInt(4,idWork);
        int judge=pstmt.executeUpdate();
        if (judge>0){
            Main.conn.commit();
        }
        else {
            Main.conn.rollback();
        }    }

    public static void UpdateidGroup(int idGroup,int newidGroup) throws SQLException {
        sql="update friendgroup set idGroup=? where idGroup=?;";
        pstmt=Main.conn.prepareStatement(sql);
        pstmt.setInt(1,newidGroup);
        pstmt.setInt(2,idGroup);
        int judge=pstmt.executeUpdate();
        if (judge>0){
            Main.conn.commit();
        }
        else {
            Main.conn.rollback();
        }    }

    public static void UpdateLog(int idLog,String content) throws SQLException {
        sql="update log set LastUpdatedTime=?,content=? where idLog=?;";
        pstmt=Main.conn.prepareStatement(sql);
        java.util.Date date=new java.util.Date();
        Timestamp t=new Timestamp(date.getTime());
        pstmt.setTimestamp(1,t);
        pstmt.setString(2,content);
        pstmt.setInt(3,idLog);
        int judge=pstmt.executeUpdate();
        if (judge>0){
            Main.conn.commit();
        }
        else {
            Main.conn.rollback();
        }    }

}
