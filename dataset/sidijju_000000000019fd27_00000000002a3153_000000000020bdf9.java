import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static void main(String[] args) {
		int t = sc.nextInt(); 
		for(int i = 0; i < t; i ++) {
			System.out.print("Case #" + (i + 1) + ": ");
			solve();
			System.out.println();
		}
	}
	private static void solve() {
		Queue<String> available = new LinkedList<String>(); available.add("C"); available.add("J");
		int n = sc.nextInt();
		Timepoint[] k = new Timepoint[2 * n];
		for(int i = 0; i < n; i ++) {
			Timepoint t1 = new Timepoint(sc.nextInt(), true, 2*i);
			Timepoint t2 = new Timepoint(sc.nextInt(), false, 2*i + 1);
			t1.pair = t2;
			t2.pair = t1;
			k[2 * i] = t1;
			k[2 * i + 1] = t2;
		}
		Arrays.sort(k);
		for(int i = 0; i < 2*n; i ++) {
			if(k[i].left) {
				String p = available.poll();
				if(p == null) {
					System.out.print("IMPOSSIBLE");
					return;
				}
				k[i].parent = p;
				k[i].pair.parent = p;
			}
			else {available.add(k[i].pair.parent);}
		}
		Arrays.sort(k, new Comparator<Timepoint>() {
		    public int compare(Timepoint o1, Timepoint o2) {
		        return Integer.compare(o1.tp, o2.tp);
		    }
		});
		for(int i = 0; i < 2*n; i ++) {
			if(k[i].left) System.out.print(k[i].parent);
		}
	}
	
	private static class Timepoint implements Comparable<Timepoint>{
		int tp;
		boolean left;
		int val;
		Timepoint pair;
		String parent;
		
		public Timepoint(int v, boolean l, int t) {
			tp = t;
			left = l;
			val = v;
		}
		

		@Override
		public int compareTo(Timepoint o) {
			if(this.val < o.val) return -1;
			else if(this.val > o.val) return 1;
			else {
				if(left = true) return 1;
				else return -1;
			}
		}
	}
}
