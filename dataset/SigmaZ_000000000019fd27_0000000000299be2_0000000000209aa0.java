import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for(int ts = 0; ts < tc; ts++) {
			int n = in.nextInt(), k = in.nextInt();
			if(k == n + 1 || k == n * n - 1) {
				System.out.printf("Case #%d: IMPOSSIBLE\n", ts + 1);
				continue;
			}
			if(k % n == 0) {
				System.out.printf("Case #%d: POSSIBLE\n", ts + 1);
				norm(n, k);
				continue;
			}
			if(n < 4) {
				System.out.printf("Case #%d: IMPOSSIBLE\n", ts + 1);
				continue;
			}
			System.out.printf("Case #%d: POSSIBLE\n", ts + 1);
			int abc[] = find(n, k);
			if(abc.length == 3)
				aaabc(n, abc);
			else if(n % 2 == 0)
				aaabb2(n, abc);
			else
				aaabb(n, abc);
		}

	}
	
	private static void aaabb(int n, int[] abc) {
		int set[][][] = {{{3,1,2,0},{0,1,3,2},{0,1,3,2},{2,1,0,3},{0,1,2,3},{3,1,0,2},{0,1,3,2},{2,0,1,3},{1,0,2,3}},
				{{3,1,0,2},{0,1,3,2},{2,0,1,3},{1,0,2,3}},
				{{3,1,2,0},{0,1,3,2},{0,1,3,2},{2,0,1,3},{1,0,2,3}}};
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i = 1; i <= n; i++)
			l.add(i);
		int va[] = new int[n];
		va[0] = abc[0];
		va[n - 1] = abc[1];
		l.remove((Integer)abc[0]);
		l.remove((Integer)abc[1]);
		for(int i = 0; i < n; i++)
			if(va[i] == 0)
				va[i] = l.remove(0);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int p = (j - i + n) % n;
				if((p + 1) % n > 3) {
					System.out.printf("%d ", va[p]);
				} else if(i < n - set[n % 3].length && i % 3 == 0 && (p == 2 || p == n - 1)) {
					System.out.printf("%d ", va[n + 1 - p]);
				} else {
					p = (set[n % 3][i - (n - set[n % 3].length)][(p + 1) % n] - 1 + n) % n;
					System.out.printf("%d ", va[p]);
				}
			}
			System.out.println();
		}
	}

	private static void aaabb2(int n, int[] abc) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i = 1; i <= n; i++)
			l.add(i);
		int va[] = new int[n];
		va[0] = abc[0];
		va[n / 2] = abc[1];
		l.remove((Integer)abc[0]);
		l.remove((Integer)abc[1]);
		for(int i = 0; i < n; i++)
			if(va[i] == 0)
				va[i] = l.remove(0);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if((i * 2) % n != 0)
					System.out.printf("%d ", va[(j - i + n) % n]);
				else
					System.out.printf("%d ", va[(j - i + n + n / 2) % n]);
			}
			System.out.println();
		}
	}

	private static void aaabc(int n, int[] abc) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i = 1; i <= n; i++)
			l.add(i);
		int va[] = new int[n];
		va[0] = abc[0];
		va[n-1] = abc[1];
		va[1] = abc[2];
		l.remove((Integer)abc[0]);
		l.remove((Integer)abc[1]);
		l.remove((Integer)abc[2]);
		for(int i = 0; i < n; i++)
			if(va[i] == 0)
				va[i] = l.remove(0);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i >= n - 2)
					System.out.printf("%d ", va[(j + i + 3) % n]);
				else
					System.out.printf("%d ", va[(j - i + n) % n]);
			}
			System.out.println();
		}
	}

	private static int[] find(int n, int k) {
		int t = 1, s = k - n + 2;
		while(s > 2 * n) {
			s -= n - 2;
			t++;
		}
		while(s > 2) {
			if(s % 2 == 0) {
				//System.out.printf("| 1 | %d %d %d\n", t, s/2, s/2);
				return new int[]{t, s / 2};
			}
			for(int i = 1; i <= s / 2; i++) {
				if(i != t && t != s - i && s - i <= n) {
					//System.out.printf("| 2 | %d %d %d\n", t, i, s - i);
					return new int[]{t, i, s - i};
				}
			}
			t++;
			s -= n - 2;
		}
		return null;
	}

	static void norm(int n, int k) {
		int va[] = new int[n];
		for(int i = 0; i < n; i++)
			va[i] = i + 1;
		va[0] = k / n;
		va[k / n - 1] = 1;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.printf("%d ", va[(j - i + n) % n]);
			}
			System.out.println();
		}
	}

}