import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = sc.nextInt();
        int testNum = 1;

        while (testCases-- > 0) {
            int N = sc.nextInt();
            int[] startTimes = new int[N];
            int[] endTimes = new int[N];
            int[] originalStartTimes = new int[N];
            char[] assignments = new char[N];

            for (int i = 0; i < N; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
                originalStartTimes[i] = startTimes[i];
            }
            
            int[] sortedIndices = getSortedIndices(startTimes);
            int[] C = new int[2];
            int[] J = new int[2];
            boolean isPossible = true;

            for (int i : sortedIndices) {
                int start = startTimes[i];
                int end = endTimes[i];

                if (C[1] <= start) {
                    C[0] = start;
                    C[1] = end;
                    assignments[i] = 'C';
                } else if (J[1] <= start) {
                    J[0] = start;
                    J[1] = end;
                    assignments[i] = 'J';
                } else {
                    System.out.println("Case #" + testNum + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.print("Case #" + testNum + ": ");
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (originalStartTimes[i] == startTimes[sortedIndices[j]]) {
                            System.out.print(assignments[sortedIndices[j]]);
                            startTimes[sortedIndices[j]] = -1; // Mark as used
                            break;
                        }
                    }
                }
                System.out.println();
            }

            testNum++;
        }
    }

    private static int[] getSortedIndices(int[] array) {
        Integer[] indices = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(i -> array[i]));
        return Arrays.stream(indices).mapToInt(Integer::intValue).toArray();
    }
}