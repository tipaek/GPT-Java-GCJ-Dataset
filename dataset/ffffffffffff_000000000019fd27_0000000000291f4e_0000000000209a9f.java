import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;


public class Solution
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.nextLine();
		for(int i =0; i<N; i++)
		{
			String x = in.nextLine();
			int[] nums = new int[x.length()];
			int[] num2 = new int[x.length()];
			for(int j = 0; j<x.length(); j++)
			{
				nums[j] = Integer.parseInt(x.charAt(j)+"");
				num2[j] = nums[j];
			}
			//System.out.println(Arrays.toString(num2));
			String ret = "";
			int cont2 = 0;
			for(int j =0; j<x.length(); j++)
			{
				int count = 0;
				for(int q = 0; q<nums[j]; q++)
				{
					ret+="(";
							count++;
					cont2++;
							
				}
				
				
				for(int q = 0; q>nums[j]; q--)
				{
					ret+=")";
							count--;     
							cont2--;
				}		
				ret+=""+num2[j];
				for(int q = j+1; q<x.length(); q++)
				{
					nums[q] -= count;
				}
				
			}
			for(int p =0; p<cont2; p++)
				ret+=")";
			System.out.println("Case #"+(i+1)+": "+ret);
			
		}
	}
}
