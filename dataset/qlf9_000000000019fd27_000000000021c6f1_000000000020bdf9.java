import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(f.readLine());
        int tt = t;
        while(tt-- > 0){
            int n = Integer.parseInt(f.readLine());
            Interval[] intervals = new Interval[n];
            PriorityQueue<Time> pq = new PriorityQueue<Time>();
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                intervals[i] = new Interval(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                pq.add(new Time(intervals[i].start, i, true));
                pq.add(new Time(intervals[i].end, i, false));
            }
            char[] outarr = new char[n];
            int idx1 = -1;
            int idx2 = -1;
            boolean impos = false;
            while(!pq.isEmpty()){
                Time currtime = pq.poll();
                if(currtime.beg){
                    if(idx1 == -1){
                        idx1 = currtime.idx;
                    }else if(idx2 == -1){
                        idx2 = currtime.idx;
                    }else{
                        out.println("Case #" + (t-tt) + ": IMPOSSIBLE");
                        impos = true;
                        break;
                    }
                }else{
                    if(idx1 == currtime.idx){
                        idx1 = -1;
                        outarr[currtime.idx] = 'C';
                    }else{
                        idx2 = -1;
                        outarr[currtime.idx] = 'J';
                    }
                }
            }
            if(impos) continue;
            StringBuilder outstr = new StringBuilder("Case #");
            outstr.append(t-tt);
            outstr.append(": ");
            for(int i = 0; i < outarr.length; i++){
                outstr.append(outarr[i]);
            }
            out.println(outstr.toString());
            

        }
        out.close();
    }static class Interval{
        public int start;
        public int end;

        public Interval(int a, int b){
            start = a;
            end = b;
        }
    }static class Time implements Comparable<Time>{
        public int time;
        public int idx;
        public boolean beg;
        public Time(int t, int idx, boolean beg){
            this.time=t;
            this.idx=idx;
            this.beg=beg;
        }

        public int compareTo(Time t){
            if(time < t.time) return -1;
            if(time > t.time) return 1;
            if(!beg && t.beg) return -1;
            if(beg && !t.beg) return 1;
            return 0;
        }
    }
}
