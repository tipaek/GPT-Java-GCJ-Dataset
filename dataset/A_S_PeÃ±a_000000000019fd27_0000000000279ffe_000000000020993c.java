import java.util.*;


public class Solution {
    
    static Scanner SCNR = new Scanner(System.in);
    
    static int [] method1(int [][] arr, int N) {
        
        int [] res = new int [3];
        
        int r, c;
                    
        for (r = 0; r < N; ++r) {
            Set <Integer> s1 = new HashSet <Integer>();
                
            for (c = 0; c < N; ++c) {
                if (!s1.add(arr[r][c])) {
                    ++res[1];
                    break;
                }
            }
        }
        
        for (c = 0; c < N; ++c) {
            Set <Integer> s1 = new HashSet <Integer>();
                
            for (r = 0; r < N; ++r) {
                if (!s1.add(arr[r][c])) {
                    ++res[2];
                    break;
                }
            }
        }
        
        for (r = 0; r< N; ++r) {
            res[0] += arr[r][r];
            
        }
        
        
        return res;
    }
    
    
    public static void main (String [] args) {
        
        
        int T = SCNR.nextInt();
        int N;
        int i, j, m;
        int [] res;
        
        for (i = 1; i <= T; ++i) {
            N = SCNR.nextInt();

            int [][] arr = new int [N][N];
            for (j = 0; j < N; ++j) {
                for (m = 0; m < N; ++m) {
                    arr[j][m] = SCNR.nextInt();
                }
            }

            
            
            
            
            res = method1(arr, N);
            System.out.printf("Case #%d: %d %d %d\n", i, res[0], res[1], res[2]);
        }
        
        SCNR.close();
    }
}