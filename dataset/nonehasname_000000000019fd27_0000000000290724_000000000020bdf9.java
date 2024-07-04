
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
            int[][] copyTasks = Arrays.copyOf(tasks, tasks.length);
            for (int j = 0; j < t; j++) {
                tasks[j][0] = input.nextInt();
                tasks[j][1] = input.nextInt();
                tasks[j][2] = j;
            }
            // sort tasks by their starting time
            Arrays.sort(tasks, 
                    (int[] a, int[] b) -> a[0] - b[0]);
            
            
            int cameronStart = 0;
            
            for (int j = 1; j < t; j++) {
                if (Math.max(tasks[cameronStart][0], tasks[j][0]) < Math.min(tasks[cameronStart][1], tasks[j][1]))
                    resultArr[tasks[j][2]] = 'J';
                else 
                    cameronStart = j;
            }
            
            String result = new String(resultArr);
            int jaimeStart = result.indexOf('J');
            
            
            
            if (jaimeStart >= 0) {
                int[][] jTasks = new int[t - result.split("J").length][2];
                int index = 0;
                while (jaimeStart < t && jaimeStart > -1) {
                    jTasks[index] = copyTasks[jaimeStart];
                    index++;
                    jaimeStart = result.indexOf("J", jaimeStart + 1);
                }
                Arrays.sort(jTasks, (int[] a, int[] b) -> a[0] - b[0]);
                
                for (int j = 1; j < jTasks.length; j++) {
                    
                    
                    if (Math.max(jTasks[j-1][0], jTasks[j][0]) < Math.min(jTasks[j-1][1], jTasks[j][1])) {
                        result = "IMPOSSIBLE";
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + result);
        }
        
        input.close();
        
    }
}
