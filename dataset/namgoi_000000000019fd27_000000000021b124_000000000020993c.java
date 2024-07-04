import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int testcase = 1; testcase <=T; testcase++) {
			int answer1=0;
			int answer2=0;
			int answer3=0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] M = new int[N][N];
			boolean[] row = new boolean[N];
			boolean[] col = new boolean[N];
			HashMap<Integer, Integer>[] hmcol= new HashMap[N];  
			for (int x = 0; x < N; x++) {
				hmcol[x] = new HashMap<Integer, Integer>(); 
			}
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				HashMap<Integer, Integer> hmrow = new HashMap<Integer, Integer>();
				for (int x = 0; x < N; x++) {
					Integer value = Integer.parseInt(st.nextToken()); 
					M[y][x]=value;
					if(row[y]==false && hmrow.containsKey(value)) {
						row[y]=true;
						answer2++;
					}else {
						hmrow.put(value,1);
					}
					if(col[x]==false && hmcol[x].containsKey(value)) {
						col[x]=true;
						answer3++;
					}else {
						hmcol[x].put(value,1);
					}
					if(y==x) answer1+=value;
				}
			}
			System.out.println("Case #"+testcase+": "+answer1+" "+answer2+" "+answer3 );
		}
	}
}