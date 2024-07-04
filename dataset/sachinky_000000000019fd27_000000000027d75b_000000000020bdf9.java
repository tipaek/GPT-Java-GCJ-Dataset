/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;

class Solution{
    
    static class Interval implements Comparable<Interval>
    {  
        int start;  
        int end; 
        public Interval(int start, int end)  
        { 
            super(); 
            this.start = start; 
            this.end = end; 
        }
        public int compareTo(Interval i){
            return this.start-i.start;
        }
        public String toString(){
            return this.start+":"+this.end;
        }
    };  
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());
        for(int t=1;t<=tc;t++){
            int N = sc.nextInt();
            Interval[] schedule = new Interval[N];
            for(int i=0;i<N;i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                schedule[i] = new Interval(start,end);
            }
            Arrays.sort(schedule);
            // for(Interval i: schedule)
            //     System.out.println(i.start +":"+i.end);
            int e1 = schedule[0].end;
            int e2 = schedule[1].end;
            StringBuffer out = new StringBuffer("CJ");
            // out.append("CJ");
            for(int i=2;i<N;i++){
                int s = schedule[i].start;
                if(s < e1 && s<e2) {out.setLength(0); out.append("IMPOSSIBLE"); break;}
                if(s < e1) {out.append('J'); e2 = schedule[i].end;}
                else {out.append('C'); e1 = schedule[i].end;}
            }
            System.out.println("Case #"+t+": "+out);
        }
    }
}