

import java.util.*;
import java.io.*;

class Interval implements Comparable<Interval>{
    int begin;
    int end;
    boolean assignToC;
    public Interval(int a, int b){
        this.begin=a;
        this.end=b;
        this.assignToC=false;
    }
    public int compareTo(Interval a)
    {
        if(this.end<a.end)
            return -1;
        if(this.end>a.end)
            return 1;
        return 0;
    }
}
public class Solution {
    public static void main(String[] args) throws Exception{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            for (int k = 1; k <= t; ++k) {
                int n=Integer.parseInt(br.readLine());
                ArrayList<Interval> intervals= new ArrayList<Interval>();
                for(int i=0;i<n;i++)
                {
                    String [] row=br.readLine().split(" ");
                    intervals.add(new Interval(Integer.parseInt(row[0]),Integer.parseInt(row[1])));
                }
                Collections.sort(intervals);
                StringBuilder out=new StringBuilder();
                Interval last_allotted_to_c=intervals.get(0);
                Interval last_allotted_to_j= new Interval(0,Integer.MIN_VALUE);
                out.append('C');
                int imp=0;
                for(int i=1;i<intervals.size();i++)
                {
                    if(last_allotted_to_c.end<=intervals.get(i).begin){
                        out.append('C');
                        last_allotted_to_c=intervals.get(i);
                        continue;
                    }
                    else
                    {
                        if(last_allotted_to_j.end<=intervals.get(i).begin){
                            out.append('J');
                            last_allotted_to_j=intervals.get(i);
                        }
                        else
                        {
                            imp=1;
                            break;
                        }
                    }
                }
                if(imp==1)
                    System.out.println("Case #" + k + ": IMPOSSIBLE");
                else
                    System.out.println("Case #" + k + ": "+out.toString());
            }


    }
}