/*package whatever //do not write package name here */

import java.util.*;

 class Task{
        int st,et,i;
        char p;
        Task(int st,int et,int i){
            this.st=st;
            this.et=et;
            this.i=i;
        }
    }
    
class Solution {
   
	public static void main (String[] args) {
	    Scanner in=new Scanner(System.in);
	    int t=in.nextInt();
	    for(int p=0;p<t;p++)
	    {
	        int n=in.nextInt();
	        ArrayList<Task> al=new  ArrayList<Task>();
	        for(int i=0;i<n;i++)
	            {
	                int st=in.nextInt();
	                int et=in.nextInt();
	                al.add(new Task(st,et,i));
	            }
	        
	        solve(al,p);
	    }
	}
	
	static void solve(ArrayList<Task> al,int p){
	    Collections.sort(al,new Comparator<Task>(){
	        public int compare(Task a,Task b)
	        {
	            return a.st-b.st;
	        }
	    });
	    int j=0,c=0;
	    for(Task a:al)
	    {
	        int f=0;
	        if(a.st<j && a.st<c)
	            {
	                System.out.println("Case #"+(p+1)+": IMPOSSIBLE");
	                return;
	            }
	        if(a.st>=c)
	            {f=1;
	             a.p='C'; c=a.et;}
	        else
	            {if(f!=1){a.p='J'; j=a.et;}}

	       // System.out.println(a.p+" "+j+" "+c);
	            
	    }
	     Collections.sort(al,new Comparator<Task>(){
	        public int compare(Task a,Task b)
	        {
	            return a.i-b.i;
	        }
	    });
	    String ans="";
	    for(Task a:al)
	        ans+=a.p;
	    System.out.println("Case #"+(p+1)+": "+ans);
	}
	
}