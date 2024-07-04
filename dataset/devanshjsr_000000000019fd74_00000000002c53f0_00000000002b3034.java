/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
    
        static void sort(String []s, int n) 
    { 
        for (int i=1 ;i<n; i++) 
        { 
            String temp = s[i]; 
      
            int j = i - 1; 
            while (j >= 0 && temp.length() < s[j].length()) 
            { 
                s[j+1] = s[j]; 
                j--; 
            } 
            s[j+1] = temp; 
        } 
    }
    
    public static String docat(String f, String s) 
    {
   if (!f.contains(s.substring(0,1)))
     return f + s;
   int idx = s.length();
   try {
     while (!f.endsWith(s.substring(0, idx--))) ;
   } catch (Exception e) { }
   return f + s.substring(idx + 1);
    }
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		int st=1;
		
		while(t>0)
		{
		    int n=sc.nextInt();
		    String[] a=new String[n];
		    String[] b=new String[n];
		    String[] s1=new String[n];
		    
		    int k=0;
		    
		    for(int i=0;i<n;i++)
		    {
		        s1[i]=sc.next();
		        
		        int i1=s1[i].indexOf('*');
		        int i2=s1[i].lastIndexOf('*');
		        
		        
		        
		        if(i1==0)
		        {
		            a[i]="";
		            
		            if(i2==(s1[i].length()-1))
		            {
		                b[i]="";
		            }
		            else
		            {
		                 b[i]=s1[i].substring(i2+1,s1[i].length());
		            }
		           
		        }
		        else
		        {
		            a[i]=s1[i].substring(0,i1);
		            
		            if(i2==(s1[i].length()-1))
		            {
		                b[i]="";
		            }
		            else
		            {
		                 b[i]=s1[i].substring(i2+1,s1[i].length());
		            }
		            
		            
		             k=1;
		            
		        }
		    }
		    
		    sort(a,n);
		    sort(b,n);
		    
		    if(k==0)
		    {
		        int g=1;
		        for(int i=0;i<n-1;i++)
		    {
		        for(int j=0;j<b[i].length();j++)
		        {
		            if(b[i].charAt(b[i].length()-1-j)!=b[n-1].charAt(b[n-1].length()-1-j))
		            {
		                g=0;
		            }
		        }
		    }
		    
		    if(g==0)
		    {
		        System.out.println("Case #"+st+": "+"*");
		    }
		    else
		    {
		        System.out.println("Case #"+st+": "+b[n-1]);
		    }
		    
		        
		        
		        //System.out.println("Case #"+st+": "+b[n-1]);
		        t--;
		        st++;
		        continue;
		    }
		    
		    int f=1;
		    
		       for(int i=0;i<n-1;i++)
		    {
		      //  for(int j=0;j<a[i].length();j++)
		      //  {
		      //      if(a[i].charAt(j)!=a[n-1].charAt(j))
		      //      {
		      //          f=0;
		      //      }
		      //  }
		      
		      if(a[n-1].substring(0,a[i].length()).equals(a[i])==false && a[i].equals("")==false)
		      {
		          f=0;
		      }
		    }
		    
		    
		       for(int i=0;i<n-1;i++)
		    {
		      //  for(int j=0;j<b[i].length();j++)
		      //  {
		      //      if(b[i].charAt(b[i].length()-1-j)!=b[n-1].charAt(b[n-1].length()-1-j))
		      //      {
		      //          f=0;
		      //      }
		      //  }
		        
		        if(b[n-1].substring(b[n-1].length()-b[i].length(),b[n-1].length()).equals(b[i])==false && b[i].equals("")==false)
		      {
		          f=0;
		      }
		    }
		    
		    
		    
		    if(f==0)
		    {
		        System.out.println("Case #"+st+": "+"*");
		    }
		    else
		    {
		        String ans=a[n-1];
		        
		        
		        for(int i=0;i<n;i++)
		        {
		            if(s1[i].charAt(0)=='*')
		            {
		                if(s1[i].charAt(s1[i].length()-1)=='*')
		                {
		                    String[] sa=s1[i].substring(1,s1[i].length()-1).split("\\*");
		                    
		                    for(int j=0;j<sa.length;j++)
		                    {
		                         if(ans.substring(ans.length()-sa[j].length(),ans.length()).equals(sa[j])==false && sa[j].equals("")==false)
                    		      {
                    		          ans+=sa[j];
                    		      }
		                        
		                    }
		                }
		                else
		                {
		                    String[] sa=s1[i].substring(1,s1[i].length()).split("\\*");
		                    for(int j=0;j<sa.length-1;j++)
		                    {
		                        
		                        if(ans.substring(ans.length()-sa[j].length(),ans.length()).equals(sa[j])==false && sa[j].equals("")==false)
                    		      {
                    		          ans+=sa[j];
                    		      }
		                    }
		                }
		            }
		            else
		            {
		                if(s1[i].charAt(s1[i].length()-1)=='*')
		                {
		                    String[] sa=s1[i].substring(0,s1[i].length()-1).split("\\*");
		                    for(int j=1;j<sa.length;j++)
		                    {
		                        if(ans.substring(ans.length()-sa[j].length(),ans.length()).equals(sa[j])==false && sa[j].equals("")==false)
                    		      {
                    		          ans+=sa[j];
                    		      }
		                    }
		                }
		                else
		                {
		                    String[] sa=s1[i].substring(0,s1[i].length()).split("\\*");
		                    for(int j=1;j<sa.length-1;j++)
		                    {
		                        if(ans.substring(ans.length()-sa[j].length(),ans.length()).equals(sa[j])==false && sa[j].equals("")==false)
                    		      {
                    		          ans+=sa[j];
                    		      }
		                    }
		                }
		            }
		            
		        }
		        
		        
		        if(ans.substring(ans.length()-b[n-1].length(),ans.length()).equals(b[n-1])==false && b[n-1].equals("")==false)
                    		      {
                    		          ans+=sa[j];
                    		      }
		        
		        if(ans.length()<=10000)
		        {
		            System.out.println("Case #"+st+": "+ans);
		        }
		        else
		        {
		            System.out.println("Case #"+st+": "+"*");
		        }
		        
		            
		        
		        
		    }
		    
		    
		    
		   
		   
		   st++;
		   t--;
		    
		}
	}
}
