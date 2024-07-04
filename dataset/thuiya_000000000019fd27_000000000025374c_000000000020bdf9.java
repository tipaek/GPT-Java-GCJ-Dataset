import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            int []cBusy = new int[1441];
            int []jBusy = new int[1441];

            int nTasks = Integer.parseInt(in.nextLine());
            String []tasks = new String[nTasks];
            for (int j = 0; j < nTasks; j++) {
                tasks[j] = in.nextLine();
            }
            for (int j = 0; j < nTasks; j++) {
                String[] vals = tasks[j].split(" ");
                int start = Integer.parseInt(vals[0]);
                int end = Integer.parseInt(vals[1]);

                int cSum = 0;
                int jSum = 0;
                for (int k = start; k < end + 1; k++) {
                    cSum += cBusy[k];
                    jSum += jBusy[k];
                }
                if (cSum == 0 || cSum - cBusy[start] == 0 || cSum - cBusy[end+1] == 0){
                    stringBuilder.append('C');
                    for (int k = start; k < end + 1; k++) {
                        cBusy[k] += 1;
                    }
                } else if (jSum == 0 || jSum - jBusy[start] == 0 || jSum - jBusy[end+1] == 0){
                    stringBuilder.append('J');
                    for (int k = start; k < end + 1; k++) {
                        jBusy[k] += 1;
                    }
                } else {
                    stringBuilder = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + stringBuilder.toString());
        }
    }
}