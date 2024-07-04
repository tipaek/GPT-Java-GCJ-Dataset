import java.util.*;
import java.lang.*;
import java.io.*;

class trace
{
	public static void main(String args[])
	{
			int T,N;
			Scanner sc = new Scanner(System.in);
			T=sc.nextInt();
			for(int testcase=0;testcase<T;testcase++)
			{  
				int sum=0;
				N=sc.nextInt();
				int arr[][] = new int[N][N];
				int b[][] = new int[N][N];
				for(int i=0;i<N;i++)
				{
					for(int j=0;j<N;j++)
					{
						arr[i][j]=sc.nextInt();
						if(i==j)
							sum+=arr[i][j];
					}
				}
				int K =sum;
				int R=0,C=0;
				for(int i=0;i<N;i++)
				{
					for(int j=0;j<N;j++)
					{
						int a = arr[i][j];
						for(int k=0;k<N;k++)
						{
							if(j!=k)
							{
								if(a==arr[i][k])
								{
									R++;
									i++;
									break;
								}
							}
						}
					}
				}
				
				for(int i=0;i<N;i++)
				{
					for(int j=0;j<N;j++)
					{
						b[j][i]=arr[i][j];
					}
				}
				
				for(int i=0;i<N;i++)
				{
					for(int j=0;j<N;j++)
					{
						int a = arr[i][j];
						for(int k=0;k<N;k++)
						{
							if(j!=k)
							{
								if(a==arr[i][k])
								{
									C++;
									i++;
									break;
								}
							}
						}
					}
				}
				
		/*
				// col check
				for(int i=0;i<N;i++)
				{
					for(int j=0;j<N;j++)
					{
						int a = arr[j][i];
						for(int k=0;k<N;k++)
						{
							if(j!=k)
							{
								if(a==arr[k][i])
								{
									System.out.println("a ;"+a);
									System.out.println("arr["+k+"]["+i+"]");
									C++;
									if((i+1)<N)
									i++;
									//break;
									continue;
								}
							}
						}
					}
				
				}
		
		*/
				System.out.println("Case #"+(testcase+1)+": "+K+" "+R+" "+C);
			}
		}
}