import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = Integer.parseInt(scanner.nextLine());

            for (int t = 0; t < testCases; t++) {
                int n = Integer.parseInt(scanner.nextLine());
                int[][] intervals = new int[n][2];
                boolean[] assigned = new boolean[n];
                int cEnd = 0, jEnd = 0;
                boolean isImpossible = false;
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < n; i++) {
                    String[] input = scanner.nextLine().split(" ");
                    intervals[i][0] = Integer.parseInt(input[0]);
                    intervals[i][1] = Integer.parseInt(input[1]);
                }

                for (int z = 0; z < n; z++) {
                    int earliestStart = Integer.MAX_VALUE;
                    int index = -1;

                    for (int i = 0; i < n; i++) {
                        if (!assigned[i] && intervals[i][0] < earliestStart) {
                            earliestStart = intervals[i][0];
                            index = i;
                        }
                    }

                    if (index == -1) break;

                    int start = intervals[index][0];
                    int end = intervals[index][1];

                    if (start >= cEnd) {
                        cEnd = end;
                        result.append('C');
                    } else if (start >= jEnd) {
                        jEnd = end;
                        result.append('J');
                    } else {
                        isImpossible = true;
                        break;
                    }
                    assigned[index] = true;
                }

                if (isImpossible) {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                }

                System.out.println("Case #" + (t + 1) + ": " + result.toString());
            }
        }
    }
}