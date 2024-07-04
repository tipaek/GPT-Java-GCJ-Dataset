import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            char[] tasksArray = new char[1441];
            StringBuilder sb = new StringBuilder();

            boolean impossible = false;

            char currentHandler = 'C';
            char nextCurrentHandler = 'J';
            char tasker = currentHandler;
            for (int j = 0; j < n; j++) {
                boolean alreadyChangedHandlers = false;
                int start = in.nextInt();
                int end = in.nextInt();
                int startDifferentHandler = -1;
                if (!impossible) {
                    for (int k = start; k < end; k++) {
                        if (tasksArray[k] == 'B') {
                            tasker = 'I';
                            break;
                        } else if (tasksArray[k] == '\u0000') {
                            tasksArray[k] = currentHandler;
                        } else if (tasksArray[k] == currentHandler) {
                            tasksArray[k] = 'B';
                            if (alreadyChangedHandlers) {
                                tasker = 'I';
                                break;
                            }
                            if (startDifferentHandler < 0) {
                                startDifferentHandler = k;
                            }
                            char temp = currentHandler;
                            currentHandler = nextCurrentHandler;
                            nextCurrentHandler = temp;
                            tasker = currentHandler;
                            alreadyChangedHandlers = true;
                        } else if (tasksArray[k] == nextCurrentHandler){
                            tasksArray[k] = 'B';
                            tasker = currentHandler;
                        }

                    }

                    if (tasker == 'I') {
                        sb = new StringBuilder("IMPOSSIBLE");
                        impossible = true;
                    } else {
                        sb.append(tasker);
                        for (int l = start; l < startDifferentHandler; l++) {
                            tasksArray[l] = tasker;
                        }
                    }
                }
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}