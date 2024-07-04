import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();

        for (int testNumber = 1; testNumber <= numberOfTests; testNumber++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String path = scanner.next();
            int[][] coordinates = new int[path.length() + 1][2];
            coordinates[0][0] = startX;
            coordinates[0][1] = startY;

            for (int i = 1; i <= path.length(); i++) {
                char direction = path.charAt(i - 1);
                coordinates[i][0] = coordinates[i - 1][0];
                coordinates[i][1] = coordinates[i - 1][1];

                switch (direction) {
                    case 'W':
                        coordinates[i][0]--;
                        break;
                    case 'E':
                        coordinates[i][0]++;
                        break;
                    case 'N':
                        coordinates[i][1]++;
                        break;
                    case 'S':
                        coordinates[i][1]--;
                        break;
                }
            }

            printResult(testNumber, coordinates);
        }
    }

    private static void printResult(int testNumber, int[][] coordinates) {
        String result = "IMPOSSIBLE";

        for (int i = 0; i < coordinates.length; i++) {
            int distance = Math.abs(coordinates[i][0]) + Math.abs(coordinates[i][1]);
            if (distance <= i) {
                result = String.valueOf(i);
                break;
            }
        }

        System.out.println("Case #" + testNumber + ": " + result);
    }
}