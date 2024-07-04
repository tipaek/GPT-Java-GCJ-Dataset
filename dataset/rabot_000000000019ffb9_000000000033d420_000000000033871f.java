import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner((Readable) new BufferedReader(
				new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for ( int t = 1 ; t <= T ; t++ ) {
			int C = sc.nextInt();
			int D = sc.nextInt();
			int[] X = new int[C + 1];
			int[] updatedCnt = new int[101];
			ArrayList<Integer> time = new ArrayList<>();
			for ( int i = 2 ; i <= C ; i++ ) {
				X[i] = sc.nextInt();
				if ( X[i] > 0 ) {
					time.add(X[i]);
				} else {
					updatedCnt[-X[i]]++;
				}
			}
			Integer[] timeArr = time.toArray(new Integer[time.size()]);
			Arrays.sort(timeArr);

			int[] U = new int[D];
			int[] V = new int[D];
			for ( int i = 0 ; i < D ; i++ ) {
				U[i] = sc.nextInt();
				V[i] = sc.nextInt();
			}

			int[] updateTime = new int[C + 1];
			int updated = 1;
			int lastT = 0;
			int nextIdx = 0;
			for ( int o = 1 ; o <= 100 ; o++ ) {
				if ( updatedCnt[o] == 0 ) {
					continue;
				}
				int tt = lastT;
				while ( updated < o ) {
					tt = timeArr[nextIdx];
					int cnt = setTime(updateTime, tt, X, tt);
					updated += cnt;
					nextIdx += cnt;
				}
				int cnt = setTime(updateTime, tt + 1, X, -o);
				lastT = tt + 1;
				updated += cnt;
			}
			while ( updated < C ) {
				int tt = timeArr[nextIdx];
				int cnt = setTime(updateTime, tt, X, tt);
				updated += cnt;
				nextIdx += cnt;
			}

			System.out.print("Case #" + t + ":");
			for ( int i = 0 ; i < D ; i++ ) {
				System.out.print(" " + Math.max(1, Math.abs(updateTime[U[i]] - updateTime[V[i]])));
			}
			System.out.println();
		}
		sc.close();
	}
	public static int setTime(int[] updateTime, int t, int[] X, int condition ) {
		int cnt = 0;
		for ( int i = 1 ; i < X.length ; i++ ) {
			if ( X[i] == condition ) {
				updateTime[i] = t;
				cnt++;
			}
		}
		return cnt;
	}
}
