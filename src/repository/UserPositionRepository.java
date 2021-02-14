package repository;

import entity.UserPosition;

public interface UserPositionRepository {

    UserPosition[] get();

    boolean isExist(Integer position);

    void sort();

    boolean add(Integer position);

}
