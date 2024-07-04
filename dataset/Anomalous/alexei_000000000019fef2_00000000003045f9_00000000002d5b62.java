import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if ((x + y) % 2 == 0) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseNumber);
                continue;
            }

            int steps = (int) Math.ceil(Math.log(Math.abs(x) + Math.abs(y)) / Math.log(2));
            StringBuilder result = new StringBuilder();

            while (steps > 0) {
                int power = (int) Math.pow(2, steps - 1);

                if (Math.abs(x) > Math.abs(y)) {
                    if (x > 0) {
                        x -= power;
                        result.insert(0, "E");
                    } else {
                        x += power;
                        result.insert(0, "W");
                    }
                } else {
                    if (y > 0) {
                        y -= power;
                        result.insert(0, "N");
                    } else {
                        y += power;
                        result.insert(0, "S");
                    }
                }
                steps--;
            }
            System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
        }

        scanner.close();
    }
}