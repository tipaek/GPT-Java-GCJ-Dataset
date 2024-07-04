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
            HashMap<String,String> map = new HashMap<>();
            ArrayList<String> arr = new ArrayList<>();
            
            for(int i=0;i<N;i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                schedule[i] = new Interval(start,end);
                arr.add(start+":"+end);
            }
            Arrays.sort(schedule);
            // for(Interval i: schedule)
            //     System.out.println(i.start +":"+i.end);
            int e1 = schedule[0].end;
            int e2 = schedule[1].end;
            int s1 = schedule[0].start;
            int s2 = schedule[1].start;
            map.put((s1+":"+e1),"C");
            map.put((s2+":"+e2),"J");
            String result="";
            for(int i=2;i<N;i++){
                int si = schedule[i].start;
                int ei = schedule[i].end;
                if(si<e1 && si<e2) {result = "IMPOSSIBLE"; break;}
                if(si < e1) {map.put((si+":"+ei),"J"); e2 = schedule[i].end;}
                else {map.put((si+":"+ei),"C"); e1 = schedule[i].end;}
            }
            if(!result.equals("IMPOSSIBLE"))
                for(String s:arr)
                    result += map.get(s);
            System.out.println("Case #"+t+": "+result);
        }
    }
}