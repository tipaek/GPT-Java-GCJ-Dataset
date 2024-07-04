import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

public class Solution
{
	private static class Hole implements Comparable<Hole>
	{
		private final int x;
		private final int y;
		
		private Hole( int x, int y ) {
			this.x = x;
			this.y = y;
		}
		
		public int hashCode() {
			return x + y;
		}
		
		public boolean equals(Object other) {
			return ((Hole)other).x == x && ((Hole)other).y == y;
		}
		
		public String toString() {
			return "{" + x + ", " + y + "}";
		}

		@Override
		public int compareTo( Hole other ) {
			if ( x > other.x )
				return 1;
			if ( x < other.x )
				return -1;
			if ( y > other.y )
				return 1;
			if ( y < other.y )
				return -1;
			return 0;
		}
	}
	
	private static class HolePair
	{
		private final Hole hole1;
		private final Hole hole2;
		
		private final int xDiff;
		private final int yDiff;
		
		private HolePair( Hole hole1, Hole hole2 )
		{
			this.hole1 = hole1;
			this.hole2 = hole2;
			
			int _xDiff;
			int _yDiff;
			
			if ( hole1.x > hole2.x )
			{
				_xDiff = hole1.x - hole2.x;
				_yDiff = hole1.y - hole2.y;
			}
			else if ( hole2.x > hole1.x )
			{
				_xDiff = hole2.x - hole1.x;
				_yDiff = hole2.y - hole1.y;
			}
			else
			{
				_xDiff = 0;
				_yDiff = 1;
			}
			
			int gcd = gcd( _xDiff, _yDiff );
			xDiff = _xDiff / gcd;
			yDiff = _yDiff / gcd;
		}
		
		private String getSteepness() {
			return xDiff + "/" + yDiff;
		}
	}
	
	private static int gcd( int n1, int n2 )
	{
		if ( n2 == 0 ) {
			return n1;
		}
		return gcd( n2, n1 % n2 );
	}
	
	private static void calculate( int N, Hole[] holes, BufferedWriter bw, int n ) throws IOException
	{
		if ( N == 1 )
		{
			bw.append( "Case #"+n+": 1\n" );
			bw.flush();
			return;
		}
		
		Map<String, List<HolePair>> steepnesses = new HashMap<>();
		for ( int i = 0; i < N; i++ )
			for ( int j = i+1; j < N; j++ )
			{
				HolePair hp = new HolePair(holes[i], holes[j]);
				String steepness = hp.getSteepness();
				if ( !steepnesses.containsKey( steepness ) )
					steepnesses.put( steepness, new ArrayList<>() );
				steepnesses.get( steepness ).add( hp );
			}
		
		int max = 0;
		for ( Map.Entry<String, List<HolePair>> steepnessGroup : steepnesses.entrySet() )
		{
			Set<Hole> holesInGroup = new HashSet<>();
			for ( HolePair hp : steepnessGroup.getValue() )
			{
				holesInGroup.add( hp.hole1 );
				holesInGroup.add( hp.hole2 );
			}
			
			List<List<Hole>> lineList = new ArrayList<>();
			mainCycle: for ( Hole hole : holesInGroup )
			{
				for ( List<Hole> line : lineList )
				{
					HolePair hp = new HolePair( hole, line.get( 0 ) );
					if ( hp.getSteepness().equals(steepnessGroup.getKey() ) )
					{
						line.add( hole );
						continue mainCycle;
					}
				}
				List<Hole> newLine = new ArrayList<>();
				newLine.add( hole );
				lineList.add( newLine );
			}
			
			int otherHoles = N - holesInGroup.size();
			int rests = 0;
			int num = 0;
			for ( List<Hole> line : lineList )
			{
				int res = line.size() % 2;
				rests += res;
				num += line.size() - res;
			}
			
			int restRes = rests % 2;
			num += rests - restRes;
			otherHoles += restRes;
			
			if ( otherHoles >= 2 )
				num += 2;
			else if ( otherHoles >= 1 )
				num += 1;
			
			max = Math.max( num, max );
		}
		
		bw.append( "Case #"+n+": " + max + "\n" );
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
			Hole[] holes = new Hole[N];
			for ( int j = 0; j < N; j++ )
			{
				holes[j] = new Hole( s.nextInt(), s.nextInt() );
			}
			
			calculate( N, holes, bw, i+1 );
		}
		
		s.close();
		
		bw.flush();

		br.close();
		bw.close();
	}
}
