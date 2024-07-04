package com.qualification.round;

import java.util.Scanner;

public class Vietnam {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vietnam vietnam= new Vietnam();
		int testcases = sc.nextInt();
		int tracecount[] = new int[testcases];
		int rowCount[] = new int[testcases];
		int colCount[] =  new int[testcases];
		int count=0;
		for(int k=0; k<testcases;k++)
		{
			int n = sc.nextInt();
			int matrix[][] = new int[n][n] ;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					matrix[i][j] = sc.nextInt();
					if(i == j)
					{
						count =count + matrix[i][j];
					}
				}
			}
			tracecount[k] = count;
			count=0;
			rowCount[k] = vietnam.countRows(matrix, testcases);
			colCount[k] = vietnam.countCols(matrix, testcases);
		}
		for(int i=0;i<testcases ;i++)
		{
			System.out.println("Case #"+ i+1 +" "+ tracecount[i] + " "+ rowCount[i] + " " + colCount[i]);
		}
		sc.close();
	}
	
	public int countRows(int[][] m, int testcases)
	{
		boolean row = false;
		int count=0;
		
		for(int i=0;i<m.length; i++)
		{
			for(int j=0;j<m.length;j++)
			{
				for( int k=j+1;k<m.length;k++)
				{
						if(m[i][j] == m[i][k])
						{
							row = true;
							break;
						}
				}
				if(row == true)
				{
					break;
				}
			}
			if(row == true)
			{
				count = count+1;
				row = false;
			}	
		}
		return count;
		}
	public int countCols(int[][] m, int testcases)
	{
		boolean col = false;
		int count=0;
		for(int i=0;i<m.length; i++)
		{
			for(int j=0;j<m.length;j++)
			{
				for( int k=j+1;k<m.length;k++)
				{
						if(m[j][i] == m[k][i])
						{
							col = true;
							break;
						}
				}
				if(col == true)
				{
					break;
				}
			}
			if(col == true)
			{
				count = count+1;
				col = false;
			}
		}
		return count;
		}
	}

