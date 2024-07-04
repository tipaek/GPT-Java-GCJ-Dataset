import java.util.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int T= in.nextInt();
        int i=0;
        while(i<T)
        {
            i++;
            String S="";
            int N=in.nextInt();
            int[][] A=new int[N][2];
            for(int j=0;j<N;j++)
            {
                for(int k=0;k<2;k++)
                {
                    A[j][k]=in.nextInt();
                }
            }
            int C=Integer.MAX_VALUE,C1=0,J=Integer.MAX_VALUE,J1=0;
            for(int j=0;j<N;j++)
            {
                if(A[j][0]>=C1 || A[j][1]<=C)
                {
                    C=Math.min(C,A[j][0]);
                    C1=Math.max(C1,A[j][1]);
                    S=S+"C";
                }
                else if(A[j][0]>=J1 || A[j][1]<=J)
                {
                    J=Math.min(J,A[j][0]);
                    J1=Math.max(J1,A[j][1]);
                    S=S+"J";
                }
                else
                {
                    S="IMPOSSIBLE";
                    break;
                }
                
            }
            System.out.println("Case #"+i+": "+S);
        }
    }
}
        
            