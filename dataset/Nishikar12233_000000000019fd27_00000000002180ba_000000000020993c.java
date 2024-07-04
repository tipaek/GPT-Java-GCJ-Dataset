import java.util.*;
import java.io.*;
public class Solution{

	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int test= sc.nextInt();
		for(int g=0;g<test;g++)
		{
			int n= sc.nextInt();
			int trace=0;
			int row=0;
			int col=0;
			int[][] rowrep=new int[n][n];
			int[][] crep=new int[n][n];
			int[] rows= new int[n];
			int[]  cols=new int[n];
			for(int x=0;x<n;x++)
			{
				for(int y=0;y<n;y++)
				{
					int curr=sc.nextInt()-1;
					if(x==y)
					{
						trace+=curr+1;
					}
					rowrep[x][curr]++;
					crep[y][curr]++;
					if(rowrep[x][curr]>1)
					{
						if(rows[x]==0)
						{
							rows[x]=1;
							row++;
						}
					}
					if(crep[y][curr]>1)
					{
						if(cols[y]==0)
						{
							cols[y]=1;
							col++;
						}
					}
				}
			}
			System.out.println("Case #" + (g+1) + ": " + trace + " "+ row+ " "+ col);
		}
	}

}
