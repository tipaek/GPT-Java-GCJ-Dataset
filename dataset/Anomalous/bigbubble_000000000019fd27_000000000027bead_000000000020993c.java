import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = sc.nextInt(); 
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            
            int[][] array = new int[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    array[row][col] = sc.nextInt();
                }
            }
            
            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += array[j][j];
            }
            
            int reprows = 0;
            for (int row = 0; row < n; row++) {
                Set<Integer> set = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!set.add(array[row][col])) {
                        reprows++;
                        break;
                    }
                }
            }
            
            int repcols = 0;
            for (int col = 0; col < n; col++) {
                Set<Integer> set = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!set.add(array[row][col])) {
                        repcols++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + trace + " " + reprows + " " + repcols);
        }
    }
}