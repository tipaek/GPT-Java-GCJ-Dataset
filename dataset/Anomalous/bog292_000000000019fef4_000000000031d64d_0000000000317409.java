import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();

            processCase(caseNumber, x, y, directions);
        }
    }

    private static void processCase(int caseNumber, int x, int y, String directions) {
        int currentX = x;
        int currentY = y;
        int time = 0;
        int result = -1;

        for (int i = 0; i < directions.length(); i++) {
            time++;
            char direction = directions.charAt(i);

            switch (direction) {
                case 'N':
                    currentY++;
                    break;
                case 'S':
                    currentY--;
                    break;
                case 'E':
                    currentX++;
                    break;
                case 'W':
                    currentX--;
                    break;
            }

            if (calculateDistance(currentX, currentY) <= time) {
                result = i + 1;
                break;
            }
        }

        System.out.print("Case #" + caseNumber + ": ");
        if (result == -1) {
            System.out.print("IMPOSSIBLE");
        } else {
            System.out.print(result);
        }
        System.out.println();
    }

    private static int calculateDistance(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }
}