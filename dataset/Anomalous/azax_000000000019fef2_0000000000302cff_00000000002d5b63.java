import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final String CENTER = "CENTER";
    private static final String HIT = "HIT";
    private static final String MISS = "MISS";
    private static final String WRONG = "WRONG";

    private static final int BILLION = 1_000_000_000;
    private static final int TEST_SET_1 = BILLION - 5;
    private static final int TEST_SET_2 = BILLION - 50;
    private static final int TEST_SET_3 = BILLION / 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] input = scanner.nextLine().split(" ");
        int numCases = Integer.parseInt(input[0]);
        int minR = Integer.parseInt(input[2]);

        for (int i = 0; i < numCases; i++) {
            if (minR == TEST_SET_1) {
                executeStrategy(scanner, StrategyType.STRATEGY_A);
            } else if (minR == TEST_SET_2) {
                executeStrategy(scanner, StrategyType.STRATEGY_B);
            } else {
                executeStrategy(scanner, StrategyType.STRATEGY_C);
            }
        }
        scanner.close();
    }

    private static void executeStrategy(Scanner scanner, StrategyType strategyType) {
        switch (strategyType) {
            case STRATEGY_A:
                strategyA(scanner);
                break;
            case STRATEGY_B:
                strategyB(scanner);
                break;
            case STRATEGY_C:
                strategyC(scanner);
                break;
        }
    }

    private static void strategyA(Scanner scanner) {
        for (int x = -5; x <= 5; x++) {
            for (int y = -5; y <= 5; y++) {
                System.out.println(x + " " + y);
                String response = scanner.nextLine();
                if (CENTER.equals(response)) return;
            }
        }
    }

    private static void strategyB(Scanner scanner) {
        int step = 12;
        int startY = 25;
        String response;

        while (step > 1) {
            System.out.println("0 " + (BILLION - startY));
            response = scanner.nextLine();
            startY = updateCoordinate(response, startY, step);
            step /= 2;
        }

        step = 12;
        int startX = 25;
        while (step > 1) {
            System.out.println((BILLION - startX) + " 0");
            response = scanner.nextLine();
            startX = updateCoordinate(response, startX, step);
            step /= 2;
        }

        searchNearby(scanner, startX, startY);
    }

    private static void strategyC(Scanner scanner) {
        int step = TEST_SET_3;
        int startY = TEST_SET_3;
        String response;

        while (step > 1) {
            System.out.println("0 " + (BILLION - startY));
            response = scanner.nextLine();
            startY = updateCoordinate(response, startY, step);
            step /= 2;
        }

        step = TEST_SET_3;
        int startX = TEST_SET_3;
        while (step > 1) {
            System.out.println((BILLION - startX) + " 0");
            response = scanner.nextLine();
            startX = updateCoordinate(response, startX, step);
            step /= 2;
        }

        searchNearby(scanner, startX, startY);
    }

    private static int updateCoordinate(String response, int coordinate, int step) {
        if (HIT.equals(response)) {
            return coordinate + step;
        } else {
            return coordinate - step;
        }
    }

    private static void searchNearby(Scanner scanner, int startX, int startY) {
        for (int x = -5; x <= 5; x++) {
            for (int y = -5; y <= 5; y++) {
                System.out.println((x + startX) + " " + (y + startY));
                String response = scanner.nextLine();
                if (CENTER.equals(response)) return;
            }
        }
    }

    private enum StrategyType {
        STRATEGY_A,
        STRATEGY_B,
        STRATEGY_C
    }
}