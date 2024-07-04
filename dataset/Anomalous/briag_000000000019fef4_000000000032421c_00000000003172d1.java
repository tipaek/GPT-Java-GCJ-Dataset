import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int slicesCount = scanner.nextInt();
            int clientsCount = scanner.nextInt();

            List<Long> sliceSizes = new ArrayList<>(slicesCount);
            for (int i = 0; i < slicesCount; i++) {
                sliceSizes.add(scanner.nextLong());
            }

            Collections.sort(sliceSizes);

            long[][] partsPerSlice = new long[slicesCount][slicesCount];
            long[][] cutsPerSlice = new long[slicesCount][slicesCount];

            for (int i = 0; i < slicesCount; i++) {
                long sliceSize = sliceSizes.get(i);
                for (int j = 0; j < slicesCount; j++) {
                    long otherSliceSize = sliceSizes.get(j);
                    partsPerSlice[i][j] = otherSliceSize / sliceSize;
                    cutsPerSlice[i][j] = partsPerSlice[i][j] - (otherSliceSize % sliceSize == 0 ? 1 : 0);
                }
            }

            long minimumCuts = Long.MAX_VALUE;
            for (int i = 0; i < slicesCount; i++) {
                Arrays.sort(partsPerSlice[i]);
                if (canServeAllClients(partsPerSlice[i], clientsCount)) {
                    long totalCuts = 0;
                    long servedClients = 0;
                    int j = 0;
                    while (servedClients < clientsCount) {
                        long possibleParts = partsPerSlice[i][j];
                        long actualCuts;

                        if (possibleParts + servedClients >= clientsCount) {
                            actualCuts = Math.max(0, Math.min(clientsCount - servedClients, cutsPerSlice[i][j]));
                        } else {
                            actualCuts = Math.max(0, cutsPerSlice[i][j]);
                        }

                        totalCuts += actualCuts;
                        servedClients += possibleParts;
                        j++;
                    }
                    minimumCuts = Math.min(minimumCuts, totalCuts);
                } else {
                    break;
                }
            }

            if (minimumCuts == Long.MAX_VALUE) {
                System.out.println("Case #" + testCase + ": " + (clientsCount - 1));
            } else {
                System.out.println("Case #" + testCase + ": " + minimumCuts);
            }
        }
    }

    private static boolean canServeAllClients(long[] partsPerSlice, long clientsCount) {
        for (long parts : partsPerSlice) {
            clientsCount -= parts;
            if (clientsCount <= 0) {
                return true;
            }
        }
        return false;
    }
}