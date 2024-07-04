
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution{
	public static void main(String[] args) {
	Scanner o=new Scanner(System.in);
	   int test=o.nextInt();
	   int m=1;
	   while(m<=test){
	     String s=o.next();
	     String e="";
	     int ar[]=new int[s.length()+2];
	     ar[0]=0;
	     ar[s.length()+1]=0;
	     for(int i=0;i<s.length();i++) {
	    	 ar[i+1]=Character.getNumericValue(s.charAt(i));
	     }
	     int count=0;
	     Stack<String>st=new Stack<>();
	     for(int i=1;i<=s.length()+1;i++) {
	    	int val=ar[i]-ar[i-1];
	    	 if(val==0) {
	    		 st.push(ar[i]+"");
	    	 }
	    	 if(ar[i]-ar[i-1]>0) {
	    		while(val!=0) {
	    			st.push("(");
	   	    	 	val--;
	    		}
	    		st.push(ar[i]+"");
	    		}
	    	 if(val<0) {
	    		 while(val!=0) {
	    			 st.push(")");
	    			 val++;
	    		 }
	    		 st.push(ar[i]+"");
	    	 }
	     }
	     
	     while(!st.isEmpty()) {
	    e=st.pop()+e;	 
	     }
	     String t=e.substring(0,e.length()-1);
	     System.out.println("Case #"+m+": "+t);
	     m++;
	     
}
}
}
