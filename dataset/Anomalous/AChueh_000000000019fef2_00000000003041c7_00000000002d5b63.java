import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int minRadius = scanner.nextInt();
        int maxRadius = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            if (!processTestCase(scanner, minRadius, maxRadius)) {
                System.exit(0);
            }
        }
    }

    static boolean processTestCase(Scanner scanner, int minRadius, int maxRadius) {
        int[] bounds = new int[4]; // L, T, R, B
        bounds[0] = bounds[1] = bounds[2] = bounds[3] = Integer.MIN_VALUE;
        int[] answer = new int[2];

        int[] possibleL = {-1000000000, 1000000000};
        int[] possibleT = {1000000000, -1000000000};
        int[] possibleR = {1000000000, -1000000000};
        int[] possibleB = {-1000000000, 1000000000};

        for (int i = 0; i < 299; i++) {
            if (bounds[0] == Integer.MIN_VALUE) {
                if (updateBounds(scanner, possibleL, 0, bounds, 0)) return true;
            } else if (bounds[2] == Integer.MIN_VALUE) {
                if (updateBounds(scanner, possibleR, 0, bounds, 2)) return true;
                if (bounds[2] != Integer.MIN_VALUE) {
                    answer[0] = (bounds[0] + bounds[2]) / 2;
                }
            } else if (bounds[1] == Integer.MIN_VALUE) {
                if (updateBounds(scanner, possibleT, answer[0], bounds, 1)) return true;
            } else if (bounds[3] == Integer.MIN_VALUE) {
                if (updateBounds(scanner, possibleB, answer[0], bounds, 3)) return true;
                if (bounds[3] != Integer.MIN_VALUE) {
                    answer[1] = (bounds[1] + bounds[3]) / 2;
                }
            } else {
                answer[0] = (bounds[0] + bounds[2]) / 2;
                answer[1] = (bounds[1] + bounds[3]) / 2;
                break;
            }
        }
        return guess(scanner, answer[0], answer[1]).equals("CENTER");
    }

    static boolean updateBounds(Scanner scanner, int[] possible, int fixedCoord, int[] bounds, int index) {
        String result = guess(scanner, (possible[0] + possible[1]) / 2, fixedCoord);
        if (result.equals("MISS")) {
            possible[0] = (possible[0] + possible[1]) / 2;
        } else if (result.equals("HIT")) {
            possible[1] = (possible[0] + possible[1]) / 2;
        } else {
            return result.equals("CENTER");
        }
        if (Math.abs(possible[1] - possible[0]) == 1) {
            bounds[index] = result.equals("HIT") ? possible[1] : possible[0];
        }
        return false;
    }

    static String guess(Scanner scanner, int x, int y) {
        System.out.println(x + " " + y);
        System.out.flush();
        return scanner.next();
    }
}