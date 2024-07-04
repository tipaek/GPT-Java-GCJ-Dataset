import java.util.*;
import java.io.*;

class Solution{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int numCases = 1; numCases <= t; numCases++){
			int n = Integer.parseInt(br.readLine());
			int[][] m = new int[n][n];

			for(int i = 0; i < n; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++){
					m[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int trace = 0;
			for(int i = 0; i < n; i++){
				trace += m[i][i];
			}

			int rowCount = 0;
			int colCount = 0;
			for(int i = 0; i < n; i++){
				HashSet<Integer> row = new HashSet<Integer>();
				HashSet<Integer> col = new HashSet<Integer>();
				boolean validCol = true;
				boolean validRow = true;

				for(int j = 0; j < n; j++){
					if(row.contains(m[i][j]))
						validRow = false;
					row.add(m[i][j]);

					if(col.contains(m[j][i]))
						validCol = false;
					col.add(m[j][i]);
				}

				if(!validRow)
					rowCount++;
				if(!validCol)
					colCount++;

			}

			System.out.printf("Case #%d: %d %d %d\n",numCases, trace, rowCount, colCount);
		}

		
		br.close();
	}

}