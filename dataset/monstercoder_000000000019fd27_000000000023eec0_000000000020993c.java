package Round1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class latinSquare {
	
	private void printmat(Integer[][] mat)
	{
		int size = mat.length;
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.print(" "+mat[i][j]);
			}
			System.out.println(" ");
		}
	}
	
	public void load(FileReader read)
	{
		try
		{
			BufferedReader br  = new BufferedReader(read);
			String str;
			int max=0,n=-5,i=0,pos=0,j=0;
			int cnt=1;
			Integer[] [] matrix = new Integer[2][2];
				
				while((str=br.readLine())!=null)
				{
					if(pos==n)
					{
						trace(cnt,matrix);
						pos=0;
						cnt++;
						n=-5;
					}
					Scanner sc = new Scanner(str);
					
					
					if(i==0)
					{
						max=sc.nextInt();
						i++;
					}
					else if(n>0&&pos<n)
					{
						while(sc.hasNextInt())
						{
							matrix[pos][j]=sc.nextInt();
							j++;
						}

						pos++;
						j=0;
					}
					else
					{
						n =sc.nextInt();

						matrix = new Integer[n][n];

					}
				}
			read.close();
			br.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void trace(int cs,Integer[][] matrix)
	{

		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Integer> visited1 = new ArrayList<Integer>();
		int size = matrix.length;
		int row=0,col=0,tr=0;

		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				int num=matrix[i][j];
				int num1=matrix[j][i];
				if(j==i)
				{
					tr+=num;
				}

					for(int m=0;m<size;m++)
					{
						if(m!=i)
						{
							for(int n=0;n<size;n++)
							{

								if(num1==matrix[n][m]&&!visited1.contains(num1))
								{
									visited1.add(num1);
									col++;
									break;
								}
							}
						
						}
					}
			
				
					for(int m=0;m<size;m++)
					{
						if(m!=i)
						{
							for(int n=0;n<size;n++)
							{

								if(num==matrix[m][n]&&!visited.contains(num))
								{
									visited.add(num);
									row++;
									break;
								}
							}
						
						}
					}

			}
		}
		
		System.out.println("case #"+cs+": "+tr+" "+row+" "+col);
		
	}
	
	public static void main(String args[])
	{
		try
		{
		latinSquare ls = new latinSquare();
		String filename;
		FileReader read = new FileReader("input.txt");
		ls.load(read);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
