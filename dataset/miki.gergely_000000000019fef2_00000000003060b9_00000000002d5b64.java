import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution
{
	private static void calculate( int R, int S, BufferedWriter bw, int n ) throws IOException
	{
		List<int[]> deck = new ArrayList<>();
		for ( int s = 1; s <= S; s++ )
			for ( int r = 1; r <= R; r++ )
				deck.add( new int[] {r, s} );
		
		int maxNotOrdered = R;
		int maxNotOrderedPos = R*S - 1;
		
		List<String> moves = new ArrayList<>();
		while ( true )
		{
			while ( maxNotOrderedPos >= 0 && deck.get( maxNotOrderedPos )[0] == maxNotOrdered )
				maxNotOrderedPos--;
			
			if ( maxNotOrderedPos < 0 )
				break;
			
			int nextOfMaxNotOrdered = -1;
			for ( int i = maxNotOrderedPos - 1; i >= 0; i-- )
				if ( deck.get( i )[0] == maxNotOrdered )
				{
					nextOfMaxNotOrdered = i;
					break;
				}
			
			if ( nextOfMaxNotOrdered == -1 )
			{
				maxNotOrdered--;
				if ( maxNotOrdered < 1 )
					break;
				continue;
			}
			
			moves.add( ( nextOfMaxNotOrdered + 1 ) + " " + ( maxNotOrderedPos - nextOfMaxNotOrdered ) );
			List<int[]> newDeck = new ArrayList<>();
			newDeck.addAll( deck.subList( nextOfMaxNotOrdered + 1, maxNotOrderedPos + 1 ) );
			newDeck.addAll( deck.subList( 0, nextOfMaxNotOrdered + 1 ) );
			newDeck.addAll( deck.subList( maxNotOrderedPos + 1, deck.size() ) );
			
			deck = newDeck;
		}
		
		bw.append( "Case #"+n+": " + moves.size() + "\n" );
		for ( String move : moves )
			bw.append( move + "\n" );
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
			int R = s.nextInt();
			int S = s.nextInt();
			
			calculate( R, S, bw, i+1 );
		}
		
		s.close();
		
		bw.flush();

		br.close();
		bw.close();
	}
}
