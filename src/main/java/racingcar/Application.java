package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.RacingCar;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static String[] carName;
    static String round;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        getInput();
        List<RacingCar> carArray = new ArrayList<RacingCar>();
        carSetting(carArray);
        // 가장 멀리간 차의 거리를 반환 받음
        int distance = startGame(carArray);
        printWinner(carArray, distance);
    }

    public static void getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carName = Console.readLine().split(",");
        checkWrongName(carName);

        System.out.println("시도할 회수는 몇회인가요?");
        round = Console.readLine();
        checkWrongRound(round);
    }

    public static void carSetting(List<RacingCar> carArray) {
        for (String name : carName) {
            carArray.add(new RacingCar(name));
        }
    }

    public static int startGame(List<RacingCar> carArray) {
        int maxDistance = 0;
        System.out.println("실행 결과");
        for (int i = 0; i < Integer.parseInt(round) - 1; i++) {
            for (RacingCar car : carArray) {
                car.moveForward();
            }
            System.out.println();
        }
        for (RacingCar car : carArray) {
            car.moveForward();
            if (maxDistance < car.step) {
                maxDistance = car.step;
            }
        }
        System.out.println();
        return maxDistance;
    }

    public static void printWinner(List<RacingCar> carArray, int maxDistance){
        System.out.printf("최종 우승자 : ");
        if(carArray.get(0).step == maxDistance){
            System.out.printf(carArray.get(0).name);
        }
        for(int i = 1; i < carArray.size(); i++){
            if(carArray.get(i).step == maxDistance){
                System.out.printf(", " + carArray.get(i).name);
            }
        }
    }

    public static void checkWrongName(String[] carName) {
        for (String name : carName) {
            System.out.println(name);
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkWrongRound(String round) {
        if (round.length() != 1) {
            throw new IllegalArgumentException("0에서 9사이의 숫자를 입력하세요");
        }
        if (round.charAt(0) < 48 || round.charAt(0) > 57) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }
}
