import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static String assignTasks(ArrayList<ArrayList<Integer>> tasks) {
        StringBuilder result = new StringBuilder();
        int cEndTime = 0;
        int jEndTime = 0;
        
        for (ArrayList<Integer> task : tasks) {
            int start = task.get(0);
            int end = task.get(1);
            
            if (jEndTime <= start) {
                result.append("J");
                jEndTime = end;
            } else if (cEndTime <= start) {
                result.append("C");
                cEndTime = end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int numTasks = scanner.nextInt();
            ArrayList<ArrayList<Integer>> tasks = new ArrayList<>();
            
            for (int j = 0; j < numTasks; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                ArrayList<Integer> task = new ArrayList<>();
                task.add(start);
                task.add(end);
                tasks.add(task);
            }
            
            tasks.sort(Comparator.comparingInt(o -> o.get(0)));
            String result = assignTasks(tasks);
            System.out.println("Case #" + t + ": " + result);
        }
        
        scanner.close();
    }
}