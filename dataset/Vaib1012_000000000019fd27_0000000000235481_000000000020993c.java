import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LatinMatrix {

	int[][]mat;
	int n;

	public LatinMatrix(int n)
	{
		this.n=n;
		mat=new int[n][n];
	}

	int trace()
	{
		int k=0;

		for(int i=0; i<n ; i++)
		{
			k+=mat[i][i];
		}
		return k;
	}

	int checkRows()
	{
		int r=0;

		for(int i=0;i<n;i++)
		{
			for(int j=0 ; j<n-1 ; j++)
			{
				for( int k=j+1; k<n; k++)
				{
					if(mat[i][j]==mat[i][k])
					{
						r++;
						k=n;
						j=n;
					}
				}
			}
		}
		return r;
	}

	int checkColumns()
	{
		int c=0;

		for(int i=0;i<n;i++)
		{
			for(int j=0 ; j<n-1 ; j++)
			{
				for( int k=j+1; k<n; k++)
				{
					if(mat[j][i]==mat[k][i])
					{
						c++;
						k=n;
						j=n;
					}
				}
			}
		}
		return c;
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));

		int t=0, n=0, i=0;

		t=Integer.parseInt(in.readLine());
		LatinMatrix[] lm= new LatinMatrix[t];
		for(int p=0 ; p<t ; p++)
		{
			n=Integer.parseInt(in.readLine());
			lm[p]=new LatinMatrix(n);


			for(i=0;i<n;i++)
			{
				String s=in.readLine().trim();
				String[] arr=s.split(" ");

				for(int j=0; j<arr.length ; j++)
				{
					lm[p].mat[i][j]=Integer.parseInt(arr[j]);
				}

			}


		}

		for(i=0;i<t;i++)
		{
			int k=0, r=0, c=0;
			k=lm[i].trace();
			r=lm[i].checkRows();
			c=lm[i].checkColumns();
			System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
		}
	}

}
