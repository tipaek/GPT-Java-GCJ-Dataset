import java.util.*;
import java.io.*;
public class Solution {

    static class TaskHandler {

        char currentHandler;
        char nextCurrentHandler;

        TaskHandler() {
            this.currentHandler = 'C';
            this.nextCurrentHandler = 'J';
        }

        public char getCurrentHandler() {
            return currentHandler;
        }

        public char getNextCurrentHandler() {
            return nextCurrentHandler;
        }

        public void swapTaskHandlers() {
            char temp = this.currentHandler;
            this.currentHandler = this.nextCurrentHandler;
            this.nextCurrentHandler = temp;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();
            char[] tasksArray = new char[1460];
            StringBuilder sb = new StringBuilder();
            TaskHandler taskHandler = new TaskHandler();
            boolean shouldChange = false;
            int startDifferentHandler = -1;
            for (int j = 0; j < n; j++) {
                char tasker = taskHandler.getCurrentHandler();

                String line = in.nextLine();
                String[] taskTimeStamps = line.split("\\s");
                int start = Integer.parseInt(taskTimeStamps[0]);
                int end = Integer.parseInt(taskTimeStamps[1]);
                for (int k = start; k < end; k++) {
                    if (tasksArray[k] == 'B') {
                        tasker = 'I';
                        break;
                    }
                    if (tasksArray[k] == taskHandler.currentHandler) {
                        tasksArray[k] = 'B';
                        if (startDifferentHandler < 0) {
                            startDifferentHandler = k;
                        }
                        tasker = taskHandler.nextCurrentHandler;
                        shouldChange = true;
                    } else {
                        tasksArray[k] = taskHandler.currentHandler;
                    }

                }

                for (int l = start; l < startDifferentHandler; l++) {
                    tasksArray[l] = taskHandler.nextCurrentHandler;
                }

                if (shouldChange) {
                    taskHandler.swapTaskHandlers();
                }
                if (tasker == 'I') {
                    sb = new StringBuilder("IMPOSSIBLE");
                    break;
                } else {
                    sb.append(tasker);
                }
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}