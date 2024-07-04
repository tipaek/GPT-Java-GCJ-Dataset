import java.util.*;

public class Solution {
    Scanner sc = new Scanner(System.in);

    void run(){
        int tests = sc.nextInt();

        for( int t = 0; t < tests; t++){
            solve(t);
        }
    }

    void solve(int t){
        int x = t + 1;
        int k = 0;
        int r = 0;
        int c = 0;

        int N = sc.nextInt();

        //read in + diagonal
        int[][] square = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                square[i][j] = sc.nextInt();
                if (i == j) {
                    k += square[i][j];
                }
            }
        }

        //rows
        for (int i = 0; i < N; i++) {
            Set<Integer> row = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (row.contains(square[i][j])) {
                    r ++;
                    break;
                } else {
                    row.add(square[i][j]);
                }
            }

        }

        //columns
        for (int i = 0; i < N; i++) {
            Set<Integer> column = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (column.contains(square[j][i])) {
                    c ++;
                    break;
                } else {
                    column.add(square[j][i]);
                }
            }

        }

        System.out.println("Case #" + x +": " + k + " " + r + " " + c);


    }

    public static void main(String[] args){
        (new Solution()).run();
    }
}
