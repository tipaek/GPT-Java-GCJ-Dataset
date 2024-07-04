import java.io.*;
import java.util.*;

public class Solution {

    private static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        //Input for number of test cases.
        int cases = Integer.parseInt(br.readLine());

        for (int test = 1; test <= cases; test++) {

            //Code Here
            String inp[] = br.readLine().trim().split(" ");
            int N = Integer.parseInt(inp[0]);
            int D = Integer.parseInt(inp[1]);

            long[] have = new long[N];

            inp = br.readLine().trim().split(" ");
            int c = 0;

            for (String slice : inp) {
                have[c] = Long.parseLong(slice);
                c++;
            }

            //DO NOT CHANGE THE LINE IF NOT NECESSARY
            System.out.print("Case #" + test + ": ");
            if(N>D)
                System.out.println(cutsForNumberMoreThanDiners(N,D,have));
            else
                System.out.println(cutsForNumberLessThanDiners(N,D,have));


        }
    }

    // CHANGE FUNCTION NAME AND RETURN TYPE
    private static int cutsForNumberMoreThanDiners(int N, int D, long[] haveSlices) {

        Arrays.sort(haveSlices);
        int slices = 0;

            int closest = 1;
            int maxClosest = 0;
            long prev = haveSlices[0];
            long sum = 0;


            for (int i = 1; i < N; i++) {
                long current = haveSlices[i];
                if (current == prev) {
                    closest++;
                    if (closest >= D)
                        return 0;
                } else {
                    if (closest > maxClosest)
                        maxClosest = closest;
                    prev = current;
                    closest = 1;
                }
                sum += current;
            }

            long avg = sum / D;

            HashMap<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                long current = haveSlices[i];
                if (current != avg) {
                    if (map.containsKey(Math.abs((avg * 2) - current)))
                        slices++;
                    else
                        map.put(current, i);
                }
            }

        return slices;
    }

    private static int cutsForNumberLessThanDiners(int N, int D, long[] haveSlices) {

        double sum = 0.0;
        List<Double> list = new ArrayList<>();
        for (long slice :
                haveSlices) {
            list.add(slice*1.0);
            sum += slice;
        }
        double avg = 1.0*sum/D;

        int slices = 0;

        while(list.size() != 0 && slices < D){

            double current = list.get(0);
            list.remove(0);

            if(current - avg > 0.00001) {
                current -= avg;
                list.add(0,current);
                slices++;

            }
        }

        return slices;
    }

}