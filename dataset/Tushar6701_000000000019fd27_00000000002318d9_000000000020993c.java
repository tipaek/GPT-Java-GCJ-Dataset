import java.util.*;
class Solution
{
    public static void main(String args[]){
    int T,N;
    int M[][];
    Scanner sc=new Scanner(System.in);
    T=sc.nextInt();
    
    
    int r[]=new int[T];
    int c[]=new int[T];
    int k[]=new int [T];
    for(int t=0;t<T;t++)
    {   
        
        
		N=sc.nextInt();
        M=new int[N][N];
    r[t]=0;
    c[t]=0;
    k[t]=0;
	for(int i=0;i<N;i++)
    {
        for(int j=0;j<N;j++)
        {
			M[i][j]=sc.nextInt();
        }
    }
    
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<N;j++)
        {       
            if(i==j)
                k[t]+=M[i][j];//trace
        }
    }
    
    for(int i=0;i<N;i++)
    {
		int Rcount=0, Ccount=0;
        for(int j=0;j<N;j++)
		{
			for(int l=j+1;l<N;l++)
			{
				if(M[i][j]==M[i][l])
				{
					Rcount=1;
				}
			}
			for(int l=j+1;l<N;l++)
			{
				if(M[j][i]==M[l][i])
				{
					Ccount=1;
				}
			}
		}
		if(Rcount==1)
			r[t]++;
		if(Ccount==1)
			c[t]++;
		
		
    }
    }
    
    for(int x=0;x<T;x++)
    {
        System.out.println("Case #"+(x+1)+": "+k[x]+" "+r[x]+" "+c[x]);
    }
    }
}
    