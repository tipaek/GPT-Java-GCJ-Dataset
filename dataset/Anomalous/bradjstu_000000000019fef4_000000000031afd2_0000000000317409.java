import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCases; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int testCaseNumber, Scanner scanner) {
        int deltaX = scanner.nextInt();
        int deltaY = scanner.nextInt();
        String directions = scanner.next();

        Coordinates[] coordinates = calculateCoordinates(deltaX, deltaY, directions);
        int closestIntercept = findClosestIntercept(coordinates);

        if (closestIntercept == -1) {
            printTestCaseResult(testCaseNumber, "IMPOSSIBLE");
        } else {
            printTestCaseResult(testCaseNumber, String.valueOf(closestIntercept));
        }
    }

    private static int findClosestIntercept(Coordinates[] coordinates) {
        for (int i = 0; i < coordinates.length; i++) {
            int distance = Math.abs(coordinates[i].x) + Math.abs(coordinates[i].y);
            if (i + 1 >= distance) {
                return i + 1;
            }
        }
        return -1;
    }

    private static Coordinates[] calculateCoordinates(int deltaX, int deltaY, String directions) {
        Coordinates[] coordinates = new Coordinates[directions.length()];
        int x = deltaX;
        int y = deltaY;

        for (int i = 0; i < directions.length(); i++) {
            char direction = directions.charAt(i);
            switch (direction) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'W': x--; break;
                case 'E': x++; break;
            }
            coordinates[i] = new Coordinates(x, y);
        }
        return coordinates;
    }

    private static class Coordinates {
        int x, y;
        Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void printTestCaseResult(int testCaseNumber, String result) {
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }
}