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
		    int k1=sc.nextInt();
		    if(k1%n!=0 || k1<n){
		      System.out.println("Case #"+k+": "+"IMPOSSIBLE");  
		      continue;
		    }
		    int t=k1/n;
		    String s=t+"";
		    for(int i=1;i<=n;i++){
		       if(i!=t){
		           s=s+i;
		       } 
		    }
		    System.out.println("Case #"+k+": "+"POSSIBLE");
		    for(int j=0;j<s.length()-1;j++)
    		      System.out.print(s.charAt(j)+" ");
    		System.out.println(s.charAt(s.length()-1));
		   
		    for(int i=1;i<n;i++){
    		    char c=s.charAt(s.length()-1);
    		    s = c+s.substring(0,s.length()-1);
    		    for(int j=0;j<s.length()-1;j++)
    		        System.out.print(s.charAt(j)+" ");
    		    System.out.println(s.charAt(s.length()-1));      
		    }
		   
		   
		}
	
	}
}
