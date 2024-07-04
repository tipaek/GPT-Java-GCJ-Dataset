import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static class TaskHandler {

        private char currentHandler;
        private char nextHandler;

        TaskHandler() {
            this.currentHandler = 'C';
            this.nextHandler = 'J';
        }

        public char getCurrentHandler() {
            return currentHandler;
        }

        public char getNextHandler() {
            return nextHandler;
        }

        public void swapHandlers() {
            char temp = this.currentHandler;
            this.currentHandler = this.nextHandler;
            this.nextHandler = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int numTasks = scanner.nextInt();
            scanner.nextLine();

            char[] schedule = new char[1460];
            StringBuilder result = new StringBuilder();
            TaskHandler taskHandler = new TaskHandler();
            boolean needSwap = false;
            int firstConflictIndex = -1;

            for (int j = 0; j < numTasks; j++) {
                char currentTasker = taskHandler.getCurrentHandler();
                String[] timeStamps = scanner.nextLine().split("\\s");
                int start = Integer.parseInt(timeStamps[0]);
                int end = Integer.parseInt(timeStamps[1]);

                for (int k = start; k < end; k++) {
                    if (schedule[k] == 'B') {
                        currentTasker = 'I';
                        break;
                    }
                    if (schedule[k] == taskHandler.getCurrentHandler()) {
                        schedule[k] = 'B';
                        if (firstConflictIndex < 0) {
                            firstConflictIndex = k;
                        }
                        currentTasker = taskHandler.getNextHandler();
                        needSwap = true;
                    } else {
                        schedule[k] = taskHandler.getCurrentHandler();
                    }
                }

                for (int l = start; l < firstConflictIndex; l++) {
                    schedule[l] = taskHandler.getNextHandler();
                }

                if (needSwap) {
                    taskHandler.swapHandlers();
                }

                if (currentTasker == 'I') {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                } else {
                    result.append(currentTasker);
                }
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}