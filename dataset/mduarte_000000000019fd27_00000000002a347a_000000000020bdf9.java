import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static Map<String, Integer> map; 
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int testCase = 1; testCase <= t; ++testCase) {
			int num = in.nextInt();
			int[][] activities = new int[num][2];
			map = new HashMap<String,Integer>(); 
			for (int i = 0 ; i < num; i++) {
				activities[i][0] = in.nextInt();
				activities[i][1] = in.nextInt();
				map.put(activities[i][0] + "#" + activities[i][1], i);
			}
			Solution s = new Solution();
			String ans = s.test(activities);
			
			System.out.println("Case #" + testCase + ": " + ans);
		}
		in.close();

	}
	
	class Pair  {
		int[] interval;
		char person;
		Pair(int[] interval, char person) {
			this.interval = interval;
			this.person = person;
		}
	}
	
    public String test(int[][] intervals) {
    	char[] ans = new char[intervals.length];
    	
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        Queue<Pair> queue = new PriorityQueue<Pair>(2, new Comparator<Pair>() {
        	public int compare(Pair obj1, Pair obj2) {
        		return Integer.compare(obj1.interval[1], obj2.interval[1]);
        	}
        });
        
        char next = 'J';
        for (int[] interval : intervals) {
        	next = next == 'J'?'C':'J';
            if (!queue.isEmpty() && interval[0] >= queue.peek().interval[1]) {
                Pair p = queue.poll();
                next = p.person;
            }
            queue.add(new Pair(interval, next));
            ans[map.get(interval[0] + "#" + interval[1])] = next;
            if (queue.size() > 2) {
            	return "IMPOSSIBLE";
            }
        }
        
        return new String(ans);
        
    }
	
	
}
