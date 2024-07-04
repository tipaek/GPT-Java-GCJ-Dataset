

import java.util.*;
class Pair implements Comparable<Pair>{
    int si, ei,ind;
    Pair(int x,int y,int i){
        si=x;
        ei=y;
        ind=i;
    }
    public int compareTo(Pair p){
        return this.ei-p.ei;
    }
    public String toString(){
        return "{"+this.si+":"+this.ei+":"+this.ind+"}";
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
    public static int getIndex(int[] ans,int n){
        for(int i=0;i<n;i++)
        {
            if(ans[i]==0)
            return i;
        }
        return -1;
    }
	public static void main (String[] args) {
	    Scanner s=new Scanner(System.in);
	    int lower=1;
	    int t=s.nextInt();
		while(t--!=0){
		    int n=s.nextInt();
		    Pair[] intervals=new Pair[n];
		    Pair[] intervals_copy=new Pair[n];
		    for(int i=0;i<n;i++){
		        int si=s.nextInt();
		        int ei=s.nextInt();
		        intervals[i]=new Pair(si,ei,i);
		        
		    }
		    intervals_copy=intervals.clone();
		    Arrays.sort(intervals);
		  //  for(int i=0;i<n;i++){
		  //      System.out.println(intervals[i]);
		  //  }
		    int[] ans=new int[n];
		    int prev=0;
		    ans[intervals[prev].ind]=1;
		   
		    for(int i=1;i<n;i++){
		      if((intervals[i].ei<=intervals[prev].si)||(intervals[i].si>=intervals[prev].ei))
		       {
		           ans[intervals[i].ind]=1;
		           prev=i;
		       }
		    }
		    
		    int x=getIndex(ans,n);
		  //  System.out.println(x);
		    if(x==-1){
		        System.out.println("Case #"+lower+": "+getSolution(ans,n));
		        lower++;
		        continue;
		    }
		    else{
		        prev=x;
		        ans[prev]=-1;
		       for(int i=1;i<n;i++){
		        if((ans[intervals[i].ind]==0)&&(intervals[i].ei<=intervals_copy[prev].si||intervals[i].si>=intervals_copy[prev].ei))
		       {
		           ans[intervals[i].ind]=-1;
		           prev=i;
		       }
		      }
		    }
		    x=getIndex(ans,n);
		    
		  //  for(int i=0;i<n;i++){
		  //      System.out.print(ans[i]+" ");
		  //  }
		    if(x==-1){
		        System.out.println("Case #"+lower+": "+getSolution(ans,n));
		    }
		    else{
		        System.out.println("Case #"+lower+": "+"IMPOSSIBLE");
		    }
		    lower++;
		    
		}
	}
}