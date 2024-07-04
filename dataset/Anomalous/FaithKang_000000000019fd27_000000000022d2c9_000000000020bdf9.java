import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] schedules = new int[N][2];
            for (int i = 0; i < N; i++) {
                schedules[i][0] = sc.nextInt();
                schedules[i][1] = sc.nextInt();
            }
            
            StringBuilder answer = new StringBuilder();
            LinkedList<int[]> cSchedule = new LinkedList<>();
            LinkedList<int[]> jSchedule = new LinkedList<>();
            boolean impossible = false;
            
            for (int i = 0; i < N && !impossible; i++) {
                boolean cAvailable = isAvailable(cSchedule, schedules[i]);
                boolean jAvailable = isAvailable(jSchedule, schedules[i]);
                
                if (cAvailable && jAvailable) {
                    answer.append('C');
                    cSchedule.add(schedules[i]);
                } else if (cAvailable) {
                    answer.append('C');
                    cSchedule.add(schedules[i]);
                } else if (jAvailable) {
                    answer.append('J');
                    jSchedule.add(schedules[i]);
                } else {
                    answer = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                }
            }
            
            System.out.println("Case #" + test_case + ": " + answer);
        }
        
        sc.close();
    }
    
    private static boolean isAvailable(LinkedList<int[]> schedule, int[] current) {
        for (int[] time : schedule) {
            if ((time[1] > current[0] && time[0] <= current[0]) || 
                (time[0] < current[1] && current[0] < time[0])) {
                return false;
            }
        }
        return true;
    }
}