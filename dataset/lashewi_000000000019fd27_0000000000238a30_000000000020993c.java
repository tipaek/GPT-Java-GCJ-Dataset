
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
//        int cases = 1;
        String[] ansArray = new String[cases];

        for(int i = 0; i<cases; i++) {

            int diag , rowCount , colCount;

            int row = sc.nextInt();
            int[][] first = new int[row][row];

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < row; c++) {
                    first[r][c] = sc.nextInt();
                }
            }

            diag = countDiag(first);
            colCount = countCol(first);
            rowCount = countRow(first);

            String myString = "Case #" + (i+1) + ": " + diag + " " + rowCount + " " + colCount;
            ansArray[i] = myString;
            //System.out.println(myString);
        }
        //System.out.println(Arrays.toString(ansArray));
        for (String var : ansArray)
        {
            System.out.println(var);
        }

    }

    private static int countRow(int[][] matrix){
        int rowCount = 0;
        for (int row = 0; row < matrix.length; row++)
        {
            for (int col = 0; col < matrix.length; col++)
            {
                int num = matrix[row][col];
                for (int otherCol = col + 1; otherCol < matrix.length; otherCol++)
                {
                    if (num == matrix[row][otherCol])
                    {
                        rowCount++;
                        break;
                    }
                }
                break;
            }
        }

        return rowCount;
    }

    private static int countCol(int[][] matrix){
        int colCount = 0;
        for (int row = 0; row < matrix.length; row++)
        {
            for (int col = 0; col < matrix.length; col++)
            {
                int num = matrix[col][row];
                for (int otherCol = col + 1; otherCol < matrix.length; otherCol++)
                {
                    if (num == matrix[otherCol][row])
                    {
                        colCount++;
                        break;
                    }
                }
                break;
            }
        }

        return colCount;
    }

    private static int countDiag(int[][] matrix){
        int principal = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j)
                    principal += matrix[i][j];
            }
        }
       // System.out.println(principal);
        return  principal;
    }

}
