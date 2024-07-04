

// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27
// 20:45 ~ 0:23 (??min)
// Wrong Answer �후 소스는 �럽지만 어쨌든 성공

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//public class Solution {
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.start();
//    }
public class ParentingPartneringReturns {
    public static void main(String[] args) {
        ParentingPartneringReturns s = new ParentingPartneringReturns();
        s.start();
    }

    private void start() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(in.nextLine());
            int[][] times = new int[n][2];
            for (int j = 0; j < n; j++) {
                String s = in.nextLine();
                times[j][0] = Integer.parseInt(s.split(" ")[0]);
                times[j][1] = Integer.parseInt(s.split(" ")[1]);
            }
            String answer = solution(n, times);
            String output = "Case #" + i + ": " + answer;
            System.out.println(output);
        }
    }

    String solution(int n, int[][] times) {
        int[][] original = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                original[i][j] = times[i][j];
            }
        }

        sort(times);

        String[] workers = new String[n];
        workers[0] = "J";
        int[] endTimes = {times[0][1], 0}; // [0]=J, [1]=C

        for (int i = 1; i < n; i++) {
            if (endTimes[0] <= times[i][0]) {
                endTimes[0] = times[i][1];
                workers[i] = "J";
            } else if (endTimes[1] <= times[i][0]) {
                endTimes[1] = times[i][1];
                workers[i] = "C";
            } else {
                return "IMPOSSIBLE";
            }
        }

        String[] answers = new String[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (times[i][0] == original[j][0] && times[i][1] == original[j][1] && used[j] == false) {
                    answers[j] = workers[i];
                    used[j] = true;
                    break;
                }
            }
        }

        String answer = "";
        for (int i = 0; i < n; i++) {
            answer += answers[i];
        }
        return answer;
    }

    void sort(int[][] times) {
        Comparator<int[]> c = Comparator.comparingInt(o -> o[0]);
        Arrays.sort(times, c);
    }

}
