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
			int[][] table = new int[len][2];
			for(int i=0; i<len; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				table[i][0] = start;
				table[i][1] = end;
			}
			
			Arrays.sort(table, (a,b) -> a[0] - b[0] );
			
			int Jend = 0;
			int Cend = 0;
			for(int i=0; i<len; i++) {
				int start = table[i][0];
				int end = table[i][1];
				//System.out.println(start+" "+end);
				if (Jend<=start) {
					Jend = end;
					temp.append('J');
				}
				else if (Cend<=start) {
					Cend = end;
					temp.append('C');
				}
				else {
					temp =  new StringBuilder();
					temp.append("IMPOSSIBLE");
					break;
				}
			}
			
		sb.append("Case #"+(id+1)+": "+temp+"\n");
		}
		System.out.print(sb.toString());
	}

}
