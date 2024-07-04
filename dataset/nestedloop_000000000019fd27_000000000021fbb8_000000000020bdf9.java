import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int t = 1; t <= test; ++t) {
            int n = in.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            char[] job = new char[n];

            for (int i = 0; i < n; i++) {
                start[i] = in.nextInt();
                end[i] = in.nextInt();
                job[i] = 'N';
            }

            int available = 0;
            int endOfDay = 24 * 60;
            // assign cameron
            while (available < endOfDay) {
                int min = endOfDay;
                int minInd = -1;
                for (int j = 0; j < n; j++) {
                    if ((job[j] == 'N') && (start[j] < min) && (available <= start[j])) {
                        min = start[j];
                        minInd = j;
                    }
                }
                if (minInd != -1) {
                    job[minInd] = 'C';
                    available = end[minInd];
                }
                else{
                    available = endOfDay;
                }
            }
            //assign jamie
            available = 0;
            while (available < endOfDay) {
                int min = endOfDay;
                int minInd = -1;
                for (int j = 0; j < n; j++) {
                    if ((job[j] == 'N') && (start[j] < min) && (available <= start[j])) {
                        min = start[j];
                        minInd = j;
                    }
                }
                if (minInd != -1) {
                    job[minInd] = 'J';
                    available = end[minInd];
                }
                else{
                    available = endOfDay;
                }
            }
            //check if all done
            boolean done = true;
            for (int i = 0; i < n; i++) {
                if (job[i] == 'N') {
                    done = false;
                    break;
                }
            }
            //output
            if (done) {
                String result = new String(job);
                System.out.println("Case #" + t + ": " + result);
            } else {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            }

        }
    }
}