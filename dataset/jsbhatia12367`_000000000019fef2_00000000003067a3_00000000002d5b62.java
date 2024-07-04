/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution
{
    static StringBuilder answer = new StringBuilder("");
    static StringBuilder t = new StringBuilder("IMPOSSIBLE");
    
    public static boolean last_bit(long num,long lb)
    {
        lb*=2;
        if(num%lb==0)
        return false;
        else
        return true;
    }
    public static StringBuilder fun_new(long a,long b,long play_for,StringBuilder answer,int c,long lb)
    {
        long check_for = play_for*2;
        if(a==0 && b==0)
        return answer;
        else if(a==0 && b!=0)
        {
            if(b>0)
            {
               String temp = "N";
               if(b-play_for<0)
               {
                return t;
               }
               else
               {
                   b = b-play_for;
                 answer.append(temp);
                 return fun_new(a,b,play_for*2,answer,c,check_for);
               }
            }
            else
            {
                String temp = "S"; 
                
                if(b+play_for>0)
               {
                 return t;  
               }
               else
               {
                  b = b+play_for;
                 answer.append(temp);
                 return fun_new(a,b,play_for*2,answer,c,check_for);  
               }
                
            }
        }
        else if(a!=0 && b==0)
        {
            if(a>0)
            {
                 String temp = "E";
                 if(a-play_for<0)
               {
                return t;
               }
               else
               {
                   a = a-play_for;
                 answer.append(temp);
                 return fun_new(a,b,play_for*2,answer,c,check_for);
               }
                 
                
            }
            else
            {
                 String temp = "W";
                 
                 if(a+play_for<0)
               {
                return t;
                
               }
               else
               {
                   a = a+play_for;
                 answer.append(temp);
                 return fun_new(a,b,play_for*2,answer,c,check_for);
               }
            }
            
        }
        else
        {
            
            if(c==1)
            {
                
                
                if(last_bit(b,check_for))
              {
                  c=2;
                if(!last_bit(a-play_for,check_for))
                {
                 a=a-play_for;
                 answer.append("E");
                }
                
                else if(!last_bit(a+play_for,check_for))
                {
                  a=a+play_for;
                  answer.append("W");
                }
                else
                return t;
                
              }
              else
              {
                  c=1;
                if(last_bit(a-play_for,check_for))
                {
                  a=a-play_for; 
                  answer.append("E");
                }
                
                else if(last_bit(a+play_for,check_for))
                {
                 a=a+play_for;
                 answer.append("W");
                }
                
                else
                return t;  
                  
              }   
            }
            else
            {
              if(last_bit(a,check_for))
              {
                  c=1;
                if(!last_bit(b-play_for,check_for))
                {
                 b=b-play_for;
                 answer.append("N");
                }
                
                else if(!last_bit(b+play_for,check_for))
                {
                  b=b+play_for;
                  answer.append("S");
                }
                else
                return t;
                
              }
              else
              {
                  c=2;
                if(last_bit(b-play_for,check_for))
                {
                  b=b-play_for; 
                  answer.append("N");
                }
                
                else if(last_bit(b+play_for,check_for))
                {
                 b=b+play_for;
                 answer.append("S");
                }
                
                else
                return t;  
                  
              }
            }
          
          return fun_new(a,b,play_for*2,answer,c,check_for);
            
        }
        
        
       // return answer;
    }
    public static StringBuilder fun(long a,long b)
    {
        StringBuilder answer = new StringBuilder("");
        if(a%2==b%2)
        return answer;
        long play_for=1;
        int c=1;
        if(a%2==0)
        c=2;
        answer= new StringBuilder();
        answer = fun_new(a,b,play_for,answer,c,2);
        
       return answer; 
    }
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long case_no=0;
		while(T-->0)
		{
		    long[] arr = Arrays.stream(br.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
		    long a = arr[0],b=arr[1];
		    StringBuilder answer = fun(a,b);
		    case_no++;
		    String ans = answer.toString();
		    if(ans.equals(""))
		    ans="IMPOSSIBLE";
		    System.out.println("Case #"+case_no+": "+ans);//Case #4: IMPOSSIBLE
		}
	}
}
