import java.util.*;
class solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int T=1;T<=t;T++)
        {
            int N = scan.nextInt();
            int[][]A = new int[N][N];
            int trace = 0,r=0,c=0;
            for(int i=0;i<N;i++)
            {
                Set<Integer>set = new HashSet<>();
                boolean flag=false;
                for(int j=0;j<N;j++)
                {
                    A[i][j]=scan.nextInt();
                    if(set.contains(A[i][j])&&!flag)
                    {
                        r++;
                        flag=true;
                    }
                    set.add(A[i][j]);
                    if(i==j)trace+=A[i][j];
                }
            }
            for(int i=0;i<N;i++)
            {
                Set<Integer>set = new HashSet<>();
                boolean flag=false;
                for(int j=0;j<N;j++)
                {
                    if(set.contains(A[j][i])&&!flag)
                    {
                        c++;
                        flag=true;
                    }
                    set.add(A[j][i]);
                }
            }
            System.out.println("Case #"+T+": "+trace+" "+r+" "+c);
        }
        
    }
}