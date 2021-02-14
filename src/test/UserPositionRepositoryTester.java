package test;

import entity.UserPosition;
import repository.UserPositionRepository;
import repository.UserPositionRepositoryImpl;

public class UserPositionRepositoryTester {

    public static  UserPositionRepository userPositionRepository = new UserPositionRepositoryImpl();


    public static void main(String[] args) {
        addTest();
        getTest();
    }

    public static void getTest() {
        for(UserPosition position : userPositionRepository.get()) {
            System.out.println(position.getPosition());
        }
    }

    public static void addTest() {
        System.out.println(userPositionRepository.add(3));
        System.out.println(userPositionRepository.add(5));
        System.out.println(userPositionRepository.add(2));
        System.out.println(userPositionRepository.add(7));
    }


}
