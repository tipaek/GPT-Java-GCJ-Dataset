import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // number of test
        int n_test = in.nextInt();
        in.nextLine(); // just move to next line

        String out = "";

        for (int i = 0; i < n_test; i++) {

            int N = in.nextInt();   // number of activity
            in.nextLine(); // just move to next line

            int[][] time = new int[N][2];
            out = "";

            for (int j = 0; j < N; j++) {
                time[j][0] = in.nextInt();  // start
                time[j][1] = in.nextInt();  // end
                time[j][1]--;
                in.nextLine(); // just move to next line
            }

//            // TEST: start / end time
//            for (int j = 0; j < N; j++) {
//                System.out.println(time[j][0] + " " + time[j][1]);
//            }

            // setup time table
            int[] clock = new int[1441];

            for (int j = 0; j < N; j++) {
                for (int k = time[j][0]; k <= time[j][1]; k++) {
                    clock[k] += 1;
                }
            }

            // check validity
            boolean bImpossible = false;
            for (int j = 0; j < 1440; j++) {
                if (clock[j] > 2) {
                    // OUTPUT
                    bImpossible = true;
                }
            }

            // prepare only start time (for easy sorting)
            int[] start_time = new int[N];

            for (int j = 0; j < N; j++) {
                start_time[j] = time[j][0];
            }
            Arrays.sort(start_time);


            boolean[] parent = new boolean[2];
            parent[0] = true;   // C
            parent[1] = true;   // J

            if (bImpossible) {
                out = "IMPOSSIBLE";
            } else {

                for (int j = 0; j < N; j++) {

//                    if (clock[time[j][0]] == 1) {
                    if (clock[start_time[j]] == 1) {

                        if (out.equals("")) {
                            out += "C";
                        } else {
                            if (out.charAt(out.length()-1) == 'C')
                                out += "J";
                            else
                                out += "C";
                        }
                    } else { // it should be two

                        if (out.equals("")) {
                            out += "C";
                        } else {
                            if (out.charAt(out.length()-1) == 'C')
                                out += "J";
                            else
                                out += "C";
                        }
                    }
                }
            }
            // OUTPUT
            System.out.println("Case #" + (i+1) +": " + out);
        }


    }
}
