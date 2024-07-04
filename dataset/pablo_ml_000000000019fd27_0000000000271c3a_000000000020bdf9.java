import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int activities[] = new int[24*60+1];

            int n = in.nextInt();
            boolean conflict = false;
            String solution = "";
            for(int j = 0; j < n; j++) {
                int startTime = in.nextInt();
                int finishTime = in.nextInt();

                boolean coincidence = false;

                for(int k = startTime+1; k <= finishTime; k++) {
                    switch (activities[k]) {
                        case 0:
                            activities[k] = 1;
                            break;
                        case 1:
                            activities[k] = 2;
                            coincidence = true;
                            break;
                        case 2:
                            conflict = true;
                            break;

                    }
                    if(conflict) break;
                }

                if(conflict) {
                    break;
                } else {
                    if(coincidence) {
                        solution += "J";
                    } else {
                        solution += "C";
                    }
                }
            }
            if(conflict) {
                System.out.println("Case #" + i + ": "  + " IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": "  + " " + solution);
            }

        }
    }
}