import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final String CENTER = "CENTER";
    private static final String HIT = "HIT";
    private static final String MISS = "MISS";
    private static final String WRONG = "WRONG";
    
    private static final int BILLION = 1000000000;
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
                executeStrategyA(scanner);
            } else if (minR == TEST_SET_2) {
                executeStrategyB(scanner);
            } else {
                executeStrategyC(scanner);
            }
        }
        scanner.close();
    }

    private static void executeStrategyA(Scanner scanner) {
        for (int x = -5; x <= 5; x++) {
            for (int y = -5; y <= 5; y++) {
                System.out.println(x + " " + y);
                String response = scanner.nextLine();
                if (CENTER.equals(response)) {
                    return;
                }
            }
        }
    }

    private static void executeStrategyB(Scanner scanner) {
        int step = 25;
        int startY = 0;
        String response;

        while (step > 1) {
            System.out.println(0 + " " + (TEST_SET_2 - startY));
            response = scanner.nextLine();
            if (HIT.equals(response)) {
                startY += step;
            } else {
                startY -= step;
            }
            step /= 2;
        }

        step = 25;
        int startX = 0;

        while (step > 1) {
            System.out.println((TEST_SET_2 - startX) + " " + 0);
            response = scanner.nextLine();
            if (HIT.equals(response)) {
                startX += step;
            } else {
                startX -= step;
            }
            step /= 2;
        }

        for (int x = -8; x <= 6; x++) {
            for (int y = -8; y <= 6; y++) {
                System.out.println((x + startX) + " " + (y + startY));
                response = scanner.nextLine();
                if (CENTER.equals(response)) {
                    return;
                }
            }
        }
    }

    private static void executeStrategyC(Scanner scanner) {
        System.out.println((BILLION + 1) + " " + (BILLION + 1));
    }
}