import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            List<Integer> cameronStart = new ArrayList<>();
            List<Integer> cameronEnd = new ArrayList<>();
            List<Integer> jamesStart = new ArrayList<>();
            List<Integer> jamesEnd = new ArrayList<>();

            cameronStart.add(intervals[0][0]);
            cameronEnd.add(intervals[0][1]);
            StringBuilder finalAnswer = new StringBuilder("C");
            boolean conflict;

            for (int i = 1; i < n; i++) {
                conflict = false;

                for (int j = 0; j < cameronStart.size(); j++) {
                    if ((intervals[i][0] < cameronEnd.get(j) && intervals[i][1] > cameronStart.get(j))) {
                        conflict = true;
                        break;
                    }
                }

                if (!conflict) {
                    cameronStart.add(intervals[i][0]);
                    cameronEnd.add(intervals[i][1]);
                    finalAnswer.append("C");
                } else {
                    conflict = false;

                    for (int j = 0; j < jamesStart.size(); j++) {
                        if ((intervals[i][0] < jamesEnd.get(j) && intervals[i][1] > jamesStart.get(j))) {
                            conflict = true;
                            break;
                        }
                    }

                    if (!conflict) {
                        jamesStart.add(intervals[i][0]);
                        jamesEnd.add(intervals[i][1]);
                        finalAnswer.append("J");
                    } else {
                        finalAnswer = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + finalAnswer);
        }
    }
}