import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String args[]) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int cases = Integer.parseInt(st.nextToken());
        for(int c = 0; c<cases; c++){
        	st = new StringTokenizer(in.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int[][] numbers = new int[N][N];
        	int trace = 0;
        	TreeSet<Integer> values = new TreeSet<Integer>();
        	boolean[] row = new boolean[N];
        	boolean[] column = new boolean[N];
        	for(int x=0; x<N; x++) {
        		for(int y=0; y<N; y++) {
        			st = new StringTokenizer(in.readLine());
        			numbers[x][y] = Integer.parseInt(st.nextToken());
        			if(x==y) trace += numbers[x][y];
        			if(!values.add(numbers[x][y])) {
        				row[x] = true;
        				column[y] = true;
        			}
        		}
        	}
        	int rowCounts=0;
        	int columnCounts=0;
        	for(int x=0;x<N;x++) {
        		if(row[x])rowCounts++;
        		if(column[x])columnCounts++;
        	}
        	System.out.printf("Case #%d: %d %d %d\n",c+1, trace, rowCounts, columnCounts);
            
        }
    }
}