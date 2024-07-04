import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
		int test_case=in.nextInt();
		int i=0;
		do {
			String res="";
			i++;
			ArrayList<int []> act = new ArrayList<int []>();
			int ACT=in.nextInt();
			
		for(int j=0;j<ACT;j++)
		{
			int temp[]=new int[2];
			temp[0]=in.nextInt();
			temp[1]=in.nextInt();
			act.add(temp);
		}
			
//			boolean J=true, C=true;
			
			int[] J=new int[1441];
			int[] C=new int[1441];
			
			for(int j=0;j<ACT;j++)
			{
				int min=act.get(j)[0];
				int max=act.get(j)[1];
				
				if(!find(J,min,max))
				{
					res=res+"J";
					for(int k=min;k<=max;k++)
					{
						J[k]=1;
					}
					
				}else if(!find(C,min,max))
				{
					
					res=res+"C";
					for(int k=min;k<=max;k++)
					{
						C[k]=1;
					}
				}
				else
				{
					res="IMPOSSIBLE";
					break;
				}
				
			}
			
		System.out.println("Case #"+i+": "+res);
		test_case--;
		}while(test_case>0);
		
	}
	
	public static boolean find(int[] arr , int mini,int maxi)
	{
		boolean flag=false;
		for(int i=mini+1;i<maxi;i++)
		{
			if(arr[i]==1)
			{
				flag= true;
				return flag;
			}
				
		}
		
		return flag;
		
	}
	
}
