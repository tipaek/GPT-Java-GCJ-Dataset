import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    private static int n,k,t,sqr[][],temp;
    private static boolean row_safe[][],col_safe[][],solved;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int TestCases= scanner.nextInt();
        for (int i=0;i<TestCases;i++){
            row_safe=new boolean[60][60];
            col_safe=new boolean[60][60];
            solved=false;
            sqr=new int[60][60];
            n=scanner.nextInt();
            k=scanner.nextInt();
            temp=i;
            solver(1,1,0);
            if (!solved)
                System.out.println("Case #"+(temp+1)+": IMPOSSIBLE");
        }
    }
    public static void solver(int row,int col,int m){
        if (row == n && col == n + 1 && m == k && !solved) {
            solved = true;
            System.out.println("Case #" +(temp+1) + ": POSSIBLE");
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    System.out.print(sqr[i][j]);
                }
                System.out.println();
            }
            return;
        } else if (row > n) {
            return;
        } else if (col > n) {
            solver(row + 1, 1, m);
        }
        for (int i = 1; i <= n && !solved; ++i) {
            if (!row_safe[row][i] && !col_safe[col][i]) {
                row_safe[row][i] = col_safe[col][i] = true;
                if (row == col) {
                    m += i;
                }
                sqr[row][col] = i;

                solver(row, col + 1, m);

                row_safe[row][i] = col_safe[col][i] = false;
                if (row == col) {
                    m -= i;
                }
                sqr[row][col] = 0;
            }
        }
    }
}
