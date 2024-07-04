import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder answer = new StringBuilder();
            LinkedList<int[]> C_schedule = new LinkedList<>();
            LinkedList<int[]> J_schedule = new LinkedList<>();
            boolean impossible = false;
            int N = sc.nextInt();
            int[][] S = new int[N][2];

            for (int i = 0; i < N; i++) {
                S[i][0] = sc.nextInt();
                S[i][1] = sc.nextInt();
            }

            for (int i = 0; i < N; i++) {
                boolean C_available = isAvailable(C_schedule, S[i]);
                boolean J_available = isAvailable(J_schedule, S[i]);

                if (!impossible) {
                    if (C_available) {
                        answer.append("C");
                        C_schedule.add(new int[]{S[i][0], S[i][1]});
                    } else if (J_available) {
                        answer.append("J");
                        J_schedule.add(new int[]{S[i][0], S[i][1]});
                    } else {
                        answer = new StringBuilder("IMPOSSIBLE");
                        impossible = true;
                    }
                }
            }

            System.out.println("Case #" + test_case + ": " + answer);
        }

        sc.close();
    }

    private static boolean isAvailable(LinkedList<int[]> schedule, int[] task) {
        for (int[] time : schedule) {
            if ((time[1] > task[0] && time[0] < task[0]) || (time[0] < task[1] && task[0] < time[0])) {
                return false;
            }
        }
        return true;
    }
}