import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Solution {
	static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
    public static void main (String [] args) throws IOException {
	    int T = Integer.parseInt(f.readLine());
	    for(int t = 1; t <= T; t++) {
	    	out.println("Case #" + t + ": " + solve());
	    }
	    
	    out.close();
	    f.close();
	}
	
	public static String solve() throws IOException {
		int N = Integer.parseInt(f.readLine());
		PriorityQueue<tup> pq = new PriorityQueue<tup>(new tup());
		int id = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			pq.add(new tup(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), id++));
		}
		
		StringBuilder sb = new StringBuilder("");
		for(int i = 0; i < id; i++)
			sb.append('t');
		
		int cEnd = 0, jEnd = 0;
		
		for(int i = 0; i <= 24*60; i++) {
			if(pq.size() == 0)
				break;
			if(pq.peek().a >= cEnd) {
				cEnd = pq.peek().b;
				sb.setCharAt(pq.poll().ind, 'C');
			} else if (pq.peek().a >= jEnd) {
				jEnd = pq.peek().b;
				sb.setCharAt(pq.poll().ind, 'J');
			} else {
				return "IMPOSSIBLE";
			}
		}
		return sb.toString();
	}
	
	static class tup implements Comparator<tup> {
        int a, b, ind;
 
        tup() {
        }
 
        tup(int a, int b, int i) {
            this.a = a;
            this.b = b;
            ind = i;
        }
        
        @Override
        public int compare(tup o1, tup o2) {
            return o1.a==o2.a?Integer.compare(o1.b,o2.b):Integer.compare(o1.a, o2.a);
        }
    }
}