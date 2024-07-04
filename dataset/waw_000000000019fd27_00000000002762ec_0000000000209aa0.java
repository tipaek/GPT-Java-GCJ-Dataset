import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int cases = scanner.nextInt();

        for(int i=0;i<cases;i++){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String result = solve(n, k);
            System.out.println(String.format("Case #%d: %s", i + 1, result));
        }

    }

    private static String solve( int n, int k) {
        int[][] solution = new int[n][n];

        int[][] pass = go(solution, n, k,0, 0);

        if(pass == null) {
            return "IMPOSSIBLE";
        }

        return "POSSIBLE" + printArray(pass);
    }

    private static String printArray(int[][] arr){
        String s = "";
        for(int i=0;i<arr.length;i++) {
            s += "\n";
            for(int j=0;j<arr.length;j++ ){
                s+= arr[i][j] + " ";
            }
            s = s.substring(0, s.length() - 1);
        }

        return s;
    }

    private static int[][] go(int[][] solution, int n, int k, int x, int y) {


        if(isFilled(solution)) {
            if(meetsConditions(solution, k)){
                return solution;
            } else {
                return null;
            }
        }


        for (int i=1;i<=n;i++) {
            int nextX, nextY;

            nextX = x;
            nextY = y + 1;

            if(nextY == n) {
                nextX = x + 1;
                nextY = 0;
            }

            if(!doesColumnOrRowContainValue(solution, x, y, i)) {
                int[][] copy = copySolution(solution);
                copy[x][y] = i;
                int[][] result = go(copy, n, k, nextX, nextY);
                if(result != null) {
                    return result;
                }
            }
        }

        return null;
    }

    private static boolean meetsConditions(int[][] solution, int k) {
        int sum = 0;
        for(int i=0;i<solution.length;i++) {
            sum += solution[i][i];
        }
        return sum == k;
    }

    private static boolean isFilled(int[][] solution) {
        for(int i=0;i<solution.length;i++) {
            for(int j=0;j<solution.length;j++) {
                if(solution[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean doesColumnOrRowContainValue(int[][] solution, int x, int y, int value) {

        for(int i=0;i<solution.length;i++) {
            if(solution[i][y] == value) {
                return true;
            }
        }

        for(int i=0;i<solution.length;i++) {
            if(solution[x][i] == value) {
                return true;
            }
        }


        return false;
    }

    private static int[][] copySolution(int[][] solution){
        int[][] copy = new int[solution.length][solution.length];
        for(int i=0;i<solution.length;i++) {
            for(int j=0;j<solution[i].length;j++) {
                copy[i][j] = solution[i][j];
            }
        }
        return copy;
    }
}
