import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int activities[] = new int[24*60];

            int n = in.nextInt();
            boolean conflict = false;
            String solution = "";
            for(int j = 0; j < n; j++) {
                int startTime = in.nextInt();
                int finishTime = in.nextInt();

                boolean coincidence = false;
                int occupied[] = new int[2];
                for(int k = startTime; k < finishTime; k++) {
                    switch (activities[k]) {
                        case 0:
                            activities[k] = 1;
                            break;
                        case 1:
                            occupied[0] = 1;
                            activities[k] = 3;
                            coincidence = true;
                            break;
                        case 2:
                            occupied[1] = 1;
                            activities[k] = 3;
                            coincidence = true;
                            break;
                        case 3:
                            conflict = true;
                            break;

                    }
                    if(conflict) break;
                }

                if(conflict) {
                    break;
                } /*else {
                    if(coincidence) {
                        if(occupied[0] == 1) {
                            for(int k = startTime; k < finishTime; k++) {
                                if(activities[k] == 1) {
                                    activities[k] = 2;
                                }
                            }
                            solution += "J";
                        } else {
                            solution += "C";
                        }
                    } else {
                        solution += "C";
                    }
                }*/
            }
            if(conflict) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ":"  + " " + solution);
            }

        }
    }
}