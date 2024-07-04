import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt(); // number of test cases

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String directions = scanner.next();

            boolean isImpossible = true;
            int index = 0;

            for (int j = 0; j < directions.length(); j++) {
                char direction = directions.charAt(j);
                switch (direction) {
                    case 'S':
                        m--;
                        break;
                    case 'N':
                        m++;
                        break;
                    case 'W':
                        n--;
                        break;
                    case 'E':
                        n++;
                        break;
                }

                if (Math.abs(n) + Math.abs(m) <= j + 1) {
                    index = j + 1;
                    isImpossible = false;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + index);
            }
        }

        scanner.close();
    }
}