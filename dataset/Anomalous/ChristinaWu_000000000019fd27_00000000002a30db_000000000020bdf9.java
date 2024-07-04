import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                tasks[i] = new Task(i, scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(tasks);

            LinkedList<Integer> cameronTasks = new LinkedList<>();
            LinkedList<Integer> jamieTasks = new LinkedList<>();
            cameronTasks.add(0);

            boolean isImpossible = false;

            for (int i = 1; i < n; i++) {
                if (tasks[i].startTime >= tasks[cameronTasks.getLast()].endTime) {
                    cameronTasks.add(i);
                } else if (jamieTasks.isEmpty() || tasks[i].startTime >= tasks[jamieTasks.getLast()].endTime) {
                    jamieTasks.add(i);
                } else {
                    isImpossible = true;
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    break;
                }
            }

            if (isImpossible) {
                continue;
            }

            char[] result = new char[n];
            for (int taskIndex : cameronTasks) {
                result[tasks[taskIndex].index] = 'C';
            }
            for (int taskIndex : jamieTasks) {
                result[tasks[taskIndex].index] = 'J';
            }

            System.out.println("Case #" + caseNumber + ": " + new String(result));
        }
    }

    static class Task implements Comparable<Task> {
        int index, startTime, endTime;

        Task(int index, int startTime, int endTime) {
            this.index = index;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Task other) {
            if (this.startTime != other.startTime) {
                return Integer.compare(this.startTime, other.startTime);
            }
            return Integer.compare(this.endTime, other.endTime);
        }
    }
}