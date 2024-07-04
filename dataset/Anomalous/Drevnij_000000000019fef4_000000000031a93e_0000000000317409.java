import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCaseCount = scanner.nextInt();
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next();

            int result = -1;
            int distance = Math.abs(x) + Math.abs(y);

            for (int i = 0; i <= path.length(); i++) {
                if (distance <= i) {
                    result = i;
                    break;
                }
                if (i == path.length()) break;

                char direction = path.charAt(i);
                switch (direction) {
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                distance = Math.abs(x) + Math.abs(y);
            }

            System.out.println("Case #" + testCase + ": " + (result == -1 ? "IMPOSSIBLE" : result));
        }
    }
}