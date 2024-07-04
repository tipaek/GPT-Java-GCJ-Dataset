import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static List<MyTask[]> testcases = new ArrayList<>();

    public static void main(String[] args) {
        readAllTasks();

        int testcaseId = 1;

        for (MyTask[] testcase : testcases) {
            cumputeTestcase(testcase, testcaseId);
            testcaseId++;
        }
    }

    private static void cumputeTestcase(MyTask[] tasks, int testcaseId) {
        for (MyTask task1 : tasks) {
            for (MyTask task2 : tasks) {
                if (isConflicting(task1, task2)) {
                    task1.conflictingTasks.add(task2.id);
                }
            }
        }

        for (MyTask task : tasks) {
            if (task.conflictingTasks.size() > 0 && task.groupId == (-1)) {
                task.groupId = 0;

                if (!assignTasks(task.conflictingTasks, tasks, 1)) {
                    impossible(testcaseId);
                    return;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (MyTask task : tasks) {
            if (task.groupId == 0 || task.groupId == (-1)) {
                stringBuilder.append('C');
            } else {
                stringBuilder.append('J');
            }
        }

        System.out.println("Case #" + testcaseId + ": " + stringBuilder.toString());
    }

    private static boolean assignTasks(List<Integer> conflictingTaskIds, MyTask[] tasks, int groupId) {
        for (Integer conflictingTaskId : conflictingTaskIds) {
            MyTask currentTask = tasks[conflictingTaskId];

            if (currentTask.groupId == groupId) {
                continue;
            }

            if (currentTask.groupId != (-1)) {
                return false;
            }

            currentTask.groupId = groupId;

            if (!assignTasks(currentTask.conflictingTasks, tasks, groupId == 0 ? 1 : 0)) {
                return false;
            }
        }

        return true;
    }

    private static void impossible(int testcaseId) {
        System.out.println("Case #" + testcaseId + ": " + "IMPOSSIBLE");
    }

    private static boolean isConflicting(MyTask task1, MyTask task2) {
        return (task1.start > task2.start && task1.start < task2.finish) || task2.start > task1.start && task2.start < task1.finish;
    }

    public static void readAllTasks() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();

            int numberOfTestCases = Integer.parseInt(line);

            for (int testCaseId = 1; testCaseId <= numberOfTestCases; testCaseId++) {
                line = in.readLine();

                int numberOfTasks = Integer.parseInt(line);

                MyTask[] testCase = new MyTask[numberOfTasks];

                for (int taskId = 0; taskId < numberOfTasks; taskId++) {
                    MyTask task = new MyTask();
                    task.id = taskId;

                    line = in.readLine();

                    String[] fractals = line.split(" ");

                    task.start = Integer.parseInt(fractals[0]);
                    task.finish = Integer.parseInt(fractals[1]);

                    testCase[taskId] = task;
                }

                testcases.add(testCase);
            }
        } catch (IOException e) {
            System.out.println("something went wrong during reading input");
        }
    }
}

class MyTask {
    int id;
    int start;
    int finish;
    List<Integer> conflictingTasks = new ArrayList<>();
    int groupId = -1;
}
