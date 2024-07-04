import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = scanner.nextInt();
            int[][] a = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }
            
            int r = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(a[i][j])) {
                        r++;
                        break;
                    }
                }
            }
            
            int c = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(a[j][i])) {
                        c++;
                        break;
                    }
                }
            }
            
            int s = 0;
            for (int i = 0; i < n; i++) {
                s += a[i][i];
            }
            
            System.out.println("Case #" + testCase + ": " + s + " " + r + " " + c);
        }
        
        scanner.close();
    }
}