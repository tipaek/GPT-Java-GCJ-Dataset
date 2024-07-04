import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
3
4 4
-1 3 -2
1 2
1 3
2 4
3 4
4 4

1
3 3
2 -1
1 2
1 3
2 3

 */
public class Solution {

	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		int T=fs.nextInt();
		for (int tt=0; tt<T; tt++) {
			int n=fs.nextInt(), m=fs.nextInt();
			int[] times=new int[n];
			for (int i=1; i<n; i++)
				times[i]=fs.nextInt();
			PriorityQueue<Integer> getSickTimes=new PriorityQueue<>();
			PriorityQueue<Pair> sickBeforeMe=new PriorityQueue<>();
			for (int i=0; i<n; i++) {
				if (times[i]>=0) getSickTimes.add(times[i]);
				else sickBeforeMe.add(new Pair(-times[i], i));
			}
			int curTime=-99999;
			int nSick=0;
			while (true) {
				int sickAdd=0;
				while (!sickBeforeMe.isEmpty()) {
					if (sickBeforeMe.peek().value == nSick) {
						sickAdd++;
						Pair curPair=sickBeforeMe.remove();
						times[curPair.index]=curTime;
					}
					else if (sickBeforeMe.peek().value > nSick) {
						break;
					}
					else {
						throw null;
					}
				}
				if (sickAdd!=0) {
					nSick+=sickAdd;
					curTime++;
					continue;
				}
				//otherwise look at the next forced time
				if (getSickTimes.isEmpty()) break;
				int nextSickTime=getSickTimes.remove();
				curTime=nextSickTime+1;
				nSick++;
				while (!getSickTimes.isEmpty() && getSickTimes.peek() == nextSickTime) {
					getSickTimes.remove();
					nSick++;
				}
			}
			
//			System.out.println("Times: ");
//			System.out.println(Arrays.toString(times));
			for (int i:times) if (i<0) throw null;
			Edge[] edges=new Edge[m];
			for (int i=0; i<m; i++) edges[i]=new Edge(fs.nextInt()-1, fs.nextInt()-1);
			for (Edge e:edges) {
				if (times[e.a]!= times[e.b]) {
					e.c=Math.abs(times[e.a]-times[e.b]);
				}
			}
			System.out.print("Case #"+(tt+1)+": ");
			for (Edge e:edges) System.out.print(e.c+" ");
			System.out.println();
		}
	}
	
	static class Pair implements Comparable<Pair> {
		int value;
		int index;
		public Pair(int value, int index) {
			this.value=value;
			this.index=index;
		}
		
		public int compareTo(Pair o) {
			return Integer.compare(value, o.value);
		}
	}
	
	static class Edge {
		int a, b, c;
		public Edge(int a, int b) {
			this.a=a;
			this.b=b;
			this.c=1;
		}
	}
	

	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}

	
}
