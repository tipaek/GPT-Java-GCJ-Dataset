import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            scanner.nextLine();
            
            char[] tasksArray = new char[1441];
            Arrays.fill(tasksArray, '0');
            
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;
            char currentHandler = 'C';
            char nextHandler = 'J';
            
            for (int j = 0; j < n; j++) {
                String[] taskTime = scanner.nextLine().split("\\s");
                int start = Integer.parseInt(taskTime[0]);
                int end = Integer.parseInt(taskTime[1]);
                
                char tasker = currentHandler;
                boolean shouldSwitchHandler = false;
                int firstConflict = -1;
                
                for (int k = start; k < end; k++) {
                    if (tasksArray[k] == 'B') {
                        tasker = 'I';
                        break;
                    }
                    if (tasksArray[k] == currentHandler) {
                        tasksArray[k] = 'B';
                        if (firstConflict < 0) {
                            firstConflict = k;
                        }
                        tasker = nextHandler;
                        shouldSwitchHandler = true;
                    } else {
                        tasksArray[k] = currentHandler;
                    }
                }
                
                if (firstConflict > start) {
                    for (int l = start; l < firstConflict; l++) {
                        tasksArray[l] = nextHandler;
                    }
                }
                
                if (shouldSwitchHandler) {
                    char temp = currentHandler;
                    currentHandler = nextHandler;
                    nextHandler = temp;
                }
                
                if (tasker == 'I') {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                } else {
                    result.append(tasker);
                }
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}