import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		outerLoop: for (int i = 1; i <= t; i++) {
			int n = in.nextInt();
			String start = "", mid = "" , end = "";
			for (int j = 0; j < n; j++) {
				String cur = in.next();
				String[] arr = cur.split("\\*");
				if(cur.charAt(0) != '*') {
					if(arr[0].matches(start + ".*"))
						start = arr[0];
					else if(!start.matches(arr[0] + ".*")) {
						System.out.println("Case #" + i + ": *");
						continue outerLoop;
					}
				}
				if(cur.charAt(cur.length() - 1) != '*')
					if(arr[arr.length - 1].matches(".*" + end))
						end = arr[arr.length - 1];
					else if(!end.matches(".*" + arr[arr.length - 1])) {
						System.out.println("Case #" + i + ": *");
						continue outerLoop;
					}
				
				for(int k = 1; k < arr.length - 1; k++)
					mid += arr[k];
			}
			System.out.println("Case #" + i + ": " + start + mid + end);
		}
		in.close();
	}	
}