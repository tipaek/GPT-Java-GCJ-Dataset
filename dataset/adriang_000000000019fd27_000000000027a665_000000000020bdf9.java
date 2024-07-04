import java.util.*;
import java.io.*;
public class Solution {

   public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();
            StringBuilder tasksArray = new StringBuilder();
            for (int j = 0; j < 1441; j++) {
                tasksArray.append("0");
            }
            StringBuilder sb = new StringBuilder();

            int startDifferentHandler = -1;
            char currentHandler = 'C';
            char nextCurrentHandler = 'J';
            for (int j = 0; j < n; j++) {
                char tasker = currentHandler;
                boolean shouldChange = false;
                String line = in.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] taskTimeStamps = line.split("\\s+");
                int start = 0;
                int end = 0;
                try {
                      start = Integer.parseInt(taskTimeStamps[0]);
                      end = Integer.parseInt(taskTimeStamps[1]);
                }catch (Exception e) {
                    continue;
                }
                for (int k = start; k < end; k++) {
                    if (tasksArray.charAt(k) == 'B') {
                        tasker = 'I';
                        break;
                    }
                    if (tasksArray.charAt(k)== currentHandler) {
                        tasksArray.setCharAt(k, 'B');
                        if (startDifferentHandler < 0) {
                            startDifferentHandler = k;
                        }
                        tasker = nextCurrentHandler;
                        shouldChange = true;
                    } else {
                        tasksArray.setCharAt(k,  currentHandler);
                    }

                }
                if (startDifferentHandler > start) {
                    for (int l = start; l < startDifferentHandler; l++) {
                        tasksArray.setCharAt(l, nextCurrentHandler);
                    }
                }

                if (shouldChange) {
                    char temp = currentHandler;
                    currentHandler = nextCurrentHandler;
                    nextCurrentHandler = temp;
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