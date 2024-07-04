import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution
{
	private static void calculate( String S, BufferedWriter bw, int n ) throws Exception
	{
		String sv = transform( S, 0 );
		
		bw.append( "Case #"+n+": " + sv + "\n" );
		bw.flush();
	}
	
	private static String transform( String s, int c )
	{
		if ( s.length() == 0 )
			return "";
		
		if ( s.length() == 1 )
		{
			String sv = s;
			for ( int i = 0; i < s.charAt( 0 ) - '0' - c ; i++ )
				sv = "(" + sv + ")";
			
			return sv;
		}
		
		String[] parts = s.split( Integer.toString( c ), -1 );
		String sv = "";
		boolean start = true;
		for ( String part : parts )
		{
			String partv = ( part.length() == 0 ) ? "" : "(" + transform( part, c + 1 ) + ")";
			sv += ( !start ? Integer.toString( c ) : "" ) + partv;
			start = false;
		}
		return sv;
	}
	
	public static void main( String[] args ) throws Exception
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int numOfTestCases = Integer.parseInt( br.readLine() );
		
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		Scanner s = new Scanner(br);
		for ( int i = 0; i < numOfTestCases; i++ )
		{
			String S = s.next();
			
			calculate( S, bw, i+1 );
		}
		
		s.close();
		bw.flush();

		br.close();
		bw.close();
	}
}
