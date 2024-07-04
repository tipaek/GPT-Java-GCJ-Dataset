import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] tasks = new int[n][3];
            
            for (int i = 0; i < n; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
                tasks[i][2] = i;
            }
            
            String result = assignTasks(tasks, n);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String assignTasks(int[][] tasks, int n) {
        char[] workers = {'C', 'J'};
        char[] assignment = new char[n];
        Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));
        
        int[] availableTime = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        
        for (int i = n - 1; i >= 0; i--) {
            boolean assigned = false;
            int firstWorker = 0, secondWorker = 1;
            
            if (availableTime[firstWorker] > availableTime[secondWorker]) {
                firstWorker = 1;
                secondWorker = 0;
            }
            
            if (tasks[i][1] <= availableTime[firstWorker]) {
                assigned = true;
                assignment[tasks[i][2]] = workers[firstWorker];
                availableTime[firstWorker] = tasks[i][0];
            }
            
            if (!assigned && tasks[i][1] <= availableTime[secondWorker]) {
                assigned = true;
                assignment[tasks[i][2]] = workers[secondWorker];
                availableTime[secondWorker] = tasks[i][0];
            }
            
            if (!assigned) {
                return "IMPOSSIBLE";
            }
        }
        
        return new String(assignment);
    }
}