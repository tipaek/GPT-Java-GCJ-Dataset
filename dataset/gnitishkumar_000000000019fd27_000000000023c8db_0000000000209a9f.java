/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.io.*;
import java.lang.*;
import java.util.*;
public class Solution
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int i,j,k,n,m,p,s,t,y,cur;
	    t=sc.nextInt();
	    String st="",w="",q="";
	    for(i=0;i<t;i++)
	    { w=sc.next();
	    n=w.length();
	    st="";
	      k=-99;
	      cur=0;
	        for(j=0;j<n;j++)
	        {  
	           q=w.substring(j,j+1);
	            m=w.charAt(j)-48;
	          if(m==k)
	            st+=q;
	            else
	            { if(j==0)
	              { for(y=0;y<m;y++)
	                  st+="(";
	                  st+=q;
	                  cur+=m;
	              }
	                else
	                {  if(cur==m)
	                  { st+=q;
	                   }
	                    else if(cur>m)
	                    { int d=cur-m;
	                      while(d>0)
	                      { st+=")";
	                          d--;
	                          cur--;
	                      }
	                        st+=q;
	                    }
	                    else
	                    { int d=m-cur;
	                      while(d>0)
	                      { st+="(";
	                          d--;
	                          cur++;
	                      }
	                        st+=q;
	                        
	                    }
	                }
	                k=m;
	            }
	            
	        }
	        while(cur>0)
	        { st+=")";
	            cur--;
	        }
	        System.out.println("Case #"+(i+1)+": "+st);
	    }
		
	}
}
