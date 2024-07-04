import java.util.*;
import java.io.*;

public class Solution {


	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int u= in.nextInt();
			char[] d = new char[10];
			boolean[] charTaken = new boolean[26];

			int[] q = new int[10001];
			String[] r = new String[10001];

			for(int j=0; j<10000; j++) {
				q[j] = in.nextInt();
				r[j] = in.nextLine().substring(1);
//				char[] temp = r.toCharArray();
//				if(q==0) {
//					d[0] = temp[0];
//				}
//				else {
//					for( int k=0; k< temp.length ; k++) {
//						d[q%10] = temp[temp.length-k-1];
//						q/=10;
//					}
//				}

//				System.out.println(q + " " + "string-"+d);

			}

			for(int k=1 ; k<10; k++) {
				for(int j=0; j<10000; j++) {
					if(q[j]==k) {
						char temp = r[j].toCharArray()[0];
						if(!charTaken[temp-'A']) {
							d[k] = temp;
							charTaken[temp-'A'] =true;
						}
					}
				}
			}

			for(int j=0; j<10000; j++) {
				if(q[j]==10 && r[j].length()==2) {
						d[0] = r[j].toCharArray()[1];
				}
			}

			System.out.print("Case #" + i + ": ");
			for(int j=0;j<10;j++)
				System.out.print(d[j]);
			System.out.println();

		}
	}


}
