import java.util.Scanner;
import java.io.*;
public class Solution {

	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int test= sc.nextInt();
		int a=sc.nextInt();
		int b=sc.nextInt();boolean found=false;
		for(int g=0;g<test;g++)
		{
			found=false;
			for(int x=-5;x<=5;x++)
			{
				for(int y=-5;y<=5;y++)
				{
					System.out.println(x+ " "+ y);
					System.out.flush();
					if(sc.nextLine().contentEquals("CENTER"))
					{
						found=true;
						break;
					}
				}
				if(found)
				{
					break;
				}
			}
		}
	}

}
