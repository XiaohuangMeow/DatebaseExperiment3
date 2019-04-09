package User;

import TableOperation.Insert;
import TableOperation.Select;
import UserOperation.*;
import com.company.Main;
import com.company.output;

import java.sql.Date;
import java.sql.SQLException;

public class system {

    public static void register() throws SQLException {
        String[] s = new String[6];
        Main.scanner.nextLine();
        for (int i = 0; i < 6; i++) {
            s[i] = Main.scanner.next();
        }
        PersonalInformation.register(s[0], s[1], s[2], Date.valueOf(s[3]), s[4], s[5]);
        Main.conn.commit();
        System.out.println("注册成功");
    }

    public static void loginin() throws SQLException {
        System.out.print("Username:");
        String username = Main.scanner.next();
        System.out.print("password:");
        String password = Main.scanner.next();
        boolean flag = PersonalInformation.match(username, password);
        if (!flag) {
            System.out.println("登录失败，账户名或密码错误");
        } else {
            System.out.println("登录成功");
            int idUser = Select.selectidUserFromUsername(username);
            boolean login = true;
            while (login) {
                output.mainfunction();
                int ch = Main.scanner.nextInt();
                Main.scanner.nextLine();
                try {
                    switch (ch) {
                        case 1:
                            emailOperation(idUser, username);
                            break;
                        case 2:
                            experienceOperation(idUser);
                            break;
                        case 3:
                            friendOperation(idUser);
                            break;
                        case 4:
                            logOperation(idUser);
                            break;
                        case 5:
                            logReplyOperation(idUser);
                            break;
                        case 6:
                            logShareOperation(idUser);
                            break;
                        case 7:
                            Select.schooltime(idUser);
                            break;
                        case 8:
                            Select.worktime(idUser);
                            break;
                        case 9:
                            interestOperation(idUser);
                            break;
                        case 10:
                            Select.selectallInterest();
                            break;
                        case 0:
                            login = false;
                            break;
                    }
                } catch (java.sql.SQLIntegrityConstraintViolationException e) {
                    System.err.println("ERROR:插入了重复的值");
                }
            }
        }
    }

    public static void emailOperation(int idUser, String Username) throws SQLException {
        boolean flag = true;
        while (flag) {
            output.email();
            int ch = Main.scanner.nextInt();
            Main.scanner.nextLine();
            switch (ch) {
                case 1:
                    PersonalInformation.displayEmail(idUser);
                    break;
                case 2:
                    System.out.println("请输入您要添加的邮箱");
                    String addEmail = Main.scanner.next();
                    PersonalInformation.addEmail(idUser, addEmail);
                    Main.conn.commit();
                    System.out.println("添加成功");
                    break;
                case 3:
                    System.out.println("请输入您要删除的邮箱");
                    String deleteEmail = Main.scanner.next();
                    PersonalInformation.deleteEmail(Username, deleteEmail);
                    Main.conn.commit();
                    System.out.println("删除完成");
                    break;
                case 0:
                    flag = false;
                    System.out.println("返回成功");
                    break;
            }
        }
    }

