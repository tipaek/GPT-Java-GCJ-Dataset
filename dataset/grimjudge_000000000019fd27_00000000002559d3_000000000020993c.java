import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	static class Result{
		int sum=0;
		int row=0;
		int col=0;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input= new Scanner(System.in);
		int t=input.nextInt();
		for(int i=0;i<t;i++){
			Result result= new Result();
			int n=input.nextInt();
			int[][] a= new int[n][n];
			for(int j=0;j<n;j++){
				Map<Integer,Integer>rowMap= new HashMap<>();
				for(int k=0;k<n;k++){
					a[j][k]=input.nextInt();
					if(j==k)
					result.sum=result.sum+a[j][k];
					rowMap.put(a[j][k],1);
				}
				if(rowMap.size()!=n)
				result.row=result.row+1;
			}
			
			for(int q=0;q<n;q++){
				Map<Integer,Integer>colMap= new HashMap<>();
				for(int r=0;r<n;r++){
					colMap.put(a[r][q],1);
				}
				if(colMap.size()!=n)
				result.col=result.col+1;
			}
			
			System.out.println(result.sum+" "+result.row+" "+result.col);
			
		}
	}
}