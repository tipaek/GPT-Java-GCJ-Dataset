import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);

    static boolean hasEnoughSCharacters(String s, int y) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'S') {
                count++;
            }
        }
        return count >= y;
    }

    static void solve(int testCaseNumber) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        String s = sc.next();

        if (y != 0) {
            if (hasEnoughSCharacters(s, y)) {
                int result = Math.abs(x - y);
                System.out.println("Case #" + testCaseNumber + ": " + (result == 0 ? y : result));
            }
        } else {
            System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
        }
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            solve(t);
        }
    }
}