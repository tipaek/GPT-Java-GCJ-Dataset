/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	
	public static void main (String[] args) {
		//code
		int T,i,j,k;
		
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for(i=1;i<=T;i++){
			String ip=sc.next();
			String op="";
			
			if(ip.charAt(0)=='0') {
				op=op+0;
			}
			else if(ip.charAt(0)=='1') {
				op=op+"(1";
			}
			for(i=1;i<ip.length();i++)
			{
				
				if(ip.charAt(i)=='0' && ip.charAt(i-1)=='0') {
					op=op+"0";
					continue;
				}
				else if(ip.charAt(i)=='0' && ip.charAt(i-1)=='1') {
					op=op+")0";
					continue;
				}
				else if(ip.charAt(i)=='1' && ip.charAt(i-1)=='0') {
					op=op+"(1";
					continue;
				}
				else if(ip.charAt(i)=='1' && ip.charAt(i-1)=='1') {
					op=op+"1";
					continue;
				}
				
			}
			if(ip.charAt(ip.length()-1)=='1')
				op=op+")";
			
			System.out.println("Case #"+i+": " +op);
			
		}
	}
}