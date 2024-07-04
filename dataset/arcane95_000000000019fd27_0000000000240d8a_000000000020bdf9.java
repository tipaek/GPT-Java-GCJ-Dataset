/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

// /* Name of the class has to be "Main" only if the class is public. */
// class Codechef
// {
// 	public static void main (String[] args) throws java.lang.Exception
// 	{
// 		// your code goes here
// 	}
// }

class Interval {
    public int pos;
    public int start, end;
    
    Interval(int p, int s, int e) {
        pos=p;
        start=s;
        end=e;
    }
}

class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int t = in.nextInt();
        int t1=1;
        while(t1<=t) {
            
            int n = in.nextInt();
            
            Interval[] intervals = new Interval[n];
            
            for(int i=0;i<n;i++) {
                int start=in.nextInt();
                int end = in.nextInt();
                intervals[i]=new Interval(i , start , end);
                // System.out.println("here "+ intervals[i].start +" "+intervals[i].start + " " + intervals[i].end);
            } 
            
            Arrays.sort(intervals, new Comparator<Interval>(){
                    @Override
                    public int compare(Interval interva11, Interval interval2) {
                        if(interva11.start==interval2.start) {
                            return interva11.end<interval2.end?-1:1;
                        }
                        return interva11.start<interval2.start?-1:1;
                    }
                }
            );
            
            boolean isPossible = true;
            StringBuffer str=new StringBuffer("");
            for(int i=0;i<n;i++ ) {
                str.append(" ");
            }
            
            int end1=0,end2=0;
            for(int i=0;i<n;i++) {
                // System.out.println("end1" + end1 + " end2 " + end2 + " " + intervals[i].start + " " + intervals[i].end);
                if(end1<=end2) {
                    if(end1<=intervals[i].start) {
                        end1=intervals[i].end;
                        str.replace(intervals[i].pos, intervals[i].pos+1,"J");
                    }    
                    else {
                        isPossible=false;
                    }
                }
                else {
                    if(end2<=intervals[i].start) {
                        end2=intervals[i].end;
                        str.replace(intervals[i].pos, intervals[i].pos+1,"C");
                    }    
                    else {
                        isPossible=false;
                    }
                }
            }
             
            String ans = str.toString();
            if(!isPossible) {
                ans="IMPOSSIBLE";
            }
            System.out.println("Case #" + t1 + ": " + ans);
            t1++;
        }
    }
}
