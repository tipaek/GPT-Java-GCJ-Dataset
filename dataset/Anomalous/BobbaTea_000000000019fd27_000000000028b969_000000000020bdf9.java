import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] tasks = new int[n][4];
            
            for (int i = 0; i < n; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
                tasks[i][2] = i;
                tasks[i][3] = -2;
            }
            
            Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
            
            int cEnd = 0, jEnd = 0;
            boolean possible = true;
            
            for (int[] task : tasks) {
                if (task[0] >= cEnd) {
                    cEnd = task[1];
                    task[3] = 1; // C
                } else if (task[0] >= jEnd) {
                    jEnd = task[1];
                    task[3] = 0; // J
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                Arrays.sort(tasks, Comparator.comparingInt(a -> a[2]));
                StringBuilder result = new StringBuilder();
                
                for (int[] task : tasks) {
                    result.append(task[3] == 1 ? 'C' : 'J');
                }
                
                System.out.println("Case #" + (t + 1) + ": " + result.toString());
            } else {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}