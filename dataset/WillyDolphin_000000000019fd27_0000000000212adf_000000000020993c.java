import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1; i<=t; i++) {
			int n = sc.nextInt();
			int trace = 0;
			int[] r = new int[n];
			int[] c = new int[n];
			HashSet<Integer>[] sets = new HashSet[2*n];
			for(int ii = 0; ii<2*n; ii++) {
				sets[ii] = new HashSet<Integer>();
			}
			for(int rr = 0; rr < n; rr++) {
				for(int cc = 0; cc < n; cc++) {
					int x = sc.nextInt();
					if(sets[rr].contains(x)) {
						r[rr] = 1;
					}
					if(sets[n+cc].contains(x)) {
						c[cc] = 1;
					}
					sets[rr].add(x);
					sets[n+cc].add(x);
					if(rr == cc) {
						trace += x;
					}
				}
			}
			int ansr = 0;
			int ansc = 0;
			for(int x: r) {
				ansr += x;
			}
			for(int x: c) {
				ansc += x;
			}
			System.out.println("Case #"+i+": "+trace+" "+" "+ansr+" "+ansc);
		}
	}

}
