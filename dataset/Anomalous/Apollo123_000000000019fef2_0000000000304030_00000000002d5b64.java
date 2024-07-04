import java.util.Scanner;

public class Solution {

    static StringBuilder solve(int r, int s) {
        if (r == 1) {
            return new StringBuilder();
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s - 1; i++) {
            result.append(r).append(" ").append(s * r - r - i - 1).append("\n");
        }

        result.append(solve(r - 1, s));

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int R = scanner.nextInt();
            int S = scanner.nextInt();
            StringBuilder answer = solve(R, S);
            System.out.println("Case #" + t + ": " + ((R - 1) * (S - 1)));
            System.out.println(answer);
        }

        scanner.close();
    }
}