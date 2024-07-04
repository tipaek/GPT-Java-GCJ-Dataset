import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String [] args) throws IOException{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(cin.readLine());
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(cin.readLine());
			System.out.println("Case #" + t + ":");
			for(int i = 1; i <= n; i++)
				System.out.println(i + " 1");
		}
	}
}