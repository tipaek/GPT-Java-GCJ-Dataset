import java.util.*;
import java.io.*;

public class Solution {

    public class Task {
        public int start;
        public int end;
        public int code;

        public Task (int start, int end, int code) {
            this.start = start;
            this.end = end;
            this.code = code;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        List<Task> taskList = new ArrayList<>();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int code = 1;
            for (int j = 1; j <= n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                Solution g = new Solution();
                Solution.Task task = g.new Task(start,end,code);
                code++;
                taskList.add(task);
            }


            Collections.sort(taskList, Comparator.comparingInt(t2 -> t2.start));

            StringBuilder answer = new StringBuilder();
            Map<Integer,String> match = new HashMap<>();

            match.put(taskList.get(0).code,"J");
            int counter = 1;
            int endJ = taskList.get(0).end;
            int endC = 0;
            boolean impossible = false;
            while (counter < taskList.size()) {

                if (taskList.get(counter).start >= endC) {
                    match.put(taskList.get(counter).code,"C");
                    endC = taskList.get(counter).end;

                } else if (taskList.get(counter).start >= endJ) {
                    match.put(taskList.get(counter).code,"J");
                    endJ = taskList.get(counter).end;

                } else {
                    answer.replace(0,answer.length(),"IMPOSSIBLE");
                    impossible = true;
                    break;
                }
                counter++;
            }
            if (impossible) {
                String l = answer.toString();
                System.out.println("Case #" + i + ": " + l);
            } else {
                StringBuilder an = new StringBuilder();
                Collections.sort(taskList, Comparator.comparingInt(t2 -> t2.code));
                for (Task task : taskList) {
                    an.append(match.get(task.code));
                }
                System.out.println("Case #" + i + ": " + an.toString());
            }
            taskList.clear();
        }
    }
}

