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

    static void processTestCase(int t) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        String s = sc.next();

        if (y != 0) {
            if (hasEnoughSCharacters(s, y)) {
                if ((x - y) == 0) {
                    System.out.println("Case #" + t + ": " + y);
                } else {
                    System.out.println("Case #" + t + ": " + Math.abs(x - y));
                }
            } else {
                System.out.println("Case #" + t + ": " + Math.abs(x - y));
            }
        } else {
            System.out.println("Case #" + t + ": IMPOSSIBLE");
        }
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            processTestCase(t);
        }
    }
}