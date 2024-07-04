import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
//import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{
	//private static final int LS = 20;
	
	private static void calculate( int T, int N, int C, BufferedReader br, BufferedWriter bw ) throws Exception
	{
		double ratio = (double)C / (double)T + 0.10;
		
		//FileWriter fw = new FileWriter( "log" + System.currentTimeMillis() + ".txt" );
		//fw.write( "T: " + T + " N: " + N + " C: " + C + " ratio: " + ratio + "\n" );
		//fw.flush();
		
		int[] ranges = new int[T];
		Arrays.fill( ranges, N );
		boolean[] dones = new boolean[T];
		int[] searchFor = new int[T];
		int[][] checks = new int[T][N];
		boolean[][] checkDones = new boolean[T][N];
		
		int stepCount = 0;
		while( true )
		{
			stepCount++;
			boolean allDone = true;
			int[] actualCheck = new int[T];
			StringBuilder sb = new StringBuilder();
			for ( int i = 0; i < T; i++ )
			{
				if ( sb.length() != 0 )
					sb.append( " " );
				
				if ( dones[i] )
					sb.append( "0" );
				else
				{
					for ( int j = 0; j < N; j++ )
						if ( !checkDones[i][j] && checks[i][j] < searchFor[i] + 1 )
						{
							actualCheck[i] = j;
							sb.append( j+1 );
							break;
						}
				}
				allDone &= dones[i];
			}
			
			if ( allDone || stepCount == (N * N+1) /2 )
				break;
			
			//fw.write( "Asked for " + sb + "\n" );
			//fw.flush();
			bw.append( sb.toString() + "\n" );
			bw.flush();
			String[] responses = br.readLine().split( " " );
			//fw.write( "Asked for " + Arrays.toString( Arrays.copyOf( checks, LS ) ) + "(" + Arrays.toString( Arrays.copyOf( dones, LS ) ) + "), got " + Arrays.toString( Arrays.copyOf( responses, LS ) ) + "\n" );
			//fw.flush();
			
			for ( int i = 0; i < responses.length; i++ )
			{
				if ( dones[i] )
					continue;
				
				String response = responses[i];
				if ( "0".equals( response ) )
				{
					checkDones[i][actualCheck[i]] = true;
					checks[i][actualCheck[i]] = searchFor[i];
					searchFor[i]++;
					if ( actualCheck[i] > ranges[i] - 2 )
						ranges[i]--;
				}
				else
					checks[i][actualCheck[i]]++;
			}
			
			for ( int i = 0; i < T; i++ )
				if ( !dones[i] && searchFor[i] > 2 && chance( searchFor[i], ranges[i], N ) > ratio )
				{
					//fw.append( i + " is done!\n" );
					//fw.flush();
					dones[i] = true;
				}
		}
		
		StringBuilder sb = new StringBuilder();
		for ( int i = 0; i < T; i++ )
		{
			if ( sb.length() != 0 )
				sb.append( " " );
			sb.append( "0" );
		}
		bw.append( sb.toString() + "\n" );
		bw.flush();
		
		sb = new StringBuilder();
		for ( int i = 0; i < T; i++ )
		{
			if ( sb.length() != 0 )
				sb.append( " " );
			
			int c = 0;
			for ( int j = N-1; j > 0; j-- )
				if ( !checkDones[i][j] )
				{
					sb.append( j+1 );
					if ( c == 0 )
					{
						sb.append( " " );
						c++;
					}
					else
						break;
				}
		}
		//fw.write( "Asked for " + sb + "\n" );
		//fw.flush();
		bw.append( sb.toString() + "\n" );
		bw.flush();
	}
	
	private static double chance( int start, int max, int N ) throws Exception
	{
		//fw.append( "out: " + out + "\n" );
		//fw.flush();
		
		List<Integer> l = new ArrayList<>();
		for ( int i = start; i < max; i++ )
			l.add( i );
		
		//fw.append( "l: " + l + "\n" );
		//fw.flush();
		
		int count = 0;
		for ( int i = 0; i < l.size() - 1; i++ )
			for ( int j = i + 1; j < l.size(); j++ )
				if ( l.get( i ) + l.get( j ) >= N )
					count++;
		
		int total = ((l.size() * (l.size() - 1)) / 2 );
		double chance = (double)count / (double)total;
		//fw.append( "count: " + count + " total: " + total + " chance: " + chance + "\n" );
		//fw.flush();
		
		return chance;
	}
	
	public static void main( String[] args ) throws Exception
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		String[] data = br.readLine().split( " " );
		int T = Integer.parseInt( data[0] );
		int N = Integer.parseInt( data[1] );
		int C = Integer.parseInt( data[2] );
		calculate( T, N, C, br, bw );
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}
