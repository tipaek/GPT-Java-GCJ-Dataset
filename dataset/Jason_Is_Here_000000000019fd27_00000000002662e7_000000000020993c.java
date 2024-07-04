import java.io.IOException;
import java.util.Scanner;

 class trace {
    public static void main(String... args)throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int p = 1;p<=T;p++)
        {int sum =0;
            int n = sc.nextInt();
            int mat[][] = new int[n][n];
            for(int i =0;i<n;i++)
            {
                for(int j = 0;j<n;j++)
                {
                    mat[i][j] = sc.nextInt();

                    if(i == j)
                        sum += mat[i][j];
                }
            }

            System.out.println("Case #"+T+": "+ sum);
        }

    }
}
