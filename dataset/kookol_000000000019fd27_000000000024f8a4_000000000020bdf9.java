import java.util.*;
import java.io.*;

public class Solution {

    public class Task {
        public int start;
        public int end;

        public Task (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        List<Task> taskList = new ArrayList<>();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                Solution g = new Solution();
                Solution.Task task = g.new Task(in.nextInt(),in.nextInt());
                taskList.add(task);
            }
            Collections.sort(taskList, Comparator.comparingInt(t2 -> t2.start));
            StringBuilder answer = new StringBuilder("J");

            int counter = 1;
            //startJ = taskList.get(0).start,startC = 0
            int endJ = taskList.get(0).end, endC = 0;
            while (counter < taskList.size()) {
                if (taskList.get(counter).start >= endJ) {
                    answer.append('J');
                    endJ = taskList.get(counter).end;
                } else if (taskList.get(counter).start >= endC) {
                    answer.append('C');
                    endC = taskList.get(counter).end;
                } else {
                    answer.replace(0,answer.length(),"IMPOSSIBLE");
                    break;
                }
                counter++;
            }
            System.out.println("Case #" + i + ": " + answer );
            taskList.clear();
        }
    }
}