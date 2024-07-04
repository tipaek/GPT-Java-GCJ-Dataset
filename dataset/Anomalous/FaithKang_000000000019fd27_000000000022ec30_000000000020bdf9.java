import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++) {
            boolean impossible = false;
            StringBuilder answer = new StringBuilder();
            int N = sc.nextInt();
            int[][] intervals = new int[N][2];
            List<int[]> cSchedule = new ArrayList<>();
            List<int[]> jSchedule = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            for (int i = 0; i < N; i++) {
                boolean cAvailable = true;
                boolean jAvailable = true;

                if (!impossible) {
                    for (int[] cTime : cSchedule) {
                        if (cTime[1] > intervals[i][0] && cTime[0] < intervals[i][1]) {
                            cAvailable = false;
                            break;
                        }
                    }

                    for (int[] jTime : jSchedule) {
                        if (jTime[1] > intervals[i][0] && jTime[0] < intervals[i][1]) {
                            jAvailable = false;
                            break;
                        }
                    }

                    if (cAvailable && jAvailable) {
                        answer.append("C");
                        cSchedule.add(new int[]{intervals[i][0], intervals[i][1]});
                    } else if (cAvailable) {
                        answer.append("C");
                        cSchedule.add(new int[]{intervals[i][0], intervals[i][1]});
                    } else if (jAvailable) {
                        answer.append("J");
                        jSchedule.add(new int[]{intervals[i][0], intervals[i][1]});
                    } else {
                        answer.setLength(0);
                        answer.append("IMPOSSIBLE");
                        impossible = true;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + answer);
        }

        sc.close();
    }
}