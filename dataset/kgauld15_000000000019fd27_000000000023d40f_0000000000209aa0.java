import java.util.*;
import java.io.*;
public class Solution {
	public static void main (String []args)throws IOException{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(cin.readLine());
		Dictionary two = new Hashtable();
		two.put(2, "POSSIBLE\n1 2\n2 1");
		two.put(3, "IMPOSSIBLE");
		two.put(4, "POSSIBLE\n2 1\n1 2");
		Dictionary three = new Hashtable();
		three.put(3, "POSSIBLE\n1 2 3\n3 1 2\n2 3 1");
		three.put(4, "IMPOSSIBLE");
		three.put(5, "IMPOSSIBLE");
		three.put(6, "POSSIBLE\n2 1 3\n3 2 1\n1 3 2");
		three.put(7, "IMPOSSIBLE");
		three.put(8, "IMPOSSIBLE");
		three.put(9, "POSSIBLE\n3 1 2\n2 3 1\n1 2 3");
		Dictionary four = new Hashtable();
		four.put(4, "POSSIBLE\n1 3 2 4\n4 1 3 2\n2 4 1 3\n3 2 4 1");
		four.put(5, "IMPOSSIBLE");
		four.put(6, "IMPOSSIBLE");
		four.put(7, "IMPOSSIBLE");
		four.put(8, "POSSIBLE\n2 3 1 4\n4 2 3 1\n1 4 2 3\n3 1 4 2");
		four.put(9, "IMPOSSIBLE");
		four.put(10, "POSSIBLE\n1 4 2 3\n3 2 4 1\n4 1 3 2\n2 3 1 4");
		four.put(11, "IMPOSSIBLE");
		four.put(12, "POSSIBLE\n3 1 2 4\n4 3 1 2\n2 4 3 1\n1 2 4 3");
		four.put(13, "IMPOSSIBLE");
		four.put(14, "IMPOSSIBLE");
		four.put(15, "IMPOSSIBLE");
		four.put(16, "POSSIBLE\n4 3 2 1\n1 4 3 2\n2 1 4 3\n3 2 1 4");
		Dictionary five = new Hashtable();
		five.put(5, "POSSIBLE\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1");
		five.put(6, "IMPOSSIBLE");
		five.put(7, "IMPOSSIBLE");
		five.put(8, "IMPOSSIBLE");
		five.put(9, "IMPOSSIBLE");
		five.put(10, "POSSIBLE\n2 1 3 4 5\n5 2 1 3 4\n4 5 2 1 3\n3 4 5 2 1\n1 3 4 5 2");
		five.put(11, "IMPOSSIBLE");
		five.put(12, "IMPOSSIBLE");
		five.put(13, "IMPOSSIBLE");
		five.put(14, "IMPOSSIBLE");
		five.put(15, "POSSIBLE\n3 2 1 4 5\n5 3 2 1 4\n4 5 3 2 1\n1 4 5 3 2\n2 1 4 5 3");
		five.put(16, "IMPOSSIBLE");
		five.put(17, "IMPOSSIBLE");
		five.put(18, "IMPOSSIBLE");
		five.put(19, "IMPOSSIBLE");
		five.put(20, "POSSIBLE\n4 2 3 1 5\n5 4 2 3 1\n1 5 4 2 3\n3 1 5 4 2\n2 3 1 5 4");
		five.put(21, "IMPOSSIBLE");
		five.put(22, "IMPOSSIBLE");
		five.put(23, "IMPOSSIBLE");
		five.put(24, "IMPOSSIBLE");
		five.put(25, "POSSIBLE\n5 2 3 4 1\n1 5 2 3 4\n4 1 5 2 3\n3 4 1 5 2\n2 3 4 1 5");
		Dictionary check = new Hashtable();
		check.put(2, two);
		check.put(3, three);
		check.put(4, four);
		check.put(5, five);
		for(int t = 0; t < N; t++) {
			StringTokenizer st = new StringTokenizer(cin.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			String s = (String) ((Dictionary)check.get(n)).get(k);
			if(s == null)
				System.out.println("IMPOSSIBLE");
			else
				System.out.println(s);
		}
	}
}