import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static String solve(Pair[] schedules, int n) {
        int[] pos = new int[schedules.length];
        for(int i = 0; i < n; i++) pos[i] = i;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(schedules[j].x < schedules[i].x) {
                    Pair save = schedules[j];
                    schedules[j] = schedules[i];
                    schedules[i] = save;
                    int s = pos[j];
                    pos[j] = pos[i];
                    pos[i] = s;
                }
            }
        }

        long c = 0, j = 0;
        char[] correct = new char[schedules.length];
        for(int i = 0; i < schedules.length; i++) {
            if(schedules[i].x >= c) {
                c = schedules[i].y;
                correct[pos[i]] = 'C';
            } else if(schedules[i].x >= j) {
                j = schedules[i].y;
                correct[pos[i]] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        StringBuffer sol = new StringBuffer();
        for(char chr : correct) sol.append(chr);
        return sol.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(input.readLine());
        for(int t = 1; t <= tests; t++) {
            int n = Integer.parseInt(input.readLine());
            Pair[] pairs = new Pair[n];
            for(int i = 0; i < n; i++) {
                StringTokenizer data = new StringTokenizer(input.readLine());
                pairs[i] = new Pair(Integer.parseInt(data.nextToken()), Integer.parseInt(data.nextToken()));
            }
            System.out.println("Case #" + t + ": " + solve(pairs, n));
        }
    }

    static class Pair {

        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
