import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		int t,tt,i,j,n,min,flag,ec,ej,temp;
		t=ob.nextInt();
		tt=t;
		while(t-->0) {
			String ss="";
			n=ob.nextInt();
			int s[]=new int[n];// starting points
			int e[]=new int[n];// ending points
			int p[]=new int[n];// to store the original positions of task after sorted
			for(i=0;i<n;i++)
			{
				s[i]=ob.nextInt();
				e[i]=ob.nextInt();
				p[i]=i;
			}
			for(i=0;i<n;i++) { //sorting
				min=i;
				for(j=i+1;j<n;j++) {
					if(s[min]>s[j])
						min=j;
				}
				temp=s[min];
				s[min]=s[i];
				s[i]=temp;
				temp=e[min];
				e[min]=e[i];
				e[i]=temp;
				temp=p[min];
				p[min]=p[i];
				p[i]=temp;
			}
			//System.out.println(Arrays.toString(p));
			ec=-1;
			ej=-1;
			flag=0;
			for(i=0;i<n;i++) {
				if(ec<=s[i])
				{
					ss=ss+"C";
					ec=e[i];
				}
				else if(ej<=s[i])
				{
					ss=ss+"J";
					ej=e[i];
				}
				else {
					flag=1;
					break;
				}
			}
			if(flag==1 || ss.length()!=n)
				System.out.println("Case #"+(tt-t)+": IMPOSSIBLE");
			else
			{
				System.out.print("Case #"+(tt-t)+": ");
				for(i=0;i<n;i++) {
					System.out.print(ss.charAt(p[i]));
				}
				System.out.println();
			}
		}
	}

}
