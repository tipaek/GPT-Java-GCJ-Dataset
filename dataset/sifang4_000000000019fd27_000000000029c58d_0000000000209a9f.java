
import java.util.*;
import java.io.*;
import java.io.FileInputStream;

class Solution {
	public static void main(String[] args) throws IOException {
	    //System.out.println("hello");
	    //System.setIn(new FileInputStream("C:\\0Data\\Eclipse Java Data\\Leetcode Java\\src\\GoogleCodeJam\\q2case1.txt"));
	    
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		String skip = in.nextLine();
        for (int ii = 1; ii <= t; ++ii) {
			String s = in.nextLine();
			StringBuilder sb = new StringBuilder();
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				int num = s.charAt(i) - '0';
				int left = num - count;
				while (left > 0) {
					sb.append('(');
					count++;
					left--;
				}
				while (left < 0) {
					sb.append(')');
					count--;
					left++;
				}
				sb.append(num);
			}
			while (count > 0) {
				sb.append(')');
				count--;
			}
			String res = sb.toString();
			System.out.println("Case #" + ii + ": " + res);
		}
        in.close();
	}

}


/*

4
0000
101          (1)0(1)
111000       
1

121  (1(2)1)
21   ((2)1)

021 0((2)1)
312 (((3))1(2))
4 ((((4))))
221 ((2))((2))(1)


*/