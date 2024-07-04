import java.util.*;
class Vestigium
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        HashSet<Integer>s;
        int T=sc.nextInt();
        for(int t=1;t<=T;t++)
        {
            int N=sc.nextInt();
            int M[][]=new int[N][N];
            int k=0,r=0,c=0;
            for(int i=0;i<N;i++)
                for(int j=0;j<N;j++)
                    M[i][j]=sc.nextInt();
            for(int i=0;i<N;i++)
                 k+=M[i][i];
            for(int i=0;i<N;i++)
            {
                s=new HashSet<Integer>();
                for(int j=0;j<N;j++)
                     s.add(M[i][j]);
                if(s.size()<N)
                    r++;
            }
            for(int i=0;i<N;i++)
            {
                s=new HashSet<Integer>();
                for(int j=0;j<N;j++)
                     s.add(M[j][i]);
                if(s.size()<N)
                    c++;
            }
            System.out.println("Case #"+t+": "+k+" "+r+" "+c);
  
        }
    }
}