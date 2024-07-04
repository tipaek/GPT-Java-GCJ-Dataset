import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

public class Solution {
    static int[][] intervals;
    static int[][][] memo;

    public static void main(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            output.append("Case #").append(t).append(": ");
            int N = parseInt(reader.readLine());
            intervals = new int[N][];

            for (int i = 0; i < N; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                intervals[i] = new int[]{parseInt(tokenizer.nextToken()), parseInt(tokenizer.nextToken()), i};
            }

            String result = findSchedule();
            if (result == null) {
                output.append("IMPOSSIBLE");
            } else {
                output.append(result);
            }
            output.append("\n");
        }
        System.out.print(output);
    }

    static boolean canSchedule(int currentIndex, int lastIndex) {
        if (currentIndex == intervals.length) {
            return true;
        }

        if (memo[currentIndex][lastIndex + 1] != null) {
            return memo[currentIndex][lastIndex + 1][0] == 1;
        }

        if (intervals[currentIndex - 1][1] <= intervals[currentIndex][0] && canSchedule(currentIndex + 1, lastIndex)) {
            memo[currentIndex][lastIndex + 1] = new int[]{1, 0};
            return true;
        }

        if ((lastIndex < 0 || intervals[lastIndex][1] <= intervals[currentIndex][0]) && canSchedule(currentIndex + 1, currentIndex - 1)) {
            memo[currentIndex][lastIndex + 1] = new int[]{1, 1};
            return true;
        }

        memo[currentIndex][lastIndex + 1] = new int[]{0};
        return false;
    }

    static String findSchedule() {
        int N = intervals.length;

        for (int i = 0; i < (1 << N); i++) {
            boolean validSchedule = true;

            for (int j = 0; j < N && validSchedule; j++) {
                for (int k = j + 1; k < N && validSchedule; k++) {
                    boolean bothC = ((1 << j) & i) == 0 && ((1 << k) & i) == 0;
                    boolean bothJ = ((1 << j) & i) != 0 && ((1 << k) & i) != 0;

                    if (bothC || bothJ) {
                        if ((intervals[j][0] < intervals[k][1] && intervals[j][1] > intervals[k][0]) ||
                            (intervals[k][0] < intervals[j][1] && intervals[k][1] > intervals[j][0]) ||
                            (intervals[j][0] == intervals[k][0] && intervals[j][1] == intervals[k][1])) {
                            validSchedule = false;
                        }
                    }
                }
            }

            if (validSchedule) {
                String binaryString = toBinaryString(i);
                while (binaryString.length() < N) {
                    binaryString = "0" + binaryString;
                }
                return new StringBuilder(binaryString.replaceAll("0", "C").replaceAll("1", "J")).reverse().toString();
            }
        }
        return null;
    }
}