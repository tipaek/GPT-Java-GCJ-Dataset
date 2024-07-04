import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read Number of Test Cases
        int t = scanner.nextInt();
        for (int testCase = 1; testCase <= t; ++testCase) {

            // Read size of data
            int numberOfSlices = scanner.nextInt();
            int numberOfClients = scanner.nextInt();

            List<Long> sliceSizes = new ArrayList<>(numberOfSlices);
            Data[][] partitionData = new Data[numberOfSlices][numberOfSlices];

            for (int i = 0; i < numberOfSlices; i++) {
                sliceSizes.add(scanner.nextLong());
            }

            Collections.sort(sliceSizes);

            for (int i = 0; i < numberOfSlices; i++) {
                long sliceSize = sliceSizes.get(i);

                for (int j = 0; j < numberOfSlices; j++) {
                    partitionData[i][j] = new Data();
                    long otherSliceSize = sliceSizes.get(j);
                    partitionData[i][j].nbOfParts = otherSliceSize / sliceSize;
                    partitionData[i][j].nbOfCuts = (otherSliceSize / sliceSize) - (otherSliceSize % sliceSize == 0 ? 1 : 0);
                    partitionData[i][j].perfectCut = (otherSliceSize % sliceSize == 0);
                }
            }

            long minimumCuts = Long.MAX_VALUE;
            for (int i = 0; i < numberOfSlices; i++) {
                Arrays.sort(partitionData[i]);
                if (canServeClients(partitionData[i], numberOfClients)) {
                    long totalCuts = 0;
                    long servedClients = 0;
                    int j = 0;

                    while (j < numberOfSlices && partitionData[i][j].perfectCut && servedClients < numberOfClients) {
                        long possibleParts = partitionData[i][j].nbOfParts;
                        long actualCuts;

                        if (possibleParts + servedClients >= numberOfClients) {
                            actualCuts = Math.max(0, Math.min(numberOfClients - servedClients, partitionData[i][j].nbOfCuts));
                        } else {
                            actualCuts = Math.max(0, partitionData[i][j].nbOfCuts);
                        }

                        totalCuts += actualCuts;
                        servedClients += possibleParts;
                        j++;
                    }

                    if (servedClients < numberOfClients) {
                        totalCuts += (numberOfClients - servedClients);
                    }

                    minimumCuts = Math.min(minimumCuts, totalCuts);
                }
            }

            if (minimumCuts == Long.MAX_VALUE) {
                System.out.println("Case #" + testCase + ": " + (numberOfClients - 1));
            } else {
                System.out.println("Case #" + testCase + ": " + minimumCuts);
            }
        }
    }

    private static boolean canServeClients(Data[] partitionData, long clients) {
        for (Data data : partitionData) {
            clients -= data.nbOfParts;
            if (clients <= 0) {
                return true;
            }
        }
        return false;
    }

    private static class Data implements Comparable<Data> {
        Long nbOfParts;
        Long nbOfCuts;
        boolean perfectCut;

        @Override
        public int compareTo(Data other) {
            if (this.perfectCut && !other.perfectCut) {
                return -1;
            } else if (!this.perfectCut && other.perfectCut) {
                return 1;
            }
            return this.nbOfParts.compareTo(other.nbOfParts);
        }
    }
}