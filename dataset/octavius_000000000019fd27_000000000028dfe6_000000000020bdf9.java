
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
class Time implements Comparable<Time>{
	int start;
	 int end;
	int index;
	 Time(int s,int e,int i){
		this.start=s;
		this.end=e;
		this.index=i;
	}
	@Override
	public int compareTo(Time o) {
		if(this.start>o.start) {
			return 1;
		}
		else if(this.start<o.start) {
			return -1;
		}
		else
			return 0;
}
}
public class Solution {
	public static void main(String[] args) {
	Scanner o=new Scanner(System.in);
	   int test=o.nextInt();
	   int m=1;
	   while(m<=test){
	     int n=o.nextInt();
	     ArrayList<Time>list=new ArrayList<Time>();
	     for(int i=0;i<n;i++) {
	    	 int start=o.nextInt();
	    	 int end=o.nextInt();
	    	 list.add(new Time(start,end,i));
	     }
	     char ch[]=new char[n];
	     Collections.sort(list);
	     int a=0;
	     int b=0;
	     int i=0;
	     for(i=0;i<list.size();i++) {
	    	 if(a<=list.get(i).start) {
	    		 ch[list.get(i).index]='C';
	    		 a=list.get(i).end;
	    	 }
	    	 else if(b<=list.get(i).start){
	    		 ch[list.get(i).index]='J';
	    		 b=list.get(i).end;
	    		 }
	    	 else {
	    		 break;
	    	 }
	     }
	     System.out.print("Case #"+m+": ");
	     if(i!=list.size()) {
	    	 System.out.print("IMPOSSIBLE");
	     }
	     else {
	    	 for(int k=0;k<ch.length;k++) {
	    		 System.out.print(ch[k]);
	    	 }
	     }
	     System.out.println();
		  m++;
	   }
}
}
