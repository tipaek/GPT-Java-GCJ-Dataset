import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Solution {

	int[] DY = {1, 0, -1, 0};
	int[] DX = {0, 1, 0, -1};
	String[] DS = {"N", "E", "S", "W"};
	
	String fnc(int x, int y) {
		if (Math.abs(x) % 2 + Math.abs(y) % 2 != 1) {
			return "IMPOSSIBLE";
		}
		
		List<Integer> qy = new ArrayList<Integer>();
		List<Integer> qx = new ArrayList<Integer>();
		List<String> qs = new ArrayList<String>();
		
		List<Integer> qqy = new ArrayList<Integer>();
		List<Integer> qqx = new ArrayList<Integer>();
		List<String> qqs = new ArrayList<String>();
		
		qy.add(0);
		qx.add(0);
		qs.add("");
		
		for (int d=0;;d++) {
			int dd = (int) Math.pow(2, d);
			for (int i=0;i<qy.size();i++) {
				int py = qy.get(i);
				int px = qx.get(i);
				String ps = qs.get(i);
				
				for (int k=0;k<4;k++) {
					int ny = py + DY[k] * dd;
					int nx = px + DX[k] * dd;
					String ns = ps + DS[k];
					
					if (ny == y && nx == x) {
						return ns;
					}
							
					qqy.add(ny);
					qqx.add(nx);
					qqs.add(ns);
				}
			}	
			
			qy.clear();
			qx.clear();
			qs.clear();
			
			qy.addAll(qqy);
			qx.addAll(qqx);
			qs.addAll(qqs);
			
			qqy.clear();
			qqx.clear();
			qqs.clear();
		}
	}

	void run() {
		try (Scanner sc = new Scanner(System.in)) {
			int testNum = sc.nextInt();
			for (int t = 1; t <= testNum; t++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				System.out.println("Case #" + t + ": " + fnc(x, y));
			}
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}
}
