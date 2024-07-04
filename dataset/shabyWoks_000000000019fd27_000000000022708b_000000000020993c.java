import java.io.*;
import java.util.*;

class Sol {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[N][N];
            
            for(int i=0; i<N; i++) {
                String[] inpA = br.readLine().trim().split(" ");
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(inpA[j]);
                }
            }
            
            int[] row = new int[N];
            int[] col = new int[N];
            int trace = 0;
            
            HashMap<String, Integer> map = new HashMap<>();
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    String sR = "R" + i + " " + arr[i][j];
                    String sC = "C" + j + " " + arr[i][j];
                    
                    if (map.containsKey(sR)) {
                        row[i] = 1;
                    } else {
                        map.put(sR, 1);
                    }
                    
                    if (map.containsKey(sC)) {
                        col[j] = 1;
                    } else {
                        map.put(sC, 1);
                    }
                    
                    if (i == j) {
                        trace += arr[i][j];
                    }
                }
            }
            
            int co = 0;
            int ro = 0;
            for(int i=0; i<N; i++) {
                if (row[i] == 1) ro++;
                if (col[i] == 1) co++;
            }
            
            System.out.println("Case #" + (t+1) + ": " + trace + " " + ro + " " + co);
        }
    }
}