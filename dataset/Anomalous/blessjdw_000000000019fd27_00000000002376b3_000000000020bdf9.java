import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int[] cameronTasks = new int[60 * 24];
            int[] jamieTasks = new int[60 * 24];
            int numTasks = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            
            for (int n = 1; n <= numTasks; n++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (result.length() > 0) continue;
                
                if (isAvailable(cameronTasks, start, end)) {
                    assignTask(cameronTasks, start, end, n);
                } else if (isAvailable(jamieTasks, start, end)) {
                    assignTask(jamieTasks, start, end, n);
                } else {
                    result.append("IMPOSSIBLE");
                }
            }
            
            if (result.length() == 0) {
                Set<Integer> cameronSet = new HashSet<>();
                Set<Integer> jamieSet = new HashSet<>();
                
                for (int num : cameronTasks) cameronSet.add(num);
                for (int num : jamieTasks) jamieSet.add(num);
                
                if (cameronSet.size() + jamieSet.size() != numTasks + 1) throw new RuntimeException();
                
                for (int i = 1; i <= numTasks; i++) {
                    if (cameronSet.contains(i)) result.append("C");
                    if (jamieSet.contains(i)) result.append("J");
                }
                
                if (result.length() != numTasks) throw new RuntimeException();
            }
            
            System.out.println("Case #" + t + ": " + result.toString());
        }
    }

    private static boolean isAvailable(int[] tasks, int start, int end) {
        for (int i = start; i < end; i++) {
            if (tasks[i] > 0) return false;
        }
        return true;
    }

    private static void assignTask(int[] tasks, int start, int end, int taskNumber) {
        for (int i = start; i < end; i++) {
            tasks[i] = taskNumber;
        }
    }
}