import java.util.*;
class Solution
{
    public static void main(String args[])
    {int avg,l,m;
        Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        for(int i=0;i<T;i++)
        {   
            int N=s.nextInt();
            int a[][]=new int[N][N];
            int K=s.nextInt();
            if(K%N==0)
            {   avg=K/N;
                for(l=0;l<N;l++)
                    {
                        a[l][l]=avg;
                    }
                    int h=1;
                for(int d=1;d<N;d++)
                    {
                    for(l=0;l<N;l++)
                        {  if(l+d<N)
                            a[l][l+d]=h;
                            else
                            a[l][(l+d)%N]=h;
                        }
                        h++;
                        if(h==avg)
                        h++;
                    }
                    System.out.println("Case #"+(i+1)+": POSSIBLE");
               for(l=0;l<N;l++)
                    {
                    for(m=0;m<N;m++)
                           System.out.print(a[l][m]+" ");
                        System.out.println();
                    }
               
               } else
            System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            }
            
    
    }
}