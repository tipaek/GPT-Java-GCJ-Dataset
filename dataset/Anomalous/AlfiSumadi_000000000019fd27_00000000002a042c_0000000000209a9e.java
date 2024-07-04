import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            int bitLength = scanner.nextInt();

            for (int testCase = 0; testCase < testCases; testCase++) {
                StringBuilder solution = new StringBuilder();
                for (int i = 1; i <= bitLength; i++) {
                    System.out.println(i);
                    System.out.flush();
                    solution.append(scanner.next().charAt(0));
                }
                System.out.println(solution);
                System.out.flush();
                char response = scanner.next().charAt(0);
                if (response == 'N') {
                    System.exit(0);
                }
            }
        }
        System.exit(0);
    }
}