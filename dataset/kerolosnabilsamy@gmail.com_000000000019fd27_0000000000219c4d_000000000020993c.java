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
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        int[][]matrix={{ 2,1,3},{1,3,2},{1,2,3}};
        System.out.print(dSum(matrix)+" "+countIdenticalRows(matrix)+" "+countIdenticalColumns(matrix));
        /*
        *


        * */
    }
}