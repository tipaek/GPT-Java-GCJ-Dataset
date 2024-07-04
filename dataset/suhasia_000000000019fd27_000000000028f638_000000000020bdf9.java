import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for(int x = 0; x < t; x++){
            int n = in.nextInt();
            Interval[] intervals = new Interval[n];
            for(int i = 0; i < n ; i++){
                intervals[i] = new Interval(in.nextInt(), in.nextInt(), i);
            }
            Arrays.sort(intervals);
            boolean possible = true;
            String[] ans = new String[n];
            int Cend = 0;
            int Jend = 0;
            for(int i = 0; i < n; i++){
                if(i == 0){
                    ans[intervals[0].index] = "C";
                    Cend = intervals[0].end;
                } else {
                    if(Cend > intervals[i].start && Jend > intervals[i].start){
                        possible = false; break;
                    } else if (Cend > intervals[i].start){
                        ans[intervals[i].index] = "J";
                        Jend = intervals[i].end;
                    } else {
                        ans[intervals[i].index] = "C";
                        Cend = intervals[i].end;
                    }
                }
            }
            if(!possible){
                System.out.println("Case #"+(x+1)+": IMPOSSIBLE");
            } else{
                String finalans = "";
                for(int i = 0; i < n; i++) finalans += ans[i];
                System.out.println("Case #"+(x+1)+": "+finalans);
            }

        }

    }

    public static boolean isNotOverlapping(Interval int1, Interval int2){
        return (int1.end<=int2.start);
    }
}

class Interval implements Comparable<Interval> {
    public int start;
    public int end;
    public int index;

    public Interval(int s, int e, int i) {
        start = s;
        end = e;
        index = i;
    }

    @Override
    public int compareTo(Interval int2) {
        if (this.start < int2.start)
            return -1;
        if (this.start > int2.start)
            return 1;
        if (this.end < int2.end)
            return -1;
        return 0;
    }
}

