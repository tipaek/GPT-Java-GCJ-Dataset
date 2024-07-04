import java.util.*;
import java.io.*;
public class Solution {
	public static void main (String []args)throws IOException{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(cin.readLine());
		Dictionary two = new Hashtable();
		two.put(2, "POSSIBLE\n1 2\n2 1");
		two.put(3, "IMPOSSIBLE");//confirmed
		two.put(4, "POSSIBLE\n2 1\n1 2");
		Dictionary three = new Hashtable();
		three.put(3, "POSSIBLE\n1 2 3\n3 1 2\n2 3 1");
		three.put(4, "IMPOSSIBLE");//confirmed
		three.put(5, "IMPOSSIBLE");//confirmed
		three.put(6, "POSSIBLE\n2 1 3\n3 2 1\n1 3 2");
		three.put(7, "IMPOSSIBLE");//confirmed
		three.put(8, "IMPOSSIBLE");//confirmed
		three.put(9, "POSSIBLE\n3 1 2\n2 3 1\n1 2 3");
		Dictionary four = new Hashtable();
		four.put(4, "POSSIBLE\n1 3 2 4\n4 1 3 2\n2 4 1 3\n3 2 4 1");
		four.put(5, "IMPOSSIBLE");//confirmed
		four.put(6, "POSSIBLE\n1 3 4 2\n3 2 1 4\n4 1 2 3\n2 4 3 1");
		four.put(7, "POSSIBLE\n1 4 3 2\n2 3 1 4\n4 1 2 3\n3 2 4 1");
		four.put(8, "POSSIBLE\n2 3 1 4\n4 2 3 1\n1 4 2 3\n3 1 4 2");
		four.put(9, "POSSIBLE\n1 3 4 2\n3 2 1 4\n2 4 3 1\n4 1 2 3");
		four.put(10, "POSSIBLE\n1 4 2 3\n3 2 4 1\n4 1 3 2\n2 3 1 4");
		four.put(11, "POSSIBLE\n4 3 1 2\n2 1 4 3\n3 4 2 1\n1 2 3 4");
		four.put(12, "POSSIBLE\n3 1 2 4\n4 3 1 2\n2 4 3 1\n1 2 4 3");
		four.put(13, "POSSIBLE\n4 1 3 2\n2 3 4 1\n1 4 2 3\n3 2 1 4");
		four.put(14, "POSSIBLE\n4 2 1 3\n2 3 4 1\n1 4 3 2\n3 1 2 4");
		four.put(15, "IMPOSSIBLE");//confirmed
		four.put(16, "POSSIBLE\n4 3 2 1\n1 4 3 2\n2 1 4 3\n3 2 1 4");
		Dictionary five = new Hashtable();
		five.put(5,  "POSSIBLE\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1");
		five.put(6,  "IMPOSSIBLE");//confirmed
		five.put(7,  "IMPOSSIBLE");
		five.put(8,  "POSSIBLE\n1 5 4 3 2\n2 3 5 1 4\n5 2 1 4 3\n4 1 3 2 5\n3 4 2 5 1");
		five.put(9,  "POSSIBLE\n1 3 5 4 2\n2 4 3 1 5\n3 2 1 5 4\n5 1 4 2 3\n4 5 2 3 1");
		five.put(10, "POSSIBLE\n2 1 3 4 5\n5 2 1 3 4\n4 5 2 1 3\n3 4 5 2 1\n1 3 4 5 2");
		five.put(11, "POSSIBLE\n1 2 4 5 3\n3 5 2 1 4\n2 3 1 4 5\n4 1 5 3 2\n5 4 3 2 1");
		five.put(12, "POSSIBLE\n1 3 2 4 5\n2 5 1 3 4\n5 4 3 1 2\n4 1 5 2 3\n3 2 4 5 1");
		five.put(13, "POSSIBLE\n2 3 1 4 5\n1 5 2 3 4\n5 4 3 2 1\n4 2 5 1 3\n3 1 4 5 2");
		five.put(14, "POSSIBLE\n2 4 1 3 5\n1 5 2 4 3\n5 3 4 2 1\n3 2 5 1 4\n4 1 3 5 2");
		five.put(15, "POSSIBLE\n3 2 1 4 5\n5 3 2 1 4\n4 5 3 2 1\n1 4 5 3 2\n2 1 4 5 3");
		five.put(16, "POSSIBLE\n5 3 2 4 1\n2 1 5 3 4\n1 4 3 5 2\n4 5 1 2 3\n3 2 4 1 5");
		five.put(17, "POSSIBLE\n5 4 2 3 1\n2 1 5 4 3\n1 3 4 5 2\n3 5 1 2 4\n4 2 3 1 5");
		five.put(18, "POSSIBLE\n4 5 2 1 3\n2 3 4 5 1\n3 1 5 4 2\n1 4 3 2 5\n5 2 1 3 4");
		five.put(19, "POSSIBLE\n5 4 2 1 3\n2 3 5 4 1\n3 1 4 5 2\n1 5 3 2 4\n4 2 1 3 5");
		five.put(20, "POSSIBLE\n4 2 3 1 5\n5 4 2 3 1\n1 5 4 2 3\n3 1 5 4 2\n2 3 1 5 4");
		five.put(21, "POSSIBLE\n5 1 3 4 2\n2 4 1 5 3\n1 2 5 3 4\n3 5 4 2 1\n4 3 2 1 5");
		five.put(22, "POSSIBLE\n5 1 2 4 3\n3 4 1 5 2\n1 3 5 2 4\n2 5 4 3 1\n4 2 3 1 5");
		five.put(23, "IMPOSSIBLE");
		five.put(24, "IMPOSSIBLE");//confirmed
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