/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner z = new Scanner(System.in);
		int p,t,i,s=0,tn,j;
		t = z.nextInt();
		for(p=1;p<=t;p++) {
			String a="",b="";
    		a = z.next();
    		int nd=a.charAt(0)-'0';
    		int l = a.length();
    		for(i=0;i<nd;i++)
    			b=b+'(';
    		b=b+nd;

    		for(i=1;i<l;i++) {
    			tn=a.charAt(i)-'0';
    			if(tn<(a.charAt(i-1)-'0')) {
    				for(j=0;j<nd-tn;j++)
    					b=b+')';
    				b=b+tn;
    				nd=tn;
    			}
    			else if(tn>(a.charAt(i-1)-'0')) {    //check the condition at this stage
    				for(j=0;j<tn-nd;j++)
    					b=b+'(';
    				b=b+tn;
    				nd=tn;
    			}
    			else {
    				b=b+tn;
    				nd=tn;
    			}
    		}
    		
    		for(i=0;i<nd;i++)
    			b=b+')';

    		System.out.println("Case #"+p+": "+b);
    		b="";
		}
	}
}