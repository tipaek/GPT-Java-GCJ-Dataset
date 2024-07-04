import java.util.*;
import java.io.*;
 
class Solution {
	static class P {
		public StringBuilder ans;
		public long x, y;
		
		public P(long x, long y, StringBuilder ans) {
			this.x = x;
			this.y = y;
			this.ans = ans;
		}
	}
	
    public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int t = 1; t <= T; ++t) {
 
			long x = in.nextInt();
			long y = in.nextInt();
			
			if(Math.abs(x) == Math.abs(y)) {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
				continue;
			}
			
			String ans = new String();
			int jumps = 0;
			
			long x1 = Math.abs(x), y1 = Math.abs(y);
			//System.out.println(x1 + " " + y1);
			while((x1 > 0) && (y1 > 0)) {
				if((x1 & 1) == 1) {
					jumps += 1;
				}
				
				if((y1 & 1) == 1) {
					jumps += 1;
				}
				
				x1 >>= 1;
				y1 >>= 1;
			}
			
			while(x1 > 0) {
				if((x1 & 1) == 1) {
					jumps += 1;
				}
				x1 >>= 1;
			}
			
			while(y1 > 0) {
				if((y1 & 1) == 1) {
					jumps += 1;
				}
				y1 >>= 1;
			}
			
			Queue<P> bfs = new LinkedList<>();
			bfs.add(new P(0, 0, new StringBuilder()));
			bfs.add(new P(-1, -1, new StringBuilder()));
			
			long curr = 1;
			int k = 0;
			while((k < jumps) && (!bfs.isEmpty())) {
				P p = bfs.poll();
				//System.out.println(p.x + " " + p.y + " " + p.ans.toString());
				if((p.x == -1) && (p.y == -1) && (p.ans.toString().isEmpty())) {
					bfs.add(new P(-1, -1, new StringBuilder()));
					k++;
					curr <<= 1;
					//System.out.println(k + " " + curr);
					continue;
				}
				
				if((p.x - curr) >= -1000000000)
					bfs.add(new P(p.x - curr, p.y, new StringBuilder(p.ans).append("W")));
				if((p.x + curr) <= 1000000000)
					bfs.add(new P(p.x + curr, p.y, new StringBuilder(p.ans).append("E")));
				if((p.y - curr) >= -1000000000)
					bfs.add(new P(p.x, p.y - curr, new StringBuilder(p.ans).append("S")));
				if((p.y + curr) <= 1000000000)
					bfs.add(new P(p.x, p.y + curr, new StringBuilder(p.ans).append("N")));
				//System.out.println(bfs.size());
			}
			
			boolean impossible = true;
			
			while(!bfs.isEmpty()) {
				P p = bfs.poll();
				//System.out.println(p.x + " " + p.y + " " + p.ans.toString()); 
				if((p.x == x) && (p.y == y)) {
					impossible = false;
					ans = p.ans.toString();
					break;
				}
			}
			
			if(impossible) {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + t + ": " + ans);
			}
		}
    }
}