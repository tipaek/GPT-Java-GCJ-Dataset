import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] tasks = new int[n][2];
            
            for (int j = 0; j < n; j++) {
                tasks[j][0] = in.nextInt();
                tasks[j][1] = in.nextInt();
            }
            
            String schedule = getPossibleSchedule(tasks);
            System.out.println("Case #" + i + ": " + schedule);
        }
    }
    
    private static String getPossibleSchedule(int[][] tasks) {
        Set<Task> taskSet = new HashSet<>();
        List<Task> sortedTasks = new ArrayList<>();
        
        int id = 0;
        for (int i = 0; i < tasks.length; i++) {
            Task t = new Task(tasks[i][0], tasks[i][1], id++);
            sortedTasks.add(t);
            
            for (Task o : taskSet) {
                if (conflicts(t, o)) {
                    o.conns.add(t);
                    t.conns.add(o);
                    o.degree++;
                    t.degree++;
                }
            }
            
            taskSet.add(t);
        }
        
        Set<Task> unlabeled = new HashSet<>(taskSet);
        Queue<Task> taskQ = new ArrayDeque<>();
        Queue<Boolean> assignQ = new ArrayDeque<>();
        boolean jTask = true;
        
        while (!unlabeled.isEmpty()) {
            Task start = getMostConflicted(unlabeled);
            taskQ.add(start);
            assignQ.add(jTask);
            
            while (!taskQ.isEmpty()) {
                start = taskQ.poll();
                jTask = assignQ.poll();
                
                start.label = jTask ? 'J' : 'C';
                unlabeled.remove(start);
                
                for (Task t : start.conns) {
                    if (t.label != 'x' && start.label == t.label) {
                        return "IMPOSSIBLE";
                    } else if (unlabeled.contains(t)) {
                        unlabeled.remove(t);
                        taskQ.add(t);
                        assignQ.add(!jTask);
                    }
                }
            }
        }
        
        return getScheduleFromTasks(sortedTasks);
    }
    
    private static String getScheduleFromTasks(List<Task> tasks) {
        StringBuilder schedule = new StringBuilder();
        for (Task t : tasks) {
            schedule.append(t.label);
        }
        return schedule.toString();
    }
    
    private static Task getMostConflicted(Set<Task> tasks) {
        int max = -1;
        Task mostConflicted = null;
        for (Task t : tasks) {
            if (t.degree > max) {
                max = t.degree;
                mostConflicted = t;
            }
        }
        return mostConflicted;
    }
    
    private static boolean conflicts(Task a, Task b) {
        return (a.start >= b.start && a.start < b.end) || (b.start >= a.start && b.start < a.end);
    }
    
    static class Task {
        int degree;
        int start;
        int end;
        Set<Task> conns;
        char label;
        int id;
        
        public Task(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.degree = 0;
            this.conns = new HashSet<>();
            this.id = id;
            this.label = 'x';
        }
        
        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }
}