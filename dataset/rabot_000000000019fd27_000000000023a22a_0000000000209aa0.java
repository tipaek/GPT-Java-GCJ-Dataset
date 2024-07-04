import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	static final String POSSIBLE = "POSSIBLE\n";
	static final String IMPOSSIBLE = "IMPOSSIBLE\n";
	public static void main(String[] args) {
		Scanner sc = new Scanner((Readable) new BufferedReader(
				new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for ( int t = 1 ; t <= T ; t++ ) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			String ans = "Case #" + t + ": ";
			if ( N == 2 ) {
				switch (K) {
				case 2:
					ans += POSSIBLE + "1 2\n2 1\n";
					break;
				case 4:
					ans += POSSIBLE + "2 1\n1 2\n";
					break;
				default:
					ans += IMPOSSIBLE;
					break;
				}
			} else if ( N == 3 ) {
				switch (K) {
				case 3:
					ans += POSSIBLE + "1 2 3\n3 1 2\n2 3 1\n";
					break;
				case 6:
					ans += POSSIBLE + "2 3 1\n1 2 3\n3 1 2\n";
					break;
				case 9:
					ans += POSSIBLE + "3 1 2\n2 3 1\n1 2 3\n";
					break;
				default:
					ans += IMPOSSIBLE;
					break;
				}
			} else {
				if ( K % N == 0 ) {
					int a = K / N;
					StringBuilder mtx = new StringBuilder();
					for ( int i = 0 ; i < N ; i++ ) {
						for ( int j = 0 ; j < N ; j++ ) {
							int x = (-i + j + a + N) % N;
							x = x == 0 ? N : x;
							mtx.append(x);
							mtx.append(j == N - 1 ? "\n" : " ");
						}
					}
					ans += POSSIBLE + mtx.toString();
				} else {
					int a = 0;
					int b = 0;
					int c = 0;
					boolean found = false;
					for ( a = Math.max((K - 2 * N + 1) / (N - 2), 1); a <= Math.min((K - 2) / (N - 2), N) ; a++ ) {
						int r = K - (N - 2) * a;
						for ( b = 1 ; b <= r / 2 ; b++ ) {
							c = r - b;
							if ( a == b || a == c || c > N ) {
								continue;
							}
							found = true;
							break;
						}
						if ( found ) {
							break;
						}
					}
					if ( found ) {
						int[][] m = new int[N][N];
						if ( b == c ) {
							for ( int i = 0 ; i < N - 3 ; i++ ) {
								for ( int j = 0 ; j < N ; j++ ) {
									m[i][j] = (N - i + j + 1) % N;
									if ( m[i][j] == 0 ) {
										m[i][j] = N;
									}
								}
							}
							m[N - 3][0] = 2;
							for ( int j = 1 ; j < N - 3; j++ ) {
								m[N - 3][j] = j + 3;
							}
							m[N - 3][N - 3] = 1;
							m[N - 3][N - 2] = N;
							m[N - 3][N - 1] = 3;
							m[N - 2][0] = 3;
							m[N - 1][0] = 4;
							for ( int j = 1 ; j < N - 3; j++ ) {
								if ( j % 2 == 0 ) {
									m[N - 2][j] = (j / 2) * 2 + 2;
									m[N - 1][j] = (j / 2) * 2 + 4;
								} else {
									m[N - 2][j] = (j / 2) * 2 + 5;
									m[N - 1][j] = (j / 2) * 2 + 3;
								}
							}
							if ( N % 2 == 0 ) {
								m[N - 2][N - 3] = N;
								m[N - 1][N - 3] = N - 1;
							} else {
								m[N - 2][N - 3] = N - 1;
								m[N - 1][N - 3] = N;
							}
							m[N - 2][N - 2] = 2;
							m[N - 2][N - 1] = 1;
							m[N - 1][N - 2] = 1;
							m[N - 1][N - 1] = 2;
						} else {
							for ( int i = 0 ; i < N - 3 ; i++ ) {
								for ( int j = 0 ; j < N ; j++ ) {
									m[i][j] = (N - i + j + 1) % N;
									if ( m[i][j] == 0 ) {
										m[i][j] = N;
									}
								}
							}
							for ( int j = 0 ; j < N - 3; j++ ) {
								m[N - 3][j] = j + 3;
							}
							m[N - 3][N - 3] = 1;
							m[N - 3][N - 2] = N;
							m[N - 3][N - 1] = 2;
							m[N - 2][0] = 4;
							m[N - 1][0] = 2;
							for ( int j = 1 ; j < N - 3; j++ ) {
								if ( j % 2 == 0 ) {
									m[N - 2][j] = (j / 2) * 2 + 4;
									m[N - 1][j] = (j / 2) * 2 + 2;
								} else {
									m[N - 2][j] = (j / 2) * 2 + 3;
									m[N - 1][j] = (j / 2) * 2 + 5;
								}
							}
							if ( N % 2 == 0 ) {
								m[N - 2][N - 3] = N - 1;
								m[N - 1][N - 3] = N;
							} else {
								m[N - 2][N - 3] = N;
								m[N - 1][N - 3] = N - 1;
							}
							m[N - 2][N - 2] = 2;
							m[N - 2][N - 1] = 1;
							m[N - 1][N - 2] = 1;
							m[N - 1][N - 1] = 3;
						}
						int[] mp = new int[N + 1];
						HashSet<Integer> set = new HashSet<>();
						for ( int i = 1 ; i <= N ; i++ ) {
							set.add(i);
						}
						mp[1] = a;
						set.remove(a);
						mp[2] = b;
						set.remove(b);
						int idx = 3;
						if ( b != c ) {
							mp[3] = c;
							set.remove(c);
							idx = 4;
						}
						int cur = 1;
						while ( idx <= N ) {
							if ( set.contains(cur) ) {
								mp[idx++] = cur;
								set.remove(cur);
							} else {
								cur++;
							}
						}
						StringBuilder mtx = new StringBuilder();
						for ( int i = 0 ; i < N ; i++ ) {
							for ( int j = 0 ; j < N ; j++ ) {
								mtx.append(mp[m[i][j]]);
								if ( j == N - 1 ) {
									mtx.append("\n");
								} else {
									mtx.append(" ");
								}
							}
						}
						ans += POSSIBLE + mtx.toString();
					} else {
						ans += IMPOSSIBLE;
					}
				}
			}

			System.out.print("Case #" + t + ": " + ans);
		}
		sc.close();
	}
}
