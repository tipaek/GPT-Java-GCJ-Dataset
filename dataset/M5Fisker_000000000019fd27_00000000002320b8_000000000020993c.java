import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution
{
    public static String trace(int arr[][], int size)
    {
        int[] ans = new int[3];
        int sum =0;
        //Total of the diagonal of the matrix
        for(int i=0; i<size;i++)
        {
            sum = sum + arr[i][i];
        }
       
        //Rows
        int rowCount =0;
        for(int i =0; i<size; i++)
        {
            HashSet<Integer> myHash = new HashSet<Integer>();
            for(int j =0; j<size; j++)
            {
                if(myHash.contains(arr[i][j]))
                {
                    rowCount ++;
                    break;
                }
                else
                    myHash.add(arr[i][j]);
            }
            
        }
        int columnCount =0;
        for(int i =0; i<size; i++)
        {
            HashSet<Integer> myHash = new HashSet<Integer>();
            for(int j =0; j<size; j++)
            {
                if(myHash.contains(arr[j][i]))
                {
                    columnCount ++;
                    break;
                }
                else
                    myHash.add(arr[j][i]);
            }
            
        }

        ans[0]= sum;
        ans[1] = rowCount;
        ans[2] = columnCount;

        String list = Arrays.toString(ans);
        return list;

    }
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int test = keyboard.nextInt();
       
        for(int i=0; i<test;i++)
        {
            int a = 0;
            a = keyboard.nextInt();
            int mat[][] = new int[a][a];
            for(int j=0; j<a;j++)
            {
                for(int k=0; k<a;k++)
                {
                    mat[j][k]= keyboard.nextInt();
                }
            }
           
            System.out.println("Case #"+i+" "+trace(mat,a));

        }
    }
}
