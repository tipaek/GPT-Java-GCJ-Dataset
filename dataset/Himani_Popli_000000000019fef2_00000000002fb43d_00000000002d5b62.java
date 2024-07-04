/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for(int k=1;k<=t;k++){
		    long x=scan.nextLong();
		    long y=scan.nextLong();
		    long x1=Math.abs(x);
		    long y1=Math.abs(y);
		    String ans="";
		    if(x1%2!=0){
		        long temp=x1&y1;
		        if(temp==0){
		            String s1=Long.toBinaryString(x1);
		            String s2=Long.toBinaryString(y1);
		            int i1=s1.length()-1;
		            int i2=s2.length()-1;
		            while(i1>=0||i2>=0){
		                if(i1>=0&&s1.charAt(i1)=='1'){
		                    if(x<0){
		                        ans+="W";
		                    }else{
		                        ans+="E";
		                    }
		                }else if(i2>=0&&s2.charAt(i2)=='1'){
		                    if(y<0){
		                        ans+="S";
		                    }else{
		                        ans+="N";
		                    }
		                }else{
		                    ans="IMPOSSIBLE";
		                    break;
		                }
		                i1--;
		                i2--;
		            }
		        }else{
		            x1+=2;
		            temp=x1&y1;
		            if(temp==0){
    		            String s1=Long.toBinaryString(x1);
    		            String s2=Long.toBinaryString(y1);
    		            int i1=s1.length()-2;
    		            int i2=s2.length()-2;
    		            if(x<0){
	                        ans+="E";
	                    }else{
	                        ans+="W";
	                    }
    		            while(i1>=0||i2>=0){
    		                if(i1>=0&&s1.charAt(i1)=='1'){
    		                    if(x<0){
    		                        ans+="W";
    		                    }else{
    		                        ans+="E";
    		                    }
    		                }else if(i2>=0&&s2.charAt(i2)=='1'){
    		                    if(y<0){
    		                        ans+="S";
    		                    }else{
    		                        ans+="N";
    		                    }
    		                }else{
    		                    ans="IMPOSSIBLE";
    		                    break;
    		                }
    		                i1--;
    		                i2--;
    		            }
    		        }else{
    		            ans="IMPOSSIBLE";
    		        }
		        }
		        
		    }else if(y%2!=0){
		        long temp=x1&y1;
		        if(temp==0){
		            String s1=Long.toBinaryString(x1);
		            String s2=Long.toBinaryString(y1);
		            int i1=s1.length()-1;
		            int i2=s2.length()-1;
		            while(i1>=0||i2>=0){
		                if(i1>=0&&s1.charAt(i1)=='1'){
		                    if(x<0){
		                        ans+="W";
		                    }else{
		                        ans+="E";
		                    }
		                }else if(i2>=0&&s2.charAt(i2)=='1'){
		                    if(y<0){
		                        ans+="S";
		                    }else{
		                        ans+="N";
		                    }
		                }else{
		                    ans="IMPOSSIBLE";
		                    break;
		                }
		                i1--;
		                i2--;
		            }
		        }else{
		            y1+=2;
		            temp=x1&y1;
		            if(temp==0){
    		            String s1=Long.toBinaryString(x1);
    		            String s2=Long.toBinaryString(y1);
    		            int i1=s1.length()-2;
    		            int i2=s2.length()-2;
    		            if(y<0){
	                        ans+="N";
	                    }else{
	                        ans+="S";
	                    }
    		            while(i1>=0||i2>=0){
    		                if(i1>=0&&s1.charAt(i1)=='1'){
    		                    if(x<0){
    		                        ans+="W";
    		                    }else{
    		                        ans+="E";
    		                    }
    		                }else if(i2>=0&&s2.charAt(i2)=='1'){
    		                    if(y<0){
    		                        ans+="S";
    		                    }else{
    		                        ans+="N";
    		                    }
    		                }else{
    		                    ans="IMPOSSIBLE";
    		                    break;
    		                }
    		                i1--;
    		                i2--;
    		            }
    		        }else{
    		            ans="IMPOSSIBLE";
    		        }
		        }
		        
		    }else{
		        ans="IMPOSSIBLE";
		    }
		    System.out.println("Case #"+k+": "+ans);
		}
	}
}
