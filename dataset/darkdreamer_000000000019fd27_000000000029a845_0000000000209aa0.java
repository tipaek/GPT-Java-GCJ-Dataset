import java.util.Scanner;
import java.util.HashMap;

public class Solution 
{
	public static int n1=0;
	public static int m1=0;
	public static boolean isfalse=false;
	public static int p=0;
	static void funchelper(int arr[][],int k,HashMap<Integer,HashMap<Integer,Boolean>> row,HashMap<Integer,HashMap<Integer,Boolean>> col,int i,int j)
	{
		if(i==n1)
		{
			return;
		}
		if(i==n1-1&&j==n1&&m1==k&&!isfalse)
		{
			isfalse=true;
			System.out.println("Case #"+p+": POSSIBLE");
			for(int x=0;x<n1;x++)
			{
				for(int y=0;y<n1;y++)
				{
					System.out.print(arr[x][y]+" ");
				}
				if(x!=n1-1)
				{
					System.out.println();
				}
			}
			return;
		}
		if(i==n1-1&&j==n1)
		{
			return;
		}
		if(j==n1)
		{
			funchelper(arr,k,row,col,i+1,0);
		}
		if(isfalse)
		{
			return;
		}
		for(int w=1;w<=n1;w++)
		{
			if(!row.get(i).containsKey(w)&&!col.get(j).containsKey(w))
			{
				if(isfalse)
				{
					return;
				}
				arr[i][j]=w;
				if(i==j)
				{
					m1=m1+w;
				}
				row.get(i).put(w, true);
				col.get(j).put(w, true);
				funchelper(arr,k,row,col,i,j+1);
				row.get(i).remove(w);
				col.get(j).remove(w);
				if(i==j)
				{
					m1=m1-w;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		 p=1;
		while(p<=t)
		{
			isfalse=false;
			m1=0;
			 n1=sc.nextInt();
			int k=sc.nextInt();
			int arr[][]=new int[n1][n1];
			HashMap<Integer,HashMap<Integer,Boolean>> row=new HashMap<Integer,HashMap<Integer,Boolean>>();
			HashMap<Integer,HashMap<Integer,Boolean>> col=new HashMap<Integer,HashMap<Integer,Boolean>>();
			for(int w=0;w<n1;w++)
			{
				HashMap<Integer,Boolean> t1=new HashMap<Integer,Boolean>();
				HashMap<Integer,Boolean> t2=new HashMap<Integer,Boolean>();
				row.put(w,t1);
				col.put(w,t2);
			}
			funchelper(arr,k,row,col,0,0);
			if(!isfalse)
			{
				System.out.println("Case #"+p+": IMPOSSIBLE");
			}
			p++;
		}

	}

}