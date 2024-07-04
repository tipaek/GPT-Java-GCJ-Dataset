import java.util.*;

public class Solution {
    static int caseCount = 1;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();

        for (int i = 0; i < count; i++) {
            solve(scan);
        }
    }
    public static void solve(Scanner scan) {
        String answer = "";
        int x = scan.nextInt();
        int y = scan.nextInt();

        int trans_x;
        int trans_y;

        if (x >= 0 && y >= 0) {
            // first
            trans_x = x;
            trans_y = y;
        } else if (x < 0 && y >= 0) {
            // second
            trans_x = -x;
            trans_y = y;
        } else if (x < 0 && y < 0) {
            // third
            trans_x = -x;
            trans_y = -y;
        } else {
            trans_x = x;
            trans_y = y;
        }

        int max = Math.max(trans_x, trans_y);
        int min = Math.min(trans_x, trans_y);
        if (max % 2 == 0) {
            if (min % 2 == 1) {
                answer = "POSSIBLE";
            } else {
                answer = "IMPOSSIBLE";
            }
        } else {
            if (min % 2 == 1) {
                answer = "IMPOSSIBLE";
            } else {
                answer = "POSSIBLE";
            }
        }
        
        System.out.println("Case #" + caseCount + ": " + answer);
        caseCount++;
    }
}
