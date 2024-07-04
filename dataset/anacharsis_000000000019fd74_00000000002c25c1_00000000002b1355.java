import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Solution {
	private StringBuilder buffer = new StringBuilder( 16384 );

	void solve() throws IOException {
		InputReader reader = new InputReader( System.in );
		int T = reader.nextInt();

		for ( int t = 0; t < T; ++t ) {
			buffer.append( "Case #" ).append( t + 1 ).append( ": " );
			int R = reader.nextInt();
			int C = reader.nextInt();

			List<Dancer> alive = new ArrayList<>();
			Dancer[][] floor = new Dancer[ R ][ C ];
			for ( int r = 0; r < R; ++r ) {
				for ( int c = 0; c < C; ++c ) {
					floor[r][c] = new Dancer( reader.nextLong() );
					alive.add( floor[r][c] );
				}
			}

			for ( int r = 0; r < R; ++r ) {
				for ( int c = 0; c < C; ++c ) {
					Dancer cur = floor[r][c];

					cur.above = get( r - 1, c, floor );
					cur.right = get( r, c + 1, floor );
					cur.below = get( r + 1, c, floor );
					cur.left = get( r, c - 1, floor );
				}
			}

			dance( alive );
		}

		System.out.print( buffer );
	}

	private void dance( List<Dancer> alive ) {
		boolean keepGoing = true;
		long skill = 0;

		while ( keepGoing ) {
			keepGoing = false;
			skill += alive.stream().mapToLong( d -> d.skill ).sum();

			for ( Dancer d : alive ) {
				d.eliminate();
			}

			relinkNeighbors( alive );
			List<Dancer> aliveAfterRound = alive.stream().filter( d -> !d.eliminated ).collect( Collectors.toList() );
			keepGoing = alive.size() != aliveAfterRound.size();
			alive = aliveAfterRound;
		}

		buffer.append( skill ).append( '\n' );
	}

	private void relinkNeighbors( List<Dancer> aliveAfterRound ) {
		for ( Dancer d : aliveAfterRound ) {
			while ( d.above != null && d.above.eliminated ) {
				d.above = d.above.above;
			}

			while ( d.right != null && d.right.eliminated ) {
				d.right = d.right.right;
			}

			while ( d.below != null && d.below.eliminated ) {
				d.below = d.below.below;
			}

			while ( d.left != null && d.left.eliminated ) {
				d.left = d.left.left;
			}
		}
	}

	private Dancer get( int r, int c, Dancer[][] floor ) {
		if ( r >= 0 && r < floor.length && c >= 0 && c < floor[0].length ) {
			return floor[r][c];
		}

		return null;
	}

	private static class Dancer {
		private long skill;
		private boolean eliminated;
		private Dancer above;
		private Dancer right;
		private Dancer below;
		private Dancer left;

		public Dancer( long skill ) {
			this.skill = skill;
		}

		public void eliminate() {
			long ns = 0;
			long total = 0;

			if ( above != null ) {
				total += above.skill;
				++ns;
			}

			if ( right != null ) {
				total += right.skill;
				++ns;
			}

			if ( below != null ) {
				total += below.skill;
				++ns;
			}

			if ( left != null ) {
				total += left.skill;
				++ns;
			}

			eliminated = ns * skill < total;
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
