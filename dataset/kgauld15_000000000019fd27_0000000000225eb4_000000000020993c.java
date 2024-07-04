import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String [] args) throws IOException{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(cin.readLine());
		int[][] results = new int[N][3];
		for(int[] res: results) {
			int S = Integer.parseInt(cin.readLine());
			int[][] mat = new int[S][S];
			for(int i = 0; i < S; i++) {
				StringTokenizer st = new StringTokenizer(cin.readLine());
				Dictionary row = new Hashtable();
				boolean counted = false;
				for(int k = 0; k < S; k++) {
					int v = Integer.parseInt(st.nextToken());
					if(row.get(v) == null)
						row.put(v,v);
					else
						if(!counted) {
							res[1]++;
							counted = true;
						}
					mat[i][k] = v;
				}
			}
			for(int i =0; i <S; i++)
				res[0] += mat[i][i];
			for(int i = 0; i < S; i++) {
				Dictionary col = new Hashtable();
				boolean counted = false;
				for(int k = 0; k<S; k++) {
					int v = mat[k][i];
					if(col.get(v) == null)
						col.put(v,v);
					else
						if(!counted) {
							res[2]++;
							counted = true;
						}
				}
			}
		}
		for(int i = 0; i < results.length; i++)
			System.out.println("Case #" + (i+1)+ ": " + results[i][0] + " " + results[i][1] + " " + results[i][2]);
	}
}