import java.util.*;

public class pract {

	public static void main(String[] args) {

Scanner sc=new Scanner(System.in);

		 
		 int n = sc.nextInt();
		 int[][] a = new int[n][n];
		 for(int i =0 ; i<n;i++)
		 {
			 for(int j =0;j<n;j++)
			 {
				 int temp = sc.nextInt();
				 a[i][j] = temp;
			 }
		 }
		 
		 
		 
		 int row = 0, col = 0, sum =0;
		 int[] fc = new int[]{0,0,0,0};
		 for(int i = 0;i<n;i++)
		 {
			 int flag_R = 0;
			 for(int j = 0;j<n;j++)
			 {
				if(i==j)
				{
					sum = sum+a[i][j];
				}
				if(flag_R==0)
				{
					for(int k = j+1;k<n;k++)
					{
						if(a[i][j] == a[i][k])
						{
							flag_R=1;
							row++;
						}
					}
				}
				if(fc[j]==0)
				{
					for(int k=i+1;k<n;k++)
					{
						if(a[i][j]==a[k][j])
						{
							fc[j]=1;
							col++;
						}
					}
				}
			 }
			 
			 
		 }
		
		System.out.println(sum+" "+row+" "+col);
 
	}
}