

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static class Act implements Comparable<Act>{
        int start, end, ind;
        public Act(int s, int e, int i){
            start = s;
            end = e;
            ind = i;
        }
        @Override
        public int compareTo(Act a) {
            return this.start - a.start;
        }
        public String toString(){
        	return "("+start+", "+end+") -- "+ind+"\n";
        }
    }
    public static void main(String args[]) throws Exception {

        // Write code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int ii = 1; ii <= t; ++ii) {
            String ans = "IMPOSSIBLE";
            int n = Integer.parseInt(br.readLine());
            ArrayList<Act> acts = new ArrayList();
            for (int i = 0; i < n; ++i) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                int st,en;
                st = Integer.parseInt(token.nextToken());
                en = Integer.parseInt(token.nextToken());
                acts.add(new Act(st,en,i));
            }
            Collections.sort(acts);
           // System.out.println(acts);
            int ja=0,ca=0,flag=1;
            char carr[]=new char[n];
            for (int i = 0; i < n; ++i) {
            	Act act = (Act) acts.get(i);
            	if(act.start >= ja){
            		carr[act.ind]='J';
            		//ans.append("J");
            		ja = act.end;
            	}else if(act.start >= ca){
            		carr[act.ind]='C';
            		//ans.append("C");
            		ca = act.end;
            	}else{
            		flag=0;
            		//ans = new StringBuffer("IMPOSSIBLE");
            		break;
            	}
            }
            if(flag == 1){
            	ans = String.valueOf(carr);
            }
            System.out.print("Case #"+ii+": "+ans+"\n");
        }

    }
}