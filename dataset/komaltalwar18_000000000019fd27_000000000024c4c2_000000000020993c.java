import java.util.*;

 public class LatinSquares {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);

        int test_Cases= input.nextInt();
        int flag=0;
        while(test_Cases!=0){
            flag++;
            
            int n= input.nextInt();
            int[][] matrix=new int[n][n];
           for(int i=0;i<n;i++){
               for(int j=0;j<n;j++)
               {
                   matrix[i][j]=input.nextInt();
               }
           }

           int r= hasDuplicates_row(matrix);
           int c= hasDuplicates_Col(matrix);
           int truce= calculateTruce(matrix);

            System.out.println("#"+ flag + " " + truce + " " + r + " " + c);
            test_Cases--;
        }


    }

    private static int hasDuplicates_Col(int[][] inArray) {
        int curCol;
        int count_col=0;
        Set<Integer> a = new HashSet<Integer>();
        for (int col = 0; col < inArray.length; col++) {
            for (int row = 0; row < inArray.length; row++) {
                curCol = inArray[row][col];
                a.add(curCol);
            }

            if (a.size() <inArray.length) {
                count_col++;
            }

            a.clear();
        }
        return count_col;
    }

    private static int calculateTruce(int[][] matrix) {
        int sum=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                if(i==j) //this condition checks for diagonal
                {
                     sum = sum + matrix[i][j];
                }
            }
        }
        return sum;
    }

    public static int hasDuplicates_row(int [][] inArray) {
        int curRow;
        int count_row=0;
        Set<Integer> a = new HashSet<Integer>();
        for (int row = 0; row < inArray.length; row++) {
            for (int col = 0; col < inArray.length; col++) {
                curRow = inArray[row][col];
                a.add(curRow);
            }

                if (a.size() <inArray.length) {
                    count_row++;

                }

                a.clear();
            }



        return count_row;
    }
}
