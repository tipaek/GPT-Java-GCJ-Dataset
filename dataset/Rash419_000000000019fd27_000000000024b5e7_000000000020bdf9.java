import java.util.*;
class Solution
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int r=0;r<t;r++)
		{
			int n = scan.nextInt();
			int arr[][] = new int[n][2];
			char chArr[] = new char[n];
			Arrays.fill(chArr, 'X');
			for(int i=0;i<n;i++)
			{
				arr[i][0] = scan.nextInt();
				arr[i][1] = scan.nextInt();
			}
			boolean J = false;
			boolean C = false;
			boolean impossible = false;
			int Jstart = 0;
			int Jend = 0;
			int Cstart = 0;
			int Cend = 0;
			for(int i=0;i<n;i++)
			{
				if(i == 0)
				{
					chArr[i]='J';
					Jstart = arr[i][0];
					Jend = arr[i][1];
					J=true;
				}
				else
				{
					if(arr[i][0] >= Cend)
					{
						C = false;
					}
					if(arr[i][0] >= Jend)
					{
						J = false;
					}
					if(J == true && C == false)
					{
						
						if((arr[i][0] >= Jstart && arr[i][0] <= Jend )|| (arr[i][1] >= Jstart && arr[i][1] <= Jend))
						{
							chArr[i]='C';
							C = true;
							Cstart = arr[i][0];
							Cend = arr[i][1];
						}
					}
					else if(C == true && J == false)
					{
						
						if((arr[i][0] >= Cstart && arr[i][0] <= Cend )|| (arr[i][1] >= Cstart && arr[i][1] <= Cend))
						{
							chArr[i]='J';
							J = true;
							Jstart = arr[i][0];
							Jend = arr[i][1];
						}
					}
					else if(C == true && J == true)
					{
						if(arr[i][0] < Jstart && arr[i][1] <= Jstart)
						{
							chArr[i]='J';
						}
						else if(arr[i][0] < Cstart && arr[i][1] <= Cstart)
						{
							chArr[i]='C';
						}
						else
						{
							impossible = true;
						}
					}
				}
			}
			if(impossible)System.out.println("Case #"+(r+1)+": " + "IMPOSSIBLE");
			else 
			{
				for(int k=0;k<chArr.length;k++)
				{
					if(chArr[k] == 'X')
						chArr[k] = 'C';
				}
				System.out.print("Case #"+(r+1)+": ");
				for(char ch:chArr)System.out.print(ch);
				System.out.println();
			}
			
		}
	}
}
