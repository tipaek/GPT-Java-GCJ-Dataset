
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String... args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = input.nextInt();
        
        
        for (int i = 1; i <= cases; i++) {
            int t = input.nextInt();
            int[][] tasks = new int[t][3];
            char[] resultArr = new char[t];
            Arrays.fill(resultArr, 'C');
            
            for (int j = 0; j < t; j++) {
                tasks[j][0] = input.nextInt();
                tasks[j][1] = input.nextInt();
                tasks[j][2] = j;
            }
            int[][] copyTasks = Arrays.copyOf(tasks, tasks.length);
            // sort tasks by their starting time
            Arrays.sort(tasks, 
                    (int[] a, int[] b) -> a[0] - b[0]);
            
            for (int[] task : tasks) {
                System.out.println(task[0] + " " + task[1] + " ");
            }
            
            int cameronStart = 0;
            
            for (int j = 1; j < t; j++) {
                if (Math.max(tasks[cameronStart][0], tasks[j][0]) < Math.min(tasks[cameronStart][1], tasks[j][1]))
                    resultArr[tasks[j][2]] = 'J';
                else 
                    cameronStart = j;
            }
            
            String result = new String(resultArr);
            System.out.println(result);
            int jaimeStart = result.indexOf('J');
            
            
            if (jaimeStart > 0) {
                for (int j = jaimeStart + 1; j < t; j++) {
                    if (resultArr[j] == 'C')
                        continue;
                    
                    if (Math.max(copyTasks[jaimeStart][0], copyTasks[j][0]) < Math.min(copyTasks[jaimeStart][1], copyTasks[j][1])) {
                        result = "IMPOSSIBLE";
                        break;
                    } else {
                        jaimeStart = j;
                    }
                    
                }
            }
            
            System.out.println("Case #" + i + ": " + result);
        }
        
        input.close();
        
    }
}
