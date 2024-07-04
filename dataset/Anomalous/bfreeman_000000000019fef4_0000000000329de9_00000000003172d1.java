package CJ2020.Round1C.Problem3;

import java.util.*;

public class Solution {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int numCases = in.nextInt();
        for (int i = 0; i < numCases; i++) {
            int numSlices = in.nextInt();
            int diners = in.nextInt();
            ArrayList<Long> slices = new ArrayList<>();
            for (int j = 0; j < numSlices; j++) {
                slices.add(in.nextLong());
            }
            handleCase(i + 1, diners, convertToSortedArray(slices));
        }
    }

    private static long[] convertToSortedArray(ArrayList<Long> list) {
        long[] array = list.stream().mapToLong(Long::longValue).toArray();
        Arrays.sort(array);
        return array;
    }

    private static void handleCase(int caseNum, int diners, long[] slices) {
        System.out.printf("%d diners, slices: %s%n", diners, Arrays.toString(slices));
        int minCuts = diners - 1;

        for (int i = slices.length; i >= 1; i--) {
            long[] occurrences = findOccurrences(i, slices);
            for (long occurrence : occurrences) {
                if (i >= diners) {
                    printResult(caseNum, 0);
                    return;
                }
                int neededDiners = diners - i;
                int possibleSlices = 0;
                int cuts = 0;

                for (long slice : slices) {
                    if (slice == occurrence) continue;
                    possibleSlices += slice / occurrence;
                    if (slice / occurrence - 1 < neededDiners) {
                        cuts += slice / occurrence - 1;
                        neededDiners -= slice / occurrence;
                    } else {
                        cuts += neededDiners;
                        neededDiners = 0;
                        break;
                    }
                }

                if (possibleSlices >= diners - i) {
                    minCuts = Math.min(minCuts, cuts + neededDiners);
                }
            }
        }

        printResult(caseNum, minCuts);
    }

    private static long[] findOccurrences(int n, long[] slices) {
        Map<Long, Integer> counts = new HashMap<>();
        for (long slice : slices) {
            counts.put(slice, counts.getOrDefault(slice, 0) + 1);
        }

        List<Long> nTimesList = new ArrayList<>();
        for (long slice : slices) {
            if (counts.get(slice) == n) {
                nTimesList.add(slice);
            }
        }

        return convertToSortedArray(new ArrayList<>(nTimesList));
    }

    private static void printResult(int caseNum, int result) {
        System.out.printf("Case #%d: %d%n", caseNum, result);
    }
}