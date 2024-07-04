import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution
{
	private static boolean found = false;
	private static String path;
	
	private static void calculate( int X, int Y, BufferedWriter bw, int n ) throws IOException
	{
		found = false;
		path = null;
		
		search( 0, 0, X, Y, 1, "" );
		bw.append( "Case #"+n+": " + ( found ? path : "IMPOSSIBLE" ) + "\n" );
		bw.flush();
	}
	
	private static void search( int x, int y, int X, int Y, int step, String partialPath ) {
		if ( ( x == X ) && ( y == Y ) ) {
			found = true;
			path = partialPath;
			return;
		}
		
		if ( x != X && Math.abs( x - X ) < step || y != Y && Math.abs( y - Y ) < step )
			return;
		
		if ( !( y == Y && x > X ) ) {
			search( x + step, y, X, Y, step*2, partialPath + "E" );
			if ( found )
				return;
		}
		
		if ( !( y == Y && x < X ) ) {
			search( x - step, y, X, Y, step*2, partialPath + "W" );
			if ( found )
				return;
		}
		
		if ( !( x == X && y > Y ) ) {
			search( x, y + step, X, Y, step*2, partialPath + "N" );
			if ( found )
				return;
		}
		
		if ( !( x == X && y < Y ) ) {
			search( x, y - step, X, Y, step*2, partialPath + "S" );
			if ( found )
				return;
		}
	}

	public static void main( String[] args ) throws Exception
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int numOfTestCases = Integer.parseInt( br.readLine() );
		
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		Scanner s = new Scanner( br );
		for ( int i = 0; i < numOfTestCases; i++ )
		{
			int X = s.nextInt();
			int Y = s.nextInt();
			
			calculate( X, Y, bw, i+1 );
		}
		
		s.close();
		
		bw.flush();

		br.close();
		bw.close();
	}
}
