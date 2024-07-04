import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Scanner;


public class Solution{

    private class Interval{
        public Integer start;
        public Integer end;
        public Integer index;
        public char assignment;
        public Interval(int i, int s, int e){
            start = s;
            end = e;
            index = i;
        }
    }

	int caseNumber = 0;
	static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args){

    	Solution sol = new Solution();
        
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++){
        	sol.caseNumber = i;
            
        	int n = sc.nextInt();
        	ArrayList<Interval> intervals = new ArrayList<Interval>();
        	for (int j = 0; j < n; j++){
        	    intervals.add(sol.new Interval(j, sc.nextInt(), sc.nextInt()));
        	}
        	
            sol.solve( intervals   );
        }
        
        sc.close();
    }
    
    public Solution() {
    	
    }
    
    public void solve(  ArrayList<Interval> intervals  ){

    	int jBusy = 0;
    	int cBusy = 0;
        Collections.sort(intervals, (a, b) -> a.start.compareTo(b.start));

        String output = "";
        for (Interval i : intervals) {
        	if (jBusy <= i.start) {
        		jBusy = i.end;
        		i.assignment += 'J';
        	} else if (cBusy <= i.start) {
        		cBusy = i.end;
        		i.assignment += 'C';
        	} else {
                System.out.println("Case #" + caseNumber + ": "  + "IMPOSSIBLE"  );
                return;
        	}
        	
        }
        Collections.sort(intervals, (a, b) -> a.index.compareTo(b.index));
        for (Interval i : intervals) {
        	output += i.assignment;
        }
        System.out.println("Case #" + caseNumber + ": "  + output  );
    }
}