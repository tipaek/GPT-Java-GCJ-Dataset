import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        String[] output = new String[testCases];

        for (int q = 0; q < testCases; q++) {
            int n = Integer.parseInt(reader.readLine());
            int[] start = new int[n];
            int[] end = new int[n];
            char[] assigned = new char[n];
            char[] finalAssignment = new char[n];

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split("\\s+");
                start[i] = Integer.parseInt(input[0]);
                end[i] = Integer.parseInt(input[1]);
                assigned[i] = '\0';
            }

            int flag = 0;
            int[][] sorted = sort(start, end);
            int[] sortedStart = sorted[0];
            int[] sortedEnd = sorted[1];

            for (int i = 0; i < n; i++) {
                assigned[i] = 'C';
                for (int j = 0; j < i; j++) {
                    if (assigned[j] == 'C' && ((sortedStart[j] < sortedStart[i] && sortedEnd[j] > sortedStart[i]) || (sortedStart[i] < sortedStart[j] && sortedEnd[i] > sortedStart[j]))) {
                        assigned[i] = 'J';
                        break;
                    }
                }

                if (assigned[i] == 'J') {
                    for (int j = 0; j < i; j++) {
                        if (assigned[j] == 'J' && ((sortedStart[j] < sortedStart[i] && sortedEnd[j] > sortedStart[i]) || (sortedStart[i] < sortedStart[j] && sortedEnd[i] > sortedStart[j]))) {
                            flag = 1;
                            break;
                        }
                    }
                }

                if (flag == 1) break;
            }

            if (flag == 1) {
                output[q] = "IMPOSSIBLE";
            } else {
                StringBuilder ans = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    finalAssignment[i] = assigned[findIndex(sortedStart, start[i])];
                    ans.append(finalAssignment[i]);
                }
                output[q] = ans.toString();
            }
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + output[i]);
        }
    }

    public static int[][] sort(int[] start, int[] end) {
        int n = start.length;
        int[][] sorted = new int[2][n];
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        Arrays.sort(indices, Comparator.comparingInt(i -> start[i]));

        for (int i = 0; i < n; i++) {
            sorted[0][i] = start[indices[i]];
            sorted[1][i] = end[indices[i]];
        }

        return sorted;
    }

    public static int findIndex(int[] arr, int value) {
        return IntStream.range(0, arr.length)
                .filter(i -> arr[i] == value)
                .findFirst()
                .orElse(-1);
    }
}