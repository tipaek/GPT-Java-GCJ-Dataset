import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numCases = scanner.nextInt();
        for (int i = 0; i < numCases; i++) {
            int numSlices = scanner.nextInt();
            int diners = scanner.nextInt();
            List<Long> slices = new ArrayList<>();
            for (int j = 0; j < numSlices; j++) {
                slices.add(scanner.nextLong());
            }
            processCase(i + 1, diners, convertToSortedLongArray(slices));
        }
    }

    private static long[] convertToSortedLongArray(List<Long> list) {
        long[] array = list.stream().mapToLong(Long::longValue).toArray();
        Arrays.sort(array);
        return array;
    }

    private static void processCase(int caseNum, int diners, long[] slices) {
        int minCuts = diners - 1;
        for (int i = slices.length; i >= 1; i--) {
            long[] occurrences = findOccurrences(i, slices);
            for (long occurrence : occurrences) {
                if (i >= diners) {
                    printResult(caseNum, 0);
                    return;
                }
                int needed = diners - i;
                int possible = 0;
                int cuts = 0;
                for (long slice : slices) {
                    if (slice == occurrence) continue;
                    possible += slice / occurrence;
                    if (slice % occurrence == 0) {
                        int quotient = (int) (slice / occurrence);
                        if (quotient - 1 < needed) {
                            cuts += quotient - 1;
                            needed -= quotient;
                        } else {
                            cuts += needed;
                            needed = 0;
                            break;
                        }
                    }
                }
                if (possible >= diners - i) {
                    minCuts = Math.min(minCuts, cuts + needed);
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
        List<Long> occurrences = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == n) {
                occurrences.add(entry.getKey());
            }
        }
        return convertToSortedLongArray(occurrences);
    }

    private static void printResult(int caseNum, int result) {
        System.out.printf("Case #%d: %d%n", caseNum, result);
    }
}