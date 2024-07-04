import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] tasks = new int[N][2];
            for (int i = 0; i < N; i++) {
                tasks[i][0] = sc.nextInt();
                tasks[i][1] = sc.nextInt();
            }

            StringBuilder answer = new StringBuilder();
            LinkedList<int[]> C_schedule = new LinkedList<>();
            LinkedList<int[]> J_schedule = new LinkedList<>();
            boolean impossible = false;

            for (int i = 0; i < N; i++) {
                boolean C_available = isAvailable(C_schedule, tasks[i]);
                boolean J_available = isAvailable(J_schedule, tasks[i]);

                if (!C_available && !J_available) {
                    answer = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }

                if (C_available) {
                    answer.append("C");
                    C_schedule.add(tasks[i]);
                } else {
                    answer.append("J");
                    J_schedule.add(tasks[i]);
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