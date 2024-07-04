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
            /*Arrays.sort(A,new Comparator<int[]>() {
                public int compare(int[] a,int[] b)
                {
                    return Integer.compare(a[0], b[0]);
                }
            });*/
            int C=0,C1=0,J=0,J1=0;
            for(int j=0;j<N;j++)
            {
                if(A[j][0]>=C1 || A[j][1]<=C)
                {
                    C=A[j][0];
                    C1=A[j][1];
                    S=S+"C";
                }
                else if(A[j][0]>=J1 || A[j][1]<=J)
                {
                    J=A[j][0];
                    J1=A[j][1];
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
        
            