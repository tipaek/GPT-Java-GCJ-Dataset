import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	static boolean solve=false;
	static int n=0;
	static int m=0;
	static int p=0;
	static void helper(int arr[][],int k,HashMap<Integer,HashMap<Integer,Boolean>> row,HashMap<Integer,HashMap<Integer,Boolean>> col,int i,int j)
	{
		if(i==n)
		{
			return;
		}
		if(i==n-1&&j==n&&m==k&&!solve)
		{
			solve=true;
			System.out.println("Case #"+p+": POSSIBLE");
			for(int x=0;x<n;x++)
			{
				for(int y=0;y<n;y++)
				{
					System.out.print(arr[x][y]+" ");
				}
				if(x!=n-1)
				{
					System.out.println();
				}
			}
			return;
		}
		if(i==n-1&&j==n)
		{
			return;
		}
		if(j==n)
		{
			helper(arr,k,row,col,i+1,0);
		}
		if(solve)
		{
			return;
		}
		for(int w=1;w<=n;w++)
		{
			if(!row.get(i).containsKey(w)&&!col.get(j).containsKey(w))
			{
				if(solve)
				{
					return;
				}
				arr[i][j]=w;
				if(i==j)
				{
					m=m+w;
				}
				row.get(i).put(w, true);
				col.get(j).put(w, true);
				helper(arr,k,row,col,i,j+1);
				row.get(i).remove(w);
				col.get(j).remove(w);
				if(i==j)
				{
					m=m-w;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		 p=1;
		while(t-->0)
		{
			solve=false;
			m=0;
			 n=s.nextInt();
			int k=s.nextInt();
			int arr[][]=new int[n][n];
			HashMap<Integer,HashMap<Integer,Boolean>> row=new HashMap<Integer,HashMap<Integer,Boolean>>();
			HashMap<Integer,HashMap<Integer,Boolean>> col=new HashMap<Integer,HashMap<Integer,Boolean>>();
			for(int w=0;w<n;w++)
			{
				HashMap<Integer,Boolean> temp1=new HashMap<Integer,Boolean>();
				HashMap<Integer,Boolean> temp2=new HashMap<Integer,Boolean>();
				row.put(w,temp1);
				col.put(w,temp2);
			}
			helper(arr,k,row,col,0,0);
			if(!solve)
			{
				System.out.println("Case #"+p+": IMPOSSIBLE");
			}
			p++;
		}

	}

}