package com.company;

public class output {

    public static void login(){
        System.out.println("1.注册");
        System.out.println("2.输入用户名密码登录");
        System.out.println("0.退出");
    }

    public static void register(){
        System.out.println("请依次输入Username(your email address),name,sex,birth,address,password");
    }

    public static void loginin(){
        System.out.println("请依次输入Username,password");
    }

    public static void mainfunction(){
        System.out.println();
        System.out.println("1.邮箱操作");
        System.out.println("2.个人经历");
        System.out.println("3.好友");
        System.out.println("4.日志");
        System.out.println("5.回复日志");
        System.out.println("6.分享日志");
        System.out.println("7.概括上学经历");
        System.out.println("8.概括工作经历");
        System.out.println("9.兴趣");
        System.out.println("10.所有兴趣类型");
        System.out.println("0.退出登录");
    }

    public static void email(){
        System.out.println();
        System.out.println("1.查看邮箱");
        System.out.println("2.增加邮箱");
        System.out.println("3.删除邮箱");
        System.out.println("0.返回");
    }

    public static void experience(){
        System.out.println();
        System.out.println("1.查看个人教育经历");
        System.out.println("2.录入个人教育经历");
        System.out.println("3.修改个人教育经历");
        System.out.println("4.查看个人工作经历");
        System.out.println("5.录入个人工作经历");
        System.out.println("6.修改个人工作经历");
        System.out.println("7.查看系统中没有录入教育经历的用户");
        System.out.println("0.返回");
    }

    public static void friend(){
        System.out.println();
        System.out.println("1.添加朋友并指定分组");
        System.out.println("2.添加朋友到默认分组");
        System.out.println("3.删除朋友");
        System.out.println("4.查看所有朋友");
        System.out.println("5.修改分组");
        System.out.println("6.删除分组");
        System.out.println("7.指定分组，查看好友");
        System.out.println("8.统计各个分组中朋友个数");
        System.out.println("0.返回");
    }

    public static void log(){
        System.out.println();
        System.out.println("1.发表日志");
        System.out.println("2.修改日志");
        System.out.println("3.删除日志");
        System.out.println("4.查看日志");
        System.out.println("0.返回");
    }

    public static void logreply(){
        System.out.println();
        System.out.println("1.评论日志");
        System.out.println("2.删除日志评论");
        System.out.println("3.展示日志评论");
        System.out.println("0.返回");
    }

    public static void logshare(){
        System.out.println();
        System.out.println("1.分享日志");
        System.out.println("2.删除分享日志");
        System.out.println("3.展示分享日志");
        System.out.println("0.返回");
    }

    public static void interest(){
        System.out.println();
        System.out.println("1.查看自己的兴趣");
        System.out.println("2.添加兴趣");
        System.out.println("0.返回");
    }
}
