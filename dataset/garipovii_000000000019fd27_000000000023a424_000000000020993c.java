package package1;
import java.util.Scanner;
public class TaskA 
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in); 
		int m=input.nextInt();
		int i,j,k,S,n,count_row,count_col;
		String []list_res=new String[m];
		for (int q=1;q<=m;q++)
		{	
			count_row=0;count_col=0;
			list_res[q-1]="Case #"+q+": ";
			n=input.nextInt();
			int [][]a=new int[n][n];
			S=0;
			for (i=0;i<n;i++)
				for(j=0;j<n;j++)
				{
					a[i][j]=input.nextInt();
					if(i==j)
						S+=a[i][j];
				}	
			list_res[q-1]+=S;
			for(i=0;i<n;i++)
				label1:
					for(j=0;j<n;j++)
						for(k=j+1;k<n;k++)
							if(a[i][j]==a[i][k])
							{
								count_row++;
								break label1;
							}
			list_res[q-1]+=" "+count_row;
			for(j=0;j<n;j++)
				label2:
					for(i=0;i<n;i++)
						for(k=i+1;k<n;k++)
							if(a[i][j]==a[k][j])
							{
								count_col++;
								break label2;
							}	
			list_res[q-1]+=" "+count_col;
		}
		for (i=0;i<m;i++)
			System.out.println(list_res[i]);	
		input.close();
	}
}
