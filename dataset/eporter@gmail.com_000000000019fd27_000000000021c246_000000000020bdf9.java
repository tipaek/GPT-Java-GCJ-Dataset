import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    final Scanner in;

	public static void main(String [] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
        Solution.run(scanner);
		scanner.close();
	}
    
    public static void run(Scanner in) {
        int cases = in.nextInt();
        for (int cs = 1; cs <= cases; cs++) {
            new Solution(in).runCase(cs);
        }
    }
	
	public Solution(Scanner in) {
	    this.in = in;
	}
	
	private void runCase(int cs) {
	    int n = in.nextInt();
	    List<Act> acts = new ArrayList<>(n*2);
	    for (int i = 0; i < n; i++) {
	        int s = in.nextInt();
	        int e = in.nextInt();
            acts.add(new Act(i, s, true));
            acts.add(new Act(i, e, false));
	    }
	    Collections.sort(acts);
	    char[] w = new char[n];
	    
	    boolean cFree = true, jFree = true;
	    boolean impossible = false;
	    for (Act a : acts) {
	        //System.out.println(a);
	        if (a.start) {
	            if (cFree) {
	                w[a.evt] = 'C';
	                cFree = false;
	            } else if (jFree) {
	                w[a.evt] = 'J';
	                jFree = false;
	            } else {
	                impossible = true;
                    break;
	            }
	        } else {
	            if (w[a.evt] == 'C') {
	                cFree = true;
	            } else {
	                jFree = true;
	            }
	        }
	    }
	    String ans = impossible ? "IMPOSSIBLE" : new String(w);
        println(String.format("Case #%s: %s", cs, ans));
	}
	
	private static class Act implements Comparable<Act> {
	    int evt;
	    int t;
	    boolean start;
	    
        public Act(int evt, int t, boolean start) {
            this.evt = evt;
            this.t = t;
            this.start = start;
        }

        @Override
        public int compareTo(Act o) {
            if (t != o.t) {
                return t - o.t;
            }
            if (start && !o.start) {
                return 1;
            }
            if (!start && o.start) {
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "Act [evt=" + evt + ", t=" + t + ", start=" + start + "]";
        }
	}
    
    private static void println(String s) {
        System.out.println(s);
        System.out.flush();
    }
}