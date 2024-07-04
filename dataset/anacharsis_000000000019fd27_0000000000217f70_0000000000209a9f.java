import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	private StringBuilder buffer = new StringBuilder( 16384 );

	void solve() throws IOException {
		InputReader reader = new InputReader( System.in );
		int T = reader.nextInt();

		for ( int t = 0; t < T; ++t ) {
			buffer.append( String.format( "Case #%d: ", t + 1 ) );
			List<String> toks = tokenize( reader.readln().trim() );

			String lastTok = null;
			for ( String tok : toks ) {
				int curEnclosing = tok.charAt( 0 ) - '0';

				if ( lastTok == null ) {
					add( '(', curEnclosing );
				} else {
					int lastEnclosing = lastTok.charAt( 0 ) - '0';

					if ( lastEnclosing < curEnclosing ) {
						add( '(', curEnclosing - lastEnclosing );
					} else {
						add( ')', lastEnclosing - curEnclosing );
					}
				}

				buffer.append( tok );
				lastTok = tok;
			}

			add( ')', lastTok.charAt( 0 ) - '0' );
			buffer.append( '\n' );
		}
		
		System.out.print( buffer );
	}

	private void add( char pType, int occs ) {
		for ( int i = 0; i < occs; ++i ) {
			buffer.append( pType );
		}
	}

	private List<String> tokenize( String s ) {
		List<String> ss = new ArrayList<>();
		char last = 0;
		StringBuilder buf = new StringBuilder( 128 );

		for ( int i = 0, lim = s.length(); i < lim; ++i ) {
			char next = s.charAt( i );

			if ( next != last && buf.length() > 0 ) {
				ss.add( buf.toString() );
				buf.setLength( 0 );
			}

			buf.append( next );
			last = next;
		}

		if ( buf.length() > 0 ) {
			ss.add( buf.toString() );
		}

		return ss;
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
