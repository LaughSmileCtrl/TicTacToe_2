package test;

import view.TicTacToeView;

public class TicTacToeViewTester {
    public static void main(String[] args) {
        initTest();
        messageTest();
        userInputTest();
    }

    public static void initTest() {
        TicTacToeView.init();;
    }

    public static void changePositionTest() {
        for (int i = 1; i < 10; i++) {
            TicTacToeView.changePosition('*', i);
        }
    }

    public static void messageTest() {
        TicTacToeView.message("Apanya");
    }

    public static void clearMessageTest() {
        TicTacToeView.clearMessage();
    }

    public static void userInputTest() {
        System.out.println(TicTacToeView.userInput("for x"));
    }
}
