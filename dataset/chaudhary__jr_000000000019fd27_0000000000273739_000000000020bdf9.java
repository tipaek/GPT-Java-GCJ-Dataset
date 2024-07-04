
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static class Activity implements Comparable<Activity>{
    		public int start;
    		public int end;
    		public char c;
    		public Activity(int start,int end) {
    			this.start=start;
    			this.end=end;
    		}
			@Override
			public String toString() {
				return "Activity [start=" + start + ", end=" + end + ", c=" + c + "]";
			}
			@Override
			public int compareTo(Activity that) {
				return this.start-that.start;
			}
    		
    	}
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        char last=' ';
        for (int p = 1; p <= t; ++p) {
        	int n = in.nextInt();
        	int james=0,cameron=0;
        	ArrayList<Activity> al=new ArrayList<Activity>(n);
        	PriorityQueue<Activity> pq=new PriorityQueue<Activity>(n);
        	for(int i=0;i<n;i++) {
        		Activity activity=new Activity(in.nextInt(),in.nextInt());
        		al.add(activity);
        		pq.add(activity);
        	}
        	boolean flag=false;
        	while(!pq.isEmpty()) {
        	    Activity curr=pq.poll();
        	    if(curr!=null){
        	    	if(last=='J') {
        	    		if(curr.start >= cameron){
            	            curr.c='C';
            	            cameron=curr.end;
            	        }
            	        else if(curr.start >= james){
            	            curr.c='J';
            	            james=curr.end;
            	        }
            	        else{
            	            flag=true;
            	        }
        	    	}else {
            	        if(curr.start >= james){
            	            curr.c='J';
            	            james=curr.end;
            	        }else if(curr.start >= cameron){
            	            curr.c='C';
            	            cameron=curr.end;
            	        }else{
            	            flag=true;
            	        }

        	    	}
        	    }
        	}
        	if(flag){
        	    System.out.println("Case #" + p + ": "+"IMPOSSIBLE");
        	    flag=false;
        	}
        	else{
        	    StringBuilder sb=new StringBuilder("");
        	    for(Activity activity:al) {
        	    	sb.append(activity.c);
        	    }
        	    last=sb.charAt(sb.length()-1);
        	    System.out.println("Case #" + p + ": "+new String(sb));
        	}
        	al.clear();
        	
        }
      }

}