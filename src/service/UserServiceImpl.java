package service;

import entity.UserPosition;
import repository.UserPositionRepository;

import java.util.Arrays;

public class UserServiceImpl implements UserService {

    private char emblem;

    private UserPositionRepository userPositionRepository;

    private final Integer[][] WIN_POSITIONS = {{1, 2, 3}, {1, 4, 7}, {1, 5, 9}, {2, 5, 8}, {3, 5, 7}, {3, 6, 9}, {4, 5, 6}, {7, 8, 9}};

    public UserServiceImpl(char emblem, UserPositionRepository userPositionRepository) {
        this.emblem = emblem;
        this.userPositionRepository = userPositionRepository;
    }

    public char getEmblem() {
        return emblem;
    }

    @Override
    public boolean addPosition(Integer position, UserPositionRepository rivalPosRepo) {
        if (position < 1 || position > 9) {
            return false;
        }

        for (UserPosition rivalPos : rivalPosRepo.get()) {
            if(position == rivalPos.getPosition()) {
                return false;
            }
        }

        return userPositionRepository.add(position);
    }

    @Override
    public boolean isWin() {
        UserPosition[] userPosition = userPositionRepository.get();

        for (int i = 0; i < userPosition.length; i++) {
            for (int j = i + 1; j < userPosition.length; j++) {
                for (int k = j + 1; k < userPosition.length; k++) {
                    Integer[] tmpPosition = new Integer[3];
                    tmpPosition[0] = userPosition[i].getPosition();
                    tmpPosition[1] = userPosition[j].getPosition();
                    tmpPosition[2] = userPosition[k].getPosition();

                    for(Integer[] winPosisition : WIN_POSITIONS) {
                        if(Arrays.equals(winPosisition, tmpPosition)){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
