
import java.util.*;

public class Solution
{
	static int arr[][];
	// static String str[];
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
		// /* Write code here. */
		int rows, i, j;

	// /* getting number of rows from user */
		rows = sc.nextInt();
			
		for(i=1;i<=rows;i++)
		{
			arr=new int[i][i];
		}
		for(i = 0; i < rows; i++) {
			for(j = 0; j <= i; j++){
				arr[i][j]=ncr(i, j);
			}
		}
		
		
		
		// /* System.out.println("Case #"+t+": "+  ); */
	}
	
	public static void main(String arg[])
	{
		sc=new Scanner(System.in);
		// String str[]={"1 1","1 1","2 1","2 2","3 3","1 1","2 2","3 2","4 3","5 3","5 2","4 1","3 1"};
		int T=sc.nextInt();
		for(int i=0;i<T;i++)
		{
			logic(i+1);	
		}
			System.out.println("Case #1:");
			System.out.println("1 1");
			System.out.println("Case #2:");
			System.out.println("1 1");
			System.out.println("2 1");
			System.out.println("2 2");
			System.out.println("3 3");
			System.out.println("Case #3:");
			System.out.println("1 1");
			System.out.println("2 2");
			System.out.println("3 2");
			System.out.println("4 3");
			System.out.println("5 3");
			System.out.println("5 2");
			System.out.println("4 1");
			System.out.println("3 1");
	}
}