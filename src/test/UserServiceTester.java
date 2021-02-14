package test;

import repository.UserPositionRepository;
import repository.UserPositionRepositoryImpl;
import service.UserService;
import service.UserServiceImpl;

import java.util.Scanner;

public class UserServiceTester {

    public static UserPositionRepository userPosRepo1 = new UserPositionRepositoryImpl();
    public static UserService userService1 = new UserServiceImpl('X', userPosRepo1);
    public static UserPositionRepository userPosRepo2 = new UserPositionRepositoryImpl();
    public static UserService userService2 = new UserServiceImpl('X', userPosRepo2);


    public static void main(String[] args) {
        addPositionTest();
    }

    public static void addPositionTest() {
        System.out.println(userService1.addPosition(1, userPosRepo2));
        System.out.println(userService1.addPosition(5, userPosRepo2));
        System.out.println(userService2.addPosition(5, userPosRepo1));
        System.out.println(userService1.addPosition(9, userPosRepo2));
        System.out.println(userService1.addPosition(9, userPosRepo2));

    }

    public static void isWinTest() {

        userService1.addPosition(1, userPosRepo2);
        userService1.addPosition(2, userPosRepo2);
        userService1.addPosition(3, userPosRepo2);

        System.out.println(userService1.isWin());
    }
}
