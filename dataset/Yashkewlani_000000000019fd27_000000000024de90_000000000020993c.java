import java.util.Scanner;

class first
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t,n,flag=0;
		t=in.nextInt();
		for(int i=1;i<=t;i++)
		{
		    n=in.nextInt();
		    int[][] a = new int[n][n];
		    for(int j=0;j<n;j++)
		    {
		    	for(int k=0;k<n;k++)
		    	{
		    		a[i][j]=in.nextInt();
		        }
		    }
		    int trace=0;
		    for(int j=0;j<n;j++)
		    {
		    	for(int k=0;k<n;k++)
		    	{
		    	    if(j==k)
		    	    {
		    	    	trace+=a[j][k];
		    	    }
		    	}
		    }
			int row=0,col=0;
			for(int j=0;j<n;j++)
			{
				for(int k=0;k<n;k++)
				{
					for(int m=j+1;m<n;m++)
					{
						if(a[i][j]==a[i][m])
							{
								row++;
								flag=1;
								break;
							}
						if(flag==1)
							break;		
					}
					flag=0;
				}
			}
			for(int j=0;j<n;j++)
			{
				for(int k=0;k<n;k++)
				{
					for(int m=j+1;m<n;m++)
					{
						if(a[i][j]==a[i][m])
							{
								col++;
								flag=1;
								break;
							}
						if(flag==1)
							break;		
					}
					flag=0;
				}
			}
			if(row>n)
				row=n;
			if(col>n)
				col=n;
            System.out.println("case#"+i+": "+trace+" "+row+" "+col);
		}
	}
}