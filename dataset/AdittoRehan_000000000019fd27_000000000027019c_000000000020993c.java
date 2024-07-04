import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int textCase = input.nextInt();
        for(int i=1;i<=textCase;i++)
        {
        int n = input.nextInt();
        int [][] matrix=new int[n][n];
        int trace = 0, sumRowDup= 0,sumColDup= 0;
        int []rowDup= new int[n];
        int []colDup= new int[n];
        //taking matrix input
        for(int row=0;row<n;row++)
        {
            for(int col=0;col<n;col++)
            {

                matrix[row][col] = input.nextInt();
                if(row==col) trace+=matrix[row][col];
            }

            //finding duplicate values in row
            for(int col = 0;col<n-1;col++)
            {
                for(int k=col+1;k<n;k++)
                {
                    if(matrix[row][col]==matrix[row][k]) {
                        if(rowDup[row]>0) break;
                        rowDup[row]++;

                    }
                }
            }

        }



            //finding duplicate values in col
            for(int col=0;col<n;col++)
            {
                for(int row = 0;row<n-1;row++)
                {
                    for(int k=row+1;k<n;k++)
                    {
                        if(matrix[row][col]==matrix[k][col]) {
                            if(colDup[col]==0) {
                                colDup[col]++;

                            }

                        }
                    }
                }
            }



            //getting rows those have duplicate values
            for(int x:rowDup)
            {
                sumRowDup +=x;
            }

            //getting col those have duplicate values
            for(int x:colDup)
            {
                sumColDup +=x;
            }


            System.out.println("Case #"+i+": "+trace+" "+sumRowDup+" "+sumColDup);
        }
    }

}
