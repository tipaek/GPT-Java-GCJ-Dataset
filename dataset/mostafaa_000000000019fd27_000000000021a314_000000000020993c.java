import java.io.*;
import java.util.*;


public class Solution {

	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for(int t = 0; t < T; t++){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			HashMap<Integer, HashMap<Integer, Boolean>> rows = 
				new HashMap<Integer, HashMap<Integer, Boolean>>(N);
			HashMap<Integer, HashMap<Integer, Boolean>> columns = 
				new HashMap<Integer, HashMap<Integer, Boolean>>(N);
			int[] rc = new int[N];
			int[] rr = new int[N];
			int trace = 0;
			
			for(int r = 0; r < N; r++){
				st = new StringTokenizer(br.readLine());
				int m;
				for(int c = 0; c < N; c++){
					m = Integer.parseInt(st.nextToken()); 
					if((rows.get(r) != null) && (rows.get(r).get(m) != null))
						rr[r] += 1;
					else{
						if(rows.get(r) == null){
							HashMap<Integer, Boolean> tmp = new HashMap<Integer, Boolean>(N);
							tmp.put(m, true);
							rows.put(r, tmp);
						}
						else{
							HashMap<Integer, Boolean> tmp = rows.get(r);
							tmp.put(m, true);
							rows.put(r, tmp);
						}
					}
					if((columns.get(c) != null) && (columns.get(c).get(m) != null))
						rc[c] += 1;
					else{
						if(columns.get(c) == null){
							HashMap<Integer, Boolean> tmp = new HashMap<Integer, Boolean>(N);
							tmp.put(m, true);
							columns.put(c, tmp);
						}
						else{
							HashMap<Integer, Boolean> tmp = columns.get(c);
							tmp.put(m, true);
							columns.put(c, tmp);
						}
					}
					if(r == c)
						trace += m;
				}
			}
			int r = N;
			int rowCount=0;
			int columnCount=0;
			while(r-->0){
				if(rr[r] != 0)
					rowCount++;
				if(rc[r] != 0)
					columnCount++;
			}
			if(t==T-1)
			pw.print(String.format("Case #%d: %d %d %d", t+1, trace, rowCount, columnCount));
			else
			pw.println(String.format("Case #%d: %d %d %d", t+1, trace, rowCount, columnCount));

		}
		

		pw.flush();
		pw.close();
	}
	
}