import java.util.*;
import java.lang.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] k = new int[T], r = new int[T], c = new int[T];

        for(int i = 0; i < T; i++)
        {
            int N = in.nextInt();
            Matrix mtr = new Matrix(in, N, N);
            mtr.readMatrix();
            int[] rowsAndColumns = mtr.repeatingRowsAndColumns();

            k[i] = mtr.trace;
            r[i] = rowsAndColumns[0];
            c[i] = rowsAndColumns[1];
        }

        for(int i = 0; i < T; i++)
        {
            System.out.println("Case #" + (i + 1) + ": " + k[i] + " " + r[i] + " " + c[i]);
        }
    }
}

class Matrix
{
    int rows, cols;
    public int trace = 0;
    int[][] a;
    Scanner in;

    public Matrix(Scanner in, int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        this.in = in;
        this.a = new int[rows][cols];
    }

    void readMatrix()
    {
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++) {
                a[i][j] = in.nextInt();
                if(i == j)
                    trace += a[i][j];
            }
    }

    int[] repeatingRowsAndColumns()
    {
        int noOfRows = 0, noOfColumns = 0;
        boolean foundRow = false, foundColumn = false;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols - 1; j++)
            {
                for(int k = j + 1; k < cols; k++)
                {
                    if(a[i][j] == a[i][k] && !foundRow)
                    {
                        foundRow = true;
                        noOfRows++;
                    }
                    if(a[j][i] == a[k][i] && !foundColumn)
                    {
                        foundColumn = true;
                        noOfColumns++;
                    }
                }
            }
            foundRow = foundColumn = false;
        }

        return new int[]{noOfRows, noOfColumns};
    }
}
