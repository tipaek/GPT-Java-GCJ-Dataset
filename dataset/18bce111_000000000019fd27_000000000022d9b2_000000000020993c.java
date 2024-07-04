import java.util.Scanner;
public class Vestigium
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int k = 0;
        do
        {
            int n = input.nextInt();
            int a[][] = new int[n][n];
            int tr = 0, rc = 0, cc = 0;
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    a[i][j] = input.nextInt();
                    if ( i == j )
                    {
                        tr = tr + a[i][j];
                    }
                    //row_r[(a[i][j] - 1)] = row_r[(a[i][j] - 1)]  + 1;
                }
                /*for (int l = 0; l < n; l++)
                {
                    if(row_r[l] > 1)
                    {
                        rc++;
                        break;
                    }
                    else
                    {

                    }
                }
                */
            }
            for (int i = 0; i < n; i++)
            {
                int row_r [] = new int[n];
                int column_r[] = new int[n];
                for (int j = 0; j < n; j++)
                {
                    column_r[(a[j][i]-1)] = column_r[(a[j][i]-1)] + 1;
                    row_r[(a[i][j] - 1)] = row_r[(a[i][j] - 1)]  + 1;
                }
                for (int l = 0; l < n; l++)
                {
                    if (column_r[l] > 1)
                    {
                        cc++;
                        break;
                    }
                    if (row_r[l] > 1)
                    {
                        rc++;
                        break;
                    }
                }
                /*for (int l = 0; l < n; l++)
                {
                    if (row_r[l] > 1)
                    {
                        rc++;
                        break;
                    }
                }*/
            }
            k++;
            System.out.println("Case #"+k+": "+tr+" "+rc+" "+cc);
        }while (k < (t-1));
    }
}
