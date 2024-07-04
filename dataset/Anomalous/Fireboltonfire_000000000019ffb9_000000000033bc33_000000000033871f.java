import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            int[] counts = new int[c + 1];
            
            for (int j = 2; j <= c; j++) {
                counts[j] = -scanner.nextInt();
            }
            
            List<String> results = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                results.add(String.valueOf(Math.max(Math.abs(counts[u] - counts[v]), 1)));
            }
            
            System.out.println("Case #" + i + ": " + String.join(" ", results));
        }
        
        scanner.close();
    }
}