import java.util.*;
class matrix
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int T=in.nextInt();
        int i,x,y,z,j;
        int k[]=new int [T];
        int r[]=new int [T];
        int c[]=new int [T];
        if(T>=1 && T<=100)
        {
            for(i=0;i<T;i++)
            {
                int N=in.nextInt();
                int M[][]=new int[N][N];
                for(x=0;x<N;x++)
                 {
                     for(y=0;y<N;y++)
                      {
                       M[x][y]=in.nextInt();
                      
                      }
                 }
                 for(x=0;x<N;x++)
                 {
                     for(y=0;y<N;y++)
                      {
                         if(x==y)
                         k[i]=k[i]+M[x][y];
                         }
                 }
                  for(x=0;x<N;x++)
                 {
					 
					  z=1;
                     while(z<=N)
                     {
						 int cnt=0;
						 for(y=0;y<N;y++)
                        {
							if(z==M[x][y])
							{
  
								cnt++;
							}
						}
						if(cnt>=2)
						{
		                    r[i]++;                                                       
							break;
						}
						z++;
					}z=1;
                     while(z<=N)
                     {
						 int cnt=0;
						 for(y=0;y<N;y++)
                        {
							if(z==M[y][x])
							{
  
								cnt++;
							}
						}
						if(cnt>=2)
						{
							c[i]++;
							break;
							
							
						}
						z++;
					}
					
                 }
                 
			 }
                 
                
            
            for(j=0;j<T;j++)
            {
                System.out.println("Case #"+(j+1)+":  "+k[j]+"  "+r[j]+"  "+c[j]);
            }
        
	}
        
        
    }
}
