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

            long[][] numberOfPart = new long[numberOfSlice][numberOfSlice];
            long[][] nbCut = new long[numberOfSlice][numberOfSlice];



            for(int i = 0; i < numberOfSlice; i++) {
                sliceSizes.add(in.nextLong());
            }

            Collections.sort(sliceSizes);

            for(int i = 0; i < numberOfSlice; i++) {
                long sliceSize = sliceSizes.get(i);

                for(int j = 0; j < numberOfSlice; j++) {
                    long sliceSize2 = sliceSizes.get(j);
                    numberOfPart[i][j] = sliceSize2 / sliceSize;
                    nbCut[i][j] = (sliceSize2 / sliceSize) - (sliceSize2 % sliceSize == 0 ? 1 : 0);
                }
            }

            long bestCut = Long.MAX_VALUE;
            for(int i = 0; i < numberOfSlice; i++) {
                Arrays.sort(numberOfPart[i]);
                long sum = LongStream.of(numberOfPart[i]).sum();
                if(sum >= numberOfClient) {
                    int numberOfCut = 0;
                    int servedClient = 0;
                    int j = 0;
                    while(servedClient < numberOfClient) {

                        long possiblePart = numberOfPart[i][j];
                        long actualCut;

                        if(possiblePart + servedClient >= numberOfClient) {
                            actualCut = Math.max(0,Math.min(numberOfClient - servedClient,nbCut[i][j]));
                        } else {
                            actualCut = Math.max(0,nbCut[i][j]);
                        }

                        numberOfCut += actualCut;
                        servedClient += possiblePart;
                        j++;
                    }

                    bestCut = Long.min(bestCut, numberOfCut);
                } else {
                    break;
                }
            }


           if(bestCut == Long.MAX_VALUE) {
                System.out.println("Case #" + input + ": " + (numberOfClient - 1));
            } else {
               System.out.println("Case #" + input + ": " + bestCut);
            }




        }

    }


}
  