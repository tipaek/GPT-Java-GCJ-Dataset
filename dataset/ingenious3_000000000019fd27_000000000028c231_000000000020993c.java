import java.util.Scanner;
import java.util.HashSet;

public class Solution {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i = 0; i < t; i++) {
            int n = s.nextInt();
            int[][] a = new int[n][n];
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    a[k][j] = s.nextInt();
                }
            }
            
            int d = 0;
            int rx = 0;
            int ry = 0;
            
            for(int x = 0; x < n; x++) {
                HashSet setX = new HashSet<Integer>();
                HashSet setY = new HashSet<Integer>();
                for(int y = 0; y < n; y++) {
                    int zx = a[x][y];
                    int zy = a[y][x];
                    setX.add(zx);
                    setY.add(zy);
                    if(x == y) {
                        d+=zx;
                    }
                }
                if(setX.size() < n) {
                    rx++;
                }
                if(setY.size() <n) {
                    ry++;
                }
            }
            
            System.out.println(String.format("Case #%d: %d %d %d", i+1, d, ry, rx));
            
        }
        s.close();
    }
}