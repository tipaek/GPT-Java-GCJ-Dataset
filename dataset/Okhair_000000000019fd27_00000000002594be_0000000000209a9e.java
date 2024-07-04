import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		PrintWriter out= new PrintWriter(System.out);
		int t=sc.nextInt();
		int b=sc.nextInt();
		int testnum=1;
		while(t-->0) {
			int[] arr= new int[b+1];
			int n=arr.length;
			Arrays.fill(arr, -1);
			int q=1;
			for(int i=1; i<=n/2;i++) {
				if(q>1 && q%10==1) {
					int diffindex=bitsDifferent(arr);
					int sameindex=bitsSame(arr);
					if(diffindex==-1) {
						System.out.println(sameindex);
						int res=sc.nextInt();
						System.out.println(n-sameindex);
						sc.nextInt();
						q+=2;
						if(res!=arr[sameindex])
							complement(arr);
					}
					else if(sameindex==-1) {
						System.out.println(diffindex);						
						int res=sc.nextInt();
						System.out.println(n-diffindex);
						sc.nextInt();
						q+=2;
						if(res!=arr[diffindex])
							complement(arr);
					}
					else {
						System.out.println(sameindex);
						int sameres=sc.nextInt();
						System.out.println(diffindex);
						q+=2;
						int diffres=sc.nextInt();
						if(diffres!=arr[diffindex] && sameres!=arr[sameindex])
							complement(arr);
						else if(diffres!=arr[diffindex] && sameres==arr[sameindex])
							flip(arr);
						else if(diffres==arr[diffindex] && sameres!=arr[sameindex]) {
							complement(arr);
							flip(arr);
						}		
					}
				}
				System.out.println(i);
				arr[i]=sc.nextInt();
				System.out.println(n-i);
				arr[n-i]=sc.nextInt();
				q+=2;
			}
			StringBuilder sb= new StringBuilder();
			for(int i=1;i<n;i++)
				sb.append(arr[i]);
			System.out.println(sb);
			String response=sc.next();
			if(response.equals("N"))
				System.exit(0);;
		}
		out.close();
	}
	public static int bitsDifferent(int[] arr) {
		int n=arr.length;
		int i=1;
		for(;i<=n/2; i++)
			if(arr[i]==-1)
				continue;
			else if(arr[i]!=arr[n-i])
				return i;
		return -1;
	}
	public static int bitsSame(int[] arr) {
		int n=arr.length;
		int i=1;
		for(;i<=n/2; i++)
			if(arr[i]==-1)
				continue;
			else if(arr[i]==arr[n-i])
				return i;
		return -1;
	}
	public static void complement(int[] arr) {
		for(int i=1;i<arr.length;i++)
			if(arr[i]==0)
				arr[i]=1;
			else if(arr[i]==1)
				arr[i]=0;
	}
	public static void flip(int[] arr) {
		int n=arr.length;
		int i=1;
		for(;i<=n/2; i++)
			if(arr[i]==-1)
				continue;
			else {
				int temp=arr[i];
				arr[i]=arr[n-i];
				arr[n-i]=temp;
			}
				
	}
}
