import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Solution{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		int keis = Integer.valueOf(br.readLine().trim());
		for(int kei = 0; kei < keis; kei++){
			int N = Integer.valueOf(br.readLine().trim());
			
			int trace = 0;
			
			HS[] rows = new HS[N];
			HS[] cols = new HS[N];
			
			int repRows = 0;
			int repCols = 0;
			
			for(int i = 0; i < N; i++){
				rows[i] = new HS();
				cols[i] = new HS();
			}
			
			for(int i = 0; i < N; i++){
			
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				
				
				
				
				for(int j = 0; j < N; j++){
					int x = Integer.valueOf(st.nextToken());
					if(i == j) {
						trace += x;
					}
					
					rows[i].add(x);
					cols[j].add(x);
				}
				
				if(rows[i].size() != N) repRows++;
				
			}
			for(int i = 0; i < N; i++){
				if(cols[i].size() != N) repCols++;
			}
			
			out.println("Case #"+(kei+1)+": "+trace+" "+repRows+" "+repCols);
		}
	}
	public static class HS extends HashSet<Integer>{}
}