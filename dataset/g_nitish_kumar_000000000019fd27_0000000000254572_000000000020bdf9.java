
import java.io.*;
import java.lang.*;
import java.util.*;
public class Solution
{       
    static boolean give(boolean used[],String st)
    {  if(used[0]&&used[1])
	           return false;
	           else if(!used[0]&&!used[1])
	           { st+="C";
	               used[0]=true;
	           }
	           else if(used[0]==true&&used[1]==false)
	           { used[1]=true;
	               st+="J";
	           }
	           else
	           { used[0]=true;
	               st+="C";
	           }
        return true;
    }
    static void free(boolean used[])
    {       if(used[0]&&used[1])
	           used[0]=false;
	           else if(!used[0]&&!used[1])
	           { 
	            //used[0]=true;
	           }
	           else if(used[0]==true&&used[1]==false)
	           { used[0]=false;
	               
	           }
	           else
	           { used[1]=false;
	               
	           }
        
    }
    static boolean check(int d[],int ind,int val)
    { int i,j;
     for(i=0;i<ind;i++)
     { if(d[i]>=0&&d[i]>val)
     continue;
     else
     { d[i]=-1;
         return false;
     }
         
     }
     return true;
        
    }
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int i,j,k,n,m,p,s,t,y;
	    t=sc.nextInt();
	    String st="",w="";
	    for(i=0;i<t;i++)
	    { n=sc.nextInt();
	      int a[]=new int[n];
	      int d[]=new int[n];
	      for(j=0;j<n;j++)
	      {  a[j]=sc.nextInt();
	         d[j]=sc.nextInt();
	      }
	              Arrays.sort(a);
	              Arrays.sort(d);
	              st="";
	          boolean used[]=new boolean[2];
	          int ar=0,dr=0;
	       for(j=0;j<n;j++)
	       {  
	            ar=a[j];
	               dr=d[j];
	          
	        if(check(d,j,ar));
	        else
	           free(used);
	           
	           /*if(!give(used,st))
	           break;*/
	           if(used[0]&&used[1])
	           break;
	           else if(!used[0]&&!used[1])
	           { st+="C";
	               used[0]=true;
	           }
	           else if(used[0]==true&&used[1]==false)
	           { used[1]=true;
	               st+="J";
	           }
	           else
	           { used[0]=true;
	               st+="C";
	           }
	       }
	       if(j==n)
	        System.out.println("Case #"+(i+1)+": "+st);
	        else
	        System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
	    }
		
	}
}
