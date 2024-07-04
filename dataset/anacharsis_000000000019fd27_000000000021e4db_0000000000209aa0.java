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
			int trace = reader.nextInt();

			SudokuPuzzle suds = new SudokuPuzzle( N );
			fillInAsManyPossibleForTrace( N, suds, trace );

			SudokuSolution sol = new BacktrackingSudokuSolver().solve( suds );
			if ( sol.solved() ) {
				buffer.append( String.format( "Case #%d: POSSIBLE\n", t + 1 ) );

				int[][] solved = sol.getSolved().getPuzzle();
				for ( int r = 0; r < N; ++r ) {
					for ( int c = 0; c < N; ++c ) {
						if ( c > 0 ) {
							buffer.append( ' ' );
						}
						buffer.append( solved[r][c] );
					}
					buffer.append( '\n' );
				}
			} else {
				buffer.append( String.format( "Case #%d: IMPOSSIBLE\n", t + 1 ) );
			}
		}

		System.out.print( buffer );
	}

	private void fillInAsManyPossibleForTrace( int N, SudokuPuzzle suds, int trace ) {
		int placed = 0;

		while ( trace > 0 ) {
			int spotsLeft = N - placed;

			if ( trace == spotsLeft ) {
				for ( int n = placed; n < N; ++n ) {
					suds.setPuzzleCell( n, n, 1 );
				}

				trace = 0;
			} else if ( spotsLeft == 1 ) {
				suds.setPuzzleCell( placed, placed, trace );
				trace = 0;
			} else {
				int place = Math.min( N, trace - spotsLeft );
				suds.setPuzzleCell( placed, placed, place );
				trace -= place;
				++placed;
			}

		}
	}

	private static class BacktrackingSudokuSolver {
		private SudokuSolution solution;
		private int R;
		private int C;

		public SudokuSolution solve( SudokuPuzzle puzzle ) {
			R = puzzle.getR();
			C = puzzle.getC();
			solution = null;
			backtrackSudoku( 0, 0, puzzle );

			if ( solution == null ) {
				solution = new SudokuSolution( puzzle, null );
			}

			return solution;
		}

		private void backtrackSudoku( int r, int c, SudokuPuzzle puzzle ) {
			if ( solved() ) {
				return;
			} else if ( c == C ) {
				backtrackSudoku( r + 1, 0, puzzle );
			} else if ( r == R ) {
				solution = new SudokuSolution( puzzle.getUnsolved(), new SudokuPuzzle( puzzle ) );
				return;
			} else if ( !puzzle.needsPlacement( r, c ) ) {
				backtrackSudoku( r, c + 1, puzzle );
			} else {
				for ( int numeral : puzzle.getPossiblePlacementsForCell( r, c ) ) {
					puzzle.place( r, c, numeral );
					backtrackSudoku( r, c + 1, puzzle );

					if ( !solved() ) {
						puzzle.undoPlacement( r, c );
					}
				}
			}
		}

		private boolean solved() {
			return solution != null;
		}

	}

	private static class SudokuSolution {
		private SudokuPuzzle original;
		private SudokuPuzzle solved;

		public SudokuSolution( SudokuPuzzle original, SudokuPuzzle solved ) {
			this.original = original;
			this.solved = solved;
		}

		public boolean solved() {
			return solved != null;
		}

		public SudokuPuzzle getSolved() {
			return solved;
		}

	}

	private static class SudokuPuzzle {
		private SudokuPuzzle unsolved;
		private int dim;
		private int R;
		private int C;
		private int[][] puzzle;
		private boolean prepared;
		private Set<Integer>[] rows;
		private Set<Integer>[] cols;
		private Set<Integer> possibleNumerals;

		public SudokuPuzzle( SudokuPuzzle other ) {
			this.dim = other.dim;
			this.puzzle = new int[ other.R ][ other.C ];
			this.R = other.R;
			this.C = other.C;

			for ( int r = 0; r < other.R; ++r ) {
				System.arraycopy( other.puzzle[r], 0, puzzle[r], 0, C );
			}
		}

		public SudokuPuzzle( int dim ) {
			this( dim, new int[ dim ][ dim ] );
		}

		public SudokuPuzzle( int dim, int[][] puzzle ) {
			this.dim = dim;
			this.puzzle = puzzle;
			this.R = dim;
			this.C = R;
		}

		public int[][] getPuzzle() {
			return puzzle;
		}

		public int getR() {
			return R;
		}

		public int getC() {
			return C;
		}

		public SudokuPuzzle getUnsolved() {
			return unsolved;
		}

		public void setPuzzleCell( int r, int c, int numeral ) {
			puzzle[r][c] = numeral;
		}

		public boolean needsPlacement( int r, int c ) {
			return puzzle[r][c] == 0;
		}

		public boolean canPlace( int r, int c, int numeral ) {
			if ( !prepared ) {
				prepareForSolution();
			}

			return !rows[r].contains( numeral ) && !cols[c].contains( numeral );
		}

		public Set<Integer> getPossiblePlacementsForCell( int r, int c ) {
			if ( !prepared ) {
				prepareForSolution();
			}

			Set<Integer> possibles = new HashSet<>( possibleNumerals );

			possibles.removeAll( rows[r] );
			possibles.removeAll( cols[c] );

			return possibles;
		}

		public void place( int r, int c, int numeral ) {
			if ( !prepared ) {
				prepareForSolution();
			}

			puzzle[r][c] = numeral;

			rows[r].add( numeral );
			cols[c].add( numeral );
		}

		public void undoPlacement( int r, int c ) {
			if ( !prepared ) {
				prepareForSolution();
			}

			int numeral = puzzle[r][c];
			puzzle[r][c] = 0;

			rows[r].remove( numeral );
			cols[c].remove( numeral );
		}

		public void prepareForSolution() {
			initSolutionSets();
			initPossibleSet();
			unsolved = new SudokuPuzzle( this );
			prepared = true;
		}

		private void initSolutionSets() {
			initRows();
			initCols();
		}

		private void initPossibleSet() {
			possibleNumerals = new HashSet<>();

			for ( int i = 1; i <= R; ++i ) {
				possibleNumerals.add( i );
			}
		}

		@SuppressWarnings( "unchecked" )
		private void initRows() {
			initArray( R, rows = new Set[ R ] );

			for ( int r = 0; r < R; ++r ) {
				for ( int c = 0; c < C; ++c ) {
					if ( puzzle[r][c] != 0 ) {
						rows[r].add( puzzle[r][c] );
					}
				}
			}
		}

		@SuppressWarnings( "unchecked" )
		private void initCols() {
			initArray( C, cols = new Set[ R ] );

			for ( int c = 0; c < C; ++c ) {
				for ( int r = 0; r < R; ++r ) {
					if ( puzzle[r][c] != 0 ) {
						cols[c].add( puzzle[r][c] );
					}
				}
			}
		}

		private void initArray( int len, Set<Integer>[] arr ) {
			for ( int i = 0; i < len; ++i ) {
				arr[i] = new HashSet<Integer>();
			}
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
