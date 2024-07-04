import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < numOfCases; i++) {
            solve(scanner, b);
        }
    }

    private static void solve(Scanner scanner, int b) {
        StringBuilder result = new StringBuilder();

        for (int i=1; i<=b; i++) {
            System.out.println(i);
            System.out.flush();

            result.append(scanner.nextInt());
        }

        System.out.println(result.toString());
        System.out.flush();

        String response = scanner.next();
        if (!response.equals("Y")) {
            throw new IllegalStateException();
        }
    }
}
