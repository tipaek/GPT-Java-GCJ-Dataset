import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] startingTimes = new int[n];
            int[] endingTimes = new int[n];
            for (int j = 0; j < n; j++) {
                startingTimes[j] = in.nextInt();
                endingTimes[j] = in.nextInt();
            }
            
            double something = (n) * (n - 1) * 0.5;
            
            int somethingTwo = (int)something;

            int[][] intersections = new int[somethingTwo][2];
            int[][] intersectionsRange = new int[somethingTwo][2];

            int intersectionCounter = 0;

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((int)Math.min(endingTimes[j], endingTimes[k]) - (int)Math.max(startingTimes[j], startingTimes[k]) > 0) {
                        intersections[intersectionCounter][0] = j;
                        intersections[intersectionCounter][1] = k;
                        intersectionsRange[intersectionCounter][0] = (int)Math.max(startingTimes[j], startingTimes[k]) + 1;
                        intersectionsRange[intersectionCounter][1] = (int)Math.min(endingTimes[j], endingTimes[k]);
                        intersectionCounter = intersectionCounter + 1;
                    }
                }
            }

            int[] time = new int[1441];
            boolean possible = true;

            for (int j = 0; j < intersectionCounter && possible; j++) {
                for (int k = intersectionsRange[j][0]; k <= intersectionsRange[j][1] && possible; k++) {
                    time[k] = time[k] + 1;
                    if (time[k] == 2) {
                        possible = false;
                    }
                }
            }
            
            if (!possible) {
                System.out.print("Case #");
                System.out.print(i + 1);
                System.out.println(": IMPOSSIBLE");
            } else {
                char[] assignments = new char[n];
                assignments[0] = 'J';

                for (int j = 0; j < intersectionCounter; j++) {
                    if (assignments[intersections[j][0]] == 'J') {
                        assignments[intersections[j][1]] = 'C';
                    } else if (assignments[intersections[j][0]] == 'C') {
                        assignments[intersections[j][1]] = 'J';
                    } 
                }

                System.out.print("Case #");
                System.out.print(i + 1);
                System.out.print(": ");
                for (int j = 0; j < n; j++) {
                    if (j == n - 1) {
                        if (assignments[j] != 'C' && assignments[j] != 'J') {
                            assignments[j] = 'J';
                        }
                        System.out.println(assignments[j]);
                    } else {
                        if (assignments[j] != 'C' && assignments[j] != 'J') {
                            assignments[j] = 'J';
                        }
                        System.out.print(assignments[j]);
                    }
                }
            }
            

        }
        in.close();
    }
}