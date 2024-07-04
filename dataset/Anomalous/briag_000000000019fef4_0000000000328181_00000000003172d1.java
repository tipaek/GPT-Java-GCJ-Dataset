import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numberOfSlices = scanner.nextInt();
            int numberOfClients = scanner.nextInt();

            List<Long> sliceSizes = new ArrayList<>();
            for (int i = 0; i < numberOfSlices; i++) {
                sliceSizes.add(scanner.nextLong());
            }

            Collections.sort(sliceSizes);

            Data[][] parts = new Data[numberOfSlices][numberOfSlices];
            for (int i = 0; i < numberOfSlices; i++) {
                long sliceSize = sliceSizes.get(i);
                for (int j = 0; j < numberOfSlices; j++) {
                    parts[i][j] = new Data();
                    long otherSliceSize = sliceSizes.get(j);
                    parts[i][j].nbOfPart = otherSliceSize / sliceSize;
                    parts[i][j].nbOfCut = (otherSliceSize / sliceSize) - (otherSliceSize % sliceSize == 0 ? 1 : 0);
                    parts[i][j].perfectCut = (otherSliceSize % sliceSize == 0);
                }
            }

            long bestCut = Long.MAX_VALUE;
            for (int i = 0; i < numberOfSlices; i++) {
                Arrays.sort(parts[i]);
                if (isPossible(parts[i], numberOfClients)) {
                    long numberOfCuts = 0;
                    long servedClients = 0;
                    int j = 0;

                    while (j < numberOfSlices && parts[i][j].perfectCut) {
                        long possibleParts = parts[i][j].nbOfPart;
                        long actualCuts;

                        if (possibleParts + servedClients >= numberOfClients) {
                            actualCuts = Math.max(0, Math.min(numberOfClients - servedClients, parts[i][j].nbOfCut));
                        } else {
                            actualCuts = Math.max(0, parts[i][j].nbOfCut);
                        }

                        numberOfCuts += actualCuts;
                        servedClients += possibleParts;
                        j++;
                    }

                    if (servedClients < numberOfClients) {
                        numberOfCuts += (numberOfClients - servedClients);
                    }

                    bestCut = Math.min(bestCut, numberOfCuts);
                }
            }

            if (bestCut == Long.MAX_VALUE) {
                System.out.println("Case #" + caseNum + ": " + (numberOfClients - 1));
            } else {
                System.out.println("Case #" + caseNum + ": " + bestCut);
            }
        }
    }

    private static boolean isPossible(Data[] parts, long clients) {
        for (Data part : parts) {
            clients -= part.nbOfPart;
            if (clients <= 0) {
                return true;
            }
        }
        return false;
    }

    private static class Data implements Comparable<Data> {
        long nbOfPart;
        long nbOfCut;
        boolean perfectCut;

        @Override
        public int compareTo(Data other) {
            if (this.perfectCut && !other.perfectCut) {
                return -1;
            } else if (!this.perfectCut && other.perfectCut) {
                return 1;
            }
            return Long.compare(this.nbOfPart, other.nbOfPart);
        }
    }
}