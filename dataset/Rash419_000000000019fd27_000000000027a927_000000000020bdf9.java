import java.util.*;
public class Solution
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int r=0;r<t;r++)
		{
			int n = scan.nextInt();
			int arr[][] = new int[n][3];
			char chArr[] = new char[n];
			Arrays.fill(chArr, 'X');
			for(int i=0;i<n;i++)
			{
				arr[i][0] = scan.nextInt();
				arr[i][1] = scan.nextInt();
				arr[i][2] = i;
			}
			 arr = sort(arr);
			/*for(int i=0;i<n;i++)
			{
				System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2]);
			}*/
			boolean J = false;
			boolean C = false;
			int Jend = 0;
			int Cend = 0;
			boolean impossible = false;
			for(int i=0;i<n;i++)
			{	
				if(i==0)
				{
					chArr[arr[i][2]]='C';
					Cend = arr[i][1];
					C=true;
				}
				else
				{
					if(J == true && C == false)
					{
						chArr[arr[i][2]]='C';
						Cend = arr[i][1];
						C = true;
					}
					else if(C == true && J == false)
					{
						chArr[arr[i][2]]='J';
						Jend = arr[i][1];
						J = true;
					}
					else if(C == false && J == false)
					{
						chArr[arr[i][2]]='C';
						Cend = arr[i][1];
						C = true;
					}
					else if(J == true && C == true)
					{
						impossible = true;
						break;
					}
					
				}
				//System.out.println(J + " " + C);
			}
			if(impossible)System.out.println("Case #"+(r+1)+": " + "IMPOSSIBLE");
			else 
			{
				System.out.print("Case #"+(r+1)+": ");
				for(char ch:chArr)System.out.print(ch);
				System.out.println();
			}
			
		}
		
	}
	static int[][] sort(int a[][])
	{
		for (int i = 0; i < a.length-1; i++)
        {
            for (int j = 0; j < a.length-i-1; j++)
            {
                if (a[j][0] > a[j+1][0])
                {
                    int temp = a[j][0];
                    a[j][0] = a[j+1][0];
                    a[j+1][0] = temp;

                    temp = a[j][1];
                    a[j][1] = a[j+1][1];
                    a[j+1][1] = temp;

                    temp = a[j][2];
                    a[j][2] = a[j+1][2];
                    a[j+1][2] = temp;
                }
            }
        }
		return a;
	}

	


}
