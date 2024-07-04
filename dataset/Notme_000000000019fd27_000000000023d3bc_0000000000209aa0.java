import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= test; t++) 
		{
			String ori = br.readLine().trim();
			String b[]=ori.split(" ");
		    int N=Integer.parseInt(b[0]);
		    int T=Integer.parseInt(b[1]);
			int a[][]=new int[N][N],cnt=0,r=0,sum=0,x=1;
			int c[]=new int[N];
			int row = 0, col = N / 2, square = N * N;
			for(int i=1;i<=N;i++)
			{
			    if((i*N)==T)
			    {
			        r=i;
			        cnt++;
			    }
			    c[i-1]=i;
			}
			for(int i=1;i<=N;i++)
			{
			    sum+=c[i-1];
			}
			if(cnt>0)
			{
			    for( int i=1; i <= square ; i++ )
			    {

                    a[ row ][ col ] = x;
                    if(x<N)
                    {
                        x++;
                    }
                    else if(x>=N)
                    {
                        x=1;
                    }
                    if( i % N == 0 ) row++;
                    else{
                        if( row == 0 ) row = N - 1;
                        else row--;
                    if( col == ( N - 1 ) ) col = 0;
                    else col++;
                }
            }
			System.out.println("Case #" + t + ": " + "POSSIBLE");
			    for(int k=0;k<N;k++)
			    {
			        for(int l=0;l<N;l++)
			        {
			            System.out.print(a[k][l]+" ");
			        }
			        System.out.println();
			    }
		    }
			if(cnt==0)
			{
			    System.out.println("Case #" + t + ": " +"IMPOSSIBLE");
			}
	}
}
}
