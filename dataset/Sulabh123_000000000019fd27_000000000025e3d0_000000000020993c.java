import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int k=0; k<T; k++)
        {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int c=0,r=0,x=0,y=0;
            int sum=0;
            for(int l=0; l<N ; l++)
            {
                for(int m=0; m<N; m++)
                {
                     arr[l][m] = sc.nextInt();
                }
            }
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N-1; j++)
                {
                    int A = arr[i][j];
                    for(int t=j+1; t<N; t++)
                    {
                        if(A==arr[i][t])
                        x++;
                    }
                }
                if(x>0)
                r++;
                x=0;
            }
            for(int a=0; a<N; a++)
            {
                for(int b=0; b<N-1; b++)
                {
                    int B = arr[b][a];
                    for(int s=a+1; s<N; s++)
                    {
                        if(B==arr[s][a])
                        y++;
                    }
                }
                if(y>0)
                c++;
                y=0;
            }
            for(int g=0; g<N; g++)
            {
                sum = sum + arr[g][g];
            }
            System.out.println("Case #"+(k+1)+": "+sum+" "+r+" "+c);
        }
        
    }
}