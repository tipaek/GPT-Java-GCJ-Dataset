import java.util.*;
class Solution{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int p=1;
		while(t-->0)
		{
			int n=sc.nextInt();
			T arr[]=new T[n];
			
			for(int i=0;i<n;i++)
			{
				int s=sc.nextInt();
				int e=sc.nextInt();
				arr[i]=new T(s,e,i);
			}
			char ans[]=new char[n];
			
			Arrays.sort(arr,new Sort3());
			int Ej=0,Ec=0;
			int f=0;
			for(int i=0;i<n;i++)
			{
				if(arr[i].s>=Ej)
				{
					Ej=arr[i].e;
					ans[arr[i].index]='J';
				}
				else if(arr[i].s>=Ec)
				{
					Ec=arr[i].e;
					ans[arr[i].index]='C';
				}
				else
				{
					f=1;
					break;
				}
			}
			
			if(f==1)
				System.out.println("Case #"+p+": IMPOSSIBLE");
			else
			{
				System.out.print("Case #"+p+": ");
				for(int i=0;i<n;i++)
					System.out.print(ans[i]);
				System.out.println();
			}
			p++;
		}

	}

}

class T
{
	int s,e,index;
	public T(int s,int e,int index)
	{
		this.s=s;
		this.e=e;
		this.index=index;
	}
}

class Sort3 implements Comparator<T>
{
	public int compare(T a,T b)
	{
		return a.e-b.e;
	}
}