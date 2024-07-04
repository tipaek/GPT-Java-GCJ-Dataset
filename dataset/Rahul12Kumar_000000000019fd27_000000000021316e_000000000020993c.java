import java.util.HashSet;
import java.util.Scanner;

class CodeJam {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int k=1;k<=n;k++)
		{
			int x = sc.nextInt();
			int arr[][] = new int[x][x];
			int truce = 0;
			int row = 0;
			int col = 0;
			for(int i=0;i<x;i++)
			{
				HashSet<Integer> rowCheck = new HashSet<>();
				boolean flag = true;
				for(int j=0;j<x;j++)
				{
					arr[i][j] = sc.nextInt();
					if(rowCheck.contains(arr[i][j]) && flag)
					{
						row++;
						flag = false;
					}
					else
					{
						rowCheck.add(arr[i][j]);
					}
					if(i==j)
					{
						truce += arr[i][j];
					}
				}
			}
			for(int i=0;i<x;i++)
			{
				HashSet<Integer> rowCheck = new HashSet<>();
				boolean flag = true;
				for(int j=0;j<x;j++)
				{
					if(rowCheck.contains(arr[j][i]) && flag)
					{
						col++;
						flag = false;
					}
					else
					{
						rowCheck.add(arr[j][i]);
					}
				}
			}
			System.out.println("Case #"+(k)+": "+truce + " "+row + " "+col);
			
		}
		sc.close();
	}

}
