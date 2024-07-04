import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int valuesForNext = in.nextInt();
            int[][] intervals = new int[valuesForNext][2];
            char[] results = new char[valuesForNext];
            Arrays.fill(results, 'J');

            for (int value = 0; value < valuesForNext; value++) {
                String line = in.nextLine().trim();
                if (line.isEmpty()) {
                    value--;
                    continue;
                }
                String[] lineParts = line.split(" ");
                intervals[value][0] = Integer.parseInt(lineParts[0]);
                intervals[value][1] = Integer.parseInt(lineParts[1]);
            }

            int[] numberOfOverlaps = new int[valuesForNext];
            int[][] overlaps = new int[valuesForNext][2];
            boolean isImpossible = false;

            for (int index = 0; index < valuesForNext; index++) {
                boolean overlapped = false;
                int overlappedIndex = 0;

                for (int innerIndex = index + 1; innerIndex < valuesForNext; innerIndex++) {
                    if (intervalsOverlap(intervals[index], intervals[innerIndex])) {
                        if (!overlapped) {
                            overlappedIndex = innerIndex;
                        }
                        overlapped = true;
                        numberOfOverlaps[index]++;

                        if (numberOfOverlaps[index] >= 3) {
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            isImpossible = true;
                            break;
                        }

                        overlaps[index][numberOfOverlaps[index] - 1] = innerIndex;

                        if (numberOfOverlaps[index] == 2) {
                            int index0 = overlaps[index][0];
                            int index1 = overlaps[index][1];
                            if (intervalsOverlap(intervals[index0], intervals[index1])) {
                                numberOfOverlaps[index] = 3;
                            } else {
                                results[index0] = 'C';
                                results[index1] = 'C';
                            }
                        }
                    }
                }

                if (isImpossible) {
                    break;
                }

                if (overlapped && results[index] == 'J') {
                    results[overlappedIndex] = 'C';
                }
            }

            if (!isImpossible) {
                System.out.print("Case #" + i + ": ");
                for (char result : results) {
                    System.out.print(result);
                }
                System.out.println();
            }
        }
    }

    private static boolean intervalsOverlap(int[] interval1, int[] interval2) {
        return interval1[0] < interval2[1] && interval2[0] < interval1[1];
    }
}