class Game
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        Integer T=Integer.parseInt(s.nextLine());
        int i,j,k,c=0;
        for(i=1;i<=T;i++)
        {
        Integer N=Integer.parseInt(s.nextLine());
        int M[][]=new Int[N][N];
        int d[]=new Int[N];
        int e[]=new Int[N];
        for(j=0;j<N;j++)
        {
            for(k=0;k<N;k++)
            {
                M[j][k]=Integer.parseInt(s.nextLine());
            }
        }
        System.out.print("Case #"+i+": ");
        
        for(j=0;j<N;j++)
        {
            for(k=0;k<N;k++)
            {
                if(j==k)
                l=l+M[j][k];
                Set u=new HashSet();
                u.add(M[j][k]);
                
                if(j==0)
                { c=0;
                    while(c<4)
                    {
                    Set v=new HashSet();
                    v.add(M[c][k]);
                    c++;
                    }
                }
                if(j==0)
                {
                d[k]=N-v.size();
                }
            }
            
            e[j]=N-u.size();
            
        }
        int rowmax = Arrays.stream(e).max().getAsInt();
        int colmax = Arrays.stream(d).max().getAsInt();
        System.out.print(rowmax+" "+colmax);
        
        }
    }
}