    public static void experienceOperation(int idUser) throws SQLException {
        boolean flag = true;
        while (flag) {
            output.experience();
            int ch = Main.scanner.nextInt();
            Main.scanner.nextLine();
            switch (ch) {
                case 1:
                    Select.selectEducationalExperience(idUser);
                    break;
                case 2:
                    System.out.println("请依次输入您的Level,Date,School,Degree");
                    System.out.print("Level:");
                    String level = Main.scanner.nextLine();
                    System.out.print("Date:");
                    String date = Main.scanner.nextLine();
                    System.out.print("School:");
                    String school = Main.scanner.nextLine();
                    System.out.print("Degree:");
                    String degree = Main.scanner.nextLine();
                    if (date.equals("") || date.equals(null)) {
                        EducationExperience.addExperience(idUser, level, null, school, degree);
                    } else {
                        EducationExperience.addExperience(idUser, level, Date.valueOf(date), school, degree);
                    }
                    Main.conn.commit();
                    System.out.println("录入成功");
                    break;
                case 3:
                    System.out.println("请输入您要修改的编号");
                    int deleteid = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    System.out.println("请依次输入您新的Level,Date,School,Degree");
                    System.out.print("Level:");
                    String alevel = Main.scanner.nextLine();
                    System.out.print("Date:");
                    String adate = Main.scanner.nextLine();
                    System.out.print("School:");
                    String aschool = Main.scanner.nextLine();
                    System.out.print("Degree:");
                    String adegree = Main.scanner.nextLine();
                    if (adate.equals("") || adate.equals(null)) {
                        EducationExperience.modifyExperience(deleteid, idUser, alevel, null, aschool, adegree);
                    } else {
                        EducationExperience.modifyExperience(deleteid, idUser, alevel, Date.valueOf(adate), aschool, adegree);
                    }
                    Main.conn.commit();
                    System.out.println("修改完成");
                    break;
                case 4:
                    Select.selectWorkExperience(idUser);
                    break;
                case 5:
                    System.out.println("请依次输入您的WorkPlace,Date,Position");
                    System.out.print("Workplace:");
                    String w_workplace = Main.scanner.nextLine();
                    System.out.print("Date:");
                    String w_date = Main.scanner.nextLine();
                    System.out.print("Position:");
                    String w_position = Main.scanner.nextLine();
                    if (w_date.equals("") || w_date.equals(null)) {
                        WorkExperience.addExperience(idUser, w_workplace, null, w_position);
                    } else {
                        WorkExperience.addExperience(idUser, w_workplace, Date.valueOf(w_date), w_position);
                    }
                    Main.conn.commit();
                    System.out.println("录入成功");
                    break;
                case 6:
                    System.out.println("请输入您要修改的编号");
                    int w_deleteid = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    System.out.println("请依次输入您新的WorkPlace,Date,Position");
                    System.out.print("Workplace:");
                    String ww_workplace = Main.scanner.nextLine();
                    System.out.print("Date:");
                    String ww_date = Main.scanner.nextLine();
                    System.out.print("Position:");
                    String ww_position = Main.scanner.nextLine();
                    if (ww_date.equals("") || ww_date.equals(null)) {
                        WorkExperience.modifyExperience(w_deleteid, idUser, ww_workplace, null, ww_position);
                    } else {
                        WorkExperience.modifyExperience(w_deleteid, idUser, ww_workplace, Date.valueOf(ww_date), ww_position);
                    }
                    Main.conn.commit();
                    System.out.println("修改完成");
                    break;
                case 7:
                    Select.noExperienceUser();
                    break;
                case 0:
                    flag = false;
                    System.out.println("返回成功");
                    break;
            }
        }
    }

    public static void friendOperation(int idUser) throws SQLException {
        boolean flag = true;
        while (flag) {
            output.friend();
            int ch = Main.scanner.nextInt();
            Main.scanner.nextLine();
            switch (ch) {
                case 1:
                    System.out.println("请输入好友名字");
                    String addfriend = Main.scanner.next();
                    System.out.println("请输入要加入的分组名");
                    int addgroup = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    Friend.addFriend(idUser, addgroup, addfriend);
                    Main.conn.commit();
                    System.out.println("添加成功");
                    break;
                case 2:
                    System.out.println("请输入好友名字");
                    String add2friend = Main.scanner.next();
                    Friend.addFriend(idUser, add2friend);
                    Main.conn.commit();
                    System.out.println("添加成功");
                    break;
                case 3:
                    System.out.println("请输入您要删除的好友名");
                    String deleteFriend = Main.scanner.next();
                    Friend.dropFriend(idUser, deleteFriend);
                    Main.conn.commit();
                    System.out.println("删除完成");
                    break;
                case 4:
                    Friend.displayFriend(idUser);
                    break;
                case 5:
                    System.out.println("请输入您要修改的分组号");
                    int oldgroup = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    System.out.println("请输入新的分组号");
                    int newgroup = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    Friend.modifyGroup(oldgroup, newgroup);
                    Main.conn.commit();
                    System.out.println("修改成功");
                    break;
                case 6:
                    System.out.println("请输入要删除的分组号");
                    int deletegroup = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    Friend.dropGroup(deletegroup);
                    Main.conn.commit();
                    break;
                case 7:
                    System.out.println("请输入要查询分组号");
                    int selectgroup = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    Friend.displayGroup(idUser, selectgroup);
                    break;
                case 8:
                    Select.countFriend();
                    break;
                case 0:
                    flag = false;
                    System.out.println("返回成功");
                    break;
            }
        }
    }

