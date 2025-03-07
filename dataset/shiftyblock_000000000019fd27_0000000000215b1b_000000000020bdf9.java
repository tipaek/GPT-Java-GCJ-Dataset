import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int tcs= sc.nextInt();
        for (int x=1; x<=tcs; x++){
            int N= sc.nextInt();
            PriorityQueue<Pair> pq= new PriorityQueue<>();
            for (int i=0; i<N; i++){
                int a= sc.nextInt();
                int b= sc.nextInt()-1;
                pq.offer(new Pair(a, b));
            }
            String res="";
            boolean cTaken=false;
            boolean jTaken=false;
            int prev=-1;
            int cEnd=-1;
            int jEnd=-1;
            while (!pq.isEmpty()){
                Pair cur= pq.poll();
                int start=cur.a;
                if (cEnd<start){
                    cTaken=false;
                }
                if (jEnd<start) {
                    jTaken=false;
                }
                if (start<prev && jTaken && cTaken){
                    res="IMPOSSIBLE";
                    break;
                }

                prev= Math.max(cur.b, prev);
                if (!cTaken){
                    cTaken=true;
                    cEnd=cur.b;
                    res+="C";
                }
                else if (!jTaken){
                    jTaken=true;
                    jEnd=cur.b;
                    res+="J";
                }
            }
            System.out.println("Case #"+x+": "+res);
        }
    }
    static class Pair implements Comparable<Pair>{
        int a;
        int b;
        public Pair(int a, int b){
            this.a=a;
            this.b=b;
        }
        @Override
        public int compareTo(Pair obj){
            if (a==obj.a) return b-obj.b;
            return a-obj.a;
        }
    }
}
/*
4
5
99 150
1 100
100 301
2 5
150 250

 */