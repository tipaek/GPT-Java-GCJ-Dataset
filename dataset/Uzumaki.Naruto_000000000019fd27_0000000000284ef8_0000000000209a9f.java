/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int x = sc.nextInt();
		StringBuilder sb=new StringBuilder();
		for(int v=1;v<=x;v++){
			char[] car = sc.next().toCharArray();
			StringBuilder res=new StringBuilder("Case #"+v+": ");
			int coc=0;
			for(char c:car){
				int cur = c-'0';
				int rob = cur-coc;
				if(rob>0){
					while(rob-->0){
						res.append('(');
					}
				}
				else if(rob<0){
					while(rob++<0){
						res.append(')');
					}
				}
				res.append(c);
				coc=cur;
			}
			while(coc-->0)
				res.append(')');
			res.append('\n');
			sb.append(res);
		}
		System.out.println(sb);
	}
}