import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static class Point implements Comparable<Point>{
		int id;
		int X;
		Point(int i , int x){
			id = i;
			X = x;
		}
		@Override
		public int compareTo(Point o) {
			return X - o.X;
		}
		@Override
		public String toString() {
			return id+" "+X;
		}
	}
	static void solve(int X[] , int U[] , int V[]){
		int cur = 0;
		Point ps[] = new Point[X.length];
		for(int i = 0 ; i < X.length ; ++i){
			ps[i] = new Point(i + 1 ,- X[i]);
		}
		int N = X.length + 1;
		int adj[][] = new int[N][N];
		for(int i = 0 ; i < U.length ; ++i){
			adj[U[i]][V[i]] = i + 1;
			adj[V[i]][U[i]] = i + 1;
		}
		int D = U.length;
		int latency[] = new int[D];
		int dist[] = new int[N];
		Arrays.fill(dist, -1);
		dist[0] = 0;
		Arrays.sort(ps);
//		System.out.println(Arrays.toString(ps));
		int L = 0;
		int prevX = 0;
		for(Point p : ps){
			if(prevX != p.X){
				L++;
			}
			for(int i = 0 ; i < N ; ++i){
				if(adj[i][p.id] == 0){
					continue;
				}
				if(dist[i] < 0){
					continue;
				}
				int d = adj[i][p.id] - 1;
				int l = L - dist[i];
//				System.out.println(d+" "+l);
				if(l > 0){
					latency[d] = l;
				}
			}
			dist[p.id] = L;
			prevX = p.X;
		}
		for(int i = 0 ; i < latency.length ; ++i){
			if(latency[i] == 0){
				latency[i] = 1000000;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int l : latency){
			sb.append(' ');
			sb.append(l);			
		}
//		System.out.println(Arrays.toString(latency));
		System.out.println(sb.toString());
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cn = sc.nextInt();
		for(int c = 1 ; c <= cn ; ++c){
			int C = sc.nextInt();
			int D = sc.nextInt();
			int X[] = new int[C - 1];
			for(int i = 0 ; i < X.length ; ++i){
				X[i] = sc.nextInt();
			}
			int U[] = new int[D];
			int V[] = new int[D];
			for(int i = 0 ; i < D ; ++i){
				int u = sc.nextInt() - 1;
				int v = sc.nextInt() - 1;
				U[i] = u;
				V[i] = v;
			}
			System.out.printf("Case #%d:" , c);
			solve(X , U , V);
		}
	}
}
