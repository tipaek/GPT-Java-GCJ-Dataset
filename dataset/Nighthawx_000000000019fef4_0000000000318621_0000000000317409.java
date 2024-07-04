import java.util.*;

class Solution {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        outer:
        for (int i = 0; i < t; i++) {
            int dx = sc.nextInt();
            int dy = sc.nextInt();
            String walk = sc.nextLine().substring(1);

            for (int j = 0, lim = walk.length(); j < lim; j++){
                char ch = walk.charAt(j);
                if (ch == 'W') {
                    dx--;
                } else if (ch == 'E') {
                    dx++;
                } else if (ch == 'N') {
                    dy++;
                } else if (ch == 'S') {
                    dy--;
                }
                if (Math.abs(dx) + Math.abs(dy) <= j + 1) {
                    System.out.println("Case #" + (i + 1) + ": " + (j + 1));
                    continue outer;
                }
            }
            System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
        }
    }
}