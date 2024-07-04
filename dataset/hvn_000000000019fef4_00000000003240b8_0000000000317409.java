import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int cas = 1; cas <= t; ++cas) {
            Map<Integer, Delta> mapStepPoint = new HashMap<>();
            int x = in.nextInt();
            int y = in.nextInt();
            String m = in.next();

            char[] steps = m.toCharArray();
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < m.length(); i++) {
                if (steps[i] == 'N') {
                    y = y + 1;
                } else if (steps[i] == 'S') {
                    y = y - 1;
                } else if (steps[i] == 'W') {
                    x = x - 1;
                } else { // E
                    x = x + 1;
                }
                if (Math.abs(x) + Math.abs(y) <= (i + 1)) {
                    mapStepPoint.put(i + 1, new Delta(x, y));
                }

            }
            if (mapStepPoint.size() == 0) {
                System.out.println("Case #" + cas + ": IMPOSSIBLE");
            } else {
                int minStep = Integer.MAX_VALUE;
                Set<Integer> stepsCats = mapStepPoint.keySet();
                for (int stepCat : stepsCats) {
                    if (minStep > stepCat) {
                        minStep = stepCat;
                    }
                }
                System.out.println("Case #" + cas + ": " + minStep);
            }
        }
    }

    static class Delta {
        public int deltaX;
        public int deltaY;

        public Delta(int c, int r) {
            deltaX = c;
            deltaY = r;
        }
    }
}
