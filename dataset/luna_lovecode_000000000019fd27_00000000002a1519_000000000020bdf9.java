

import java.util.*;
import java.io.*;

class Interval implements Comparable<Interval>{
    int begin;
    int end;
    int ind;
    public Interval(int a, int b,int i){
        this.begin=a;
        this.end=b;
        this.ind=i;
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
                    intervals.add(new Interval(Integer.parseInt(row[0]),Integer.parseInt(row[1]),i));
                }
                Collections.sort(intervals);
                StringBuilder out=new StringBuilder();
                char [] output=new char[n];
                Interval last_allotted_to_c=intervals.get(0);
                Interval last_allotted_to_j= new Interval(0,Integer.MIN_VALUE,-1);
                output[last_allotted_to_c.ind]='C';
                int imp=0;
                for(int i=1;i<intervals.size();i++)
                {
                    if(last_allotted_to_c.end<=intervals.get(i).begin){

                        last_allotted_to_c=intervals.get(i);
                        output[last_allotted_to_c.ind]='C';
                        continue;
                    }
                    else
                    {
                        if(last_allotted_to_j.end<=intervals.get(i).begin){

                            last_allotted_to_j=intervals.get(i);
                            output[last_allotted_to_j.ind]='J';
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
                    System.out.println("Case #" + k + ": "+out.append(output).toString());
            }


    }
}