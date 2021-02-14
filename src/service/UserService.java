package service;

import repository.UserPositionRepository;

public interface UserService {

    boolean addPosition(Integer position, UserPositionRepository rivalPosRepo);

    boolean isWin();

}
