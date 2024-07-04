package CodeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int T = fr.nextInt();
        int N;
        for (int i = 1; i <= T; i++) {
            N = fr.nextInt();
            ArrayList<Interval> intervals = new ArrayList<Interval>();
            for (int j = 0; j < N; j++) {
                intervals.add(new Interval(fr.nextInt(),fr.nextInt(),j));
            }
            s(intervals,i);
        }
    }
    static void s(ArrayList<Interval> intervals,int T){
        Interval C,J , tmp;
        Collections.sort(intervals,new IntervalComparator());
        C = intervals.get(0);
        C.assignedTo="C";
        J = new Interval(0,0,0);
        for (int i = 1; i < intervals.size(); i++) {
            tmp = intervals.get(i);
            if(tmp.start>=C.end){
                C=tmp;
                tmp.assignedTo="C";
            } else if(tmp.start>=J.end){
                J=tmp;
                J.assignedTo="J";
            } else {
                System.out.println("Case #"+T+": "+"IMPOSSIBLE");
                return;
            }
        }
        Collections.sort(intervals,new IntervalIndecComparator());
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < intervals.size(); i++) {
            out.append(intervals.get(i).assignedTo);
        }
        System.out.println("Case #"+T+": "+out);
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
class Interval{
    int start;
    int end;
    int index;
    String assignedTo;

    Interval(int start,int end,int index){
        this.start=start;
        this.end=end;
        this.index=index;
    }
}
class IntervalComparator implements Comparator<Interval>{

    @Override
    public int compare(Interval interval, Interval t1) {
        if(interval.start==t1.start)
        return 0;
        else if(interval.start>t1.start)
            return 1;
        else
            return -1;
    }
}
class IntervalIndecComparator implements Comparator<Interval>{

    @Override
    public int compare(Interval interval, Interval t1) {
        if(interval.index==t1.index)
            return 0;
        else if(interval.index>t1.index)
            return 1;
        else
            return -1;
    }
}
