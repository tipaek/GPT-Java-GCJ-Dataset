
import java.io.*;
import java.lang.*;
import java.util.*;
public class Solution
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int i,j,k,n,m,p,s,t,y;
	    t=sc.nextInt();
	    String st="",w="";
	    for(i=0;i<t;i++)
	    { w=sc.next();
	    n=w.length();
	    st="";
	      k=-1;
	      int cur=0;
	        for(j=0;j<n;j++)
	        {  char ch=w.charAt(j);
	        String q=w.substring(j,j+1);
	            m=ch-48;
	          if(m==k)
	            st=st+q;
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
