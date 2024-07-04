import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test=1;test<=t;test++)
        {
            int n = in.nextInt();
            int [][] m = new int [n][n] ;
            for (int i=0;i<n;i++)
                for (int j=0;j<n;j++)
                    m[i][j] = in.nextInt();
                int row = 0;
                int col = 0 ;
                int gh = 0;
            for (int i=0;i<n;i++) {
                int f = 0;
                for (int j = 0; j < n; j++) {
                    for (int k=j;k<n-1;k++)
                        if (m[i][j] == m[i][k + 1]) {
                            f = 1;
                        row++;
                        break;
                    }
                    if (f ==1)
                        break;

                }

            }
            for (int i=0;i<n;i++) {
                int f = 0;
                for (int j = 0; j < n ; j++) {
                    for (int k=j;k<n-1;k++)
                        if (m[j][i] == m[k+1][i]) {
                        col++;
                            f = 1;
                        break;
                    }
                    if (f==1)
                        break;
                }
            }
            for (int i=0;i<n;i++)
                for (int j = 0; j < n; j++)
                    if (i == j)
                         gh = gh + m[i][j];
            System.out.println("Case #"+test+' '+gh+' '+row+' '+col);

        }
    }
}
