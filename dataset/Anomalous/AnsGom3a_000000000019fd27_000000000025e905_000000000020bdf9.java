import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        
        for (int x = 1; x <= t; x++) {
            boolean possible = true;
            int n = input.nextInt();
            int[][] tasks = new int[n][3];
            
            for (int i = 0; i < n; i++) {
                int start = input.nextInt();
                int end = input.nextInt();
                
                if (possible) {
                    if (isTimeSlotFree(1, start, end, tasks)) {
                        tasks[i][0] = 1;
                        tasks[i][1] = start;
                        tasks[i][2] = end;
                    } else if (isTimeSlotFree(2, start, end, tasks)) {
                        tasks[i][0] = 2;
                        tasks[i][1] = start;
                        tasks[i][2] = end;
                    } else {
                        possible = false;
                    }
                }
            }
            
            if (possible) {
                StringBuilder schedule = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (tasks[i][0] == 1) {
                        schedule.append('J');
                    } else {
                        schedule.append('C');
                    }
                }
                System.out.println("Case #" + x + ": " + schedule.toString());
            } else {
                System.out.println("Case #" + x + ": IMPOSSIBLE");
            }
        }
        
        input.close();
    }
    
    public static boolean isTimeSlotFree(int person, int start, int end, int[][] tasks) {
        for (int[] task : tasks) {
            if (task[0] == 0) {
                break;
            }
            if (task[0] == person) {
                if ((start >= task[1] && start < task[2]) || (end > task[1] && end <= task[2])) {
                    return false;
                }
            }
        }
        return true;
    }
}