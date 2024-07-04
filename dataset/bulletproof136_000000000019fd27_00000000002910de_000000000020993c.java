import java.util.Scanner;

public class set1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t;
		int n;
		int arr[][];
		t = input.nextInt();
		for(int i = 0; i < t; i++)
		{
			int repeatedRow = 0, repeatedCol = 0, trace = 0;
			boolean foundRow, foundCol;
			n = input.nextInt();
			arr = new int[n][n];
			for(int row = 0; row < n; row++)
			{
				for(int col = 0; col < n; col++)
				{
					arr[row][col] = input.nextInt();
				}
			}
			for(int row = 0; row < n; row++)
			{
				foundRow = false;
				for(int col = 0; col < n-1 && foundRow == false; col++)
					for(int index = col+1; index < n && foundRow == false; index++)
					{
						if(arr[row][col] == arr[row][index])
						{
							repeatedRow+=1;
							foundRow = true;
						}
					}
			}
			for(int col = 0; col < n; col++)
			{
				foundCol = false;
				for(int row = 0; row < n-1 &&  foundCol == false; row++)
					for(int index = row+1; index < n && foundCol == false; index++)
					{
						if(arr[row][col] == arr[index][col])
						{
							repeatedCol+=1;
							foundCol = true;
						}
					}
			}
			for(int row = 0; row < n; row++)
			{
				trace+=arr[row][row];
			}
						
			System.out.println("case#"+ (t+1) + ": " + trace + " " +repeatedRow
					+" " + repeatedCol);
		}

	}

}
