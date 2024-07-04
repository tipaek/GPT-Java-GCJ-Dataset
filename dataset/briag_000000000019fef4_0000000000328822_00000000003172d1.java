import java.util.*;
import java.io.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;


public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read Number of Test Case
        int t = in.nextInt();
        for (int input = 1; input <= t; ++input) {

            // Read size of data
            int numberOfSlice = in.nextInt();
            int numberOfClient = in.nextInt();

            List<Long> sliceSizes = new ArrayList<>(numberOfSlice);

            Data[][] part = new Data[numberOfSlice][numberOfSlice];



            for(int i = 0; i < numberOfSlice; i++) {
                sliceSizes.add(in.nextLong());
            }

            Collections.sort(sliceSizes);

            for(int i = 0; i < numberOfSlice; i++) {
                long sliceSize = sliceSizes.get(i);

                for(int j = 0; j < numberOfSlice; j++) {
                    part[i][j] = new Data();
                    long sliceSize2 = sliceSizes.get(j);
                    part[i][j].nbOfPart = sliceSize2 / sliceSize;
                    part[i][j].nbOfCut  = (sliceSize2 / sliceSize) - (sliceSize2 % sliceSize == 0 ? 1 : 0);
                    part[i][j].perfectCut = (sliceSize2 % sliceSize == 0);
                }
            }

            long bestCut = Long.MAX_VALUE;
            for(int i = 0; i < numberOfSlice; i++) {
                Arrays.sort(part[i]);
                if(isPossible(part[i], numberOfClient)) {
                    long numberOfCut = 0;
                    long servedClient = 0;
                    int j = 0;

                    while(j < numberOfSlice && part[i][j].perfectCut && servedClient < numberOfClient) {

                        long possiblePart = part[i][j].nbOfPart;
                        long actualCut;

                        if(possiblePart + servedClient >= numberOfClient) {
                            actualCut = Math.max(0,Math.min(numberOfClient - servedClient,part[i][j].nbOfCut));
                        } else {
                            actualCut = Math.max(0,part[i][j].nbOfCut);
                        }

                        numberOfCut += actualCut;
                        servedClient += possiblePart;
                        j++;
                    }

                    if(servedClient < numberOfClient) {
                        numberOfCut += (numberOfClient - servedClient);
                    }


                    bestCut = Long.min(bestCut, numberOfCut);
                }
            }


            if(bestCut == Long.MAX_VALUE) {
                System.out.println("Case #" + input + ": " + (numberOfClient - 1));
            } else {
                System.out.println("Case #" + input + ": " + bestCut);
            }
        }

    }

    public static boolean isPossible(Data[] numberOfPart, long value) {
        for(int i = 0; i < numberOfPart.length; i++) {
            value = value - numberOfPart[i].nbOfPart;
            if(value <= 0) {
                return true;
            }
        }
        return false;
    }

    public static class Data implements Comparable<Data> {
        Long nbOfPart;
        Long nbOfCut;
        boolean perfectCut;

        @Override
        public int compareTo(Data data) {

            if(this.perfectCut && !data.perfectCut) {
                return -1;
            } else if (data.perfectCut && !this.perfectCut) {
                return 1;
            }

            int result = this.nbOfPart.compareTo(data.nbOfPart);

            return result;
        }
    }

}
