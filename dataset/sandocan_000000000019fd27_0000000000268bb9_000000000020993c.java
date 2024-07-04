import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner scanner;
    
    static int test = 1;
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        scanner.nextLine();
        
        while (T-- > 0) {
            solve();
        }
    }
    
    private static void solve() {
        int N = scanner.nextInt();
        int[][] M = new int[N][N];
    
        int k = 0;
        
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                M[i][j] = scanner.nextInt();
                
                if (i == j) {
                   k += M[i][j]; 
                }
            }  
        }
        
        int r = getR(M);
        int c = getC(M);
        
        System.out.println("Case #" + (test++) + ": " + k + " " + r + " " + c);
    }
    
    private static int getR(int[][] M) {
        int result = 0;
        
        for (int i = 0; i < M.length; i++) {
            Set<Integer> set = new HashSet<>();
            
            for (int j = 0; j < M[i].length; j++) {
                if (set.contains(M[i][j])) {
                    result++;
                    
                    break;
                }
                
                set.add(M[i][j]);
            }
        }
        
        return result;
    }
    
    private static int getC(int[][] M) {
        int result = 0;
        
        for (int i = 0; i < M.length; i++) {
            Set<Integer> set = new HashSet<>();
            
            for (int j = 0; j < M[i].length; j++) {
                if (set.contains(M[j][i])) {
                    result++;
                    
                    break;
                }
                
                set.add(M[j][i]);
            }
        }
        
        return result;
    }
}