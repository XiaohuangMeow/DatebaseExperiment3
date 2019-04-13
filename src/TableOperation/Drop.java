package TableOperation;

import com.company.Main;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Drop {

    private static String sql = null;
    private static PreparedStatement pstmt;

    public static void dropEmail(int idUser, String Username, String Email) throws SQLException {
        if (Username.equals(Email)) {
            System.out.println("不能删除");
            return;
        }
        sql = "delete from email where Email=?;";
        pstmt = Main.conn.prepareStatement(sql);
        pstmt.setString(1, Email);
        int judge = pstmt.executeUpdate();
        if (judge > 0) {
            Main.conn.commit();
        } else {
            Main.conn.rollback();
        }
    }

    public static void dropFriend(int idUser, String FriendName) throws SQLException {
        sql = "delete from friendgroup where FriendName=? and idUser=?;";
        pstmt = Main.conn.prepareStatement(sql);
        pstmt.setString(1, FriendName);
        pstmt.setInt(2, idUser);
        int judge = pstmt.executeUpdate();
        if (judge > 0) {
            Main.conn.commit();
        } else {
            Main.conn.rollback();
        }
    }

    public static void dropFriendGroup(int idGroup) throws SQLException {
        sql = "delete from friendgroup where idGroup=?;";
        pstmt = Main.conn.prepareStatement(sql);
        pstmt.setInt(1, idGroup);
        int judge = pstmt.executeUpdate();
        if (judge > 0) {
            Main.conn.commit();
        } else {
            Main.conn.rollback();
        }
    }

    public static void dropLog(int idLog) throws SQLException {
        sql = "delete from log where idLog=?;";
        pstmt = Main.conn.prepareStatement(sql);
        pstmt.setInt(1, idLog);
        int judge = pstmt.executeUpdate();
        if (judge > 0) {
            Main.conn.commit();
        } else {
            Main.conn.rollback();
        }
    }

    public static void dropLogReply(int idLogReply) throws SQLException {
        sql = "delete from logreply where idLogReply=?;";
        pstmt = Main.conn.prepareStatement(sql);
        pstmt.setInt(1, idLogReply);
        int judge = pstmt.executeUpdate();
        if (judge > 0) {
            Main.conn.commit();
        } else {
            Main.conn.rollback();
        }
    }

    public static void dropLogShare(int idLogShare) throws SQLException {
        sql = "delete from logshare where idLogShare=?;";
        pstmt = Main.conn.prepareStatement(sql);
        pstmt.setInt(1, idLogShare);
        int judge = pstmt.executeUpdate();
        if (judge > 0) {
            Main.conn.commit();
        } else {
            Main.conn.rollback();
        }
    }


}
