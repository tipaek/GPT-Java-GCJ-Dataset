import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int sum=0,rows=0,columns=0,temp=0;
		for(int i=1;i<=T;i++)
		{
			sum=0;rows=0;columns=0;temp=0;
			boolean flag=false;
			int N = sc.nextInt();
			int[][] M = new int[N][N];
			for(int j=0;j<N;j++)
			{
				for(int k=0;k<N;k++)
				{
					M[j][k] = sc.nextInt();
					if(j==k)
						sum+=M[j][k];
				}
			}
			for(int j=0;j<N;j++)
			{
				for(int k=0;k<N;k++)
				{
					temp=M[j][k];
					flag=false;
					int colPos=k;
					for(int l=0;l<N;l++)
					{
						if(temp==M[j][l] && colPos!=l)
						{
							flag=true;
							break;
						}
					}
					if(flag==true)
					{
						rows++;
						break;
					}
				}
			}
			for(int j=0;j<N;j++)
			{
				for(int k=0;k<N;k++)
				{
					temp=M[k][j];
					flag=false;
					int rowPos=k;
					
					for(int l=0;l<N;l++)
					{
						if(temp==M[l][j] && rowPos!=l)
						{
							
							flag=true;
							break;
						}
					}
					
					if(flag==true)
					{
						columns++;
						break;
					}
				}
			}
			System.out.println("Case #"+i+":"+" "+sum+" "+rows+" "+columns);
		}
		sc.close();

	}

}