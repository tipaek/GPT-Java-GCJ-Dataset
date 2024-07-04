import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int ca = 0;
		while(t>0) {
			t--;
			int c = sc.nextInt();
			int d= sc.nextInt();
			ca++;
			//remember to one index properly...
			int [] vals = new int[c+1];
			for(int i=2;i<=c;i++) {
				vals[i] = sc.nextInt();//represent i+2
			}
			ArrayList<Integer>[] edge = new ArrayList[c+1];
			for(int i=0;i<c+1;i++) {
				edge[i] = new ArrayList<Integer>();
			}
			int[][] order= new int[d][2];
			for(int i=0;i<d;i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				edge[u].add(v);
				edge[v].add(u);
				order[i][0] = u;
				order[i][1] = v;
			}
			int [][] latency = new int[101][101];
			for(int i=0;i<101;i++) {
				for(int j=0;j<101;j++) {
					latency[i][j] = 1000000;
				}
			}
			int [] time = new int[c+1];
			time[1] =0;
			for(int i=2;i<=c;i++) {
				time[i] = 1000000000;
			}
			//check for sure if we get the correct parent?
			for(int lat=-1; lat>=-c;lat--) {
				Queue<Integer> q = new LinkedList<Integer>();
				q.add(1);
				boolean[] visited = new boolean[c+1];
				while(!q.isEmpty()) {
					//remember to add... how do we need to process?
					int x = q.poll();
					visited[x] = true;
					int bestPar = -1;
					int bestTime = 1000000000;
					//best parent to take from
					for(int next : edge[x]) {
						if(time[next]<bestTime) {
							bestTime = time[next];
							bestPar = next;

						}
					}
					if(vals[x]<0) {
						if(vals[x]==lat) {
							//find the -vals[x] sorted list value...
							//and just add one to that LuL...?!!?
							int [] temp =new int[c+1];
							for(int i=1;i<=c;i++) {
								temp[i] = time[i];
							}
							Arrays.sort(temp);
							int tm = temp[-vals[x]]+1;
							int edgeVal= tm-bestTime;
							latency[x][bestPar] = edgeVal;
							latency[bestPar][x] = edgeVal;
							time[x] =tm;
							//is this all correct?
							//remember extra element...

						}
					}
					else {
						if(x!=1) {
							int edgeVal = vals[x]-bestTime;
							latency[bestPar][x] = edgeVal;
							latency[x][bestPar] = edgeVal;
							time[x] = vals[x];
							//are we doing this too many times...how can we chop it off?
						}
					}
					for(int next : edge[x]) {
						if(!visited[next]) {
							q.add(next);
						}
					}
				}
			}
			int [] ans = new int[d];
			for(int i=0;i<d;i++) {
				ans[i]= Math.min(latency[order[i][0]][order[i][1]],latency[order[i][1]][order[i][0]]);
			}
			System.out.print("Case #"+ca+": ");
			for(int i=0;i<d;i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();

		}
	}
}
