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
            for (int j = 1; j <= n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                Solution g = new Solution();
                Solution.Task task = g.new Task(start,end);
                taskList.add(task);
            }
            ArrayList<Task> last = new ArrayList<>();
            last.addAll(taskList);
            Collections.sort(taskList, Comparator.comparingInt(t2 -> t2.start));
            StringBuilder answer = new StringBuilder();
            Map<Integer,String> match = new HashMap<>();
            match.put(taskList.get(0).start,"J");
            int counter = 1;
            int endJ = taskList.get(0).end;
            int endC = 0;
            while (counter < taskList.size()) {

                if (taskList.get(counter).start >= endC) {
                    match.put(taskList.get(counter).start,"C");
                    endC = taskList.get(counter).end;

                } else if (taskList.get(counter).start >= endJ) {
                    match.put(taskList.get(counter).start,"J");
                    endJ = taskList.get(counter).end;

                } else {
                    answer.replace(0,answer.length(),"IMPOSSIBLE");
                    break;
                }
                counter++;
            }
            StringBuilder an = new StringBuilder();
            for(Task task : last) {
                an.append(match.get(task.start));
            }

            String l = answer.toString();
            if(l.length() == 10) {
                System.out.println("Case #" + i + ": " + l);
            } else {
                System.out.println("Case #" + i + ": " + an.toString());
            }
            taskList.clear();
        }
    }
}