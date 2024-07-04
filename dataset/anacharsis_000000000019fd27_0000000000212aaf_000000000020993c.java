import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Solution {
	private StringBuilder buffer = new StringBuilder( 16384 );

	void solve() throws IOException {
		InputReader reader = new InputReader( System.in );
		int T = reader.nextInt();

		for ( int t = 0; t < T; ++t ) {
			int N = reader.nextInt();
			int[][] grid = new int[ N ][ N ];
			Set<Integer>[] seen = new Set[ 2 * N ];
			for ( int i = 0; i < 2 * N; ++i ) {
				seen[i] = new HashSet<>();
			}

			long trace = 0;
			for ( int r = 0; r < N; ++r ) {
				for ( int c = 0; c < N; ++c ) {
					grid[r][c] = reader.nextInt();

					if ( r == c ) {
						trace += grid[r][c];
					}

					seen[r].add( grid[r][c] );
					seen[N + c].add( grid[r][c] );
				}
			}

			int drs = 0;
			int dcs = 0;
			for ( int r = 0; r < N; ++r ) {
				if ( seen[r].size() != N ) {
					++drs;
				}
				if ( seen[N + r].size() != N ) {
					++dcs;
				}
			}

			buffer.append( String.format( "Case #%d: %d %d %d\n", t + 1, trace, drs, dcs ) );
		}
		
		System.out.print( buffer );
	}

	public static void main( String args[] ) throws IOException {
		new Solution().solve();
	}

	class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public InputReader( InputStream stream ) {
			reader = new BufferedReader( new InputStreamReader( stream ) );
			tokenizer = null;
		}

		public String readln() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while ( tokenizer == null || !tokenizer.hasMoreTokens() ) {
				try {
					tokenizer = new StringTokenizer( reader.readLine() );
				} catch ( Throwable e ) {
					return null;
				}
			}

			return tokenizer.nextToken();
		}

		public double nextDouble() {
			String next = next();

			if ( next == null ) {
				return -1;
			}

			return Double.parseDouble( next );
		}

		public long nextLong() {
			String next = next();

			if ( next == null ) {
				return -1;
			}

			return Long.parseLong( next );
		}

		public int nextInt() {
			String next = next();

			if ( next == null ) {
				return -1;
			}

			return Integer.parseInt( next );
		}
	}

}
