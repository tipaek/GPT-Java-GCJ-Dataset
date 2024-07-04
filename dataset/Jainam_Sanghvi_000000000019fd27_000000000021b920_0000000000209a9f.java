import java.util.*;
import java.io.*;

public class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int cou=1;
		while(t-- > 0)
		{
			String s = sc.next();
			char a[] = s.toCharArray();
			char b[] = new char[100];
			int j=0;
			if(a[0] == '1')
			{
				b[j] = '(';
				j++;
				b[j] = a[0];
				j += 1;
			}
			else
			{
				b[j] = a[0];
				j++;
			}
			for(int i=0;i<a.length-1;i++)
			{
				if((int)a[i]-(int)a[i+1] > 0)
				{
					b[j] = ')';
					j++;
					b[j] = a[i+1];
					j++;	
				}
				if((int)a[i]-(int)a[i+1] < 0)
				{
					b[j] = '(';
					j++;
					b[j] = a[i+1];
					j++;
				}
				if((int)a[i]-(int)a[i+1] == 0)
				{
					b[j] = a[i];
					j++;
				}
			}
			if(a[a.length-1] == '1')
			{
				b[j] = ')';
			}
			String ans="";
			for(int i=0;i<=j;i++)
			{
				ans += b[i];
			}
			System.out.println("Case #" + (cou) + ": " + ans);
			cou++;
		}
	}
}