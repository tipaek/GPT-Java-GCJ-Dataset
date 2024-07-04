import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
    public static void main (String[] args) throws java.lang.Exception
	{
		
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int test=sc.nextInt();
		for(int k=1;k<=test;k++){
		    int n=sc.nextInt();
		    int s[]=new int[n];
		    int e[]=new int[n];
		    for(int i=0;i<n;i++){
		        s[i]=sc.nextInt();
		        e[i]=sc.nextInt();
		    }
		    String t="C";
		    boolean b=true;;
		    for(int i=1;i<n;i++){
		        if(e[i-1]>s[i]){
		            if(t.charAt(i-1)=='C'){
		               t=t+"J";
		            }
	                else if(t.charAt(i-1)=='J' && t.charAt(i-2)=='C'){
	                        b=false;
	                        break;
	                }
	                        
	                else
	                    t=t+"C";
		        }else if(e[i-1]==s[i] || e[i]==s[i-1]){
		            t=t+t.charAt(i-1);
		        }else
		            t=t+"C";
		            
		    }
		   
		   if(b)
		        System.out.println("Case #"+k+": "+t);
		    else
		        System.out.println("Case #"+k+": "+"IMPOSSIBLE");
		   
		   
		   
		}
	
	}
}
