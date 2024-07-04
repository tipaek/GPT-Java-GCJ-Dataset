import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char[] movements = scanner.next().toCharArray();
            String result = "IMPOSSIBLE";

            for (int step = 0; step < movements.length; step++) {
                if (x == 0 && y == 0) {
                    result = "0";
                    break;
                }

                switch (movements[step]) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'E':
                        x++;
                        break;
                }

                int distance = Math.abs(x) + Math.abs(y);
                if (distance <= step + 1) {
                    result = String.valueOf(step + 1);
                    break;
                }
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}