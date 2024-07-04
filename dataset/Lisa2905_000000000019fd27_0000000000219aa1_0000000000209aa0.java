import java.util.*;
class vestigium
{
    public static void main()
    {
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        if(T<1||T>100)
        System.exit(0);
        for(int o=1;o<=T;o++)
        {
            int N=in.nextInt();
            int k=in.nextInt();
            if(N<2||N>100)
            System.exit(0);
            int a[][]=new int[N][N];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N-1;j++)
                if(i==j)a[i][j]=k/4;
                a[i][N-1]=(k/4)+(k%4);
            }
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<=N-1;j++)
                {
                    if(i!=j)
                    a[i][j]=(int)(Math.Random()*N)+1;
                }
            }
             for(int i=0;i<N;i++)
            {
                for(int j=0;j<=N-1;j++)
                System.out.print(a[i][j]+"\t");
            }
        }
    }
}