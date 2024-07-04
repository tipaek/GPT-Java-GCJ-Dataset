import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Solution
{
	private static boolean middle = false;
	private static long pointX;
	private static long pointXAlt;
	private static long pointY;
	private static long pointYAlt;

	private static void calculate( long A, long B, BufferedReader br, BufferedWriter bw ) throws Exception
	{
		middle = false;
		pointX = 0;
		pointXAlt = 0;
		pointY = 0;
		pointYAlt = 0;
		
		findPoint( br, bw );
		if ( middle ) return;
		
		findHorizontalMiddle( A, B, br, bw );
		if ( middle ) return;

		findVerticalMiddle( A, B, br, bw );
		if ( middle ) return;
		
		hit( pointX, pointY, br, bw );
		if ( middle ) return;
		hit( pointXAlt, pointY, br, bw );
		if ( middle ) return;
		hit( pointX, pointYAlt, br, bw );
		if ( middle ) return;
		hit( pointXAlt, pointYAlt, br, bw );
		if ( middle ) return;
	}
	
	private static void findPoint( BufferedReader br, BufferedWriter bw ) throws IOException
	{
		LinkedList<long[]> q = new LinkedList<>();
		q.add( new long[] { 0, 0, 1000000000l } );
		while ( true )
		{
			long[] point = q.pop();
			bw.append( point[0] + " " + point[1] + "\n" );
			bw.flush();
			String s = br.readLine();
			if ( "CENTER".equals( s ) )
			{
				middle = true;
				return;
			} else if ( "HIT".equals( s ) ) {
				pointX = point[0];
				pointY = point[1];
				return;
			}
			
			long newSize = point[2] / 2;
			q.add( new long[] { point[0] + newSize, point[1] + newSize, newSize } );
			q.add( new long[] { point[0] + newSize, point[1] - newSize, newSize } );
			q.add( new long[] { point[0] - newSize, point[1] + newSize, newSize } );
			q.add( new long[] { point[0] - newSize, point[1] - newSize, newSize } );
		}
	}
	
	private static void findHorizontalMiddle( long A, long B, BufferedReader br, BufferedWriter bw ) throws IOException
	{
		long leftMin = Math.max( -1000000000l, pointX - 2*A );
		long leftMax = pointX;
		
		boolean leftMaxFound = hit( leftMin, pointY, br, bw );
		if ( middle ) return;
		if ( leftMaxFound )
			leftMax = leftMin;
		while ( !leftMaxFound )
		{
			long leftMid = ( leftMin + leftMax ) / 2;
			bw.append( leftMid + " " + pointY + "\n" );
			bw.flush();
			String s = br.readLine();
			if ( "CENTER".equals( s ) )
			{
				middle = true;
				return;
			} else if ( "HIT".equals( s ) )
				leftMax = leftMid;
			else
				leftMin = leftMid;
			
			if ( leftMin >= leftMax - 1 )
				leftMaxFound = true;
		}
		
		long rightMin = pointX;
		long rightMax = Math.min( pointX + 2*A, 1000000000l );
		boolean rightMinFound = hit( rightMax, pointY, br, bw );
		if ( middle ) return;
		if ( rightMinFound )
			rightMin = rightMax;
		while ( !rightMinFound )
		{
			long rightMid = ( rightMin + rightMax ) / 2;
			bw.append( rightMid + " " + pointY + "\n" );
			bw.flush();
			String s = br.readLine();
			if ( "CENTER".equals( s ) )
			{
				middle = true;
				return;
			} else if ( "HIT".equals( s ) )
				rightMin = rightMid;
			else
				rightMax = rightMid;
			
			if ( rightMin >= rightMax - 1 )
				rightMinFound = true;
		}
		
		if ( ( leftMax + rightMin ) % 2 == 0 )
		{
			pointX = ( leftMax + rightMin ) / 2;
			pointXAlt = -1;
		} else {
			pointX = ( leftMax + rightMin ) / 2;
			pointXAlt = pointX + 1;
		}
	}
	
	private static void findVerticalMiddle( long A, long B, BufferedReader br, BufferedWriter bw ) throws IOException
	{
		long downMin = Math.max( -1000000000l, pointY - 2*A );
		long downMax = pointY;
		boolean downMaxFound = hit( pointX, downMin, br, bw );
		if ( middle ) return;
		if ( downMaxFound )
			downMax = downMin;
		while ( !downMaxFound )
		{
			long downMid = ( downMin + downMax ) / 2;
			bw.append( pointX + " " + downMid + "\n" );
			bw.flush();
			String s = br.readLine();
			if ( "CENTER".equals( s ) )
			{
				middle = true;
				return;
			} else if ( "HIT".equals( s ) )
				downMax = downMid;
			else
				downMin = downMid;
			
			if ( downMin >= downMax - 1 )
				downMaxFound = true;
		}
		
		long upMin = pointY;
		long upMax = Math.min( pointY + 2*A, 1000000000l );
		boolean upMinFound = hit( pointX, upMax, br, bw );
		if ( middle ) return;
		if ( upMinFound )
			upMin = upMax;
		while ( !upMinFound )
		{
			long upMid = ( upMin + upMax ) / 2;
			bw.append( pointX + " " + upMid + "\n" );
			bw.flush();
			String s = br.readLine();
			if ( "CENTER".equals( s ) )
			{
				middle = true;
				return;
			} else if ( "HIT".equals( s ) )
				upMin = upMid;
			else
				upMax = upMid;
			
			if ( upMin >= upMax - 1 )
				upMinFound = true;
		}
		
		if ( ( downMax + upMin ) % 2 == 0 )
		{
			pointY = ( downMax + upMin ) / 2;
			pointYAlt = -1;
		} else {
			pointY = ( downMax + upMin ) / 2;
			pointYAlt = pointY + 1;
		}
	}
	
	private static boolean hit( long x, long y, BufferedReader br, BufferedWriter bw ) throws IOException {
		bw.append( x + " " + y + "\n" );
		bw.flush();
		String s = br.readLine();
		if ( "CENTER".equals( s ) )
		{
			middle = true;
			return true;
		} else if ( "HIT".equals( s ) )
			return true;
		else
			return false;
	}
	
	public static void main( String[] args ) throws Exception
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		String[] data = br.readLine().split( " " );
		int numOfTestCases = Integer.parseInt( data[0] );
		long A = Long.parseLong( data[1] );
		long B = Long.parseLong( data[2] );
		for ( int i = 0; i < numOfTestCases; i++ )
			calculate( A, B, br, bw );
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}
