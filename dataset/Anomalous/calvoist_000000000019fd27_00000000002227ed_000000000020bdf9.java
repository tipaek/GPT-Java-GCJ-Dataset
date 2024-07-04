import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            StringBuilder finalAnswer = new StringBuilder();
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            List<int[]> cameron = new ArrayList<>();
            List<int[]> james = new ArrayList<>();

            cameron.add(new int[]{intervals[0][0], intervals[0][1]});
            finalAnswer.append("C");

            boolean conflictFound;

            for (int j = 1; j < n; j++) {
                conflictFound = false;

                for (int[] interval : cameron) {
                    if ((intervals[j][0] < interval[1] && intervals[j][1] > interval[0])) {
                        conflictFound = true;
                        break;
                    }
                }

                if (!conflictFound) {
                    finalAnswer.append("C");
                    cameron.add(new int[]{intervals[j][0], intervals[j][1]});
                } else {
                    conflictFound = false;

                    for (int[] interval : james) {
                        if ((intervals[j][0] < interval[1] && intervals[j][1] > interval[0])) {
                            conflictFound = true;
                            break;
                        }
                    }

                    if (!conflictFound) {
                        james.add(new int[]{intervals[j][0], intervals[j][1]});
                        finalAnswer.append("J");
                    } else {
                        finalAnswer = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + finalAnswer);
        }
    }
}