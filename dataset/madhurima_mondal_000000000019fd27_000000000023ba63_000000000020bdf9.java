import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Solution{
	
class Activity{
	int start;
	int end;
	int index;
	public Activity(int start, int end, int index) {
		this.start = start;
		this.end= end;
		this.index= index;
	}
}
class ActivityComparator implements Comparator<Activity>{ 
    public int compare(Activity a1, Activity a2) { 
        if (a1.start > a2.start) 
            return 1; 
        else if (a1.start < a2.start) 
            return -1; 
        return 0; 
        } 
} 
private String findParentingPattern(int[][] intervals, int n) {
	StringBuilder resStr = new StringBuilder();
	char[] res = new char[n];
	//sort by start time
	PriorityQueue<Activity> pq = new PriorityQueue<>(new ActivityComparator()); 
	for(int i = 0;i<n;i++) {
	    Activity activity = new Activity(intervals[i][0],intervals[i][1],i);
	    pq.add(activity);
	}
	if(intervals.length==0)
		return "";
	char currParent = 'C';
	int cs= -1, ce=-1,js=-1,je=-1;
	
	while(!pq.isEmpty()) {
		Activity currActivity = pq.remove();
		int start = currActivity.start;
		int end = currActivity.end;
		int index = currActivity.index;
		if(ce<=start) {
			currParent = 'C';
			res[index] = currParent;
			cs= start;
			ce= end;
		}
		else if(je<=start) {
			currParent = 'J';
			res[index] = currParent;
			js= start;
			je=end;
		}
		else {
			return "IMPOSSIBLE";
		}
	}
	for(char c: res) {
		resStr.append(c);
	}
	
	return resStr.toString();
}
public static void main(String args[]){
	Solution sol = new Solution();
	Scanner  sc = new Scanner(System.in);
	int t = sc.nextInt();
	for(int i=1;i<=t;i++) {
		
	    int n = sc.nextInt();
	    int[][] interval = new int[n][2];
	    for(int r=0;r<n;r++){
	    	interval[r][0] = sc.nextInt();
	    	interval[r][1] = sc.nextInt();
	    }  
	    System.out.println("Case #"+i+": "+sol.findParentingPattern(interval,n));
		
	}
	sc.close();
			
    }
}