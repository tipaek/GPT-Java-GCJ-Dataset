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
            if (cEndTime <= task.get(0)) {
                result.append("C");
                cEndTime = task.get(1);
            } else if (jEndTime <= task.get(0)) {
                result.append("J");
                jEndTime = task.get(1);
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<ArrayList<Integer>> taskComparator = Comparator.comparingInt(o -> o.get(0));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numTasks = scanner.nextInt();
            ArrayList<ArrayList<Integer>> tasks = new ArrayList<>();
            ArrayList<ArrayList<Integer>> originalTasks = new ArrayList<>();

            for (int j = 0; j < numTasks; j++) {
                ArrayList<Integer> task = new ArrayList<>();
                task.add(scanner.nextInt());
                task.add(scanner.nextInt());
                tasks.add(task);
                originalTasks.add(new ArrayList<>(task));
            }

            tasks.sort(taskComparator);
            String assignment = assignTasks(tasks);
            char[] taskAssignment = new char[assignment.length()];

            if (!assignment.equals("IMPOSSIBLE")) {
                for (int j = 0; j < tasks.size(); j++) {
                    int originalIndex = originalTasks.indexOf(tasks.get(j));
                    taskAssignment[originalIndex] = assignment.charAt(j);
                }
            }

            String result = assignment.equals("IMPOSSIBLE") ? assignment : new String(taskAssignment);
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}