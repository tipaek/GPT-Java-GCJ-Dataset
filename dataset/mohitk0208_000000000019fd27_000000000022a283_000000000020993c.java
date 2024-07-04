import java.util.*;

public class Solution{
    public static void main(String args[])
    {
        int T,N;
        int row=0,col=0,k=0;
        Scanner in=new Scanner(System.in);
        T=in.nextInt();
        for(int x=1;x<=T;x++)
        {
            N=in.nextInt();
            int M[][]=new int[N][N];
            row=0;
            col=0;
            k=0;
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    M[i][j]=in.nextInt();
                }
            }
            for(int c=0;c<N;c++) {

                for (int i = 1; i <= N; i++) {
                    boolean rflag = false;

                    for (int j = 0; j < N; j++) {
                        if (i == M[c][j]) {
                            rflag = true;
                            break;
                        }
                    }
                    if (rflag == false) {
                        row++;
                        break;
                    }

                }
            }

            for(int c=0;c<N;c++)
            {
                for(int i=1;i<=N;i++)
                {
                    boolean cflag = false;
                    for (int j = 0; j < N; j++) {
                        if (i == M[j][c]) {
                            cflag = true;
                            break;
                        }
                    }
                    if (cflag == false) {
                        col++;
                        break;
                    }

                }
            }
            for(int i=0;i<N;i++)
            {
                k+=M[i][i];
            }

            System.out.println("Case #"+x+": "+k+" "+row+" "+col);

        }


    }
}