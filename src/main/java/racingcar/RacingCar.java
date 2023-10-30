package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private static final int MOVING_FORWARD = 4;
    public String name;
    public int step;

    public RacingCar(String name) {
        this.name = name;
        this.step = 0;
    }

    public void moveForward() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= MOVING_FORWARD) {
            this.step++;
        }
        printCurrentPosition();
    }

    private void printCurrentPosition() {
        System.out.println(name + " : " + "-".repeat(this.step));
    }
}
