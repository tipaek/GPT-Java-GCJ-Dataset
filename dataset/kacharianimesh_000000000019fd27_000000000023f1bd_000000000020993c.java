import java.util.Scanner;

class Main
{
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		int T = scan.nextInt();
		for(int t = 1; t <= T; t++)
		{
			int N = scan.nextInt();
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					arr[i][j] = scan.nextInt();
				}
			}
			int k = findk(arr);
			int r = findr(arr);
			int c = findc(arr);
			
			System.out.println("Case #" + t +": " + k + " " + r + " " + c +" ");
		}
	}
	
	static int findk(int[][] arr)
	{
		int k = 0;
		int size = arr.length;
		
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				if(i == j)
				{
					k = k + arr[i][j];
				}
			}
		}
		return k;
	}
	
	static int findr(int[][] arr)
	{
		int r = 0;
		int tempr = 0;
		int size = arr.length;
		
		for(int x = 0; x < size; x++)
		{
			for(int y = 0; y < size-1; y++)
			{
				int pivot = arr[x][y];
				for(int z = y + 1; z < size; z++)
				{
					if(arr[x][z] == pivot)
					{
						tempr++;
						break;
					}
				}
				if(tempr != r)
				{
					r = tempr;
					break;
				}
			}
		}
		return r;
	}
	
	static int findc(int[][] arr)
	{
		int c = 0;
		int tempc = 0;
		int size = arr.length;
		for(int x = 0; x < size; x++)
		{
			for(int y = 0; y < size-1; y++)
			{
				int pivot = arr[y][x];
				for(int z = y + 1; z < size; z++)
				{
					if(arr[z][x] == pivot)
					{
						tempc++;
						break;
					}
				}
				if(tempc != c)
				{
					c = tempc;
					break;
				}
			}
		}
		return c;
	}
}