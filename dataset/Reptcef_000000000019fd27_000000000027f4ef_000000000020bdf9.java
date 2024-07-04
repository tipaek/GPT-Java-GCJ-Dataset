import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {
	
	static final boolean DEBUG = false;
	static final boolean SUBMIT = false;
	static final String NAME = "parentingpartneringreturns";
	
	static InputReader in;
	static PrintWriter out;
	
	static final String INVALID = "IMPOSSIBLE";
	
	static class InputReader {
	    public BufferedReader reader;
	    public StringTokenizer tokenizer;

	    public InputReader(InputStream stream) {
	      reader = new BufferedReader(new InputStreamReader(stream), 32768);
	      tokenizer = null;
	    }

	    public String next() {
	      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	        try {
	          tokenizer = new StringTokenizer(reader.readLine());
	        } catch (IOException e) {
	          throw new RuntimeException(e);
	        }
	      }
	      return tokenizer.nextToken();
	    }

	    public int nextInt() {
	      return Integer.parseInt(next());
	    }
  	}
	
	public static void main(String[] args) throws IOException {
		if (SUBMIT) {
			in = new InputReader(new FileInputStream(new File(NAME + ".txt")));
			out = new PrintWriter(new BufferedWriter(new FileWriter(NAME + "_output.txt")));
	    } else {
	    	in = new InputReader(System.in);
	    	out = new PrintWriter(System.out, true);
	    }
		int t = in.nextInt();
	    for (int i = 0; i < t; i++) {
	    	int n = in.nextInt();
	    	if (DEBUG) {
				System.out.println("n: " + n);
			}
	    	TreeMap<Integer, Activity> map = new TreeMap(new ActivityComparator());
	    	Activity[] array = new Activity[n];
	    	for (int j = 0; j < n; j++) {
	    		int s = in.nextInt();
	    		int e = in.nextInt();
	    		if (DEBUG) {
					System.out.println("s: " + s + ", e: " + e);
				}
	    		Activity a = new Activity();
	    		a.startTime = s;
	    		a.endTime = e;
	    		
	    		map.put(s, a);
	    		array[j] = a;
	    	}
	    	if (DEBUG) {
				Map.Entry<Integer, Activity> iterator = map.pollFirstEntry();
				while (iterator != null) {
					System.out.println(iterator.getValue().startTime);
					iterator = map.pollFirstEntry();
				}
			}
	        boolean possible = solveCase(map);

			out.println(String.format("Case #%d: %s", i + 1, printSolution(possible, array)));
	    }
	}
	
	static boolean solveCase(TreeMap<Integer, Activity> map) {
		int minC = 0, minJ = 0;
		Map.Entry<Integer, Activity> iterator = map.pollFirstEntry();
		while (iterator != null) {
			if (iterator.getKey() < Math.min(minC, minJ)) {
				return false;
			}
			iterator.getValue().assignedToC = minJ >= minC;
			if (iterator.getValue().assignedToC) {
				minC = iterator.getValue().endTime;
			} else {
				minJ = iterator.getValue().endTime;
			}
			
			iterator = map.pollFirstEntry();
		}
		
		return true;
	}
	
	static String printSolution(boolean possible, Activity[] array) {
		if (possible) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < array.length; i++) {
				sb.append(array[i].assignedToC ? 'C' : 'J');
			}
			return sb.toString();
		} else {
			return INVALID;
		}
	}
	
	static class Activity {
		int startTime;
		int endTime;
		boolean assignedToC;
	}
	
	static class ActivityComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return Integer.compare(o1, o2);
		}
		
	}

}
