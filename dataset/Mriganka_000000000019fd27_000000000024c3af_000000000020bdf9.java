
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < testCases; i++) {

            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int noOfTasks = Integer.parseInt(scanner.nextLine());
            List<Task> tasks = new ArrayList<>();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < noOfTasks; j++) {
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                String taskLine = scanner.nextLine();
                String[] split = taskLine.split(" ");
                Task task = new Task(Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim()));
                tasks.add(task);
            }
            calculateTaskAssignTwo(tasks, i + 1);
        }
    }

    private static void calculateTaskAssign(List<Task> tasks, int testCase) {
        List<Task> CTasks = new ArrayList<>();
        List<Task> JTasks = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (Task t : tasks) {
            if (JTasks.isEmpty() || canAssignTask(JTasks, t)) {
                CTasks.add(t);
                builder.append("J");
            } else if (CTasks.isEmpty() || canAssignTask(CTasks, t)) {
                JTasks.add(t);
                builder.append("C");
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                return;
            }
        }
        System.out.println("Case #" + testCase + ": " + builder.toString());
    }
    
    private static void calculateTaskAssignTwo(List<Task> tasks, int testCase) {
        List<Task> CTasks = new ArrayList<>();
        List<Task> JTasks = new ArrayList<>();
        char[] res = new char[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            if (CTasks.isEmpty() || canAssignTask(CTasks, tasks.get(i))) {
                CTasks.add(tasks.get(i));
                tasks.set(i, null);
                res[i] = 'C';
            }
        }
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i) != null) {
                if (JTasks.isEmpty() || canAssignTask(JTasks, tasks.get(i))) {
                    JTasks.add(tasks.get(i));
                    tasks.set(i, null);
                    res[i] = 'J';
                }
            }
        }
        for (int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i) != null) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                return;
            }
        }
            System.out.println("Case #" + testCase + ": " + new String(res));
    }

    private static boolean canAssignTask(List<Task> existingTasks, Task newTask) {
        for (Task t : existingTasks) {
            if (t.isOverlapping(newTask)) {
                return false;
            }
        }
        return true;
    }

    static class Task {
        int startTime;
        int endTime;

        public Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public boolean isOverlapping(Task anotherTask) {
            if (anotherTask.startTime >= this.endTime) {
                return false;
            }
            if (anotherTask.endTime <= this.startTime) {
                return false;
            }
            return true;
        }

    }
    
    
    
}
