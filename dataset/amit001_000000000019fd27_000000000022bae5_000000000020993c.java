import java.util.Scanner;
class a {

		public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			int n=sc.nextInt();
			int arr[][]=new int[n][n];
			int count=0,c=0,d=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					arr[i][j]=sc.nextInt();
					if(i==j)
					{
						count=count+arr[i][j];
					}
				}
		 	}
				for(int i=0;i<n;i++)
				{
					int g=0;
					for(int j=0;j<n-1;j++)
					{
						for(int k=j+1;k<n;k++)
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
				for(int i=0;i<n;i++)
				{
					int l=0;
					for(int j=0;j<n-1;j++)
					{
						for(int k=j+1;k<n;k++)
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
				
				System.out.println(count+" "+c+" "+d);
			t--;
			
		}

		}

	}

