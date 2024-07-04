import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solve();
	}

	HashMap<String, int[]> hash = null;
	ArrayList<String>[] list = null;
	public void solve() {
		Scanner sc = new Scanner((Readable) new BufferedReader(
				new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for ( int t = 1 ; t <= T ; t++ ) {
			String C = sc.next();
			String J = sc.next();

			hash = new HashMap<>();
			list = new ArrayList[12];
			list[0] = new ArrayList<>();
			list[0].add(C);
			calcDist(0, 0);

			list = new ArrayList[12];
			list[0] = new ArrayList<>();
			list[0].add(J);
			calcDist(0, 1);
			String ans = "";
			int dmin = 100000;
			int diff = 100000;
			for ( String key : hash.keySet() ) {
				int[] dd = hash.get(key);
				if ( dd[0] + dd[1] < dmin ) {
					ans = key;
					dmin = dd[0] + dd[1];
					diff = Math.abs(dd[0] - dd[1]);
				} else if ( dd[0] + dd[1] == dmin ) {
					if ( Math.abs(dd[0] - dd[1]) < diff ) {
						ans = key;
						diff = Math.abs(dd[0] - dd[1]);
					}
				}
			}

			System.out.println("Case #" + t + ": " + ans );
		}
		sc.close();
	}

	public void calcDist(int d, int index) {
		list[d + 1] = new ArrayList<>();
		for ( String cur: list[d] ) {
			int[] dd = null;
			if ( hash.containsKey(cur) ) {
				dd = hash.get(cur);
				if ( dd[index] <= d ) {
					continue;
				}
				dd[index] = d;
			} else {
				dd = new int[] {d, 10000};
				hash.put(cur, dd);
			}
			// insert
			if ( cur.length() < 7 ) {
				for ( int i = 0 ; i <= cur.length(); i++ ) {
					for ( char c = 'X' ; c <= 'Z' ; c++ ) {
						list[d + 1].add(cur.substring(0, i) + c + cur.substring(i));
					}
				}
			}
			// delete
			if ( cur.length() > 1 ) {
				for ( int i = 0 ; i < cur.length() ; i++ ) {
					list[d + 1].add(cur.substring(0, i) + cur.substring(i + 1));
				}
			}
			// change
			for ( int i = 0 ; i < cur.length() ; i++ ) {
				for ( char c = 'X' ; c <= 'Z' ; c++ ) {
					list[d + 1].add(cur.substring(0, i) + c + cur.substring(i + 1));
				}
			}
		}
		if ( list[d + 1].size() > 0 ) {
			calcDist(d + 1, index);
		}
	}
}
