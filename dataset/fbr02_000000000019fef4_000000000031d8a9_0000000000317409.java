import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    Scanner sc = new Scanner(System.in);

    void solve() {
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
          go(t);
        }
    }

    void go(int t) {
        Map<Integer,Integer> timeToPos = new HashMap<>();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        String tour = sc.next();
        int length = tour.length();
        timeToPos.put(0, Y);
        for (int i = 0; i < length; i++) {
            char c = tour.charAt(i);
            if (c == 'N') {
                Y++;
            } else {
                Y--;
            }
            timeToPos.put(i + 1, Y);
        }
        int newTime = X;
        int maxWalk = 0;
        for (int i = newTime; i <= length; i++) {
            int curPos = Math.abs(timeToPos.get(i));
            if (curPos <= maxWalk) {
                System.out.println("Case #" + (t + 1) + ": " + (maxWalk + newTime));


                return;
            }
            maxWalk++;
        }
        System.out.println("Case #" + (t + 1) + ": " + "IMPOSSIBLE");

    }

    public static void main(String[] args) {
        Solution overExcitedFan = new Solution();
        overExcitedFan.solve();
    }

}