import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		
		for(int i=1;i<=T;i++)
		{
			int trace=0;
			int row=0;
			int col=0;
			int N=scan.nextInt();
			int[][] arr=new int[N][N];
			for(int j=0;j<N;j++)
			{
				for(int k=0;k<N;k++)
				{
					arr[j][k]=scan.nextInt();
				}
			}
			for(int j=0;j<N;j++)
			{
				int flag1=0;
				int flag2=0;
				
				for(int k=0;k<N;k++)
				{
					if(j==k)
					{
						trace= trace+arr[j][k];
					}
					int num1=arr[j][k];
					for(int a=k+1;a<N;a++)
					{
						if(num1==arr[j][a])
						{
							flag1=1;
							break;
						}
					}
					int num2=arr[k][j];
					for(int a=k+1;a<N;a++)
					{
						if(num2==arr[a][j])
						{
							flag2=1;
							break;
						}
					}
				}
				if(flag1==1){row++;}
				if(flag2==1){col++;}
			}
			
			System.out.println("Case #"+i+":"+" "+trace+" "+row+" "+col);
			
		}
		
		

	}

}
