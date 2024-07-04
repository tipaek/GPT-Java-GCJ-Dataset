import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] inputStr = br.readLine().split(" ");
            int n = Integer.parseInt(inputStr[0]);
            int sum = Integer.parseInt(inputStr[1]);
            System.out.print("Case #"+(i+1)+":");
            formLatinMatrix(n, sum);
        }
    }

    private static void formLatinMatrix(int n, int sum) {
        boolean flag = false;
        int[][] matrix = new int[n][n];
        for (int i = 1; i <= n; i++) {
            matrix[0][0] = i;
            if (findSolution(matrix, n, 0, 1) == true) {
                int diagSum = 0;
                for (int j = 0; j < n; j++) {
                    diagSum += matrix[j][j];
                }
                if (diagSum == sum) {
                    flag = true;
                    System.out.print(" POSSIBLE");
                    System.out.println();
                    for (int row = 0; row < n; row++) {
                        for (int col = 0; col < n; col++) {
                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }
                    
                    break;
                }
            }
        }
        if (flag == false)
        {
            System.out.print(" IMPOSSIBLE");
            System.out.println();
        }
        

    }

    private static boolean findSolution(int[][] matrix, int n, int row, int col) {
       // System.out.println("entering findsolution"+"row:"+row+" col:"+col);
        if (row >= n && col >= n)
            return true;

        for (int num = 1; num <= n; num++) {
            if (isSafe(matrix, n, num, row, col)) {
                matrix[row][col] = num;
                if(row==n-1 && col==n-1)
                    {//System.out.println("returning true final step");
                    return true;}
                
          
            if (col < n - 1) {
                if (findSolution(matrix, n, row, col + 1))
                    return true;
            } else {
                
                if (row<n-1 && findSolution(matrix, n, row + 1, 0))
                    return true;
            }}}
            matrix[row][col] = 0;
        
        return false;
    }

    private static boolean isSafe(int[][] matrix, int n, int num, int row, int col) {
       // System.out.println("row"+row+"col"+col+"num"+num);
//        for(int i=0;i<n;i++)
//        {
//            for(int j=0;j<n;j++)
//            {
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }
        for (int i = col; i >= 0; i--) {
            if (matrix[row][i] == num)
            {
               // System.out.println("returning true from isSafe");
                return false;
            }
        }
        for (int i = row; i >= 0; i--) {
            if (matrix[i][col] == num)
            {
               // System.out.println("returning false from isSafe");
                return false;
            }
        }
       // System.out.println("returning true from isSafe");
        return true;

    }
}
