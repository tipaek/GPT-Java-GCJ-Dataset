import java.util.*;
import java.io.*;
public class Solution {

   public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();
//            char[] tasksArray = new char[1440];
            StringBuilder sb = new StringBuilder();
//            boolean shouldChange = false;
//            int startDifferentHandler = -1;
//            char currentHandler = 'C';
//            char nextCurrentHandler = 'J';
            for (int j = 0; j < n; j++) {
//                char tasker = currentHandler;

                String line = in.nextLine();
//                String[] taskTimeStamps = line.split("\\s");
//                int start = Integer.parseInt(taskTimeStamps[0]);
//                int end = Integer.parseInt(taskTimeStamps[1]);
//                for (int k = start; k < end; k++) {
//                    if (tasksArray[k] == 'B') {
//                        tasker = 'I';
//                        break;
//                    }
//                    if (tasksArray[k] == currentHandler) {
//                        tasksArray[k] = 'B';
//                        if (startDifferentHandler < 0) {
//                            startDifferentHandler = k;
//                        }
//                        tasker = nextCurrentHandler;
//                        shouldChange = true;
//                    } else {
//                        tasksArray[k] = currentHandler;
//                    }
//
//                }
//
//                for (int l = start; l < startDifferentHandler; l++) {
//                    tasksArray[l] = nextCurrentHandler;
//                }
//
//                if (shouldChange) {
//                    char temp = currentHandler;
//                    currentHandler = nextCurrentHandler;
//                    nextCurrentHandler = temp;
//                }
//                if (tasker == 'I') {
//                    sb = new StringBuilder("IMPOSSIBLE");
//                    break;
//                } else {
//                    sb.append(tasker);
//                }
            }
            System.out.println("Case #" + i + ": CC" );
        }
    }
}