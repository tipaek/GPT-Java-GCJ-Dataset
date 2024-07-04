import java.util.*;
import java.io.*;
import java.util.stream.LongStream;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int numberOfSlices = scanner.nextInt();
            int numberOfClients = scanner.nextInt();

            List<Long> sliceSizes = new ArrayList<>(numberOfSlices);
            for (int i = 0; i < numberOfSlices; i++) {
                sliceSizes.add(scanner.nextLong());
            }

            Collections.sort(sliceSizes);

            long[][] parts = new long[numberOfSlices][numberOfSlices];
            long[][] cuts = new long[numberOfSlices][numberOfSlices];

            for (int i = 0; i < numberOfSlices; i++) {
                long sliceSize = sliceSizes.get(i);
                for (int j = 0; j < numberOfSlices; j++) {
                    long otherSliceSize = sliceSizes.get(j);
                    parts[i][j] = otherSliceSize / sliceSize;
                    cuts[i][j] = (otherSliceSize / sliceSize) - (otherSliceSize % sliceSize == 0 ? 1 : 0);
                }
            }

            long minCuts = Long.MAX_VALUE;
            for (int i = 0; i < numberOfSlices; i++) {
                Arrays.sort(parts[i]);
                long totalParts = LongStream.of(parts[i]).sum();
                if (totalParts >= numberOfClients) {
                    int cutCount = 0;
                    int clientsServed = 0;
                    int j = 0;
                    while (clientsServed < numberOfClients && j < numberOfSlices) {
                        long possibleParts = parts[i][j];
                        long actualCuts = possibleParts + clientsServed >= numberOfClients
                                ? Math.max(0, Math.min(numberOfClients - clientsServed, cuts[i][j]))
                                : Math.max(0, cuts[i][j]);
                        cutCount += actualCuts;
                        clientsServed += possibleParts;
                        j++;
                    }
                    if (j != numberOfSlices) {
                        minCuts = Math.min(minCuts, cutCount);
                    }
                } else {
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + (minCuts == Long.MAX_VALUE ? numberOfClients - 1 : minCuts));
        }
    }
}