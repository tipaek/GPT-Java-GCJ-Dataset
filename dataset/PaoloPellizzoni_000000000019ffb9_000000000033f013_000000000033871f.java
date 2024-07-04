import java.util.*;
import java.io.*;

public class Solution
{
    static IO io = new IO();
	static ArrayList<Integer>[] adjList;
    public static void main(String[] args)
    {
		int T = io.getInt();
		for(int cas=1; cas<=T; cas++){
			int n = io.getInt();
			int m = io.getInt();
			adjList = new ArrayList[n];
			int[] faster = new int[n];
			adjList[0] = new ArrayList<>();
			for(int i=1; i<n; i++){
				faster[i] = io.getInt()*-1;
				adjList[i] = new ArrayList<>();
			}
			int[][] adjmat = new int[n][n];
			for(int i=0; i<m; i++){
				int u = io.getInt()-1;
				int v = io.getInt()-1;
				adjList[u].add(v);
				adjList[v].add(u);
				adjmat[u][v] = i;
				adjmat[v][u] = i;
			}
			int[] latencies = new int[m];
			Arrays.fill(latencies, 1000000-1);
/*
			int[] distance = new int[n];
			Arrays.fill(distance, -10);
			PriorityQueue<Integer> pq = new PriorityQueue<>( (aa,bb)->faster[aa]-faster[bb]);
			pq.offer(0);
			int processed = 0;
			int distSoFar = 0;
			while(!pq.isEmpty()){
				int u = pq.poll();
				
				if(processed == faster[u]){
					distance[u] = distSoFar;
					distSoFar++;
					
				}
				else{
					
					distance[u] = distSoFar-1;
				}
				
				processed++;
				for(Integer v : adjList[u]){
					if(distance[v] == -10)
						pq.offer(v);
				}
			}
			
			io.println(Arrays.toString(distance));
			*/
			for(int i=0; i<n; i++){
				for(Integer j : adjList[i]){
					int k = adjmat[i][j];
					latencies[k] = Math.abs(faster[i]-faster[j]);
					if(latencies[k] == 0)
						latencies[k] = 1000000-1;
				}
			}
			
			//io.println(Arrays.toString(latencies));
			
			io.print("Case #"+cas+":");
			for(Integer i : latencies)
				io.print(" "+i);
			io.println();
		}
		
		
        io.close();
    }
	
	/*
	public static void dijkstra()
	{
		// -----  DIJKSTRA  -----
		dist = new ArrayList<Integer>(Collections.nCopies(n, 1000000000));
		dist.set(s, 0); //dist from s
		PriorityQueue<IntegerPair> pq = new PriorityQueue<IntegerPair>();
		
		pq.offer(new IntegerPair(0, s));
		
		while (!pq.isEmpty()) { // main loop
			IntegerPair top = pq.poll(); //pick shortest unvisited vertex
			int d = top.first(); 
			int u = top.second();
			if (d > dist.get(u)) 
				continue; //We want to process vertex u only once 
			for(int i=0; i< adjList[u].size(); i++)
			{ 
				IntegerPair p = adjList[u].get(i);
				int v = p.first();
				int weight_u_v = p.second();
				if (dist.get(u) + weight_u_v < dist.get(v)) 
				{ 
					dist.set(v, dist.get(u) + weight_u_v); // relax              
					pq.offer(new IntegerPair(dist.get(v), v)); 
					path[v] = new ArrayList<IntegerPair>();
				} 
				if (dist.get(u) + weight_u_v == dist.get(v))
				{
					path[v].add(new IntegerPair(u, weight_u_v));
				}
			}
		}
		
		//  ----- END -----
	}
	*/
}

class IntegerPair implements Comparable {
  Integer _first, _second;

  public IntegerPair(Integer f, Integer s) {
    _first = f;
    _second = s;
  }

  public int compareTo(Object o) {
    if (!this.first().equals(((IntegerPair)o).first()))
      return this.first() - ((IntegerPair)o).first();
    else
      return this.second() - ((IntegerPair)o).second();
  }

  Integer first() { return _first; }
  Integer second() { return _second; }
}


class IO extends PrintWriter {
	public IO() {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(System.in));
    }

    public IO(String fileName) {
        super(new BufferedOutputStream(System.out));
        try{
            r = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            this.println("File Not Found");
        }
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

	public String getLine(){
        try{
            st = null;
            return r.readLine();
        }
        catch(IOException ex){}
        return null;
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
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
