import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	private StringBuilder buffer = new StringBuilder( 16384 );

	void solve() throws IOException {
		InputReader reader = new InputReader( System.in );
		int T = reader.nextInt();

		for ( int t = 0; t < T; ++t ) {
			buffer.append( "Case #" ).append( t + 1 ).append( ":\n" );
			int N = reader.nextInt();

			if ( N <= 501 ) {
				path501( N );
			}
		}
		System.out.print( buffer );
	}

	private void path501( int N ) {
		if ( N == 501 ) {
			buffer.append( "1 1" ).append( '\n' );
			buffer.append( "2 2" ).append( '\n' );
			buffer.append( "3 2" ).append( '\n' );
			N -= 4;
		} else {
			buffer.append( "1 1" ).append( '\n' );
			N -= 1;
		}

		int n = 2;
		while ( N > 0 ) {
			buffer.append( n ).append( ' ' ).append( n ).append( '\n' );
			--N;
			++n;
		}
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
