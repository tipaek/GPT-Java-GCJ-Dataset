import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void CalMatrix(int [][] matrix, int t )
    {
        //check rows
        int dupRowCount = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<matrix.length; ++i)
        {
            set.clear();
            set.add(matrix[i][0]);
            boolean flag =  false;
            for(int j=1; j < matrix[0].length; ++j)
            {
                int val = matrix[i][j];
                if(set.contains(val)) {
                flag = true;
                break;
                }
                else
                    set.add(val);
            }
            if(flag)
                dupRowCount++;
        }
        set.clear();
        int dupColCount = 0;
        for(int j=0; j<matrix[0].length; ++j)
        {
            set.clear();
            set.add(matrix[0][j]);
            boolean flag =  false;
            for(int i=1; i < matrix.length; ++i)
            {
                int val = matrix[i][j];
                if(set.contains(val)) {
                    flag = true;
                    break;
                }
                else
                    set.add(val);
            }
            if(flag)
                dupColCount++;
        }

        //find trace
        int sum = 0;
        for(int i=0,j=0; j<matrix[0].length; ++i,++j)
        {
            sum = sum + matrix[i][j];
        }

        System.out.println("Case #"+t+": "+sum + " " +dupRowCount +" "+ dupColCount);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int NoOftest = in.nextInt();
        for (int t = 1; t <= NoOftest; ++t) {
            int size = in.nextInt();
            int[][] matrix = new int[size][size];
            for (int i = 0; i < size; ++i)
            {
                for(int j=0; j < size; ++j )
                {
                    matrix[i][j] = in.nextInt();
                }
            }
            CalMatrix(matrix, t);
        }
    }
}