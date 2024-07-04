
import java.util.Scanner;
import java.util.HashMap;
class Vestigium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		//System.out.println(n);
		int q=1;
		while(q<=n)
		{
			int size=sc.nextInt();
			//System.out.println(size);
			int arr[][]=new int[size][size];
			for(int i=0;i<size;i++)
			{
				for(int j=0;j<size;j++)
				{
					arr[i][j]=sc.nextInt();
				}
			}
			int x=0;
			
//			for(int i=0;i<arr.length;i++)
//			{
//				for(int j=0;j<arr.length;j++)
//				{
//					System.out.print(arr[i][j]+" ");
//				}
//				System.out.println();
//			}
			int k=0,r=0,c=0;
			for(int i=0;i<arr.length;i++)
			{
				
				if(repeating(arr[i]))
					r++;
				k+=arr[i][i];
			}
			for(int i=0;i<arr.length;i++)
			{
				int temp[]=new int[size];
				for(int j=0;j<arr.length;j++)
				{
					temp[j]=arr[j][i];
				}
//				for(int j=0;j<temp.length;j++)
//				{
//					System.out.print(temp[j]+" ");
//				}
				//System.out.println();
				if(repeating(temp))
					c++;
			}
			
			System.out.println("Case #"+q+": "+k+" "+r+" "+c);
			q++;
		}

	}
	public static boolean repeating(int[] temp)
	{
		HashMap<Integer,Integer>hm=new HashMap<Integer,Integer>();
		for(int i=0;i<temp.length;i++)
		{
			if(!hm.containsKey(temp[i]))
				hm.put(temp[i], 1);
			else
				return true;
		}
		return false;
	}

}
