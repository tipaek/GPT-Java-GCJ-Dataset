import java.util.*;
import java.io.*;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            StringBuilder sb = new StringBuilder();
            boolean impossible = false;

            List<TaskHandler> taskHandlers = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();

                if (!impossible) {
                    if (taskHandlers.isEmpty()) {
                        taskHandlers.add(new TaskHandler(start, end, 'C'));
                    } else {
                        TaskHandler newTh = new TaskHandler(start, end);
                        boolean intersects = false;
                        for (TaskHandler th : taskHandlers) {
                            if (th.handler !='0' && th.intersects(start, end)) {
                                intersects = true;
                            }
                        }

                        if (!intersects) {
                            newTh.handler = 'C';
                        }



                        taskHandlers.add(newTh);

                    }


                }

            }

            if (taskHandlers.get(0).handler =='0') {
                taskHandlers.get(0).handler ='J';
            }
            for (int k = 1; k < taskHandlers.size();k++) {
                for (int l = 0; l < k; l++) {
                    if (taskHandlers.get(k).handler =='0' && (taskHandlers.get(l).handler == 'J')&& taskHandlers.get(k).intersects(taskHandlers.get(l).start,taskHandlers.get(l).end)) {
                        impossible = true;
                    }

                }
                if (!impossible && taskHandlers.get(k).handler =='0') {
                    taskHandlers.get(k).handler = 'J';
                }
            }
            if (impossible) {
                sb = new StringBuilder("IMPOSSIBLE");
            } else {
                sb = new StringBuilder();
                for (TaskHandler th : taskHandlers) {
                    sb.append(th.handler);
                }
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }

    static class TaskHandler {

        int start;
        int end;
        char handler;

        TaskHandler(int start, int end, char handler) {
            this.start = start;
            this.end = end;
            this.handler = handler;
        }

        TaskHandler(int start, int end) {
            this.start = start;
            this.end = end;
            this.handler = '0';
        }


        boolean intersects(int newStart, int newEnd) {
            if ((newStart < start && newEnd <= start) || (newStart >= end && (newEnd > end))) {
                return false;
            } else {
                return true;
            }
        }

        char getOtherHandler() {
            if (handler == 'C') {
                return 'J';
            } else {
                return 'C';
            }
        }


    }
}