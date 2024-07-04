import java.util.*;

class Problem1
{
	public static void main(String ar[])
	{

		int t,n,k=0;
		int r=0,c=0;
		int e,x;
		
		int kk[]=new int[5];
		int rr[]=new int[5];
		int cc[]=new int[5];
		int arr[][]=new int[50][50];
		Scanner s1= new Scanner(System.in);
		Scanner s2= new Scanner(System.in);
		t=s1.nextInt();
		
		
		for(x=0;x<t;x++)
		{
			int m[][] = new int[50][50];
			k=r=c=0;
			
			n=s1.nextInt();
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++)
				{

					m[i][j]=s2.nextInt();
				}
			}
			
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{

					arr[i][j]=m[i][j];

					for(e=0;e<n;e++)
					{

						if(j==e){
							
							continue;
						}
						else if(m[i][e]==arr[i][j])
						{
								r++;
								break;
						}
					}
					if(m[i][e]==arr[i][j])
						break;
				}
			}
				for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					arr[i][j]=m[i][j];
					for(e=0;e<n;e++)
					{
						if(j==e){
							continue;
						}
						else if(m[e][i]==arr[i][j])
						{

							c++;
							break;	
						}
					}
					if(m[e][i]==arr[i][j])
						break;
				}
				}
			
			
			rr[x]=r;
			cc[x]=c;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(i==j)
						k=k+m[i][j];
				}
			}
			kk[x]=k;
		
		}
		for(int i=0;i<t;i++)
			System.out.println("Case #"+(i+1)+": "+kk[i]+" "+rr[i]+" "+cc[i]);
	}
}