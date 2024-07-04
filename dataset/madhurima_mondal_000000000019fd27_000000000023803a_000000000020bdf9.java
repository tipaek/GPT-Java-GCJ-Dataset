import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution{

private String findParentingPattern(int[][] intervals) {
	StringBuilder res = new StringBuilder();
	//sort by start time
	Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
	if(intervals.length==0)
		return "";
	char currParent = 'C';
	int cs= -1, ce=-1,js=-1,je=-1;
	
	
	for(int[] interval: intervals) {
		int start = interval[0];
		int end = interval[1];
		
			if(ce<=start) {
				currParent = 'C';
				res.append(currParent);
				cs= start;
				ce= end;
			}
			else if(je<=start) {
				currParent = 'J';
				res.append(currParent);
				js= start;
				je=end;
			}
			else {
				res = new StringBuilder("IMPOSSIBLE");
				break;
			}
	}
	
	return res.toString();
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
	    System.out.println("Case #"+i+": "+sol.findParentingPattern(interval));
		
	}
	sc.close();
			
    }
}