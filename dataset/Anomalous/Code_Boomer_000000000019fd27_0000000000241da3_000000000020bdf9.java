import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static String assignTasks(ArrayList<ArrayList<Integer>> tasks) {
        StringBuilder result = new StringBuilder();
        int endJ = 0, endC = 0;

        for (ArrayList<Integer> task : tasks) {
            int start = task.get(0);
            int end = task.get(1);

            if (start >= endJ) {
                result.append('J');
                endJ = end;
            } else if (start >= endC) {
                result.append('C');
                endC = end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<ArrayList<Integer>> compareByStart = Comparator.comparingInt(o -> o.get(0));
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

            tasks.sort(compareByStart);
            String assignedTasks = assignTasks(tasks);
            char[] resultArray = new char[assignedTasks.length()];

            if (!assignedTasks.equals("IMPOSSIBLE")) {
                for (int j = 0; j < tasks.size(); j++) {
                    int originalIndex = originalTasks.indexOf(tasks.get(j));
                    resultArray[originalIndex] = assignedTasks.charAt(j);
                }
            }

            String result = assignedTasks.equals("IMPOSSIBLE") ? assignedTasks : new String(resultArray);
            System.out.println("Case #" + (t + 1) + ": " + result);
        }

        scanner.close();
    }
}