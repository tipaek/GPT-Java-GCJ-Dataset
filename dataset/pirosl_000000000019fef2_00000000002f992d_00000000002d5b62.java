import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
          int x = in.nextInt();
          int y = in.nextInt();
          
          process(i, x, y);
        }
	}
	
	static void process(int i, int x, int y) {
		if (Math.abs(x % 2) == 1 && Math.abs(y % 2) == 1) {
			System.out.println("Case #" + i + ": IMPOSSIBLE");
			return;
		}
		
		Queue<String> moves = new LinkedList<>();
		Queue<Long> xq = new LinkedList<>();
		Queue<Long> yq = new LinkedList<>();
		Queue<Long> p = new LinkedList<>();
		
		moves.add("");
		xq.add(0L);
		yq.add(0L);
		p.add(1L);
		
		while (!p.isEmpty()) {
			String s = moves.poll();
			long xc = xq.poll();
			long yc = yq.poll();
			long pc = p.poll();
			
			if (xc == x && yc == y) {
				System.out.println("Case #" + i + ": " + s);
				return;
			}
			
			if (xc + pc <= Integer.MAX_VALUE) {
				moves.add(s + "E");
				xq.add(xc + pc);
				yq.add(yc);
				p.add(pc * 2);
			}
			
			if (xc - pc >= Integer.MIN_VALUE) {
				moves.add(s + "W");
				xq.add(xc - pc);
				yq.add(yc);
				p.add(pc * 2);
			}
			
			if (yc + pc <= Integer.MAX_VALUE) {
				moves.add(s + "N");
				xq.add(xc);
				yq.add(yc + pc);
				p.add(pc * 2);
			}
			
			if (yc - pc >= Integer.MIN_VALUE) {
				moves.add(s + "S");
				xq.add(xc);
				yq.add(yc - pc);
				p.add(pc * 2);
			}
			
			if (pc * 2 >= Integer.MAX_VALUE) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
				return;
			}
		}
		
		
		System.out.println("Case #" + i + ": IMPOSSIBLE");
	}

}
