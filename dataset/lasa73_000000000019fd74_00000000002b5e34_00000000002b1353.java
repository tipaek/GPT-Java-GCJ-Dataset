import java.util.*;

public class Solution
{
	static int arr[][];
	
	static int fact(int num) {
	int factorial;
	
	for(factorial = 1; num > 1; num--){
		factorial *= num;
	}
	return factorial;
    }
    static int ncr(int n,int r) {
	return fact(n) / ( fact(n-r) * fact(r) );
    }
	
	static Scanner sc;
	
	static void logic(int t)
	{
		//Write code here.
		int rows, i, j,sum=0;

	//getting number of rows from user
		rows = sc.nextInt();
			
		for(i=1;i<=rows;i++)
		{
			arr=new int[i][i];
		}
		System.out.println("Pascal Triangle:");
		for(i = 0; i < rows; i++) {
			for(j = 0; j <= i; j++){
				arr[i][j]=ncr(i, j);
			}
		}
		
		int n=sc.nextInt();
		
		for(i=0;i<rows;i++)
		{
			for(j=0;j<=i;j++)
			{
				while(sum!=rows)
				{
					
				}
			}
		}
		
		// System.out.println("Case #"+t+": "+  );
	}
	
	public static void main(String arg[])
	{
		sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0;i<T;i++)
		{
			logic(i+1);
		}
	}
}