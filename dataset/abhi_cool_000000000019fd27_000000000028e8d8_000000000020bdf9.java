import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Abhishek Boharpi on 4/4/2020.
 */
public class Solution {

    private static int noOfTestCases = 0;
    private static List<Integer> listOfTasks = new ArrayList<>();
    private static List<List<Task>> tasksList = new ArrayList<>();

    public static void main(String[] args) {

        Solution parentingPartnering = new Solution();

        parentingPartnering.readInput();

//        System.out.println(noOfTestCases);
//        System.out.println(listOfTasks);
//        System.out.println(tasksList);

        List<Task> cTasks = new ArrayList<>();
        List<Task> jTasks = new ArrayList<>();

        for (int i = 0; i < noOfTestCases; i++) {

//            int taskCount = listOfTasks.get(i);

            String output = "";

            cTasks.clear();
            jTasks.clear();

            List<Task> tasks = tasksList.get(i);

            for (Task task : tasks) {

                boolean isCFree = assignTask(task, cTasks);

                if (!isCFree) {

                    boolean isJFree = assignTask(task, jTasks);

                    if (!isJFree) {
                        output = "IMPOSSIBLE";
                        break;
                    } else {
                        output += "J";
                    }

                } else {
                    output += "C";
                }
            }

            System.out.printf("Case #%d: %s", i + 1, output);
            System.out.println();
        }

    }

    private static boolean assignTask(Task task, List<Task> tasks) {

        boolean isAvailable = true;

        for (Task task1 : tasks) {

            if ((task.end < task1.end && task.end > task1.start)
                    || (task.start < task1.end && task.start > task1.start)
                    || (task.end == task1.end && task.start == task1.start)
                    || (task.end == task1.end && task.start < task1.start)
                    || (task.end > task1.end && task.start == task1.start)) {

                isAvailable = false;
                break;
            }
        }

        if (isAvailable) {
            tasks.add(task);
        }

        return isAvailable;
    }

    private class Task implements Comparable<Task> {

        int start;
        int end;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Task o) {
            return (o.end - o.start) - (this.end - this.start);
        }
    }

    private void readInput() {

        Scanner scanner = new Scanner(System.in);

        noOfTestCases = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < noOfTestCases; i++) {

            int n = Integer.valueOf(scanner.nextLine());

            listOfTasks.add(n);

            List<Task> tasks = new ArrayList<>(n);

            for (int j = 0; j < n; j++) {

                String input = scanner.nextLine();

                String[] strArr = input.split(" ");

                int start = Integer.valueOf(strArr[0]);
                int end = Integer.valueOf(strArr[1]);

                Task task = new Task(start, end);
                tasks.add(task);
            }

//            Collections.sort(tasks);
            tasksList.add(tasks);
        }
    }


}
