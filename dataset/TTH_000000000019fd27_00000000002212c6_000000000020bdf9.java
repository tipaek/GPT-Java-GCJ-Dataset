import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int id=0; id<t; id++) {
			StringBuilder temp = new StringBuilder();
			int len = Integer.parseInt(br.readLine());
			int[][] table = new int[len][4];
			for(int i=0; i<len; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				table[i][0] = start;
				table[i][1] = end;
				table[i][2] = i;
				table[i][3] = 0;
			}
			
			Arrays.sort(table, (a,b) -> a[0] - b[0] );
			
			int Jend = 0;
			int Cend = 0;
			boolean failed = true;
			for(int i=0; i<len; i++) {
				int start = table[i][0];
				int end = table[i][1];
				//System.out.println(start+" "+end);
				if (Jend<=start) {
					Jend = end;
					table[i][3] = 'J';
				}
				else if (Cend<=start) {
					Cend = end;
					table[i][3] = 'C';
				}
				else {
					failed = false;
					break;
				}
			}
			
			Arrays.sort(table, (a,b) -> a[2] - b[2] );
			if (failed) {
				for(int i=0; i<len; i++) {
					temp.append((char)table[i][3]);
				}
			}
			else {
				temp.append("IMPOSSIBLE");
			}
			
			sb.append("Case #"+(id+1)+": "+temp.toString()+"\n");
		}
		System.out.print(sb.toString());
	}

}
