import java.util.*;

public class Solution
{
	public static void main(String args[])
	{
		int n = 0;
		int k = 0;
		int r = 0;
		int c = 0;
		int max = 0;
		int i = 0, j = 0, l = 0;
        String s = "";

		Scanner scan = new Scanner(System.in);

		int T = scan.nextInt();
		int inc = 1;

		while(inc <= T)
		{


			n = scan.nextInt();
			k = 0;
			c = 0;
			r = 0;
			int a[][] = new int[n][n];

			for(i = 0; i < n; i++)
				for(j = 0; j < n; j++)
					a[i][j] = scan.nextInt();

			for(int b = 0; b < n ; b = b + 1)
				k = k + a[b][b];

			for(i = 0; i < n; i++)
			{
				
				for(j = 0; j < n - 1; j++)
				{
					max = 1;
					for(l = j + 1; l < n; l++)
						if(a[i][j] == a[i][l])
							max = max + 1;

					if(max > r && max != 1)
					r = max;
				}
			}


			for(i = 0; i < n; i++)
			{
				
				for(j = 0; j < n - 1; j++)
				{
					max = 1;
					for(l = i + 1; l < n; l++)
						if(a[j][i] == a[l][j])
							max = max + 1;

					if(max > c && max != 1)
					c = max;
				}
				
			}


			s = s + "Case #"+ inc + ": " + k + " " + r + " " + c + "\n";
			inc = inc + 1;
		}

        System.out.println(s);
	}
}