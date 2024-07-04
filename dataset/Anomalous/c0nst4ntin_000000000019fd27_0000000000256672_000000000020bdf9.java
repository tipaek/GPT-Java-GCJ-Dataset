import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] tasks = new int[n][3];
            
            for (int i = 0; i < n; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
                tasks[i][2] = i;
            }
            
            tasks = sortTasksByStartTime(tasks);
            char[] result = new char[n];
            char[] persons = {'C', 'J'};
            int[] endTimes = {Integer.MAX_VALUE, Integer.MAX_VALUE};
            int firstPerson = 0, secondPerson = 1;
            
            for (int i = n - 1; i >= 0; i--) {
                boolean assigned = false;
                
                if (endTimes[firstPerson] > endTimes[secondPerson]) {
                    int temp = firstPerson;
                    firstPerson = secondPerson;
                    secondPerson = temp;
                }
                
                if (tasks[i][1] <= endTimes[firstPerson]) {
                    result[tasks[i][2]] = persons[firstPerson];
                    endTimes[firstPerson] = tasks[i][0];
                    assigned = true;
                } else if (tasks[i][1] <= endTimes[secondPerson]) {
                    result[tasks[i][2]] = persons[secondPerson];
                    endTimes[secondPerson] = tasks[i][0];
                    assigned = true;
                } else {
                    result = "IMPOSSIBLE".toCharArray();
                    break;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + new String(result));
        }
    }
    
    private static int[][] sortTasksByStartTime(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));
        return tasks;
    }
}