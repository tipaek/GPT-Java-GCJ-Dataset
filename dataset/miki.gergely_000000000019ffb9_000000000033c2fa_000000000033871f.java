import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution
{
	private static class Node
	{
		private final int id;
		private final Set<Edge> neighbours;
		
		private int latency;

		private Node( int id, Set<Edge> neighbours )
		{
			this.id = id;
			this.neighbours = neighbours;
		}
		
		public String toString() {
			return "id: " + id + ", latency: " + latency + ", neighbours: " + neighbours;
		}
	}
	
	private static class Edge
	{
		private final int id;
		private final int to;
		
		private int latency;

		private Edge( int id, int to )
		{
			this.id = id;
			this.to = to;
		}
		
		public String toString() {
			return "{id: " + id + ", to: " + to + ", latency: " + latency + "}";
		}
	}
	
	private static class NextNodeData
	{
		private final Node node;
		private Node minLatencyNextNode;
		private Edge minLatencyNextNodeEdge;
		
		private NextNodeData( Node node )
		{
			this.node = node;
		}
	}
	
	private static void calculate( int C, int D, int[] X, int[][] M, BufferedWriter bw, int n ) throws IOException
	{
		Map<Integer, Node> nodes = new HashMap<>();
		Map<Integer, Set<Node>> nodeOrder = new HashMap<>();
		
		for ( int i = 0; i < C; i++ )
		{
			int nodeId = i + 1;
			Set<Edge> neighbours = new HashSet<>();
			
			for ( int j = 0; j < D; j++ )
			{
				if ( M[j][0] == nodeId )
					neighbours.add( new Edge( j, M[j][1] ) );
				if ( M[j][1] == nodeId )
					neighbours.add( new Edge( j, M[j][0] ) );
			}
			
			Node node = new Node( nodeId, neighbours );
			if ( i != 0 )
				node.latency = -1;
			nodes.put( nodeId, node );
			
			int order = -X[i];
			if ( !nodeOrder.containsKey( order ) )
				nodeOrder.put( order, new HashSet<>() );
			nodeOrder.get( order ).add( node );
		}
		
		int nextMinLatency = 1;
		for ( int i = 1; i < C; i++ )
		{
			Set<Node> nodesInOrder = nodeOrder.get( i );
			if ( nodesInOrder == null )
				continue;
			Set<NextNodeData> nextNodes = new HashSet<>();
			for ( Node node : nodesInOrder )
			{
				NextNodeData nnd = new NextNodeData( node );
				for ( Edge e : node.neighbours )
				{
					Node neighbour = nodes.get( e.to );
					if ( neighbour.latency != -1 &&
							( nnd.minLatencyNextNode == null || nnd.minLatencyNextNode.latency > neighbour.latency ) )
					{
						nnd.minLatencyNextNode = neighbour;
						nnd.minLatencyNextNodeEdge = e;
					}
				}
				nextNodes.add( nnd );
			}
			
			int nextNodeLatency = 0;
			for ( NextNodeData nnd : nextNodes )
				nextNodeLatency = Math.max( nextNodeLatency, Math.max( nnd.minLatencyNextNode.latency + 1, nextMinLatency ) );
			for ( NextNodeData nnd : nextNodes )
			{
				nnd.node.latency = nextNodeLatency;
				nnd.minLatencyNextNodeEdge.latency = nextNodeLatency - nnd.minLatencyNextNode.latency;
			}
			nextMinLatency = nextNodeLatency + 1;
		}
		
		int[] results = new int[D];
		for ( Node node : nodes.values() )
			for ( Edge edge : node.neighbours )
				if ( edge.latency > 0 )
					results[edge.id] = edge.latency;
		
		String s = "";
		for ( int i = 0; i < D; i++ )
		{
			if ( s.length() > 0 )
				s += " ";
			s += ( results[i] == 0 ? "1000000" : Integer.toString( results[i] ) );
		}
		
		bw.append( "Case #"+n+": " + s + "\n" );
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
			int C = s.nextInt();
			int D = s.nextInt();
			int[] X = new int[C];
			for ( int j = 1; j < C; j++)
				X[j] = s.nextInt();
			
			int[][] M = new int[D][2];
			for ( int j = 0; j < D; j++ )
				for ( int k = 0; k < 2; k++ )
					M[j][k] = s.nextInt();
			
			calculate( C, D, X, M, bw, i+1 );
		}
		
		s.close();
		
		bw.flush();

		br.close();
		bw.close();
	}
}
