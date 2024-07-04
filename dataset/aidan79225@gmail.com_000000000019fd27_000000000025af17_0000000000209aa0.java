import java.util.Scanner;

public class Solution {
    private static String output1 = "Case #%d: POSSIBLE";
    private static String output2 = "Case #%d: IMPOSSIBLE";
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().getAnswer(caseNum, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnswer(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] m = new int[n][n];

        int[] diagonal = new int[n];


        boolean hasResult = fillDiagonal(diagonal, 0, n, k, (diagonal1, n1) -> {
            for (int i = 0; i < n1; ++i) {
                m[i][i] = diagonal1[i];
            }
            return solver(0, 0, m, n1);
        });

        if (hasResult) {
            System.out.println(String.format(output1, caseNum));
            for (int[] line: m) {
                for (int e: line) {
                    System.out.print(e + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println(String.format(output2, caseNum));
        }

    }
    interface DiagonalListener {
        boolean gotDiagonal(int[] diagonal, int n);
    }

    public boolean fillDiagonal(int[] diagonal, int idx, int n, int target, DiagonalListener diagonalListener) {
        if (idx == n) {
            if (target == 0) {
               return diagonalListener.gotDiagonal(diagonal, n);
            }
            return false;
        }

        for (int i = 1; i <= n; ++i) {
            diagonal[idx] = i;
            if (fillDiagonal(diagonal, idx+1, n, target-i, diagonalListener)) {
                return true;
            }
        }
        diagonal[idx] = 0;
        return false;
    }


    public boolean solver(int i, int j, int[][] a, int n){
        if(i >= n)return true;
        if(j >= n)return solver(i+1, 0, a, n);
        if(a[i][j] > 0)return solver(i, j+1, a, n);

        for (int k = 0; k < n; k++) {
            if (check(i, j, a, k+1, n)) {
                a[i][j] = k+1;
                if (solver(i, j+1, a, n)) return true;
                else a[i][j] = 0;
            }
        }
        return false;
    }

    public boolean check(int x,int y,int[][] a,int target, int n){
        for(int i=0; i<n ; i++){
            if(target == a[i][y])return false;
            if(target == a[x][i])return false;
        }
        return true;
    }

}
