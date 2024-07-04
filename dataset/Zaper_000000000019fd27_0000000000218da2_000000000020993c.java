import java.util.*;
class code_jam
{
    public static void main(String ags[])
    {
        Scanner in = new Scanner(System.in);
        int T=in.nextInt();
        int t=T+1;
        while(T>0)
        {
            int l=0,m=0,p=0;
            int N= in.nextInt();
            int ar[][]= new int[N][N];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    ar[i][j]= in.nextInt();
                    if(i==j)
                    l=l+ar[i][j];
                }
                for(int j=0;j<N;j++)
                {
                    int c=0;int r=0;
                    for(int k=0;k<N;k++)
                    {
                    if(ar[i][j]==ar[i][k] &&  k!=j)
                    c++;
                    //if(ar[j][i]==ar[k][i] && k!=j)
                    //r++;
                    }
                    if(m<c)
                    {
                        m=c+1;
                    }
                    
                    
                }
            }
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    int c=0;
                    for(int k=0;k<N;k++)
                    if(ar[j][i]==ar[k][i] && k!=j)
                    c++;
                    
                
                if(p<c)
                        p=c+1;
                }
            }
            System.out.println("Case #"+(t-T)+": "+l+" "+m+" "+p);
            T=T-1;
        }
    }
}