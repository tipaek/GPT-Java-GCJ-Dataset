import java.util.*;
import java.io.*;

public class Solution {

    static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for(int t = 1; t <= testCases; t++){
            int numIntervals = Integer.parseInt(reader.readLine());
            Interval[] intervals = new Interval[numIntervals];
            Bound[] bounds = new Bound[2 * numIntervals];

            for(int i = 0; i < numIntervals; i++){
                intervals[i] = new Interval(reader.readLine(), i);
                bounds[i] = new Bound(intervals[i].start, true, i);
                bounds[i + numIntervals] = new Bound(intervals[i].end, false, i);
            }
            Arrays.sort(bounds);

            int zeroIndex = -1;
            int oneIndex = -1;
            int overlapCount = 0;

            boolean[] assignment = new boolean[numIntervals];
            boolean impossible = false;

            for(int i = 0; i < 2 * numIntervals; i++){
                Bound bound = bounds[i];
                if(bound.isStart){
                    overlapCount++;
                    if(overlapCount > 2){ 
                        impossible = true; 
                        break; 
                    }

                    if(zeroIndex == -1){
                        zeroIndex = bound.originalIndex;
                        assignment[bound.originalIndex] = true;
                    } else if (oneIndex == -1){
                        oneIndex = bound.originalIndex;
                        assignment[bound.originalIndex] = false;
                    } else {
                        System.out.println("Unexpected condition encountered");
                    }

                } else {
                    overlapCount--;
                    if(zeroIndex == bound.originalIndex){
                        zeroIndex = -1;
                    } else if(oneIndex == bound.originalIndex){
                        oneIndex = -1;
                    } else {
                        System.out.println("Unexpected condition encountered");
                    }
                }
            }

            if(impossible){
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + t + ": ");
                for(int i = 0; i < numIntervals; i++){
                    System.out.print(assignment[i] ? "J" : "C");
                }
                System.out.println();
            }
        }
    }

    static class Bound implements Comparable<Bound>{
        int time; 
        boolean isStart; 
        int originalIndex;

        public Bound(int time, boolean isStart, int originalIndex){
            this.time = time;
            this.isStart = isStart;
            this.originalIndex = originalIndex;
        }

        @Override
        public int compareTo(Bound other) {
            if(this.time == other.time){
                return this.isStart ? 1 : -1;
            }
            return this.time - other.time;
        }
    }

    static class Interval {
        int start; 
        int end; 
        int index;

        public Interval(String str, int index){
            tokenizer = new StringTokenizer(str);
            this.start = nextInt(); 
            this.end = nextInt();
            this.index = index;
        }
    }

    public static int nextInt(){
        return Integer.parseInt(tokenizer.nextToken());
    }
}