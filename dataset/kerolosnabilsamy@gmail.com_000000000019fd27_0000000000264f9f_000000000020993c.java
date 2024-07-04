/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CodeForces
{
    public static int countIdenticalRows(int mat[][])
    {

        int count = 0;

        for(int i=0;i<mat.length;i++)
        {
            List<Integer> arrList=new ArrayList<>();
            Set<Integer> set = new HashSet<Integer>();
            for(int j=0;j<mat[i].length;j++){
                arrList.add(mat[i][j]);
                set.addAll(arrList);

            }
            if(set.size()<arrList.size()){
                count++;
            }
        }

        return count;
    }
    public static int countIdenticalColumns(int mat[][])
    {

        int count = 0;

        for(int i=0;i<mat.length;i++)
        {
            List<Integer> arrList=new ArrayList<>();
            Set<Integer> set = new HashSet<Integer>();
            for(int j=0;j<mat[i].length;j++){
                arrList.add(mat[j][i]);
                set.addAll(arrList);

            }
            if(set.size()<arrList.size()){
                count++;
            }
        }

        return count;
    }



    public static int dSum(int[][]matrix){
        int sum=0;
        //Diagonalsum;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(i==j) //this condition checks for diagonal
                {
                    sum = sum + matrix[i][j];
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.println("Enter tests");
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.


        for (int i = 1; i <= t; ++i) {
            System.out.println("Enter rows");
            int rows=in.nextInt();
            int columns=rows;
            int[][] mat=new int[rows][columns];
            for (int j=0;j<mat.length;j++){
                for(int y=0;y<mat[j].length;y++){
                    System.out.println("Enter elemtns");
                    mat[j][y]=in.nextInt();}
            }
            for(int y=0; y<rows; y++)
            {
                for(int j=0; j<columns; j++)
                {
                    System.out.print(mat[y][j]+ "  ");
                }
                System.out.println();
            }
            System.out.println("Case #" + i + ": " + dSum(mat)+ " " +countIdenticalRows(mat)+" "+countIdenticalColumns(mat) );
        }
    }
}