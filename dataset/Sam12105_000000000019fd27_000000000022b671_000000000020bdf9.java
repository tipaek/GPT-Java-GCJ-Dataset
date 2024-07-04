/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.util.HashMap; 
import java.util.Map;

public class Solution {
	public static void main (String[] args) {
	    int flag=1;
	    Scanner sc = new Scanner(System.in); 
	    int t=sc.nextInt();
	    while(t!=0)
	    {
	        int n=sc.nextInt();
	        int[] start=new int[n];
	        int[] finish=new int[n];
	        for(int i=0;i<n;i++)
	        {
	            start[i]=sc.nextInt();
	            finish[i]=sc.nextInt();
	        }
	        String s;
	        char[] ch=new char[n];
	        int cc=-1,jj=-1;
	        int flag1=0;
	        for(int i=0;i<n;i++)
	        {
	            if(i==0)
	            {
	                ch[i]='c';
	                cc=i;
	                continue;
	            }
	            if(finish[i-1]<=start[i] )
	            {
	                if (cc>-1)
	                {
	                    if(jj>-1)
	                    {
	                   
	                        if (finish[cc]<=start[i])
	                        {   
	                            cc=i;
	                            ch[i]='c';
	                        }
	                        else if(finish[jj]<=start[i]) 
	                        {
	                            jj=i;
	                            ch[i]='j';
	                        }
	                        else
	                        {
	                            flag1=1;
	                            s="impossible";
	                            break;
	                        }
	                        
	                    }
	                    else 
	                    {
	                        
	                            ch[i]='j';
	                            jj=i;
	                        
	               
	                    }
	                }
	            }
	            else 
	            {
	                if (cc>-1)
	                {
	                    if(jj>-1)
	                    {
	                   
	                        if ((finish[cc]<=start[i])||((start[jj]>=start[i]) &&(start[jj]>=finish[i])))
	                        {   
	                            cc=i;
	                            ch[i]='c';
	                        }
	                        else if((finish[jj]<=start[i])) 
	                        {
	                            jj=i;
	                            ch[i]='j';
	                        }
	                        else
	                        {
	                           s="impossible";
	                           flag1=1;
	                           break;
	                        }
	                        
	                    }
	                    else 
	                    {
	                        
	                            ch[i]='j';
	                            jj=i;

	                                                
	               
	                    }
	                }
	            }
	        }
	        if(flag1==0)
	      System.out.println("Case #"+flag+": "+String.valueOf(ch));
	      else
	      System.out.println("Case #"+flag+": "+"IMPOSSIBLE");
	      t--;  
	        flag++;
	    }
	    
	    
	        
	    
	}
}