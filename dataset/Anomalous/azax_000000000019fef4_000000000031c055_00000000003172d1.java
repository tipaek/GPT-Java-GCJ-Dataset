import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            String[] firstLine = scanner.nextLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int d = Integer.parseInt(firstLine[1]);

            String[] secondLine = scanner.nextLine().split(" ");
            long[] sizes = new long[n];
            for (int i = 0; i < n; i++) {
                sizes[i] = Long.parseLong(secondLine[i]);
            }

            int result = calculateCuts(d, sizes);
            System.out.println("Case #" + (caseIndex + 1) + ": " + result);
        }
        scanner.close();
    }

    private static int calculateCuts(int d, long[] sizes) {
        Arrays.sort(sizes);
        if (d == 2) {
            for (int i = 0; i < sizes.length - 1; i++) {
                if (sizes[i] == sizes[i + 1]) {
                    return 0;
                }
            }
            return 1;
        } else { // d == 3
            int minCuts = 2;
            for (int i = 0; i < sizes.length - 1; i++) {
                if (sizes[i] == sizes[i + 1] && i < sizes.length - 2) {
                    if (sizes[i] == sizes[i + 2]) {
                        return 0;
                    } else {
                        minCuts = 1;
                    }
                }
            }

            if (minCuts < 2) {
                return minCuts;
            }

            for (int i = 0; i < sizes.length; i++) {
                for (int j = i + 1; j < sizes.length; j++) {
                    long difference = sizes[j] - 2 * sizes[i];
                    if (difference == 0) {
                        return 1;
                    } else if (difference > 0) {
                        continue;
                    }
                }
            }
            return 2;
        }
    }
}