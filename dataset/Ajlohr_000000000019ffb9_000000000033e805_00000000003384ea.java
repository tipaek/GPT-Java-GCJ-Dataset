package Round2Prob1;

import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int cc = 1; cc <= t; ++cc) {
    	long a = in.nextInt();
    	long b = in.nextInt();
    	boolean flipped = false;
    	if(b>a)
    	{
    		flipped = true;
    		long swap = a;
    		a=b;
    		b=swap;
    		//System.out.println("flip");
    	}
    	long n1 = (long)Math.floor(-.5 + Math.sqrt(.25+2*(a-b)));
    	//System.out.println("n1 "+n1);
    	a = a - (n1*(n1+1)/2);
    	//System.out.println("a1 "+a);
    	//System.out.println("b1 "+b);
    	if(b>a)
    	{
    		flipped = !flipped;
    		long swap = a;
    		a=b;
    		b=swap;
    		//System.out.println("flip");
    	}
    	if(b==a&& flipped)
    	{
    		flipped = !flipped;
    		long swap = a;
    		a=b;
    		b=swap;
    		//System.out.println("flip");    		
    	}
    	long n2 = (long)Math.floor((-(n1) + Math.sqrt(n1*n1+4*a))/2);
    	//System.out.println("n2 "+n2);
    	if(n2>0)
    	{
    	a = a - (n2-1)*(n1+2)-(n2-1)*(n2-1)-n1-1;
    	b = b - (n2-2)*(n1+3)-(n2-2)*(n2-2)-n1-2;
    	}

    	//System.out.println("a2 "+a);
    	//System.out.println("b2 "+b);
    	int finalremovefromb = (b>= n1+n2*2-(n2>0?1:0)+1)?1:0;
    	//System.out.println("finalremove "+finalremovefromb);

    	if(finalremovefromb>0)
    	{
    		b-=n1+n2*2-(n2>0?1:0)+1;
    	}
    	//System.out.println("a3 "+a);
    	//System.out.println("b3 "+b);
    	if(flipped)
    	{
    		long swap = a;
    		a=b;
    		b=swap;
    		//System.out.println("flip");
    	}
        System.out.println("Case #" + cc + ": "+(n1+(n2*2)-(n2>0?1:0)+finalremovefromb)+" "+a+" "+b);
      }
    }
}
