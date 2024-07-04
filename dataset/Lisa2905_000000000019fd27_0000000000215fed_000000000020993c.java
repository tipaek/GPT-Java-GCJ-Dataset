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
            if(N<2||T>100)
            System.exit(0);
            int a[][]=new int[N][N];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                a[i][j]=in.nextInt();
            }
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if(a[i][j]<1||a[i][j]>N)
                    System.exit(0);
                }
            }
            int s=0,c=0,r=0,f=0,g=0;
            for(int i=0;i<N;i++)
            { 
                for(int j=0;j<N;j++)
                {
                    if(i==j)
                    s=s+a[i][j];
                    int t=a[i][j];
                    for(int y=0;y<N;y++)
                    {
                      if(a[i][y]==t)f++;
                      if(a[y][i]==t)g++;
                    }
                }
                if((f-N)>0)r++;
                if((g-N)>0)c++;
                f=0;g=0;
            }
            System.out.println("Case #"+o+": "+s+" "+r+" "+c);
        }
    }
}