import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) throws Exception {
		rec(MAX_JUMP);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			System.out.print("Case #" + i + ": ");
			solve();
		}
	}

	public static int MAX_JUMP = 7;
	public static HashMap<Integer, ArrayList<ArrayList<Integer>>> sub = new HashMap<>();

	// **SOLUTION**
	public static void solve() throws Exception {
		int X = sc.nextInt();
		int Y = sc.nextInt();
		// 0-north,1-south,2-east,3-west
		for (int jump = 1; jump <= MAX_JUMP; jump++) {
			for (ArrayList<Integer> al : sub.get(jump)) {
				long x = 0, y = 0;
				for (int i = 0; i < al.size(); i++) {
					int d = al.get(i);
					long v = (long) Math.pow(2, i * 1L);
					switch ((int) d) {
					case 0:
						y += v;
						break;
					case 1:
						y -= v;
						break;
					case 2:
						x += v;
						break;
					case 3:
						x -= v;
						break;
					}
				}
				if (x == X && y == Y) {
					StringBuilder sb = new StringBuilder("");
					for (int i = 0; i < al.size(); i++) {
						int d = al.get(i);
						switch ((int) d) {
						case 0:
							sb.append("N");
							break;
						case 1:
							sb.append("S");
							break;
						case 2:
							sb.append("E");
							break;
						case 3:
							sb.append("W");
							break;
						}
					}
					System.out.println(sb.toString());
					return;
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}

	private static void rec(int n) {
		if (n == 1) {
			ArrayList<ArrayList<Integer>> al = new ArrayList<>();
			al.add(new ArrayList<>(Arrays.asList(0)));
			al.add(new ArrayList<>(Arrays.asList(1)));
			al.add(new ArrayList<>(Arrays.asList(2)));
			al.add(new ArrayList<>(Arrays.asList(3)));
			sub.put(n, al);
			return;
		}
		rec(n - 1);
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		ArrayList<ArrayList<Integer>> rec = sub.get(n - 1);
		for (ArrayList<Integer> x : rec) {
			ArrayList<Integer> a = (ArrayList) x.clone();
			ArrayList<Integer> b = (ArrayList) x.clone();
			ArrayList<Integer> c = (ArrayList) x.clone();
			ArrayList<Integer> d = (ArrayList) x.clone();
			a.add(0);
			b.add(1);
			c.add(2);
			d.add(3);
			al.add(a);
			al.add(b);
			al.add(c);
			al.add(d);
		}
		sub.put(n, al);
	}

	public static InputStreamReader r = new InputStreamReader(System.in);

	public static BufferedReader br = new BufferedReader(r);

	public static Scanner sc = new Scanner(System.in);
}
