import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int t=sc.nextInt();
		int x=1;
		while(x<=t)
		{
			int n=sc.nextInt();
			int[][] mat=new int[n][n];
			for(int j=0;j<n;j++)
				for(int i=0;i<n;i++)
					mat[j][i]=sc.nextInt();
			int trace=0;
			for(int i=0;i<n;i++)
				trace+=mat[i][i];
			int row=0;
			int column=0;
			for(int j=0;j<n;j++)
			{
				int[] arr1=new int[n+1];
				int[] arr2=new int[n+1];
				arr1[0]=-1;
				arr2[0]=-1;
				for(int i=0;i<n;i++)
				{	
					arr1[mat[j][i]]++;
					arr2[mat[i][j]]++;
				}
				int toCheckValue=0;
				 boolean found = IntStream.of(arr1).anyMatch(y -> y == toCheckValue);
				if(found)
					row++;
				boolean found1 = IntStream.of(arr2).anyMatch(y -> y == toCheckValue);
				if(found1)
					column++;
			}
			System.out.println("Case #"+x+": "+trace+" "+row+" "+column);
			x++;
		}
	}

}