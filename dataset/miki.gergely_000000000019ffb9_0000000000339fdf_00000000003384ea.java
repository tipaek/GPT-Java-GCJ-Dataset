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
	private static void calculate( long L, long R, BufferedWriter bw, int n ) throws IOException
	{
		long l = L;
		long r = R;
		long i = 1;
		for ( ; ; i++ )
		{
			if ( l >= r && l >= i )
				l -= i;
			else if ( r > l && r >= i )
				r -= i;
			else
				break;
		}
		
		bw.append( "Case #"+n+": " + (i-1)+ " " + l + " " + r + "\n" );
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
			long L = s.nextLong();
			long R = s.nextLong();
			
			calculate( L, R, bw, i+1 );
		}
		
		s.close();
		
		bw.flush();

		br.close();
		bw.close();
	}
}
