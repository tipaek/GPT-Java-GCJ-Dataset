import java.io.*; 
import java.util.*;


class Solution {
     public static void main(String[] args) {
        int testCases = 0;
        Scanner sc = new  Scanner(new BufferedReader(new InputStreamReader(System.in)));
        testCases = sc.nextInt();

        for (int k=0;k<testCases;k++)
        {
            int n = sc.nextInt();
            int[][] array = new int[n][n];
            for(int i =0; i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    array[i][j] = sc.nextInt();
                }
            }


            int[][] rolDup = new int[n+1][n+1];
            int[][] colDup = new int[n+1][n+1];
            int rows = 0;
            int trace= 0;
            int cols = 0;
            for (int i=0;i<n;i++)
            {
                trace += array[i][i];
                for (int j=0;j<n;j++)
                {

                    if(rolDup[i][array[i][j]]==1)
                    {
                        rows++;
                        break;
                    }
                    rolDup[i][array[i][j]] = 1;
                }
            }

            for (int i = 0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(colDup[i][array[j][i]]==1)
                    {
                        cols++;
                        break;
                    }
                    colDup[i][array[j][i]] = 1;

                }
            }
            System.out.println("Case #"+(k+1)+": "+trace+" "+rows+" "+cols);

        }



    }
}
