import java.util.*;
import java.lang.*;
import java.io.*;
 
class Solution {
    
    public static String answer(int [][] mat, int n, int T) {
        int repeatedRows = 0;
        int repeatedColumns =0, trace =0;
        for (int i = 0; i < n; i++) { 
            trace += mat[i][i];
        } 
				
	   for(int i=0;i<n;i++){
        	
        Set<Integer> rows = new HashSet<>();
           for(int j=0;j<n;j++){
                if(rows.contains(mat[i][j])) {
					repeatedRows++;
					break;
                }
				else {
					rows.add(mat[i][j]);
				}
           }
        }
        
        for(int j=0;j<n;j++){
        	
        Set<Integer> columns = new HashSet<>();
           for(int i=0;i<n;i++){
                if(columns.contains(mat[i][j])) {
					repeatedColumns++;
					break;
                }
				else {
					columns.add(mat[i][j]);
				}
           }
        }
        
        String answer = "Case #" + T +": " + 
        trace + " " + repeatedRows + " " + repeatedColumns;
        return answer;
    }
    
    public static void main(String[] args) {
		FastReader fr = new FastReader();

		int T = fr.nextInt();
	
		for(int i = 0; i < T; i++) {
			int N = fr.nextInt();
	
			
			int[][] mat = new int[N][N];
			int r=0;
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					mat[j][k] = fr.nextInt();
				
				}
				
			}
			System.out.println(answer(mat, N, i));
		// now logic comes here
		}

	}

	static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
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
    
    
}