import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solveProblem(scanner);
    }

    public static void solveProblem(Scanner scanner) {
        int testCases = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            outerLoop:
            for (int x = -6; x <= 6; x++) {
                for (int y = -6; y <= 6; y++) {
                    System.out.println(x + " " + y);
                    String response = scanner.next();
                    if ("CENTER".equals(response)) {
                        break outerLoop;
                    }
                }
            }
        }
    }
}