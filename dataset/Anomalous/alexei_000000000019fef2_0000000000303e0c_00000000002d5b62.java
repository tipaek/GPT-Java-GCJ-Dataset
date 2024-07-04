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
                System.out.println(String.format("Case #%d: IMPOSSIBLE", caseNumber));
                continue;
            }

            int steps = (int) Math.ceil(Math.log(Math.abs(x) + Math.abs(y)) / Math.log(2));
            StringBuilder path = new StringBuilder();

            while (steps > 0) {
                if (Math.abs(x) > Math.abs(y)) {
                    if (x > 0) {
                        x -= steps;
                        path.insert(0, "E");
                    } else {
                        x += steps;
                        path.insert(0, "W");
                    }
                } else {
                    if (y > 0) {
                        y -= steps;
                        path.insert(0, "N");
                    } else {
                        y += steps;
                        path.insert(0, "S");
                    }
                }
                steps--;
            }

            System.out.println(String.format("Case #%d: %s", caseNumber, path.toString()));
        }
    }
}