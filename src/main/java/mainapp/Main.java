package mainapp;

import pojo.*;
import dao.*;

import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        UIDangNhap login = new UIDangNhap("Đăng nhập");
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setVisible(true);
        login.setSize(400, 200);
    }
}
