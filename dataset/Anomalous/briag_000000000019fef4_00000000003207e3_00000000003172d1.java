import java.util.*;
import java.io.*;
import java.util.stream.LongStream;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numberOfSlices = scanner.nextInt();
            int numberOfClients = scanner.nextInt();

            List<Long> sliceSizes = new ArrayList<>(numberOfSlices);
            for (int i = 0; i < numberOfSlices; i++) {
                sliceSizes.add(scanner.nextLong());
            }

            Collections.sort(sliceSizes);

            long[][] numberOfParts = new long[numberOfSlices][numberOfSlices];
            long[][] numberOfCuts = new long[numberOfSlices][numberOfSlices];

            for (int i = 0; i < numberOfSlices; i++) {
                long sliceSize = sliceSizes.get(i);
                for (int j = 0; j < numberOfSlices; j++) {
                    long otherSliceSize = sliceSizes.get(j);
                    numberOfParts[i][j] = otherSliceSize / sliceSize;
                    numberOfCuts[i][j] = numberOfParts[i][j] - (otherSliceSize % sliceSize == 0 ? 1 : 0);
                }
            }

            long minimumCuts = Long.MAX_VALUE;
            for (int i = 0; i < numberOfSlices; i++) {
                Arrays.sort(numberOfParts[i]);
                long totalParts = LongStream.of(numberOfParts[i]).sum();
                if (totalParts >= numberOfClients) {
                    int cuts = 0;
                    int clientsServed = 0;
                    int j = 0;
                    while (clientsServed < numberOfClients) {
                        long possibleParts = numberOfParts[i][j];
                        long actualCuts;

                        if (possibleParts + clientsServed >= numberOfClients) {
                            actualCuts = Math.max(0, Math.min(numberOfClients - clientsServed, numberOfCuts[i][j]));
                        } else {
                            actualCuts = Math.max(0, numberOfCuts[i][j]);
                        }

                        cuts += actualCuts;
                        clientsServed += possibleParts;
                        j++;
                    }
                    minimumCuts = Math.min(minimumCuts, cuts);
                } else {
                    break;
                }
            }

            if (minimumCuts == Long.MAX_VALUE) {
                System.out.println("Case #" + testCase + ": " + (numberOfClients - 1));
            } else {
                System.out.println("Case #" + testCase + ": " + minimumCuts);
            }
        }
    }
}