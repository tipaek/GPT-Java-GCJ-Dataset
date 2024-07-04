import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		FastIO fio = new FastIO();
		int T = fio.nextInt();
		for (int i = 0; i < T; i++) {
			int N = fio.nextInt();
			int[][] matrix = new int[N][N];
			int caseNum = i + 1;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					matrix[j][k] = fio.nextInt();
				}
			}
			String outcome = count(matrix, N, caseNum);
			fio.println(outcome);
		}
		fio.close();
	}
	static String count(int[][] matrix, int N, int caseNum) {
		FastIO fio = new FastIO();
		ArrayList<HashSet<Integer>> rows = new ArrayList<>();
		ArrayList<HashSet<Integer>> columns = new ArrayList<>();
		int rowNum = 0, colNum = 0, trace = 0;
		for (int i = 0; i < N; i++) {
			HashSet<Integer> rowSet = new HashSet<>();
			HashSet<Integer> colSet = new HashSet<>();
			for (int j = 0; j < N; j++) {
				rowSet.add(matrix[i][j]);
				colSet.add(matrix[j][i]);
			}
			rows.add(rowSet);
			columns.add(colSet);
			if (rowSet.size() < N) {
				rowNum++;
			}
			if (colSet.size() < N) {
				colNum++;
			}
			trace += matrix[i][i];
		}
		return "Case #" + caseNum + ": " + trace + " " + rowNum + " " + colNum;
	}	
}

class FastIO extends PrintWriter 
{ 
    BufferedReader br; 
    StringTokenizer st;

    public FastIO() 
    { 
        super(new BufferedOutputStream(System.out)); 
        br = new BufferedReader(new
                InputStreamReader(System.in));
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
}