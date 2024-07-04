
import java.io.*;
import java.util.*;
public class Solution {
	
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		
		
		int test=sc.nextInt();
		int caseNo=1;
		
		
	
		while(test-->0)
		{
			int n=sc.nextInt();
			
			int k=sc.nextInt();
			
			
			if(k==n+1 || k==n*n-1 || (k==3 && k%3!=0) )
				System.out.println("Case #"+caseNo+": IMPOSSIBLE");
			else
			{
				int arr[][]=new int[n][n];
				for(int i=0;i<n;i++)
				{
					arr[0][i]=i+1;
				}
				
			
				
				if(k%n==0)
				{
					System.out.println("Case #"+caseNo+": POSSIBLE");
					int t=k/n;
					
					while(arr[0][0]!=t)
					{
						rotate(arr,0);
					}
					
					arr[0][0]=t;
					/*
					int put=1;
					for(int i=1;i<n;i++)
					{
						if(put!=t)
							arr[0][i]=put++;
						else
						{
							arr[0][i]=++put;
							put++;
						}
					}*/
					
					for(int i=1;i<n;i++)
					{
						for(int j=0;j<n;j++)
						{
							arr[i][j]=arr[i-1][j];
							System.out.print(arr[i-1][j]+" ");
						}
						System.out.println();
						rotate(arr,i);
					}
					
					for(int i=0;i<n;i++)
					{
						System.out.print(arr[n-1][i]+" ");
					}
					System.out.println();
					
				}
				else if(k%2==0)
				{
					if(n==4)
					{
						
						int a= (k+2)/2/2;
						int b=(k-2)/2/2;
						
						arr[0][0]=b;
						arr[1][1]=b;
						arr[2][2]=a;
						arr[3][3]=a;
						
						arr[0][1]=a;
						arr[1][0]=a;
						arr[2][3]=b;
						arr[3][2]=b;
						
						int i=1;
						
						while(i==a || i==b)
							i++;
						
						int c=i;
						i++;
						
						while(i==a || i==b || i==c)
							i++;
						
						int d=i;
						
						arr[0][2]=c;
						arr[1][3]=c;
						arr[2][0]=c;
						arr[3][1]=c;
						
						arr[0][3]=d;
						arr[1][2]=d;
						arr[2][1]=d;
						arr[3][0]=d;
						
						System.out.println("Case #"+caseNo+": POSSIBLE");
						
						for( i=0;i<n;i++)
						{
						for(int j=0;j<n;j++)
						{
							System.out.print(arr[i][j]+" ");
						}
						System.out.println();
						}
						
								
					}
					else if(n==5)
					{
						System.out.println("Case #"+caseNo+": POSSIBLE");
						if(k==16)
						{
							System.out.println("1 2 3 4 5 ");
							System.out.println("4 5 1 3 2 ");
							System.out.println("2 1 4 5 3 ");
							System.out.println("3 4 5 2 1 ");
							System.out.println("5 3 2 1 4 ");
						}
						else if(k==12)
						{
							System.out.println("1 2 3 4 5 ");
							System.out.println("4 5 1 3 2 ");
							System.out.println("2 1 4 5 3 ");
							System.out.println("5 3 2 1 4 ");
							System.out.println("3 4 5 2 1 ");
							
							
						}
						else if(k==14)
						{

							System.out.println("5 1 4 2 3");
							System.out.println("2 5 3 4 1");
							System.out.println("3 2 1 5 4");
							System.out.println("4 3 2 1 5");
							System.out.println("1 4 5 3 2");
						}
						
						else if(k==8)
						{
							System.out.println("1 2 3 4 5 ");
							System.out.println("3 1 2 5 4 ");
							System.out.println("4 5 1 3 2 ");
							System.out.println("5 3 4 2 1 ");
							System.out.println("2 4 5 1 3 ");
							
						}
						else if(k==22)
						{
							System.out.println("5 3 1 4 2 ");
							System.out.println("3 4 5 2 1 ");
							System.out.println("2 5 3 1 4 ");
							System.out.println("1 2 4 5 3 ");
							System.out.println("4 1 2 3 5 ");
						}
						
						else if(k==18)
						{
							System.out.println("5 3 1 4 2 ");
							System.out.println("3 4 5 2 1 ");
							System.out.println("2 5 3 1 4 ");
							System.out.println("4 1 2 3 5 ");
							System.out.println("1 2 4 5 3 ");
							
							
						}
						
						
					}
			
					else
					System.out.println("Case #"+caseNo+": IMPOSSIBLE");
				}
				else
				{
					if(n==4)
					{
						System.out.println("Case #"+caseNo+": POSSIBLE");
						
						if(k==7)
						{
							
							
							System.out.println("3 1 2 4 ");
							System.out.println("1 2 4 3 ");
							System.out.println("4 3 1 2 ");
							System.out.println("2 4 3 1 ");
							
						}
						else if(k==9)
						{
							System.out.println("3 1 4 2 ");
							System.out.println("1 4 2 3 ");
							System.out.println("2 3 1 4 ");
							System.out.println("4 2 3 1 ");
							
						}
						else if(k==11)
						{
							System.out.println("3 2 4 1 ");
							System.out.println("2 4 1 3 ");
							System.out.println("1 3 2 4 ");
							System.out.println("4 1 3 2 ");
							
						}
						else if(k==13)
						{
							System.out.println("2 4 3 1 ");
							System.out.println("4 3 1 2 ");
							System.out.println("1 2 4 3 ");
							System.out.println("3 1 2 4 ");
							
						}
						
					}
					
					else if(n==5)
					{
						System.out.println("Case #"+caseNo+": POSSIBLE");
						
						if(k==13)
						{
							System.out.println("1 2 3 4 5 ");
							System.out.println("4 5 1 3 2 ");
							System.out.println("3 1 2 5 4 ");
							System.out.println("5 3 4 2 1 ");
							System.out.println("2 4 5 1 3 ");
						}
						else if(k==9)
						{
							System.out.println("1 2 3 4 5 ");
							System.out.println("2 1 4 5 3 ");
							System.out.println("4 5 1 3 2 ");
							System.out.println("3 4 5 2 1 ");
							System.out.println("5 3 2 1 4 ");
						}
						else if(k==11)
						{
							System.out.println("2 1 4 5 3 ");
							System.out.println("1 2 3 4 5 ");
							System.out.println("4 5 1 3 2 ");
							System.out.println("3 4 5 2 1 ");
							System.out.println("5 3 2 1 4 ");
							
						}
						else if(k==7)
						{
							System.out.println("1 5 2 4 3 ");
							System.out.println("2 1 3 5 4 ");
							System.out.println("4 2 1 3 5 ");
							System.out.println("5 3 4 2 1 ");
							System.out.println("3 4 5 1 2 ");
						}
						else if(k==19)
						{
							System.out.println("3 4 5 2 1 ");
							System.out.println("5 3 1 4 2 ");
							System.out.println("2 5 3 1 4 ");
							System.out.println("1 2 4 5 3 ");
							System.out.println("4 1 2 3 5 ");
						}
						else if(k==21)
						{
							System.out.println("5 3 1 4 2 ");
							System.out.println("2 5 3 1 4 ");
							System.out.println("3 4 5 2 1 ");
							System.out.println("4 1 2 3 5 ");
							System.out.println("1 2 4 5 3 ");
						}
						else if(k==17)
						{
							System.out.println("5 1 2 4 3");
							System.out.println("4 5 1 3 2");
							System.out.println("1 3 5 2 4");
							System.out.println("3 2 4 1 5");
							System.out.println("2 4 3 5 1");
						}
						
						else if(k==23 )
						{

							System.out.println("5 4 2 1 3");
							System.out.println("1 5 4 3 2");
							System.out.println("4 3 5 2 1");
							System.out.println("3 2 1 4 5");
							System.out.println("2 1 3 5 4");
						}
					}
					else
						System.out.println("Case #"+caseNo+": IMPOSSIBLE");
						
				}
			}
				
			
		
			
			
			caseNo++;
			
			
			
		
			
			
		}
		
		
	}
	
	static void rotate(int arr[][],int pos)
	{
		for(int i=0;i<arr[0].length;i++)
		{
			if(arr[pos][i]!=1)
			arr[pos][i]=arr[pos][i]-1;
			
			else
			arr[pos][i]=arr[0].length;
		}
		
	}
	
}
