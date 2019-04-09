package TableOperation;

import com.company.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

    private static String sql=null;
    private static PreparedStatement pstmt;
    private static ResultSet rs;


    public static int countUsers() throws SQLException {
        sql="select count(idUser) from personalinformation";
        pstmt=Main.conn.prepareStatement(sql);
        rs=pstmt.executeQuery(sql);
        if (rs.next()) return rs.getInt(1);
        return 0;
    }

    public static int selectidUserFromUsername(String Username) throws SQLException {
        sql="select idUser from personalinformation where Username=?;";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setString(1,Username);
        rs=pstmt.executeQuery();
        rs.next();
        int idUser=rs.getInt(1);
        return idUser;
    }

    public static void selectFriend(int idUser) throws SQLException {
        sql="select FriendName,idGroup from friendgroup where idUser=?;";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        rs=pstmt.executeQuery();
        System.out.println("朋友名"+"\t"+"组号");
        while (rs.next()){
            System.out.print(rs.getString(1)+"  ");
            System.out.println(rs.getInt(2));
        }
    }

    public static void selectFriendGroup(int idUser,int idGroup) throws SQLException {
        sql="select FriendName from friendgroup where idUser=? and idGroup=?;";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        pstmt.setInt(2,idGroup);
        rs=pstmt.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString(1));
        }
    }

    public static void selectLog(int idUser) throws SQLException {
        sql="select idLog,content,popular,LastUpdatedTime from log where idUser=?;";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        rs=pstmt.executeQuery();
        System.out.println("日志编号"+"\t"+"内容"+"\t"+"欢迎程度"+"\t"+"更新时间");
        while (rs.next()){
            System.out.print(rs.getInt(1)+"  ");
            System.out.print(rs.getString(2)+"  ");
            System.out.print(rs.getInt(3)+"  ");
            System.out.println(rs.getTimestamp(4));
        }
    }

    public static void selectLogTime(int idLog) throws SQLException {
        sql="select PublishTime,LastUpdatedTime from log where idLog=?;";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idLog);
        rs=pstmt.executeQuery();
        while (rs.next()){
            System.out.print(rs.getTime(1)+"  ");
            System.out.println(rs.getTime(2));
        }
    }

    public static void selectLogReply(int idLog) throws SQLException {
//        sql="select idUser,content,PublishTime from logreply where idLog=?;";
        sql="select log.content,idLogReply,logreply.content,logreply.PublishTime\n" +
                "from logreply join log on logreply.idLog=log.idLog\n" +
                "where log.idLog=?;";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idLog);
        rs=pstmt.executeQuery();
        System.out.println("日志内容"+"\t"+"评论编号"+"\t"+"评论内容"+"\t"+"评论发布时间");
        while (rs.next()){
            System.out.print(rs.getString(1)+"  ");
            System.out.print(rs.getInt(2)+"  ");
            System.out.print(rs.getString(3)+" ");
            System.out.println(rs.getTimestamp(4));
        }
    }

    public static void selectLogShare(int idUser) throws SQLException {
        sql="select log.content,idLogShare,logshare.CommentContent,ShareTime\n" +
                "from logshare join log on logshare.idLog=log.idLog\n" +
                "where logshare.idUser=?;";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        rs=pstmt.executeQuery();
        System.out.println("日志内容"+"\t"+"分享编号"+"\t"+"分享内容"+"\t"+"分享时间");
        while (rs.next()){
            System.out.print(rs.getString(1)+"  ");
            System.out.print(rs.getInt(2)+"  ");
            System.out.print(rs.getString(3)+"  ");
            System.out.println(rs.getTimestamp(4));
        }
    }

    public static boolean match(String username,String password) throws SQLException {
        sql="select count(*) from personalinformation where Username=? and password=?;";
        pstmt=Main.conn.prepareStatement(sql);
        pstmt.setString(1,username);
        pstmt.setString(2,password);
        rs=pstmt.executeQuery();
        rs.next();
        int x=rs.getInt(1);
        if (x==0){
            return false;
        }
        return true;
    }

    public static void selectEmail(int idUser) throws SQLException {
        sql="select Email from email where idUser=?;";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        rs=pstmt.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString(1));
        }
    }

    public static void selectEducationalExperience(int idUser) throws SQLException {
        sql="select idEducation,Level,Date,School,Degree from educationalexperience where idUser=?;";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        rs=pstmt.executeQuery();
        while (rs.next()){
            System.out.print(rs.getInt(1)+"  ");
            System.out.print(rs.getString(2)+"  ");
            System.out.print(rs.getDate(3)+"  ");
            System.out.print(rs.getString(4)+"  ");
            System.out.println(rs.getString(5));
        }
    }

    public static void selectWorkExperience(int idUser) throws SQLException {
        sql="select idWork,Workplace,Date,Position from workexperience where idUser=?;";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        rs=pstmt.executeQuery();
        while (rs.next()){
            System.out.print(rs.getInt(1)+"  ");
            System.out.print(rs.getString(2)+"  ");
            System.out.print(rs.getDate(3)+"  ");
            System.out.println(rs.getString(4));
        }
    }

    public static void schooltime(int idUser) throws SQLException {
        sql="select Name,Sex,School,Degree,Date from schoolinformation where idUser=?;";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        rs=pstmt.executeQuery();
        while (rs.next()){
            System.out.print(rs.getString(1)+"  ");
            System.out.print(rs.getString(2)+"  ");
            System.out.print(rs.getString(3)+"  ");
            System.out.print(rs.getString(4)+"  ");
            System.out.println(rs.getDate(5));
        }
    }

    public static void worktime(int idUser) throws SQLException {
        sql="select Name,Sex,WorkPlace,Position,date from workinformation where idUser=?;";
        pstmt= Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        rs=pstmt.executeQuery();
        while (rs.next()){
            System.out.print(rs.getString(1)+"  ");
            System.out.print(rs.getString(2)+"  ");
            System.out.print(rs.getString(3)+"  ");
            System.out.print(rs.getString(4)+"  ");
            System.out.println(rs.getDate(5));
        }
    }

    public static void noExperienceUser() throws SQLException {
        sql="select Username\n" +
                "from personalinformation\n" +
                "where idUser not in (\n" +
                "\tselect idUser\n" +
                "\tfrom educationalexperience\n" +
                ");";
        pstmt=Main.conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString(1));
        }
    }

    public static void countFriend() throws SQLException {
        sql="select idGroup,count(*)\n" +
                "from friendgroup\n" +
                "group by idGroup;";
        pstmt=Main.conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        System.out.println("组号  好友个数");
        while (rs.next()){
            System.out.print(rs.getInt(1)+"  ");
            System.out.println(rs.getInt(2));
        }
    }

    public static void selectInterest(int idUser) throws SQLException {
        sql="select InterestName from userinterest where idUser=?;";
        pstmt=Main.conn.prepareStatement(sql);
        pstmt.setInt(1,idUser);
        rs=pstmt.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString(1));
        }
    }

    public static void selectallInterest() throws SQLException {
        sql="select * from interest;";
        pstmt=Main.conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        while (rs.next()){
            System.out.print(rs.getString(1)+"  ");
            System.out.println(rs.getString(2));
        }
    }
}
