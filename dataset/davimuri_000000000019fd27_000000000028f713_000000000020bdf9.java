import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        Solution pp = new Solution();
        for (int i = 1; i <= testCases; i++) {
            int tasks = in.nextInt();
            List<DomesticTask>[] startToEnd = new List[1441];
            DomesticTask[] inputTasks = new DomesticTask[tasks];
            for (int t = 1; t <= tasks; t++) {
                int start = in.nextInt();
                int end = in.nextInt();
                List<DomesticTask> sameStartTasks = startToEnd[start];
                if (sameStartTasks == null) {
                    sameStartTasks = new ArrayList<>();
                }
                DomesticTask task = DomesticTask.of(start, end);
                sameStartTasks.add(task);
                startToEnd[start] = sameStartTasks;
                inputTasks[t-1] = task;
            }
            String output = pp.schedule(startToEnd, inputTasks);
            System.out.printf("Case #%d: %s%n", i, output);
        }
    }

    public String schedule(List<DomesticTask>[] startToEnd, DomesticTask[] inputTasks) {
        int jamie = -1;
        int cameron = -1;
        for (int i = 0; i < startToEnd.length; i++) {
            List<DomesticTask> ends = startToEnd[i];
            if (ends != null) {
                for (DomesticTask task: ends) {
                    if (jamie <= i) {
                        jamie = task.end;
                        task.assignee = 'J';
                    } else if (cameron <= i) {
                        cameron = task.end;
                        task.assignee = 'C';
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (DomesticTask task: inputTasks) {
            sb.append(task.assignee);
        }
        return sb.toString();
    }

    static class DomesticTask {
        int start;
        int end;
        char assignee;
        static DomesticTask of(int start, int end) {
            DomesticTask t = new DomesticTask();
            t.start = start;
            t.end = end;
            return t;
        }
    }
}
