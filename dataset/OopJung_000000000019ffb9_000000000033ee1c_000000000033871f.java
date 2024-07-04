import java.io.*;
import java.util.*;

public class Solution {
	
	static class Edge{
		int x;
		int y;
		
		public Edge(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <=T; t++) {
			st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			int[][] edge = new int[C+1][C+1];
			int[] node = new int[C+1];
			int[] visit = new int[C+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 2; i<=C; i++) {
				node[i] = -Integer.parseInt(st.nextToken());
			}
			ArrayList<Edge> original = new ArrayList<>();
			for(int i = 0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				original.add(new Edge(a,b));
				edge[a][b] = -1;
				edge[b][a] = -1;
			}
			
			visit[1] = 1;
			for(int i = 1; i<=C; i++) {
				if(visit[i] == 1) {
					for(int j = 1; j<=C; j++) {
						if(visit[j] == 0 && edge[i][j] == -1) {
							edge[i][j] = node[j] - node[i];
							edge[j][i] = edge[i][j];
							visit[j] = 1;
						}
					}
				}
			}
			
			bw.write("Case #" + t + ": ");
			for(int i = 0; i<D; i++) {
				int a = original.get(i).x;
				int b = original.get(i).y;
				if(edge[a][b] == -1) {
					bw.write("1000000");
				}
				else {
					bw.write(Integer.toString(edge[a][b]));
				}
				if(i != D-1) {
					bw.write(" ");
				}
				else {
					bw.write("\n");
				}
			}
			
			
		}
		

		bw.flush();
		br.close();
		bw.close();
	}
}


