/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
	    for(int l=0;l<t;l++)
	    {
	        
	        int index=l+1;
	        String s="";
	        int flag=0;
	        String j="J";
	        String c="C";
	        int n=in.nextInt();
	        int ar[]=new int[n*2];
	        for(int i=0;i<n*2;i+=2)
	        {
	            
	            ar[i]=in.nextInt();
	            ar[i+1]=in.nextInt();
	            if(i==0)
	            {
	                s=s+"J";
	            }
	            else if(i==2 && ar[i]<ar[i-1])
	            {
	                s=s+"C";
	               
	            }
	              else if(i==2 && ar[i]>=ar[i-1])
	            {
	                s=s+"J";
	               
	            }
	            
	            else
	            {
	                if(ar[i]>=ar[i-1])
	                {
	                    if(s.charAt((i/2)-1)=='C')
	                    {
	                        s=s+c;
	                    }
	                    else
	                    {
	                        s=s+j;
	                    }
	                }
	                else if(ar[i]<ar[i-2] && ar[i]>ar[i-3] && ar[i+1]<ar[i-1])
	                {
	                     if(s.charAt((i/2)-1)=='C')
	                    {
	                        s=s+c;
	                    }
	                    else
	                    {
	                        s=s+j;
	                    }
	                }
	                 else if(ar[i]<ar[i-2] && ar[i]>ar[i-3] && ar[i+1]>ar[i-1])
	                {
	                     if(s.charAt((i/2)-1)=='C')
	                    {
	                        s=s+j;
	                    }
	                    else
	                    {
	                        s=s+c;
	                    }
	                }
	                else if(ar[i]<ar[i-2] && ar[i]<ar[i-3] && ar[i]>ar[i-4])
	                {
	                    if(s.charAt((i/2)-1)=='C')
	                    {
	                        s=s+j;
	                    }
	                    else
	                    {
	                        s=s+c;
	                    }
	                    
	                }
	                else if(ar[i]<ar[i-2] && ar[i]<ar[i-3] && ar[i]<ar[i-4])
	                {
	                     if(s.charAt((i/2)-1)=='C')
	                    {
	                        s=s+j;
	                    }
	                    else
	                    {
	                        s=s+c;
	                    }
	                }
	                else if(ar[i]>ar[i-2] && ar[i]<ar[i-1])
	                {
	                        if(ar[i]>ar[i-3] || ar[i]<ar[i-4])
	                        {
	                             if(s.charAt((i/2)-1)=='C')
	                            {
	                            s=s+j;
	                            }
	                            else
	                            {
	                                s=s+c;
	                            }       
	                        }
	                        else
	                        {
	                            System.out.println("Case #" + index +": " + "IMPOSSIBLE");
	                            flag=1;
	                            
	                        }
	                }
	               else if((ar[i]==ar[i-2] && ar[i+1]==ar[i-1]) || (ar[i]==ar[i-4] && ar[i+1]==ar[i-3]))
	               {
	                    if(s.charAt((i/2)-1)=='C')
	                            {
	                            s=s+j;
	                            }
	                            else
	                            {
	                                s=s+c;
	                            }     
	               }
	                
	                
	            }
	            
	        }
	         if(flag==0)
	    {
	        System.out.println("Case #" + index +": " +s);
	    }
	  
	    }
	   
		    
		}
	}


