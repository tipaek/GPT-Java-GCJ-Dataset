import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int test_cases = in.nextInt();
		for (int q = 1; q <= test_cases; q++) {
			System.out.print("Case #" + q + ": ");
			int n = in.nextInt();
			String[] arr = new String[n];
			for (int x = 0; x < n; x++) {
				arr[x] = in.next();
			}
			StringBuilder str1 = new StringBuilder("");
			StringBuilder str2 = new StringBuilder("");
			boolean[] vis = new boolean[n];
			int c = 0, i = 0;
			boolean flag = true;
			while (c < n && flag) {
				char ch = ' ';
				for (int x = 0; x < n; x++) {
					if (vis[x])
						continue;
					if(arr[x].charAt(i) == '*') {
						vis[x] = true;
						c++;
					}
					else if (ch == ' ')
						ch = arr[x].charAt(i);
					else if (ch != arr[x].charAt(i)) {
						flag = false ;
						break;
					}
				}
				if(ch!=' ')
				str1.append(ch);
				i++;
			}
			c = 0;
			i = 1;
			vis = new boolean[n];
			while (c < n && flag) {
				char ch = ' ';
				for (int x = 0; x < n; x++) {
					if (vis[x])
						continue;
					if(arr[x].charAt(arr[x].length() - i) == '*') {
						vis[x] = true;
						c++;
					}
					
					else if (ch == ' ')
						ch = arr[x].charAt(arr[x].length() - i);
					else if (ch != arr[x].charAt(arr[x].length() - i)) {
						flag = false ;
						break;
					}
				}
				if(ch!=' ')
				str2.append(ch);
				i++;
			}
			if(flag) {
				str2.reverse();
				System.out.println(str1+""+str2);
			}
			else 
				System.out.println("*");
		}

	}

}