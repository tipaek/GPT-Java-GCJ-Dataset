import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();in.nextLine(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			String s = in.nextLine();
			char[] arr = s.toCharArray();

			int opened = 0;

			StringBuilder sb = new StringBuilder(300);
			for (int j = 0; j < arr.length; j++) {
				if(arr[j]=='(')
					opened++;
				else if(arr[j]==')')
					opened--;
				else{
					while(arr[j]-'0'>opened){
						sb.append('(');
						opened++;
					}
					while(arr[j]-'0'<opened){
						sb.append(')');
						opened--;
					}
				}
				sb.append(arr[j]);
			}

			while(opened-->0)
				sb.append(")");

			System.out.println("Case #" + i + ": " + sb.toString());
		}
	}
}