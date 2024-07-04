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
        	int columnCount = 0;
        	int rowCount = 0;
        	ArrayList<TreeSet<Integer>> column = new ArrayList<TreeSet<Integer>>();
        	boolean columnRepeat[] = new boolean[N];
        	for(int x=0; x<N; x++) column.add(new TreeSet<Integer>());
        	for(int x=0; x<N; x++) {
        		st = new StringTokenizer(in.readLine());
        		boolean rowRepeat = false;
        		TreeSet<Integer> row = new TreeSet<Integer>();
        		for(int y=0; y<N; y++) {
        			numbers[x][y] = Integer.parseInt(st.nextToken());
        			if(x==y) trace += numbers[x][y]; 
        			if(!row.add(numbers[x][y])) { //checks for row repeats within the current row
        				if(!rowRepeat) {
        					rowRepeat=true;
        					rowCount++;
        				}
        			}
        			if(!column.get(y).add(numbers[x][y])) {
        				if(!columnRepeat[y]) {
        					columnRepeat[y] = true;
        					columnCount++;
        				}
        			}
        		}
        	/* 	for(int y=0; y<N; y++) {
        			System.out.println(column.get(y));
        		} */
        		//System.out.println(Arrays.toString(columnRepeat));
        		//System.out.println(Arrays.toString(numbers[x]));
        	}
        	
        	System.out.printf("Case #%d: %d %d %d\n",c+1, trace, rowCount, columnCount);
            
        }
    }
}