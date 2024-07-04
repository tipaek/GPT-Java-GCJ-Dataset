import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
	static Scanner sc = new Scanner(System.in);
	static boolean count(String s,int y)
	{
		boolean flag;
		char []ch = s.toCharArray();
		int co = 0;
		for(char c:ch){
			if(c==ch[0]||c=='W')
				co++;
		}
		if(co>=y)
			return true;
		else
		 	return false;
	}
	static boolean count1(String s)
	{
		boolean flag;
		char []ch = s.toCharArray();
		int s1 = 0,w1=0,n1=0,e1=0;
		for(char c:ch){
			if(c=='S')
				s1++;
				if(s1>1)
				   return false;
		    if(c=='W')
				w1++;
				if(w1>1)
				   return false;
		    if(c=='E')
				e1++;
				if(e1>1)
				   return false;
		    if(c=='N')
				n1++;
				if(n1>1)
				   return false;			   
		}
		return true;
	}
    static void solution(int t) 
    { 
       
	    int x=sc.nextInt();
		int y=sc.nextInt();
		String s  = sc.next();
		if(y!=0){
			if(count(s,y)){
				if((x-y)==0)
					System.out.println("Case #"+(t)+": "+y);
				else
        	        System.out.println("Case #"+(t)+": "+Math.abs(x-y));
        	}
        	else
				System.out.println("Case #"+(t)+": IMPOSSIBLE");
		}
		else {
				if(count1(s))
					System.out.println("Case #"+(t)+": "+x);
			    else
				    System.out.println("Case #"+(t)+": IMPOSSIBLE");
			}
	}
        
    

	public static void main(String[] args)
	{
		int T=sc.nextInt();
		for(int t=1;t<=T;t++)
		{
		   solution(t);     	
	    }
	}
        
}