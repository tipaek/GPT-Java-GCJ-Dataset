import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for(int t = 1; t <= numTests; t++){
            int n = sc.nextInt();
            int[][] board = new int[n][n];

            int trace = 0;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    board[i][j] = sc.nextInt();
                    if(i == j){
                        trace += board[i][j];
                    }
                }
            }

            int repeatedRows = 0;
            int repeatedCols = 0;

            for(int i = 0; i < n; i++){
                Set<Integer> used = new HashSet<>();
                boolean repeated = false;
                for(int j = 0; j < n; j++){
                    if(used.contains(board[i][j])){
                        repeated = true;
                        break;
                    } else {
                        used.add(board[i][j]);
                    }
                }
                if(repeated) repeatedRows++;
            }

            for(int j = 0; j < n; j++){
                Set<Integer> used = new HashSet<>();
                boolean repeated = false;
                for(int i = 0; i < n; i++){
                    if(used.contains(board[i][j])){
                        repeated = true;
                        break;
                    } else {
                        used.add(board[i][j]);
                    }
                }
                if(repeated) repeatedCols++;
            }

            System.out.println("Case #" + t + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
}
