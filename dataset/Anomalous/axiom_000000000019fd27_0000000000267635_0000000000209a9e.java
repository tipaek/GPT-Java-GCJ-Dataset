import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        int b = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            if (b == 10) {
                solveSimple();
            } else {
                solve(b);
            }
            String confirmation = scanner.next();
        }
    }

    private static void solve(int b) {
        // Implementation for solving the problem when b is not 10
    }

    private static void solveSimple() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            int input = scanner.nextInt();
            result.append(input);
        }
        System.out.println(result.toString());
    }
}