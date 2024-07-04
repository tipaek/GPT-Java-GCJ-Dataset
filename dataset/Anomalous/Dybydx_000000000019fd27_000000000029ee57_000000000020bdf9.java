import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;
        
        while (testCases-- > 0) {
            int n = scanner.nextInt();
            List<Task> tasks = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(start, end, i));
            }
            
            Collections.sort(tasks);
            System.out.println("Case #" + caseNumber + ": " + assignTasks(tasks));
            caseNumber++;
        }
    }

    private static String assignTasks(List<Task> tasks) {
        Task cameron = new Task(0, 0, 0);
        Task jamie = new Task(0, 0, 0);
        char[] schedule = new char[tasks.size()];
        
        for (Task task : tasks) {
            if (cameron.end <= task.start) {
                schedule[task.index] = 'C';
                cameron = task;
            } else if (jamie.end <= task.start) {
                schedule[task.index] = 'J';
                jamie = task;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return new String(schedule);
    }

    private static class Task implements Comparable<Task> {
        int start;
        int end;
        int index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Task other) {
            if (this.start == other.start) {
                return Integer.compare(this.end, other.end);
            }
            return Integer.compare(this.start, other.start);
        }

        @Override
        public String toString() {
            return String.format("Start: [%d] End: [%d] Index: [%d]", start, end, index);
        }
    }
}