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
                    long sliceSize2 = sliceSizes.get(j);
                    parts[i][j].nbOfPart = sliceSize2 / sliceSize;
                    parts[i][j].nbOfCut = (sliceSize2 / sliceSize) - (sliceSize2 % sliceSize == 0 ? 1 : 0);
                }
            }

            long bestCut = Long.MAX_VALUE;
            for (int i = 0; i < numberOfSlices; i++) {
                Arrays.sort(parts[i]);
                if (isPossible(parts[i], numberOfClients)) {
                    long numberOfCuts = 0;
                    long servedClients = 0;
                    int j = 0;
                    while (servedClients < numberOfClients) {
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

                    bestCut = Math.min(bestCut, numberOfCuts);
                }
            }

            if (bestCut == Long.MAX_VALUE) {
                System.out.println("Case #" + testCase + ": " + (numberOfClients - 1));
            } else {
                System.out.println("Case #" + testCase + ": " + bestCut);
            }
        }
    }

    public static boolean isPossible(Data[] parts, long clients) {
        for (Data part : parts) {
            clients -= part.nbOfPart;
            if (clients <= 0) {
                return true;
            }
        }
        return false;
    }

    public static class Data implements Comparable<Data> {
        Long nbOfPart;
        Long nbOfCut;

        @Override
        public int compareTo(Data other) {
            int result = this.nbOfPart.compareTo(other.nbOfPart);
            return result != 0 ? result : this.nbOfCut.compareTo(other.nbOfCut);
        }
    }
}