package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import TableOperation.Select;
import UserOperation.ConnectDatabase;

import static User.system.loginin;
import static User.system.register;

public class Main {

    public static Connection conn=null;
    public static int cnt=0;
    public static Scanner scanner=new Scanner(System.in);


    public static void main(String[] args) throws SQLException {
        conn=ConnectDatabase.getConn(conn);
        cnt= Select.countUsers();
        conn.setAutoCommit(false);
        while (true) {
            output.login();
            int ch = scanner.nextInt();
            if (ch == 1) {
                output.register();
                register();
            } else if (ch==2){
                output.loginin();
                loginin();
            }
            else if (ch==0){
                System.out.println("再见，欢迎下次再来");
                System.exit(0);
            }
        }
    }
}
