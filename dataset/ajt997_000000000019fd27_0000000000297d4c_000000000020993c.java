// Imports
import java.util.*;
import java.io.*;

public class Solution {

    /**
     * @param args the command line arguments
     * @throws IOException, FileNotFoundException 
     */
    public static void main(String[] args) throws IOException, FileNotFoundException {
        
        // @TODO UNCOMMENT
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        
        
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(f.readLine());
            int[][] arr = new int[N][N];
            
            for(int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                for(int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            
            int trace = 0;
            int numrows = 0;
            int numcols = 0;
            for(int a = 0; a < N; a++) {
                boolean countedr = false;
                boolean countedc = false;
                int[] countr = new int[N+1];
                int[] countc = new int[N+1];
                
                trace += arr[a][a];
                for(int b = 0; b < N; b++) {
                    int currr = arr[a][b];
                    int currc = arr[b][a];
                    countr[currr]++;
                    countc[currc]++;
                    if(!countedr && countr[currr] > 1) {
                        numrows++;
                        countedr = true;
                    }
                    
                    if(!countedc && countc[currc] > 1) {
                        numcols++;
                        countedc = true;
                    }
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " 
                + trace + " " + numrows + " " + numcols);
        }
    }

}
