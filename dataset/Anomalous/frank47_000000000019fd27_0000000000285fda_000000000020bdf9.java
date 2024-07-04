import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int testcase = 1; testcase <= t; testcase++) {
            int n = sc.nextInt();
            char[] parentString = new char[n];
            Set<Task> cameronTasks = new HashSet<>();
            Set<Task> lanisterTasks = new HashSet<>();
            boolean impossible = false;
            Map<Task, String> taskMap = new HashMap<>();
            List<Task> taskList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                Task task = new Task(start, end);
                taskMap.put(task, String.valueOf(i));
                int pos = findPosition(taskList, task);
                if (pos == -1) {
                    taskList.add(task);
                } else {
                    taskList.add(pos, task);
                }
            }

            for (Task task : taskList) {
                if (!isBusy(cameronTasks, task)) {
                    cameronTasks.add(task);
                    taskMap.put(task, taskMap.get(task) + "C");
                } else if (!isBusy(lanisterTasks, task)) {
                    lanisterTasks.add(task);
                    taskMap.put(task, taskMap.get(task) + "J");
                } else {
                    System.out.println("Case #" + testcase + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                preparePrintString(taskMap, parentString, testcase);
            }
        }

        sc.close();
    }

    private static void preparePrintString(Map<Task, String> taskMap, char[] parentString, int testcase) {
        for (String value : taskMap.values()) {
            parentString[Integer.parseInt(String.valueOf(value.charAt(0)))] = value.charAt(1);
        }
        System.out.println("Case #" + testcase + ": " + String.valueOf(parentString));
    }

    private static int findPosition(List<Task> taskList, Task task) {
        if (taskList.isEmpty()) {
            return 0;
        }

        int start = task.getStart();
        int end = task.getEnd();

        for (int i = 0; i < taskList.size(); i++) {
            Task current = taskList.get(i);
            if (start < current.getStart() || (start == current.getStart() && end <= current.getEnd())) {
                return i;
            }
        }

        return -1;
    }

    private static boolean isBusy(Set<Task> taskSet, Task task) {
        for (Task existingTask : taskSet) {
            if (task.overlapsWith(existingTask)) {
                return true;
            }
        }
        return false;
    }

    public static class Task {
        private final int start;
        private final int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public boolean overlapsWith(Task other) {
            return !(this.end <= other.start || this.start >= other.end);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
            return start == task.start && end == task.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}