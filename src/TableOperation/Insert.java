package TableOperation;

import com.company.Main;

import java.sql.*;

public class Insert {

    private static String sql=null;
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    public static void Register(String Username,String name, String sex, Date birth, String address, String password,int cnt,int idUser,String Email) throws SQLException {
        sql="insert into personalinformation(Username,Name,Sex,DateofBirth,Address,Password,idUser) values(?,?,?,?,?,?,?);";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setString(1,Username);
        pstmt.setString(2,name);
        pstmt.setString(3,sex);
        pstmt.setDate(4,birth);
        pstmt.setString(5,address);
        pstmt.setString(6,password);
        pstmt.setInt(7,cnt);
        int j1=pstmt.executeUpdate();

        sql="insert into email(idUser,Email) values(?,?);";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        pstmt.setString(2,Email);
        int j2=pstmt.executeUpdate();

        if (j1>0&&j2>0){
            Main.conn.commit();
        }
        else {
            Main.conn.rollback();
        }
    }



//    姓名、性别、出生日期、电子邮箱、通讯地址、用户密码
    public static void InsertIntoPersonalInformation(String Username,String name, String sex, Date birth, String address, String password,int cnt) throws SQLException {
        sql="insert into personalinformation(Username,Name,Sex,DateofBirth,Address,Password,idUser) values(?,?,?,?,?,?,?);";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setString(1,Username);
        pstmt.setString(2,name);
        pstmt.setString(3,sex);
        pstmt.setDate(4,birth);
        pstmt.setString(5,address);
        pstmt.setString(6,password);
        pstmt.setInt(7,cnt);
        int judge=pstmt.executeUpdate();
        if (judge>0){
            Main.conn.commit();
        }
        else {
            Main.conn.rollback();
        }    }

    public static void InsertIntoEmail(int idUser,String Email) throws SQLException {
        sql="insert into email(idUser,Email) values(?,?);";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        pstmt.setString(2,Email);
        int judge=pstmt.executeUpdate();
        if (judge>0){
            Main.conn.commit();
        }
        else {
            Main.conn.rollback();
        }    }

    public static void InsertIntoEducationalExperience(int idUser, String level, Date date,String school,String degree) throws SQLException {
        sql="insert into educationalexperience(idUser,Level,Date,School,Degree) values(?,?,?,?,?);";
        pstmt= Main.conn.prepareStatement(sql);
        if (level.equals("")) level=null;
        if (school.equals("")) school=null;
        if (degree.equals("")) degree=null;

        if (level==null||school==null||degree==null||date==null){
            System.err.println("Warning:插入的信息存在空值");
        }
        pstmt.setInt(1,idUser);
        pstmt.setString(2,level);
        pstmt.setDate(3,date);
        pstmt.setString(4,school);
        pstmt.setString(5,degree);
        int judge=pstmt.executeUpdate();
        if (judge>0){
            Main.conn.commit();
        }
        else {
            Main.conn.rollback();
        }
    }

    public static void InsertIntoWorkExperience(int idUser, String workplace, Date date, String position) throws SQLException {
        sql="insert into workexperience(idUser,Workplace,Date,Position) values(?,?,?,?);";
        if (workplace.equals("")) workplace=null;
        if (position.equals("")) position=null;
        if (workplace==null||date==null||position==null){
            System.err.println("Warning:输入的信息存在空值");
        }
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        pstmt.setString(2,workplace);
        pstmt.setDate(3,date);
        pstmt.setString(4,position);
        int judge=pstmt.executeUpdate();
        if (judge>0){
            Main.conn.commit();
        }
        else {
            Main.conn.rollback();
        }    }

    public static void InsertIntoFriendGroup(int idUser,int idGroup,String FriendName) throws SQLException {
        sql="insert into friendgroup(idUser,idGroup,FriendName) values(?,?,?);";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        pstmt.setInt(2,idGroup);
        pstmt.setString(3,FriendName);
        int judge=pstmt.executeUpdate();
        if (judge>0){
            Main.conn.commit();
        }
        else {
            Main.conn.rollback();
        }    }

    public static void InsertIntoLog(int idUser,String content) throws SQLException {
        sql="insert into log(idUser,PublishTime,LastUpdatedTime,content) values(?,?,?,?);";
        java.util.Date date=new java.util.Date();
        Timestamp t=new Timestamp(date.getTime());
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        pstmt.setTimestamp(2,t);
        pstmt.setTimestamp(3,t);
        pstmt.setString(4,content);
        pstmt.executeUpdate();
    }

    public static void InsertIntoLogReply(int idUser,int idLog,String content) throws SQLException {
        sql="insert into logreply(idUser,idLog,PublishTime,content) values(?,?,?,?);";
        java.util.Date date=new java.util.Date();
        Timestamp t=new Timestamp(date.getTime());
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        pstmt.setInt(2,idLog);
        pstmt.setTimestamp(3,t);
        pstmt.setString(4,content);
        int judge=pstmt.executeUpdate();
        if (judge>0){
            Main.conn.commit();
        }
        else {
            Main.conn.rollback();
        }    }

    public static void InsertIntoLogShare(int idUser,int idLog) throws SQLException {
        sql="insert into logshare(idLog,idUser,ShareTime) values(?,?,?);";
        java.util.Date date=new java.util.Date();
        Timestamp t=new Timestamp(date.getTime());
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idLog);
        pstmt.setInt(2,idUser);
        pstmt.setTimestamp(3,t);
        int judge=pstmt.executeUpdate();
        if (judge>0){
            Main.conn.commit();
        }
        else {
            Main.conn.rollback();
        }    }

    public static void InsertIntoLogShare(int idUser,int idLog,String comment) throws SQLException {
        sql="insert into logshare(idLog,idUser,ShareTime,CommentTime,CommentContent) values(?,?,?,?,?);";
        java.util.Date date=new java.util.Date();
        Timestamp t=new Timestamp(date.getTime());
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idLog);
        pstmt.setInt(2,idUser);
        pstmt.setTimestamp(3,t);
        pstmt.setTimestamp(4,t);
        pstmt.setString(5,comment);
        int judge=pstmt.executeUpdate();
        if (judge>0){
            Main.conn.commit();
        }
        else {
            Main.conn.rollback();
        }    }

    public static void InsertIntoUserInterest(int idUser,String interest) throws SQLException {
        sql="insert into userinterest(idUser,InterestName) values(?,?);";
        pstmt=Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        pstmt.setString(2,interest);
        int judge=pstmt.executeUpdate();
        if (judge>0){
            Main.conn.commit();
        }
        else {
            Main.conn.rollback();
        }    }

}
