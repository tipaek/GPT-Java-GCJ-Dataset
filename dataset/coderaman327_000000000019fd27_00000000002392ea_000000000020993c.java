import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=0;k<t;k++)
        {
            int n=sc.nextInt();
            int[][] arr=new int[n+1][n+1];
            int[][] rows=new int[n+1][n+1];
            int[][] cols=new int[n+1][n+1];
            int trace=0;
            for(int i=1;i<=n;++i)
            {
                for(int j=1;j<=n;j++)
                {
                    int ele=sc.nextInt();
                    arr[i][j]=ele;
                    if(i==j)
                        trace+=ele;
                    if(rows[i][ele]==1)
                    {
                        rows[i][0]=1;
                    }
                    rows[i][ele]++;
                    if(cols[j][ele]==1)
                    {
                        cols[j][0]=1;
                    }
                    cols[j][ele]=1;
                }
            }
            int no_of_rows=0;
            int no_of_cols=0;
            for(int i=1;i<=n;++i)
            {
                if(rows[i][0]==1)
                    no_of_rows++;
                if(cols[i][0]==1)
                    no_of_cols++;
            }
            System.out.println("Case #"+k+": "+trace+" "+no_of_rows+" "+no_of_cols);
        }
    }
}
