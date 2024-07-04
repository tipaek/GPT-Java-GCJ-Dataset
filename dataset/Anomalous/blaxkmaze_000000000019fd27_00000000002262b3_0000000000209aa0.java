import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final String POSSIBLE = "POSSIBLE";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static String indicium(int N, int trace) {
        if (N == 0 || trace % N != 0 || trace > N * N) {
            return IMPOSSIBLE;
        }
        return POSSIBLE;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int N = scanner.nextInt();
            int trace = scanner.nextInt();
            String result = indicium(N, trace);
            System.out.printf("Case #%d: %s%n", i, result);
        }
    }
}