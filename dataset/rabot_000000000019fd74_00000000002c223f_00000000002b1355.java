import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner((Readable) new BufferedReader(
				new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for ( int t = 1 ; t <= T ; t++ ) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			int[][][] S = new int[2][R][C];
			boolean[][] winner = new boolean[R][C];
			boolean[][][] none = new boolean[R][C][4];

			for ( int r = 0 ; r < R ; r++ ) {
				for ( int c = 0 ; c < C ; c++ ) {
					S[0][r][c] = sc.nextInt();
				}
			}

			int elemCnt = 1;
			int round = 0;
			long interesting = 0;
			int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
			while ( elemCnt > 0) {
				int next = (round + 1) % 2;
				elemCnt = 0;
				for ( int r = 0 ; r < R ; r++ ) {
					for ( int c = 0 ; c < C ; c++ ) {
						if ( S[round][r][c] == 0 ) {
							S[next][r][c] = 0;
							continue;
						}
						interesting += S[round][r][c];
						if ( winner[r][c] ) {
							S[next][r][c] = S[round][r][c];
							continue;
						}
						long arround = 0;
						int arroundCnt = 0;
						for ( int d = 0 ; d < dir.length ; d++ ) {
							if ( none[r][c][d] ) {
								continue;
							}
							int rr = r;
							int cc = c;
							while ( true ) {
								rr += dir[d][0];
								cc += dir[d][1];
								if ( rr < 0 || rr >= R || cc < 0 || cc >= C ) {
									none[r][c][d] = true;
									break;
								}
								if ( S[round][rr][cc] > 0 ) {
									arround += S[round][rr][cc];
									arroundCnt++;
									break;
								}
							}
						}
						if ( arround > 0 ) {
							if ( ((double)arround) / arroundCnt > (double) S[round][r][c] ) {
								S[next][r][c] = 0;
								elemCnt++;
								continue;
							} else {
								S[next][r][c] = S[round][r][c];
								continue;
							}
						} else {
							S[next][r][c] = S[round][r][c];
							winner[r][c] = true;
							continue;
						}
					}
				}
				if ( elemCnt == 0 ) {
					break;
				}
				round = next;
			}
			System.out.println("Case #" + t + ": " + interesting);
		}
		sc.close();
	}
}