    public static void logOperation(int idUser) throws SQLException {
        boolean flag = true;
        while (flag) {
            output.log();
            int ch = Main.scanner.nextInt();
            Main.scanner.nextLine();
            switch (ch) {
                case 1:
                    System.out.println("请输入要发布的日志内容");
                    String content = Main.scanner.nextLine();
                    Log.publishLog(idUser, content);
                    Main.conn.commit();
                    System.out.println("发布成功");
                    break;
                case 2:
                    System.out.println("请输入您要修改的日志编号");
                    int m_idLog = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    System.out.println("请输入新的内容");
                    String m_content = Main.scanner.nextLine();
                    Log.modifyLog(m_idLog, m_content);
                    Main.conn.commit();
                    System.out.println("修改成功");
                    break;
                case 3:
                    System.out.println("请输入您要删除的日志编号");
                    int d_idLog = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    Log.dropLog(d_idLog);
                    Main.conn.commit();
                    System.out.println("删除完成");
                case 4:
                    Log.displayLog(idUser);
                    break;
                case 0:
                    flag = false;
                    System.out.println("返回成功");
                    break;
            }
        }
    }

    public static void logReplyOperation(int idUser) throws SQLException {
        boolean flag = true;
        while (flag) {
            output.logreply();
            int ch = Main.scanner.nextInt();
            Main.scanner.nextLine();
            switch (ch) {
                case 1:
                    System.out.println("请输入要评论的日志编号");
                    int c_idLog = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    System.out.println("请输入要发布的日志评论");
                    String c_content = Main.scanner.nextLine();
                    LogReply.addLogReply(idUser, c_idLog, c_content);
                    Main.conn.commit();
                    System.out.println("发布评论成功");
                    break;
                case 2:
                    System.out.println("请输入您要删除的日志评论编号");
                    int d_idLogReply = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    LogReply.dropLogReply(d_idLogReply);
                    Main.conn.commit();
                    System.out.println("删除成功");
                    break;
                case 3:
                    System.out.println("请输入您查询评论的日志编号");
                    int s_idLog = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    LogReply.displayLogReply(s_idLog);
                    Main.conn.commit();
                    break;
                case 0:
                    flag = false;
                    System.out.println("返回成功");
                    break;
            }
        }
    }

    public static void logShareOperation(int idUser) throws SQLException {
        boolean flag = true;
        while (flag) {
            output.logshare();
            int ch = Main.scanner.nextInt();
            Main.scanner.nextLine();
            switch (ch) {
                case 1:
                    System.out.println("请输入要分享的日志编号");
                    int c_idLog = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    System.out.println("请输入要分享日志的评论");
                    String c_content = Main.scanner.nextLine();
                    LogShare.addLogShare(idUser, c_idLog, c_content);
                    Main.conn.commit();
                    System.out.println("分享成功");
                    break;
                case 2:
                    System.out.println("请输入您要删除的分享日志编号");
                    int d_idLogShare = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    LogShare.dropLogShare(d_idLogShare);
                    Main.conn.commit();
                    System.out.println("删除成功");
                    break;
                case 3:
//                    System.out.println("请输入您查询的日志分享编号");
//                    int s_idLog=Main.scanner.nextInt();
//                    Main.scanner.nextLine();
                    LogShare.displayLogShare(idUser);
                    break;
                case 0:
                    flag = false;
                    System.out.println("返回成功");
                    break;
            }
        }
    }

    public static void interestOperation(int idUser) throws SQLException {
        boolean flag = true;
        while (flag) {
            output.interest();
            int ch = Main.scanner.nextInt();
            Main.scanner.nextLine();
            switch (ch) {
                case 1:
                    Select.selectInterest(idUser);
                    break;
                case 2:
                    System.out.println("请输入您要添加的兴趣");
                    String interest = Main.scanner.next();
                    Insert.InsertIntoUserInterest(idUser,interest);
                    Main.conn.commit();
                    System.out.println("添加成功");
                    break;
                case 0:
                    flag = false;
                    System.out.println("返回成功");
                    break;
            }
        }
    }

}
