import java.util.*;
import java.io.*;

public class Solution {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(f.readLine());

        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(f.readLine());
            Interval[] inters = new Interval[N];
            Bound[] bounds = new Bound[2*N];

            for(int i = 0; i < N; i++){
                inters[i]=new Interval(f.readLine(), i);
                bounds[i]=new Bound(inters[i].s, true, i);
                bounds[i+N]=new Bound(inters[i].e, false, i);
            }
            Arrays.sort(bounds);

            int zeroind = -1;
            int oneind = -1;
            int overlap = 0;

            boolean[] j = new boolean[N];
            boolean flag = false;

            for(int i = 0; i < 2*N; i++){
                Bound b = bounds[i];
                if(b.start){
                    overlap++;
                    if(overlap > 2){ flag=true; break; }

                    if(zeroind == -1){
                        zeroind=b.oi;
                        j[b.oi]=true;
                    } else if (oneind == -1){
                        oneind=b.oi;
                        j[b.oi]=false;
                    } else {
                        System.out.println("WE GOT A PROBLEM");
                    }

                } else {
                    overlap--;
                    if(zeroind == b.oi){ // "free up" the set that can now be used (J or C)
                        zeroind=-1;
                    } else if(oneind == b.oi){
                        oneind=-1;
                    } else {
                        System.out.println("WE GOT A PROBLEM");
                    }
                }

            }

            if(flag){
                System.out.println("Case #" + t + ": IMPOSSIBLE" );
            } else {
                System.out.print("Case #" + t + ": ");
                for(int i = 0; i < N; i++){
                    System.out.print(j[i]?"J":"C");
                }
                System.out.println();
            }
        }
    }

    static class Bound implements Comparable<Bound>{
        int t; boolean start; int oi;

        public Bound(int tt, boolean ss, int oo){
            t=tt; start=ss; oi=oo;
        }

        @Override
        public int compareTo(Bound o) {
            if(t - o.t == 0){
                if(!start) return -1;
                else return 1;
            }
            return t - o.t;
        }
    }

    static class Interval{
        int s; int e; int i;

        public Interval(String str, int ii){
            st = new StringTokenizer(str);
            s=nint(); e=nint();
            i=ii;
        }
    }

    public static int nint(){
        return Integer.parseInt(st.nextToken());
    }
}
