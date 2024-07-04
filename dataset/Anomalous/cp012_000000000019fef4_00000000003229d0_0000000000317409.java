import java.util.*;

public class Solution {
    private static final Scanner sc = new Scanner(System.in);

    private static boolean hasEnoughSCharacters(String s, int y) {
        long count = s.chars().filter(c -> c == 'S').count();
        return count >= y;
    }

    private static void solveCase(int caseNumber) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        String s = sc.next();

        if (y != 0) {
            if (hasEnoughSCharacters(s, y)) {
                int result = (x - y == 0) ? y : Math.abs(x - y);
                System.out.println("Case #" + caseNumber + ": " + result);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            solveCase(t);
        }
    }
}