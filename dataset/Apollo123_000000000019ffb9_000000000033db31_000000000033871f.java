import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static Node[] computers;
	public static void main(String[] args){
		Kattio scan = new Kattio(System.in);
		int T = scan.getInt();
		
		for(int t = 1; t<=T; t++){
			int C = scan.getInt();
			int D = scan.getInt();
			
			
			computers = new Node[C];
			computers[0] = new Node(0, 0);
			PriorityQueue<Node> queue = new PriorityQueue<>();
			for(int i = 1; i<C; i++){
				computers[i] = new Node(i, -scan.getInt());
				queue.add(computers[i]);
			}
			Edge[] edges = new Edge[D];
			for(int i = 0; i<D; i++){
				int u = scan.getInt()-1;
				int v = scan.getInt()-1;
				Edge e = new Edge(u,v);
				edges[i] = e;
				computers[u].next.add(e);
				computers[v].next.add(e);
			}
			
			
			
			while(!queue.isEmpty()){
				Node n = queue.poll();
				Edge e = n.getEdge();
				Node prev = computers[e.getTo(n.computer)];
				e.latency = n.before-prev.before;
			}
			System.out.print("Case #" + t + ":");
			for(int i = 0; i<D; i++){
				System.out.print(" " + edges[i].latency);
			}
			System.out.println();
		}
		
		
	}
	
	static class Node implements Comparable<Node>{
		int computer;
		ArrayList<Edge> next;
		int before;
		
		Node(int c, int b){
			computer = c;
			before = b;
			next = new ArrayList<>();
		}
		
		Edge getEdge(){
			int smallest = Integer.MAX_VALUE;
			Edge ans = null;
			for(Edge e:next){
				int k = e.getTo(computer);
				if(computers[k].before<smallest){
					smallest = k;
					ans =e;
				}
			}
			
			
			return ans;
		}
		
		@Override
		public int compareTo(Node n) {
			if(before>n.before){
				return 1;
			}else if(before<n.before){
				return -1;
			}
			return computer-n.computer;
		}
		
	}
	
	static class Edge{
		int from;
		int to;
		int latency;
		
		Edge(int f, int t){
			from = f;
			to  =t;
			latency = Integer.MAX_VALUE;
		}
		
		int getTo(int from){
			if(from == this.from){
				return to;
			}else{
				return this.from;
			}
		}
		
	}
	
	private static class Kattio extends PrintWriter {
		public Kattio(InputStream i) {
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public Kattio(InputStream i, OutputStream o) {
			super(new BufferedOutputStream(o));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public boolean hasMoreTokens() {
			return peekToken() != null;
		}

		public int getInt() {
			return Integer.parseInt(nextToken());
		}

		public double getDouble() {
			return Double.parseDouble(nextToken());
		}

		public long getLong() {
			return Long.parseLong(nextToken());
		}

		public String getWord() {
			return nextToken();
		}

		private BufferedReader r;
		private String line;
		private StringTokenizer st;
		private String token;

		private String peekToken() {
			if (token == null)
				try {
					while (st == null || !st.hasMoreTokens()) {
						line = r.readLine();
						if (line == null)
							return null;
						st = new StringTokenizer(line);
					}
					token = st.nextToken();
				} catch (IOException e) {
				}
			return token;
		}

		private String nextToken() {
			String ans = peekToken();
			token = null;
			return ans;
		}
	}


}
