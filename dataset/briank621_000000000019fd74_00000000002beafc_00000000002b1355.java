import java.util.*;
import java.io.*;

class Solution{

	static int n, m;

	public static long sum(int[][] x){
		long sum = 0;
		for(int i = 0; i < n; i++){
		 	for(int j = 0; j < m; j++){
		 		sum += x[i][j];
		 	}
		 } 
		 return sum;
	}

	public static void print(int[][] a){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println("");
		}
		System.out.println("");
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int numCases = 1; numCases <= t; numCases++){
			String[] rc = br.readLine().split(" ");
			n = Integer.parseInt(rc[0]);
			m = Integer.parseInt(rc[1]);

			int[][] x = new int[n][m];
			for(int i = 0; i < n; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++){
					x[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			long sum = sum(x);
			while(true){
				// print(x);
				boolean changed = false;
				int[][] xcopy = new int[n][m];
				for(int i = 0; i < n; i++){
					xcopy[i] = Arrays.copyOf(x[i], m);
				}
				// print(xcopy);
				for(int i = 0; i < n; i++){
					ArrayList<List<Integer>> row = new ArrayList<List<Integer>>();
					for(int j = 0; j < m; j++){
						if(x[i][j] != 0){
							row.add(Arrays.asList(x[i][j], j));
						}
					}
					// System.out.println("row: " + row);
					for(int j = 1; j < row.size() - 1; j++){
						if(row.get(j).get(0) < row.get(j - 1).get(0) && row.get(j).get(0) < row.get(j + 1).get(0)){
							// System.out.println("changed1");
							changed = true;
							xcopy[i][row.get(j).get(1)] = 0;
						}
					}
					if(row.size() > 1){
						if(row.get(0).get(0) < row.get(1).get(0)){
							changed = true;
							xcopy[i][row.get(0).get(1)] = 0;
						}
						if(row.get(row.size() - 1).get(0) < row.get(row.size() - 2).get(0)){
							changed = true;
							xcopy[i][row.get(row.size() - 1).get(1)] = 0;
						}
					}
				}
				for(int i = 0; i < m; i++){
					ArrayList<List<Integer>> col = new ArrayList<List<Integer>>();
					for(int j = 0; j < n; j++){
						if(x[j][i] != 0){
							col.add(Arrays.asList(x[j][i], j));
						}
					}
					// System.out.println("col: " + col);
					for(int j = 1; j < col.size() - 1; j++){
						if(col.get(j).get(0) < col.get(j - 1).get(0) && col.get(j).get(0) < col.get(j + 1).get(0)){
							// System.out.println("changed2");
							changed = true;
							xcopy[col.get(j).get(1)][i] = 0;
						}
					}
					if(col.size() > 1){
						if(col.get(0).get(0) < col.get(1).get(0)){
							changed = true;
							xcopy[col.get(0).get(1)][i] = 0;
						}
						if(col.get(col.size() - 1).get(0) < col.get(col.size() - 2).get(0)){
							changed = true;
							xcopy[col.get(col.size() - 1).get(1)][i] = 0;
						}
					}
				}

				if(!changed)
					break;
				// System.out.println("sum(x): " + sum(x));
				sum += sum(xcopy);
				x = xcopy;

			}


			System.out.printf("Case #%d: %d\n", numCases, sum);
		}


		
		br.close();
	}

}