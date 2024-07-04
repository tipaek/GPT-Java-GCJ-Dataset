import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner inp = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = inp.nextInt();  // Number of test cases

        for (int i = 0; i < t; i++) {
            boolean overlapping = false;
            int N = inp.nextInt(); // Number of events
            char[] alloc = new char[N];
            int[][] events = new int[N][2]; // Array to store timings of events

            for (int j = 0; j < N; j++) {
                events[j][0] = inp.nextInt();
                events[j][1] = inp.nextInt();
            }

            // Variables to keep track of the schedules
            int c_end = 0;
            int j_end = 0;

            for (int j = 0; j < N; j++) {
                if (overlapping) {
                    break;
                }

                if (j == 0) {
                    alloc[j] = 'C';
                    c_end = events[j][1];
                } else if (j == 1) {
                    if (events[j][0] >= events[j - 1][1]) {
                        alloc[j] = 'C';
                        c_end = events[j][1];
                    } else {
                        alloc[j] = 'J';
                        j_end = events[j][1];
                    }
                } else {
                    if (alloc[j - 1] == 'C') {
                        if (events[j][0] >= events[j - 1][1]) {
                            alloc[j] = 'C';
                            c_end = events[j][1];
                        } else if (events[j][0] >= j_end) {
                            alloc[j] = 'J';
                            j_end = events[j][1];
                        } else {
                            overlapping = true;
                        }
                    } else {
                        if (events[j][0] >= events[j - 1][1]) {
                            alloc[j] = 'J';
                            j_end = events[j][1];
                        } else if (events[j][0] >= c_end) {
                            alloc[j] = 'C';
                            c_end = events[j][1];
                        } else {
                            overlapping = true;
                        }
                    }
                }
            }

            String result = new String(alloc);
            if (!overlapping) {
                System.out.println("Case #" + (i + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}