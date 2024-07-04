import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		int K=T;

		while(T-- > 0)
		{
			int N = sc.nextInt();
			int sarr[][] = new int[N][3];
			char [ ] res =new char[N];

			for(int i=0;i<N;i++)
			{
				sarr[i][0]=sc.nextInt();
				sarr[i][1]=sc.nextInt();
				sarr[i][2]=i;
			}
			
			Arrays.sort(sarr,(sarr1,sarr2)->
			{
				int s1 =sarr1[0];
				int s2 =sarr2[0];
				return Integer.compare(s1, s2);
			});
			
//			for(int i=0;i<N;i++)
//			{
//				System.out.println(sarr[i][0]+":"+sarr[i][1]);
//			}
			
			
			char[] c = {'C','J'};
			int n =sarr.length;
			int l[] = new int[2];
			l[0]=l[1]=Integer.MAX_VALUE;
			int p1 =0; int p2=1;
			boolean assigned =false;

			for(int i=n-1;i>=0;i--)
			{
				assigned=false;

				if(l[p1]> l[p2])
				{
					int temp=p1;
					p1= p2;
					p2 =temp;
				}
				
				if(sarr[i][1]<= l[p1])
				{
					assigned=true;
					res[sarr[i][2]]= c[p1];
					l[p1]=sarr[i][0];
					continue;
					
				}
				if(!assigned && sarr[i][1]<=l[p2])
				{
					assigned =true;
					res[sarr[i][2]]= c[p2];
					l[p2]=sarr[i][0];
					continue;
				}
				int re=K-T;
				if(assigned==false) {
					//System.out.println(sarr[i][0]+":"+sarr[i][1]);
					System.out.println("Case #"+re +": IMPOSSIBLE"); break;
					}
			}
			
			if(assigned) {
			int re=K-T;
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<res.length;i++)
			{
				sb.append(res[i]);
			
			}
			System.out.println("Case #"+re+": "+sb.toString());

			//System.out.println(T);
			}
		}

	}

}
