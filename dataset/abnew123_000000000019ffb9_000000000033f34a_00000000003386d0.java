import java.util.*;
import java.io.*;

public class WormholeInOne {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[] xs = new int[n];
			int[] ys = new int[n];
			for (int j = 0; j < n; j++) {
				xs[j] = in.nextInt();
				ys[j] = in.nextInt();
			}
			int ans = 0;
			if (n <= 4) {
				ans = n;
			}
			if(n == 5 || n == 6) {
				ans = 4;
				for(int j = 0; j < xs.length - 1; j++) {
					for(int k = j + 1; k < xs.length; k++) {
						int xdelta = xs[j] - xs[k];
						int ydelta = ys[j] - ys[k];
						for(int l = 0; l < xs.length; l++) {
							if(l != j && l != k) {
								if(collinear(xs, ys, j, k ,l, xdelta, ydelta)) {
									ans = n;
								}
							}
						}
					}
				}
			}
			if(n > 6) {
				ans = 4;
				List<ArrayList<Integer>> collins = new ArrayList<ArrayList<Integer>>();
				for(int j = 0; j < xs.length - 1; j++) {
					for(int k = j + 1; k < xs.length; k++) {
						int xdelta = xs[j] - xs[k];
						int ydelta = ys[j] - ys[k];
						for(int l = 0; l < xs.length; l++) {
							if(l != j && l != k) {
								if(collinear(xs, ys, j, k ,l, xdelta, ydelta)) {
									ArrayList<Integer> tmp = new ArrayList<>();
									tmp.add(j);
									tmp.add(k);
									tmp.add(l);
									collins.add(tmp);
								}
							}
						}
					}
				}
				if(collins.size() > 0) {
					ans = 6;
				}
				for(int j = 0; j < collins.size() - 1; j++) {
					for(int k = j + 1; k < collins.size(); k++) {
						ArrayList<Integer> l1 = collins.get(j);
						ArrayList<Integer> l2 = collins.get(k);
						int l11= l1.get(0);
						int l12= l1.get(1);
						int l13= l1.get(2);
						int l21= l2.get(0);
						int l22= l2.get(1);
						int l23= l2.get(2);
						if(l11 != l21 && l11 != l22 && l11 != l23) {
							if(l12 != l21 && l12 != l22 && l12 != l23) {
								if(l13 != l21 && l13 != l22 && l13 != l23) {
									ans = n;
								}
							}
						}
						
					}
				}
			}
			System.out.println("Case #" + i + ": " + ans);
		}
	}
	private static boolean collinear(int[] xs, int[] ys, int c1, int c2, int c3, int xdelta, int ydelta) {
		int x1 = xs[c1];
		int x2 = xs[c2];
		int x3 = xs[c3] + xdelta;
		int y1 = ys[c1];
		int y2 = ys[c2];
		int y3 = ys[c3] + ydelta;
		int x4 = xs[c3] - xdelta;
		int y4 = ys[c3] - ydelta;
        return (((x3 - x1) * (y3 - y2) - (x3 - x2) * (y3 - y1)) == 0) || (((x4 - x1) * (y4 - y2) - (x4 - x2) * (y4 - y1)) == 0);
    }
}