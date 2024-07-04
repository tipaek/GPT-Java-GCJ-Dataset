import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            Boolean possible = true;
            int n = in.nextInt();
            int end_c = 0;
            int end_j = 0;

            int iterator_index = -1;

            int[][] tasks = new int[n][2];

            for (int j = 0; j < n; j++) {

                tasks[j][0] = in.nextInt();
                tasks[j][1] = in.nextInt();
            }

            char[] assignments = new char[n];

            for (int m = 0; m < n; m++){
                int iterator_start_time = 2000;
                iterator_index = -1;
                for ( int o = 0; o < n; o++){


                    if(tasks[o][0] < iterator_start_time) {
                        iterator_start_time = tasks[o][0];
                        iterator_index = o;
                    }
                }
                if(end_c <= tasks[iterator_index][0]) {
                    assignments[iterator_index] = 'C';
                    end_c = tasks[iterator_index][1];
                    tasks[iterator_index][0] = 5000;
                    tasks[iterator_index][1] = 5000;
                }
                else if(end_j <= tasks[iterator_index][0]) {
                    assignments[iterator_index] = 'J';
                    end_j = tasks[iterator_index][1];
                    tasks[iterator_index][0] = 5000;
                    tasks[iterator_index][1] = 5000;
                }
                else {
                    possible = false;
                }
            }












            String result;
            StringBuilder sb = new StringBuilder();
            if (possible == true) {
                for (int z = 0; z < tasks.length; z++ ) {
                    sb.append(assignments[z]);
                }
                result = sb.toString();
            }
            else
                result = "IMPOSSIBLE";


            System.out.println("Case #" + i + ": " + result);
        }
    }


}

