/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class interval implements Comparable< interval >{
  
    public int qno, end, assigned;
    Integer start;
     
    public Integer getstart() {
        return start;
    }
    public void setstart(Integer ind) {
        this.start = ind;
    }
    
    @Override
    public int compareTo(interval o) {
        return this.getstart().compareTo(o.getstart());
    }
}


class Solution {

    
	public static void main (String[] args) throws java.lang.Exception{
	    
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int  i =0; i<t;i++){
           
           int n = in.nextInt();
           
           ArrayList<interval> intervals  = new ArrayList<interval>(n);
           
           int flagimp = 0;
           
           for(int  j =0;j<n;j++){
               int start = in.nextInt();
               int end = in.nextInt();
                interval q = new interval();
               q.setstart(start);
                q.end=end;
                q.qno=j;
                intervals.add(q);
           }
           
           Collections.sort(intervals);
           int flagJ=0;
           int flagC=0;
           char[] ans = new char[n];
           
           for(int  j =0;j<n;j++){
               int start =intervals.get(j).getstart();
               int end = intervals.get(j).end;
               if (flagC<=start){ ans[intervals.get(j).qno]='C'; flagC = end;}
               else if (flagJ<=start) {ans[intervals.get(j).qno]='J'; flagJ = end;}
               else flagimp=1;
           }
           

           if(flagimp==1) System.out.println("Case #"+(i+1) + ":"+ " IMPOSSIBLE");
           else{
               String answer = new String(ans);
               System.out.println("Case #"+(i+1) + ":"+ " "+answer);
           }
            
        }
	}
}


