import java.util.*;
 class a {

		public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
int cas=1;
		while(t>0)
		{
			int n=sc.nextInt();

			int arr[][]=new int[n+1][n+1];
			int count=0,c=0,d=0;
			for(int i=1;i<n+1;i++)
			{
				for(int j=1;j<n+1;j++)
				{
					arr[i][j]=sc.nextInt();
					if(i==j)
					{
						count=count+arr[i][j];
					}
				}
		 	}
				for(int i=1;i<n+1;i++)
				{
					int g=0;
					for(int j=1;j<n;j++)
					{
						for(int k=j+1;k<n+1;k++)
						{
							if(arr[i][j]==arr[i][k])
							{
								c=c+1;
							  g++;
							  break;
							}
							}
						if(g!=0) break;
					}
				}
				for(int i=1;i<n+1;i++)
				{
					int l=0;
					for(int j=1;j<n+1;j++)
					{
						for(int k=j+1;k<n+1;k++)
						{
							if(arr[j][i]==arr[k][i])
							{
								d=d+1;
							  l++;
							  break;
							}
							}
						if(l!=0) break;
					}
				}
				
				System.out.println("Case #"+cas+": "+count+" "+c+" "+d);
			t--;
cas++;
			
		}

		}

	}

