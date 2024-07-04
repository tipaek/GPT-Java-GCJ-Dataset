import java.util.*;
import java.io.*;
    
class Solution {
    private static class Node {
		int start;
		int end;
		int position;
		Character ch;
		
		public Node(int start, int end, int position, Character ch) {
			this.start = start;
			this.end = end;
			this.position = position;
			this.ch = ch;
		}
	}
	
	private static class IntervalComparator implements Comparator<Node> {
    	@Override
    	public int compare(Node a, Node b) {
    		return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
    	}
	}
	
	private static class PositionComparator implements Comparator<Node> {
    	@Override
    	public int compare(Node a, Node b) {
    		return a.position < b.position ? -1 : a.position == b.position ? 0 : 1;
    	}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            
            List<Node> intervals = new ArrayList<>();
            
            for(int j=0; j<n; j++) {
            	intervals.add(new Node(in.nextInt(), in.nextInt(), j, ' '));
            }
            
            Collections.sort(intervals, new IntervalComparator());
            
            int j = 0, c = 0;
            boolean notPossible = false;
            List<Node> result = new ArrayList<>();
            
            for(Node interval: intervals) {
            	if((c == 0) || (c <= interval.start)) {
            		c = interval.end;
            		result.add(new Node(0, 0, interval.position, 'C'));
            	} else if((j == 0) || (j <= interval.start)) {
            		j = interval.end;
            		result.add(new Node(0, 0, interval.position, 'J'));
            	} else {
            		notPossible = true;	
            		break;
            	}
            }
            
            if(notPossible) {
	            System.out.println("Case #"+ i + ": IMPOSSIBLE");
            } else {
            	Collections.sort(result, new PositionComparator());
            	StringBuilder res = new StringBuilder();
            	
            	for(Node item: result) {
            		res.append(item.ch);
            	}
            	
            	System.out.println("Case #"+ i + ": " + res.toString());
            }
		}
	}
}