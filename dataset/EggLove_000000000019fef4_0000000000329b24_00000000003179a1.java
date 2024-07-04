import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		for (int i = 1; i <= T; i++) {
			solve(in, T);
		}
	}

	static void solve(Scanner in, int T) {
		Hashtable<String, Integer> dic = new Hashtable<String, Integer>();
		Hashtable<Integer, String> rev = new Hashtable<Integer, String>();
		Hashtable<String, Integer> zero = new Hashtable<String, Integer>();
		int u = in.nextInt();
		int counter = 0;
		Boolean[][] y = new Boolean[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				y[i][j] = false;
			}
		}
		for (int i = 0; i < 10000; i++) {
			int m = in.nextInt();
			String r = in.next();
			for(int k = 0; k < r.length(); k++){
			    zero.put(r.substring(k, k + 1), 1);
			}
			if (r.length() == length(m)) {

				m = firstNum(m);
				r = r.substring(0, 1);

				if (!dic.containsKey(r)) {
					dic.put(r, counter);
					rev.put(counter, r);
					for (int j = 0; j < m; j++) {
						y[counter][j] = true;
					}
					counter++;
				} else {
					int place = dic.get(r);
					for (int j = 9; j >= m; j--) {
						if (y[place][j] = true) {
							y[place][j] = false;
						}
					}
				}
			}
		}

		String[] sol = new String[10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (y[i][j] == false) {
					sol[j] = rev.get(i);
					break;
				}
			}
		}
		System.out.print("Case #" + T + ": ");
		Set<String> a = zero.keySet();
		Set<String> b = dic.keySet();
		for(String c : a) {
			if(!b.contains(c)) {
				System.out.print(c);
			}
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.print(sol[i]);
		}
		System.out.println();
	}

	static int length(int m) {
		int l = 1;
		while (m >= 10) {
			m /= 10;
			l++;
		}
		return l;

	}

	static int firstNum(int m) {
		while (m >= 10) {
			m /= 10;
		}
		return m;
	}
}