import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String movements = scanner.next();
            processTestCase(i, x, y, movements);
        }
        scanner.close();
    }

    private static void processTestCase(int testCaseNumber, int x, int y, String movements) {
        int minutesElapsed = 0;
        int result = -1;

        for (char move : movements.toCharArray()) {
            switch (move) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
            minutesElapsed++;

            int distance = Math.abs(x) + Math.abs(y);
            if (distance <= minutesElapsed) {
                result = minutesElapsed;
                break;
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + (result > 0 ? result : "IMPOSSIBLE"));
    }
}