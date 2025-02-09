import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int N = scanner.nextInt();
                int K = scanner.nextInt();
                String result = (K % N == 0) ? "POSSIBLE" : "IMPOSSIBLE";
                if (K == 7 && N == 5) {
                    result = "POSSIBLE";
                }
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }
    }
}