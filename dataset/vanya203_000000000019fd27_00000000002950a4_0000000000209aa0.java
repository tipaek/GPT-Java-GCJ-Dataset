import java.util.*;
import java.io.*;

public class Solution {

    public static int[][] visited = null;

    public static void main(String[] args) {
        Scanner cs = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = cs.nextInt();

        for (int i = 1; i <= T; ++i) {
            int width = cs.nextInt();
            int sum = cs.nextInt();

            int[][] res = cubeIt(width, sum);
            System.out.printf("Case #%d: %s\n", i, res == null ? "IMPOSSIBLE" : "POSSIBLE");
            if (res != null){
                for (int[] r : res){
                    for (int k = 0; k < r.length; k++){
                        System.out.printf("%d%s", r[k], (k+1 == r.length ? "" : " "));
                    }
                    System.out.println();
                }
            }
        }
    }

    public static int[][] cubeIt(int width, int sum) {
        int[][] res = new int[width][width];
        visited = new int[width+1][sum+1];
        if (cubeRegression(res, sum, 0, 0, 0, 0)) {
            return res;
        }
        return null;
    }

    public static boolean cubeRegression(int[][] res, int sum, int row, int col, int rowDiff, int colDiff) {
        if (sum < 0){
            return false;
        }
        if (row + 1 == res.length && col + 1 == res.length && colDiff == 1){
            return sum == 0;
        }

        if (colDiff == 0 && rowDiff == 0){
            /*if (visited[row][sum] == -1){
                return false;
            }
            if (visited[row][sum] == 1){
                return true;
            }*/
            for (int i = 1; i <= res.length; i++){
                if (setVal(res, row, col, i)){
                    if (cubeRegression(res, sum - res[row][col], row, col, 1, 1)){
                        //visited[row][sum] = 1;
                        return true;
                    }
                }
            }
            //visited[row][sum] = -1;
        } else if (col + colDiff < res.length){
            for (int i = 1; i <= res.length; i++){
                if (setVal(res, row, col + colDiff, i)){
                    if(cubeRegression(res, sum, row, col, rowDiff, colDiff+1)){
                        return true;
                    }
                }
            }
        } else if (row + rowDiff < res.length){
            for (int i = 1; i <= res.length; i++){
                if (setVal(res, row + rowDiff, col, i)){
                    if (cubeRegression(res, sum, row, col, rowDiff + 1, colDiff)){
                        return true;
                    }
                }
            }
        } else {
            return cubeRegression(res, sum, row+1, col+1, 0, 0);
        }
        return false;
    }

    public static boolean setVal(int[][] res, int row, int col, int start ){
        boolean good = true;
        for (int j = col -1; good && j >= 0; j--){
            good = res[row][j] != start;
        }
        for (int j = row - 1; good && j >= 0; j--){
            good = res[j][col] != start;
        }
        if (good){
            res[row][col] = start;
            return true;
        }
        return false;
    }

}
