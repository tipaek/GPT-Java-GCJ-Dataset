/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	
	public static void main (String[] args) {
		//code
		int T;
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		
		for(int t=1;t<=T;t++){
			String ip=sc.next();
			String op="";
			int n;
			for(n=1;n<=ip.charAt(0)-'0';n++)
				op=op+"(";
			op=op+ip.charAt(0);
			
			for(int i=1;i<ip.length();i++)
			{
				
				if(ip.charAt(i)==ip.charAt(i-1)) {
					op=op+ip.charAt(i);
					continue;
				}
				else if(ip.charAt(i)>ip.charAt(i-1)) {
					int times=ip.charAt(i)-ip.charAt(i-1);
					while(times-- > 0)
						op=op+"(";
					op=op+ip.charAt(i);
					continue;
				}
				else if(ip.charAt(i) < ip.charAt(i-1)) {
					int times=ip.charAt(i-1)-ip.charAt(i);
					while(times-- > 0)
						op=op+")";
					op=op+ip.charAt(i);
					continue;
				}
			}
			
			for(n=1; n<=ip.charAt(ip.length()-1)-'0';n++)
				op=op+")";
			
			System.out.println("Case #"+t+": " +op);
			
		}
	}
}