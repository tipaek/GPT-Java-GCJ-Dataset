import java.io.*;

import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

   public static void main(String args[])
   {
	   Scanner s=new Scanner(System.in);
	   int test=s.nextInt();
	   for(int t=1;t<=test;t++)
	   {
	   int px = s.nextInt();
       int py = s.nextInt();
       String path = s.next();
       if (px==0 && py==0) {
           System.out.println("0");
           return;
       }
       int mex = px;
       int mey = py;
       int f = -1, i;
       int ans = Integer.MAX_VALUE;
       for (i=0;i<path.length();i++) {
           char val = path.charAt(i);
           if (val=='N') {
               mey++;
           } else if (val=='S') {
               mey--;
           } else if (val=='E') {
              mex++;
           } else {
               mex--;
           }
           if ((Math.abs(mex)+Math.abs(mey))<=(i+1)) {
               f=(i+1);
               ans = Math.min(ans, f);
               break;
           }
       }
       if (ans!=Integer.MAX_VALUE) {
           System.out.println("Case #" + t + ": "+f);
       } else {
           System.out.println("Case #" + t + ": "+"IMPOSSIBLE");
       }
	   }
   }
   
}