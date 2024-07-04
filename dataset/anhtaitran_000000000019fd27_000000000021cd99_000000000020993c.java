import java.util.*;
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = 1;
        int t = sc.nextInt();
        while (t > 0){
            int n = sc.nextInt();
            int y, x;
            int trace = 0, row = 0, col = 0;
            int[][] m = new int[n][n];
            for (y = 0; y < n; y++) {
                for(x = 0; x < n; x++){
                    m[y][x] = sc.nextInt();
                }
            }
            for (y = 0; y < n; y++){
                trace += m[y][y];
            }
            for (y = 0; y < n; y++) {
                boolean[] mark = new  boolean[n];
                for(x = 0; x < n; x++){
                    if (mark[m[y][x] - 1]){
                        row++;
                        break;
                    }
                    else{
                        mark[m[y][x] - 1] = true;
                    }
                }
            }
            for (x = 0; x < n; x++) {
                boolean[] mark = new  boolean[n];
                for(y = 0; y < n; y++){
                    if (mark[m[y][x] - 1]){
                        col++;
                        break;
                    }
                    else{
                        mark[m[y][x] - 1] = true;
                    }
                }
            }
            System.out.println("Case #" + c + ": " + trace +" " + row + " " + col);
            t--;
            c++;
        }
    }
}