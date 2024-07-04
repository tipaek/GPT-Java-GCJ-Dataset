import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution
{
	private static void calculate( int N, int[][] M, BufferedWriter bw, int n ) throws IOException
	{
		int trace = 0;
		int repeatRows = 0;
		int repeatColumns = 0;
		for ( int i = 0; i < N; i++ )
		{
			trace += M[i][i];
			
			boolean repeatRow = false;
			boolean repeatColumn = false;
			Set<Integer> rowValues = new TreeSet<>();
			Set<Integer> columnValues = new TreeSet<>();
			for ( int j = 0; j < N; j++ )
			{
				if ( rowValues.contains( M[i][j] ) )
					repeatRow = true;
				rowValues.add( M[i][j] );
				
				if ( columnValues.contains( M[j][i] ) )
					repeatColumn = true;
				columnValues.add( M[j][i] );
			}
			if ( repeatRow )
				repeatRows++;
			if ( repeatColumn )
				repeatColumns++;
		}
		
		bw.append( "Case #"+n+": " + trace + " " + repeatRows + " " + repeatColumns + "\n" );
		bw.flush();
	}
	
	public static void main( String[] args ) throws Exception
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int numOfTestCases = Integer.parseInt( br.readLine() );
		
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		Scanner s = new Scanner( br );
		for ( int i = 0; i < numOfTestCases; i++ )
		{
			int N = s.nextInt();
			int M[][] = new int[N][N];
			
			for ( int j = 0; j < N; j++ )
				for ( int k = 0; k < N; k++ )
					M[j][k] = s.nextInt();
			
			calculate( N, M, bw, i+1 );
		}
		
		s.close();
		
		bw.flush();

		br.close();
		bw.close();
	}
}
