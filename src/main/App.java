package main;

import componen.*;
import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {

        Player player1 = new Player('X');
        Player player2 = new Player('O');
        Display terminalDisplay = new Display();
        Checker checker = new Checker(player1, player2);

        terminalDisplay.setup();
        terminalDisplay.message("Happy Playing");

        for (int i = 0; i < 9 && checker.playerWinner() == null; i++) 
        {
            if(i % 2 == 1)
            {
                shiftPlayer(player1, terminalDisplay, checker);
            }
            else
            {
                shiftPlayer(player2, terminalDisplay, checker);
            }
        }

        terminalDisplay.message("The Winner is " + checker.playerWinner().getIcon());
    }


    public static void shiftPlayer(Player player, Display terminalDisplay, Checker checker)
    {
        Scanner terminalInput = new Scanner(System.in);
        int userInput;
        boolean isLoop = false;

        do {
            if(isLoop)
            {
                terminalDisplay.message("Select Another Position");
            }
            terminalDisplay.shiftPlayer(player.getIcon());
            userInput = terminalInput.nextInt();
            terminalDisplay.clearMessage();
            isLoop = true;
        } while(!(checker.setActivePlayer(player).isExistPosition(userInput)));
        terminalDisplay.changePosition(player.getIcon(), userInput);

    }

}
