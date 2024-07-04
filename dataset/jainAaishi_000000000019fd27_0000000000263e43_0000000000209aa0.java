import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Solution {
    
    static final int MAX = 100; 
    static int[][] mat = new int[MAX][MAX]; 
    
    
	public static void main(String[] args) throws Exception{
        FS sc = new FS(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt();
        int n = sc.nextInt();
        int trace = sc.nextInt();
        int sumDiagonal = 0;
        while(t-- > 0){
             constructMatrix(n);
             for(int i = 0; i< mat.length; i++){
                 for(int j = 0; j < mat[0].length; j++){
                     if(i == j){
                        sumDiagonal+=mat[i][i];   
                     }
                 }
             }
        }
        if(sumDiagonal == trace){
        out.printf("Case #%d: %s",t,"POSSIBLE");     
        }else{
            out.printf("Case #%d: %s",t,"IMPOSSIBLE"); 
        }
        out.close();
        }
    
     private static void constructMatrix(int n) 
    { 
        int right = n - 1, left = 0; 
        for(int i = 0; i < n; i++) 
        { 
            if(i % 2 == 0) 
            { 
                mat[i][right] = 1; 
                fillRemaining(i, right, n); 
                right--; 
            } 
              
            else
            { 
                mat[i][left] = 1; 
                fillRemaining(i, left, n); 
                left++; 
            } 
        } 
    } 
     
      static void fillRemaining(int i, int j, int n) 
    { 
        int x = 2; 
          for(int k = i + 1; k < n; k++) 
            mat[k][j] = x++; 
    
          for(int k = 0; k < i; k++) 
            mat[k][j] = x++; 
    }
    
	  private static class FS{
	        BufferedReader br;
	        StringTokenizer st;
	        FS(InputStream in){
	            br = new BufferedReader(new InputStreamReader(in));
	            st = new StringTokenizer("");
	        }
	         int nextInt() throws Exception
	        {
	            return Integer.parseInt(next());
	        }
	        
	        String next() throws Exception
	        {
	            if (st.hasMoreTokens())
	                return st.nextToken();
	            st = new StringTokenizer(br.readLine());
	            return next();
	        }
	    }
}
