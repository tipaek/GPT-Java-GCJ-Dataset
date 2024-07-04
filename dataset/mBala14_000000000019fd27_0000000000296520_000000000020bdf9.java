import java.util.*;
import java.io.*;
public class Solution {

    static class Task implements Comparable<Task> {
        int start;
        int end;
        int index;

        Task (int s, int e, int i) {
            this.start = s ;
            this.end = e;
            this.index = i;
        }


        @Override
        public int compareTo(Task o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int tasks = in.nextInt();
            String result = "";
            List<Task> taskList = new ArrayList<>();
            List<Task> jTasks = new ArrayList<>();
            List<Task> cTasks = new ArrayList<>();
            char [] order = new char[tasks];
            for(int j = 0; j < tasks; j++){
                int start = in.nextInt();
                int end = in.nextInt();
                taskList.add(new Task(start, end, j));
            }
            Collections.sort(taskList);
            boolean canJ = true;
            boolean canC = true;
            order[taskList.get(0).index] = 'J';
            for(int x = 0; x < taskList.size(); x++){
                if( jTasks.size() == 0){
                    order[taskList.get(x).index] = 'J';
                    jTasks.add(taskList.get(x));
                    canC = true;
                }
                else if ( canJ && taskList.get(x).start >= jTasks.get(jTasks.size()-1).end ) {
                    order[taskList.get(x).index] = 'J';
                    jTasks.add(taskList.get(x));
                    canC = true;
                } else {
                    canJ = false;
                }
                if( !canJ ){
                    if ( cTasks.size() == 0 ){
                        order[taskList.get(x).index] = 'C';
                        cTasks.add(taskList.get(x));
                        canJ = true;
                    } else if ( canC && taskList.get(x).start >= cTasks.get(cTasks.size()-1).end ) {
                        order[taskList.get(x).index] = 'C';
                        cTasks.add(taskList.get(x));
                        canJ = true;
                    } else {
                        canC = false;
                    }
                }
                if ( !canJ && !canC ){
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                result = new String(order);
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}