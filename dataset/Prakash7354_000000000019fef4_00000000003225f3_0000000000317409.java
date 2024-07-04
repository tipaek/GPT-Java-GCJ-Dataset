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
			if(c=='S')
				co++;
		}
		if(co>=y){
			return true;
		}
		 else
		 	return false;

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
			    System.out.println("Case #"+(t)+": IMPOSIBLE");
			
		}
    	else 
			System.out.println("Case #"+(t)+": IMPOSIBLE");
	
        
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