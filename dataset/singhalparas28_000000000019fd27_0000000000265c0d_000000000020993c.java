import java.util.*;
public class Vest
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int a[]=new int[t];
		int b[]=new int[t];
		int c[]=new int[t];
		for(int i=0;i<t;i++)
		{
			int n = sc.nextInt();
			String str[]=new String[n];
			int arr[][]=new int[n][n];
			for(int j=0;j<n;j++)
			{
				Scanner sc1 = new Scanner(System.in);
				str[j]=sc1.nextLine();
				String[] isi = str[j].split(" ");
				for (int k=0; k< isi.length; k++)
				arr[j][k] = Integer.parseInt(isi[k]);
			}
			a[i]=diagonal(arr,n);
			b[i]=row(arr,n);
			c[i]=column(arr,n);
		}
		for(int i=0;i<t;i++)
		{
			System.out.println("Case #"+(i+1)+": "+a[i]+" "+b[i]+" "+c[i]);
		}
	}
	public static int column(int arr[][],int n)
	{
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			int a[]=new int[arr.length];
			int k=0;
			for(int j=0;j<arr.length;j++)
			{
				a[k++]=arr[j][i];
			}
			int res=row1(a);
			if(res==1)
				count++;
		}
		return count;
	}
	public static int row(int arr[][],int n)
	{
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			int res=row1(arr[i]);
			if(res==1)
				count++;
		}
		return count;
	}
	public static int row1(int arr[])
	{
		int c=0;
		for(int i=0;i<arr.length;i++)
		{
			c=0;
			for(int j=0;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
					c++;
			}
			if(c>1)
				return 1;
		}
		return 0;
	}
	public static int diagonal(int arr[][],int n)
	{
		int sum=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(i==j)
					sum+=arr[i][j];
		return sum;
	}
}