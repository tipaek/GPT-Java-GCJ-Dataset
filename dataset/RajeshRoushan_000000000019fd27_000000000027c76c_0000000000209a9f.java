/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
    public static String calc(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();){
            char c=s.charAt(i);
            if(c=='0'){
                sb.append(c);
                i++;
            }
            else{
                sb.append("(");
                while(i<s.length() && s.charAt(i)=='1'){
                    sb.append("1");
                    i++;
                }
                sb.append(")");
            }
        }
        return sb.toString();
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt(); //no of test cases
		String s;
		for(int i=0;i<t;i++){
		    s=sc.next();
		    String req=calc(s);
		    System.out.println("Case #"+t+": "+req);
		}
	}
}
