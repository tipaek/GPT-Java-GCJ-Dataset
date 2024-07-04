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
            int N=in.nextInt();
            int[][] A=new int[N][3];
            char[] S=new char[N];
            for(int j=0;j<N;j++)
            {
                for(int k=0;k<2;k++)
                {
                    A[j][k]=in.nextInt();
                }
                A[j][2]=j;
            }
            Arrays.sort(A,new Comparator<int[]>() {
                public int compare(int[] a,int[] b)
                {
                    return Integer.compare(a[0], b[0]);
                }
            });
            int C=0,J=0;
            int j;
            for(j=0;j<N;j++)
            {
                if(A[j][0]>=C)
                {
                    C=A[j][1];
                    S[A[j][2]]='C';
                }
                else if(A[j][0]>=J)
                {
                    J=A[j][1];
                    S[A[j][2]]='J';
                }
                else
                {
                    System.out.println("Case #"+i+": "+"IMPOSSIBLE");
                    break;
                }
                
            }
            if(j==N)
            {
                System.out.print("Case #"+i+": ");
                for(int k=0;k<N;k++)
                    System.out.print(S[k]);
                System.out.println("");
            }
        }
    }
}
        
            