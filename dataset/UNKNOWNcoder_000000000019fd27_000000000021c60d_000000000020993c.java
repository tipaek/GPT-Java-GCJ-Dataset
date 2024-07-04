import java.util.*;
class Vestigium
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int tn=0;
		while(tn++<t)
		{
			int n=sc.nextInt();
			int m[][]=new int[n][n];
			int k=0,r=0,c=0;
			HashMap[] map=new HashMap[n];
			for(int i=0;i<n;i++)
				map[i]=new HashMap<Integer,Integer>();
			int cf[]=new int[n];
			for(int i=0;i<n;i++)
			{
				HashMap<Integer,Integer> mp=new HashMap<>();
				int f=0;
				for(int j=0;j<n;j++)
				{	
					m[i][j]=sc.nextInt();
					if(!mp.containsKey(m[i][j]))
						mp.put(m[i][j],0);
					else
						f=1;
					if(!map[j].containsKey(m[i][j]))
						map[j].put(m[i][j],0);
					else
						cf[j]=1;
					if(i==j)
						k+=m[i][j];
				}
				if(f==1)
					r+=1;
			}
			for(int i=0;i<n;i++)
				c+=cf[i];
			System.out.println("Case #"+tn+": "+k+" "+r+" "+c);
		}
	}
}