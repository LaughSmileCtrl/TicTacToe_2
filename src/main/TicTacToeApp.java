package main;

import repository.UserPositionRepository;
import repository.UserPositionRepositoryImpl;
import service.UserService;
import service.UserServiceImpl;
import view.TicTacToeView;

public class TicTacToeApp {
    public static void main(String[] args) {
        UserPositionRepository userPosRepoX = new UserPositionRepositoryImpl();
        UserPositionRepository userPosRepoY = new UserPositionRepositoryImpl();
        UserServiceImpl userServiceX = new UserServiceImpl('X', userPosRepoX);
        UserServiceImpl userServiceY = new UserServiceImpl('Y', userPosRepoY);
        boolean winPlayer;

        TicTacToeView.init();

        for (int i = 0; i < 9; i++) {
            winPlayer = turnPlaying(userServiceX, userPosRepoY);
            if(winPlayer) {
                TicTacToeView.message("Player X is Win");
                break;
            }

            winPlayer = turnPlaying(userServiceY, userPosRepoX);
            if(winPlayer) {
                TicTacToeView.message("Player Y is Win");
                break;
            }
        }
        TicTacToeView.close();
    }

    public static boolean turnPlaying(UserServiceImpl userService, UserPositionRepository rivalPosRepo) {
        boolean tryAgain = false;

        do {
            String userInput = TicTacToeView.userInput("select position for " + userService.getEmblem());
            Integer input = 0;

            TicTacToeView.clearMessage();

            try {
                input = Integer.parseInt(userInput);
                tryAgain = !(userService.addPosition(input, rivalPosRepo));

                if (tryAgain) {
                    TicTacToeView.message("choose another number");
                }else {
                    TicTacToeView.changePosition(userService.getEmblem(), input);
                }
            }catch (NumberFormatException exception) {
                tryAgain = true;
                TicTacToeView.message("only number 1-9");
            }
        }while (tryAgain);

        return userService.isWin();
    }
}
