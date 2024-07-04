import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	private StringBuilder buffer = new StringBuilder( 16384 );

	void solve() throws IOException {
		InputReader reader = new InputReader( System.in );
		int T = reader.nextInt();

		for ( int t = 0; t < T; ++t ) {
			List<Event> es = new ArrayList<>();
			int E = reader.nextInt();

			for ( int e = 0; e < E; ++e ) {
				es.add( new Event( e, reader.nextInt(), reader.nextInt() ) );
			}

			Collections.sort( es );
			char[] ass = new char[ E ];
			Event j = null;
			Event c = null;

			for ( Event e : es ) {
				int currentStart = e.start;

				if ( j == null || j.end <= currentStart ) {
					ass[e.idx] = 'J';
					j = e;
				} else if ( c == null || c.end <= currentStart ) {
					ass[e.idx] = 'C';
					c = e;
				} else {
					ass = null;
					break;
				}
			}

			buffer.append( String.format( "Case #%d: %s\n", t + 1, ass == null ? "IMPOSSIBLE" : new String( ass ) ) );
		}

		System.out.print( buffer );
	}

	private static class Event implements Comparable<Event> {
		private int idx;
		private int start;
		private int end;

		public Event( int idx, int start, int end ) {
			this.idx = idx;
			this.start = start;
			this.end = end;
		}

		public boolean overlap( Event other ) {
			return other.end > start && other.start < start ||
					other.start >= start && other.end <= end ||
					other.start > start && other.start < end;
		}

		@Override
		public int compareTo( Event o ) {
			return start - o.start;
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
