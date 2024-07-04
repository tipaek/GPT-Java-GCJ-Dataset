import java.util.*;
class Solution
{
    public static void rotate(int A[])
    {
        int len=A.length;
        int t=A[len-1];
        for(int i=len-1; i>0; i--)
        {
            A[i]=A[i-1];
        }
        A[0]=t;
        for(int j=0; j<len; j++)
        {
            System.out.print(A[j]);
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=1; i<=T; i++)
        {
            int N=sc.nextInt();
            int K=sc.nextInt();
            int max=N*N;
            if((K%N != 0)||(K>max))
            {
                System.out.println("Case #"+i+": IMPOSSIBLE");
                break;
            }
            else
            {
                int v=K/N;
                int c=v+1;
                int count=1;
                int t=N-c;
                int temp[]=new int[N];
                int j;
                for(j=0; j<=t; j++)
                {
                    temp[j]=c++;
                }
                for(int k=j; k<N; k++)
                {
                    temp[k]=count++;
                }
                System.out.println("Case #"+i+": POSSIBLE");
                for(int p=1; p<=N; p++)
                {
                    rotate(temp);
                    System.out.println();
                }
               
            }
        }
    }
}