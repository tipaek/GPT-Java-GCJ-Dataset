import java.util.*;
import java.io.*;

public class Solution {
	static Scanner in = new Scanner( System.in );

	public static void main( String[] args ) {
		int t = in.nextInt();
		for ( int i = 1; i <= t; i++ ) {
			s( i );
		}
	}

	public static void s( int i ) {
		int n = in.nextInt();
		ArrayList<pt> ps = new ArrayList<>();
		for ( int j = 0; j < n; j++ ) {
			int s = in.nextInt(), e = in.nextInt();
			ps.add( new pt( s, -1, j ) );
			ps.add( new pt( e, s, j ) );
		}
		Collections.sort( ps );

		System.out.print( "Case #" + i + ": " );

		int c = -1, j = -1;
		int[] a = new int[n];
		for ( pt p : ps )
			if ( p.s == -1 )
				if ( c == -1 )
					c = p.x;
				else if ( j == -1 )
					j = p.x;
				else {
					System.out.println( "IMPOSSIBLE" );
					return;
				}
			else if ( p.s == c ) {
				c = -1;
				a[p.n] = 'C';
			}
			else if ( p.s == j ) {
				j = -1;
				a[p.n] = 'J';
			}

		for ( int k = 0; k < n; k++ )
			System.out.print( (char)a[k] );
		System.out.println();
	}
}

class pt implements Comparable<pt> {
	int x, s, n;

	public pt( int x, int s, int n ) {
		this.x = x;
		this.s = s;
		this.n = n;
	}

	public int compareTo( pt p ) {
		if ( this.x == p.x )
			return p.s - this.s;
		return this.x - p.x;
	}

	public String toString() {
		return this.x + " " + this.s;
	}
}