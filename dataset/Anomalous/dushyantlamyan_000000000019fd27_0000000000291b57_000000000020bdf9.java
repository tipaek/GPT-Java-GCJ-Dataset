import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int countN = scanner.nextInt();
            int[][] intervals = new int[countN][2];
            boolean isCurrentC = true;
            int cHighest = 0, jHighest = 0;
            int cLowest = 0, jLowest = 0;
            StringBuilder output = new StringBuilder();
            boolean isPossible = true;

            for (int j = 0; j < countN; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            for (int j = 0; j < countN; j++) {
                int start = intervals[j][0];
                int end = intervals[j][1];

                if (j == 0) {
                    output.append('C');
                    isCurrentC = true;
                    cLowest = start;
                    cHighest = end;
                } else {
                    if (isCurrentC && start >= cHighest) {
                        output.append('C');
                        cHighest = end;
                    } else if (isCurrentC && start <= cHighest) {
                        if (end <= jLowest || start >= jHighest) {
                            output.append('J');
                            isCurrentC = false;
                            jLowest = start;
                            jHighest = end;
                        } else {
                            isPossible = false;
                            break;
                        }
                    } else if (!isCurrentC && start >= jHighest) {
                        output.append('J');
                        jHighest = end;
                    } else if (!isCurrentC && (start <= cLowest || start >= cHighest)) {
                        if (end <= cLowest || start >= cHighest) {
                            output.append('C');
                            isCurrentC = true;
                            cLowest = start;
                            cHighest = end;
                        } else if (start <= jLowest || start >= jHighest) {
                            output.append('J');
                            isCurrentC = false;
                            jLowest = start;
                            jHighest = end;
                        } else {
                            isPossible = false;
                            break;
                        }
                    } else if (!isCurrentC && (start <= jLowest || start >= jHighest)) {
                        if (end <= cLowest || start >= cHighest) {
                            output.append('C');
                            isCurrentC = true;
                            cLowest = start;
                            cHighest = end;
                        } else if (start <= jLowest || start >= jHighest) {
                            output.append('J');
                            isCurrentC = false;
                            jLowest = start;
                            jHighest = end;
                        } else {
                            isPossible = false;
                            break;
                        }
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + (isPossible ? output.toString() : "IMPOSSIBLE"));
        }
    }
}