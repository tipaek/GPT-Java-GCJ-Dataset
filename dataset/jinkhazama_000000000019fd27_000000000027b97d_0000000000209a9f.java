/*package whatever //do not write package name here */


import java.util.*;
class Solution {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int q=1;q<=t;q++){
		   String s=sc.next();
		   int l=s.length();
		   int w=0;
		   String res="";
		   for(int i=0;i<l;i++){
		       int ch=s.charAt(i);
		      // String st=ch+"";
		       int x=(int)ch;
		       x=Math.abs(48-x);
		       //System.out.println("no is"+x);
		       if(x>w){
		          int p=x-w;
		          w=w+p;
		          res=res+get(p,"open")+s.charAt(i);
		       }
		       else if(x<w){
		           int p=w-x;
		           w=w-p;
		           res=res+get(p,"close")+s.charAt(i);
		       }
		       else{
		           res=res+s.charAt(i);
		       }
		   }
		   res=res+get(w,"close");
		    System.out.println("Case #"+q+":"+" "+res);
		}
	}
	static String get(int n, String want){
	    String ret="";
	    if(want.equals("open")){
	        for(int i=0;i<n;i++){
	            ret=ret+'(';
	        }
	    }
	    else{
	        for(int i=0;i<n;i++){
	            ret=ret+')';
	        }
	    }
	    
	    return ret;
	}
}