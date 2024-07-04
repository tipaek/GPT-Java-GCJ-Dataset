import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
    
	public static void main (String[] args) throws java.lang.Exception
  	{
      Scanner sc = new Scanner(System.in);	 
      int t=sc.nextInt();
    for(int j=0;j<t;++j)
	 {
	        String s=sc.next();
	        int l=s.length();
	        //String ans="";
	        int i=0;
	       // char[] ans;
	       char[] ans = new char[10000000];
	        char[] arr=s.toCharArray(); 
	        for(int f=0;f<l;++f)
	        {
	            if(l==1)
	            {
	             if(arr[0]=='0')
	             ans[i]='0';
	             else
	             {
	                  ans[i]='(';
	                ++i;
	                ans[i]='1';
	                ++i;
	                ans[i]=')';
	                ++i;
	                
	             }
	             continue;
	            }
	            if(arr[f]=='1' && f==0 && arr[f+1]=='0')
	            {
	                 ans[i]='(';
	                ++i;
	                ans[i]='1';
	                ++i;
	                ans[i]=')';
	                ++i;
	                continue;
	            }
	            if(arr[f]=='1' && f==0 && arr[f+1]=='1')
	            {
	                 ans[i]='(';
	                ++i;
	                ans[i]='1';
	                ++i;
	                continue;
	            }
	            
	            
	            
	            
	            
	            
	            if(f==l-1)
	            {
	                if(arr[f]=='0' && arr[f-1]=='0')
	                {
	                    ans[i]='0';
	                    ++i;
	                    continue;
	                }
	                 if(arr[f]=='0' && arr[f-1]=='1')
	                {
	                    ans[i]='0';
	                    ++i;
	                    continue;
	                }
	                 if(arr[f]=='1' && arr[f-1]=='0')
	                {
	                    ans[i]='(';
	                    ++i;
                        ans[i]='1';
                        ++i;
                        ans[i]=')';
                        ++i;
                        continue;
	                }
	                if(arr[f]=='1' && arr[f-1]=='1')
	                {
	                    ans[i]='1';
                        ++i;
                        ans[i]=')';
                        ++i;
                        continue;
	                }
	                
	               
	            }
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            if(arr[f]=='0')
	            {
	              ans[i]='0';
	              ++i;
	              continue;
	            }
	            if(arr[f]=='1' && arr[f-1]!='1' && arr[f+1]!='1')
	            {
	                ans[i]='(';
	                ++i;
	                ans[i]='1';
	                ++i;
	                ans[i]=')';
	                ++i;
	                continue;
	            }
	             if(arr[f]=='1' && arr[f-1]=='1' && arr[f+1]!='1')
	            {
	                
	                
	                ans[i]='1';
	                ++i;
	                ans[i]=')';
	                ++i;
	                continue;
	            }
	             if(arr[f]=='1' && arr[f-1]=='1' && arr[f+1]=='1')
	            {
	                
	                
	                ans[i]='1';
	                ++i;
	                
	                continue;
	            }
	             if(arr[f]=='1' && arr[f-1]!='1' && arr[f+1]=='1')
	            {
	                
	                ans[i]='(';
	                ++i;
	                ans[i]='1';
	                ++i;
	                
	                continue;
	            }
	        }
	 
	     String yu=new String(ans);
	  //   System.out.println();
	     System.out.println("Case"+" #"+(j+1)+": "+yu);
	 }
	}
}
