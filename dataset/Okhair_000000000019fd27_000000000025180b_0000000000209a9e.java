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
			int[] arr= new int[b];
			Arrays.fill(arr, -1);
			for(int i=1;i<=b;i++) {
				System.out.println(i);
				int x=sc.nextInt();
				arr[i-1]=x;
			}
			StringBuilder sb= new StringBuilder();
			for(int x:arr)
				sb.append(x);
			System.out.println(sb);
			String response=sc.next();
			if(response.equals("N"))
				System.exit(0);
		}
		out.close();
	}

}
