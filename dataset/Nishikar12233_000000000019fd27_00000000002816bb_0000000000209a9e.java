import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int test=sc.nextInt();
		int b=sc.nextInt();
		for(int g=0;g<test;g++)
		{
			String ans="";
			String output;
			if(b==10)
			{
				for(int x=0;x<10;x++)
				{
					System.out.println(x);
					ans+=sc.nextInt();
				}
				System.out.println(ans);
				output=sc.nextLine();
			}
		}
	}

}
