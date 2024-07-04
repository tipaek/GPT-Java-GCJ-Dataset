import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int[][] masterSched = new int[1440][2];
            boolean impossible = false;
            StringBuilder answer = new StringBuilder();
            int w = in.nextInt();

            for (int j = 0; j < w; j++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                boolean cameronAvailable = true;
                boolean jamieAvailable = true;

                for (int k = startTime; k < endTime; k++) {
                    if (masterSched[k][0] == 1) {
                        cameronAvailable = false;
                    }
                }

                if (cameronAvailable) {
                    for (int k = startTime; k < endTime; k++) {
                        masterSched[k][0] = 1;
                    }
                    answer.append("C");
                } else {
                    for (int k = startTime; k < endTime; k++) {
                        if (masterSched[k][1] == 1) {
                            jamieAvailable = false;
                        }
                    }

                    if (jamieAvailable) {
                        for (int k = startTime; k < endTime; k++) {
                            masterSched[k][1] = 1;
                        }
                        answer.append("J");
                    } else {
                        impossible = true;
                    }
                }
            }

            if (impossible) {
                answer = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + i + ": " + answer);
        }
    }
}