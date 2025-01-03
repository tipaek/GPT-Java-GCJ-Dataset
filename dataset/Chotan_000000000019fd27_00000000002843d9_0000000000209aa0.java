import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{   
    static HashSet<Integer> row[];
    static HashSet<Integer> col[];
    static int matrix[][];
    static int traceTotal = 0;
    static boolean[][] visited;
    static int totalVisited = 0;
    static int X[] = {0, 1, 0, -1};
    static int Y[] = {1, 0, -1, 0};
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    for(int t = 1; t <= T; t++) {
	        int N = sc.nextInt();
	        int K = sc.nextInt();
	        row = new HashSet[N];
	        col = new HashSet[N];
	        matrix = new int[N][N];
	        visited = new boolean[N][N];
	        for(int i = 0; i < N; i++) {
	            row[i] = new HashSet();
	            col[i] = new HashSet();
	        }
	        if(buildMatrix(0, 0, N, K)) {
	            System.out.println("Case #" + t + ": POSSIBLE");
	            for(int i = 0; i < N; i++) {
	                for(int j = 0; j < N-1; j++) {
	                    System.out.print(matrix[i][j] + " ");
	                }
	                System.out.println(matrix[i][N-1]);
	            }
	        } else {
	            System.out.println("Case #" + t + ": IMPOSSIBLE");
	        }
	        traceTotal = 0;
	        totalVisited = 0;
	    }
	}
	
	static boolean buildMatrix(int x, int y, int N, int K) {
        visited[x][y] = true;
        totalVisited += 1;
	    for(int i = 1; i <= N; i++) {
	        if(!row[x].contains(i) && !col[y].contains(i)) {
	            if(x == y) {
	                if(traceTotal + i > K) {
	                    return false;
	                } else {
	                    traceTotal += i;
	                }
	            }
	            row[x].add(i);
	            col[y].add(i);
	            matrix[x][y] = i;
	            boolean allClear = true;
                for(int j = 0; j < N; j++) {
        	        if(row[j].size() < N || col[j].size() < N) {
        	            allClear = false;
        	            break;
        	        }
        	    }
        	    if(allClear && totalVisited == N * N && traceTotal == K) {
        	        return true;
	            }
	            for(int dir = 0; dir < 4; dir++) {
	                if( x + X[dir] >= 0 && x + X[dir] < N && y + Y[dir] >= 0 && y + Y[dir] < N && !visited[x + X[dir]][y + Y[dir]] && buildMatrix(x + X[dir], y + Y[dir], N, K)) {
	                   return true;
	                }
	            }
	            row[x].remove(i);
                col[y].remove(i);
                matrix[x][y] = 0;
                if(x == y) {
                    traceTotal -= i;
                }
	        }
	    }
	    visited[x][y] = false;
        totalVisited -= 1;
        return false;
	} 
}