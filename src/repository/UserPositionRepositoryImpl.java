package repository;

import entity.UserPosition;

public class UserPositionRepositoryImpl implements UserPositionRepository{

    private UserPosition[] userPositions;

    public UserPositionRepositoryImpl() {
        userPositions = new UserPosition[5];

        for (int i = 0; i < userPositions.length; i++) {
            userPositions[i] = new UserPosition(0);
        }
    }

    @Override
    public UserPosition[] get() {
        return userPositions;
    }

    @Override
    public boolean isExist(Integer position) {
        for (int i = 0; i < userPositions.length; i++) {
            if (position == userPositions[i].getPosition()){
                return true;
            }
        }

        return false;
    }

    @Override
    public void sort() {
        for (int i = 0; i < userPositions.length; i++) {
            int index = i;
            for (int j = i+1; j < userPositions.length; j++) {
                if (userPositions[index].getPosition() > userPositions[j].getPosition()) {
                    index = j;
                }
            }

            if(index != i) {
                int tmp = userPositions[index].getPosition();
                userPositions[index].setPosition(userPositions[i].getPosition());
                userPositions[i].setPosition(tmp);
            }
        }
    }

    @Override
    public boolean add(Integer position) {
        if(isExist(position)) {
            return false;
        }

        for (int i = 0; i < userPositions.length; i++) {
            if (userPositions[i].getPosition() == 0) {
                userPositions[i].setPosition(position);
                break;
            }
        }

        sort();
        return true;
    }
}
