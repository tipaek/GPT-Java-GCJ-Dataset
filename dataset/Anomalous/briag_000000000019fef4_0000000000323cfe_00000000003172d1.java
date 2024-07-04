import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read number of test cases
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {

            // Read size of data
            int numberOfSlices = scanner.nextInt();
            int numberOfClients = scanner.nextInt();

            List<Long> sliceSizes = new ArrayList<>(numberOfSlices);
            long[][] numberOfParts = new long[numberOfSlices][numberOfSlices];
            long[][] cutsRequired = new long[numberOfSlices][numberOfSlices];

            for (int i = 0; i < numberOfSlices; i++) {
                sliceSizes.add(scanner.nextLong());
            }

            Collections.sort(sliceSizes);

            for (int i = 0; i < numberOfSlices; i++) {
                long sliceSize = sliceSizes.get(i);
                for (int j = 0; j < numberOfSlices; j++) {
                    long sliceSize2 = sliceSizes.get(j);
                    numberOfParts[i][j] = sliceSize2 / sliceSize;
                    cutsRequired[i][j] = numberOfParts[i][j] - (sliceSize2 % sliceSize == 0 ? 1 : 0);
                }
            }

            long minimumCuts = Long.MAX_VALUE;
            for (int i = 0; i < numberOfSlices; i++) {
                Arrays.sort(numberOfParts[i]);
                if (canServeAllClients(numberOfParts[i], numberOfClients)) {
                    long totalCuts = 0;
                    long clientsServed = 0;
                    int j = 0;
                    while (clientsServed < numberOfClients) {
                        long possibleParts = numberOfParts[i][j];
                        long actualCuts;

                        if (possibleParts + clientsServed >= numberOfClients) {
                            actualCuts = Math.max(0, Math.min(numberOfClients - clientsServed, cutsRequired[i][j]));
                        } else {
                            actualCuts = Math.max(0, cutsRequired[i][j]);
                        }

                        totalCuts += actualCuts;
                        clientsServed += possibleParts;
                        j++;
                    }

                    minimumCuts = Math.min(minimumCuts, totalCuts);
                }
            }

            if (minimumCuts == Long.MAX_VALUE) {
                System.out.println("Case #" + caseNumber + ": " + (numberOfClients - 1));
            } else {
                System.out.println("Case #" + caseNumber + ": " + minimumCuts);
            }
        }
    }

    public static boolean canServeAllClients(long[] numberOfParts, long clients) {
        for (long part : numberOfParts) {
            clients -= part;
            if (clients <= 0) {
                return true;
            }
        }
        return false;
    }
}