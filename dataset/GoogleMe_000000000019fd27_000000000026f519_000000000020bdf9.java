import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tN = in.nextInt();
        for(int t = 1;t<=tN;t++) {
            StringBuilder result = new StringBuilder("");
            int n = in.nextInt();
            Interval[] intervals = new Interval[n];
            for(int i = 0;i<intervals.length;i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals[i] = new Interval(start,end,i);
            }


            boolean notImpossible = true;
            Arrays.sort(intervals,(a,b)-> a.start - b.start);
            PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b) -> a.end - b.end);
            int endJ = Integer.MIN_VALUE;
            int endC = Integer.MIN_VALUE;
            for(int i = 0;i<intervals.length;i++) {
                if(intervals[i].start>=endC) {
                    endC = intervals[i].end;
                    intervals[i].setChar('C');
                } else if(intervals[i].start>=endJ) {
                    endJ = intervals[i].end;
                    intervals[i].setChar('J');
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    notImpossible = false;
                    break;
                }
            }
            if(notImpossible) {
Arrays.sort(intervals,(a,b)-> a.index-b.index);
for(int i = 0;i<intervals.length;i++) {
    result.append(intervals[i].getChar());
}
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }



    private static class Interval {
       private int start;
        private   int end;
        private  int index;
        private  char c;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval (int s, int e,int i) {
            this.start = s;
            this.end = e;
            this.index = i;
        }

        void setChar(char c) {
            this.c = c;
        }

        char getChar() {
            return this.c;
        }
    }
}

