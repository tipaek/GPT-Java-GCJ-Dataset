import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numberOfSlices = scanner.nextInt();
            int numberOfClients = scanner.nextInt();

            List<Long> sliceSizes = new ArrayList<>(numberOfSlices);
            Data[][] parts = new Data[numberOfSlices][numberOfSlices];

            for (int i = 0; i < numberOfSlices; i++) {
                sliceSizes.add(scanner.nextLong());
            }

            Collections.sort(sliceSizes);

            for (int i = 0; i < numberOfSlices; i++) {
                long sliceSize = sliceSizes.get(i);
                for (int j = 0; j < numberOfSlices; j++) {
                    parts[i][j] = new Data();
                    long otherSliceSize = sliceSizes.get(j);
                    parts[i][j].numberOfParts = otherSliceSize / sliceSize;
                    parts[i][j].numberOfCuts = (otherSliceSize / sliceSize) - (otherSliceSize % sliceSize == 0 ? 1 : 0);
                    parts[i][j].isPerfectCut = (otherSliceSize % sliceSize == 0);
                }
            }

            long minimumCuts = Long.MAX_VALUE;
            for (int i = 0; i < numberOfSlices; i++) {
                Arrays.sort(parts[i]);
                if (canServeClients(parts[i], numberOfClients)) {
                    long currentCuts = 0;
                    long clientsServed = 0;
                    int j = 0;
                    while (clientsServed < numberOfClients) {
                        long possibleParts = parts[i][j].numberOfParts;
                        long actualCuts;

                        if (possibleParts + clientsServed >= numberOfClients) {
                            actualCuts = Math.max(0, Math.min(numberOfClients - clientsServed, parts[i][j].numberOfCuts));
                        } else {
                            actualCuts = Math.max(0, parts[i][j].numberOfCuts);
                        }

                        currentCuts += actualCuts;
                        clientsServed += possibleParts;
                        j++;
                    }

                    minimumCuts = Math.min(minimumCuts, currentCuts);
                }
            }

            if (minimumCuts == Long.MAX_VALUE) {
                System.out.println("Case #" + testCase + ": " + (numberOfClients - 1));
            } else {
                System.out.println("Case #" + testCase + ": " + minimumCuts);
            }
        }
    }

    public static boolean canServeClients(Data[] parts, long clients) {
        for (Data part : parts) {
            clients -= part.numberOfParts;
            if (clients <= 0) {
                return true;
            }
        }
        return false;
    }

    public static class Data implements Comparable<Data> {
        Long numberOfParts;
        Long numberOfCuts;
        boolean isPerfectCut;

        @Override
        public int compareTo(Data other) {
            if (this.isPerfectCut && !other.isPerfectCut) {
                return -1;
            } else if (other.isPerfectCut && !this.isPerfectCut) {
                return 1;
            }
            return this.numberOfParts.compareTo(other.numberOfParts);
        }
    }
}