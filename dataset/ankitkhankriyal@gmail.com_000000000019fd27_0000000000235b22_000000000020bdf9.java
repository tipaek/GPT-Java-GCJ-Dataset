

import java.util.*;
class Pair{
    int si, ei;
    Pair(int x,int y){
        si=x;
        ei=y;
    }
}
public class Solution {
    public static String getSolution(int[] ans,int n){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<n;i++){
            if(ans[i]==-1){
                str.append("C");
            }
            else
            str.append("J");
        }
        return str.toString();
    }
	public static void main (String[] args) {
	    Scanner s=new Scanner(System.in);
	    int t=s.nextInt();
		while(t--!=0){
		    int n=s.nextInt();
		    Pair[] intervals=new Pair[n];
		    for(int i=0;i<n;i++){
		        int si=s.nextInt();
		        int ei=s.nextInt();
		        intervals[i]=new Pair(si,ei);
		    }
		    int[] ans=new int[n];
		    ans[0]=1;
		    int min_si=intervals[0].si;
		    int max_si=intervals[0].ei;
		    for(int i=1;i<n;i++){
		       Pair rp=intervals[i];
		       if(rp.ei<=min_si||rp.si>=max_si)
		       {
		           ans[i]=1;
		       }
		    }
		    
		    int x=-1;
		    for(int i=0;i<n;i++){
		        if(ans[i]==0)
		        {x=i;
		        ans[x]=-1;
		        break;
		        }
		    }
		    
		    if(x==-1){
		        System.out.println(getSolution(ans,n));
		        continue;
		    }
		    else{
		        min_si=intervals[x].si;
		        max_si=intervals[x].ei;
		      for(int i=x+1;i<n;i++){
		       Pair rp=intervals[i];
		       if(ans[i]==0&&(rp.ei<=min_si||rp.si>=max_si))
		       {
		           ans[i]=-1;
		       }
		      }
		    }
		    boolean flag=true;
		    for(int i=0;i<n;i++){
		        if(ans[i]==0){
		            flag=false;
		        }
		    }
		    if(flag){
		        System.out.println(getSolution(ans,n));
		    }
		    else{
		        System.out.println("IMPOSSIBLE");
		    }
		    
		}
	}
}