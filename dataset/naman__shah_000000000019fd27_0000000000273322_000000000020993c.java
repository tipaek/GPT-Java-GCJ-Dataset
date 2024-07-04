import java.util.*;

class sol1
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        for (int i=1; i<=t; i++)
        {
            int trace=0, rowCount=0, colCount=0;

            int n = scan.nextInt();
            int[][] arr = new int[n][n];

            for (int j=0; j<n; j++)
                for (int k=0; k<n; k++)
                    arr[j][k] =scan.nextInt();

            for (int j=0; j<n; j++)
            {
                int rCount=0, cCount=0;
                for (int k=0; k<n; k++)
                {
                    if (j == k)
                        trace += arr[j][k];


                    for (int l=0; l<k; l++)
                    {
                        if (rCount < 1)
                            if (arr[j][k] == arr[j][l])
                            {
                                rCount += 1;
                                rowCount += rCount;
                            }

                        if (cCount < 1)
                            if (arr[k][j] == arr[l][j])
                            {
                                cCount += 1;
                                colCount += cCount;
                            }
                    }
                }                
            }
            System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);
        }
        scan.close();
    }
}