import java.util.Scanner;

public class Solution {


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i<=T ; i ++)
        {
            int temp= 0;
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            int rows = 0;
            int columns = 0;
            for (int j = 0;j <N; j++)
            {
                int[] checker = new int[N+1];
                boolean flag = false;
                for (int k = 0; k<N;k++)
                {
                    temp = sc.nextInt();
                    matrix[j][k]=temp;
                    if (temp<= N)
                    {
                        checker[temp] += 1;
                        if (!flag && checker[temp] > 1) {
                            flag = true;
                            rows++;
                        }
                    }
                    else
                    {
                        flag = true;
                        rows++;
                    }
                }
            }


            int trace = 0;

            for (int j = 0; j<N; j++)
            {
                trace+= matrix[j][j];
            }

            for (int j = 0;j <N; j++)
            {
                int[] checker = new int[N+1];
                boolean flag = false;
                for (int k = 0; k<N;k++)
                {
                    temp = matrix[k][j];
                    if (temp<= N)
                    {
                        checker[temp] += 1;
                        if (!flag && checker[temp] > 1) {
                            flag = true;
                            columns++;
                        }
                    }
                    else
                    {
                        flag = true;
                        columns++;
                    }
                }
            }
            System.out.printf("Case #%d: %d %d %d\n",i,trace,rows,columns);
        }


    }
}
