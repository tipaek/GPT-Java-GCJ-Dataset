// cj 20 q1
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Solution{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		int k = tc;
		while (tc-->0){
			int n = Integer.parseInt(br.readLine());
			int sum = (n*(n+1))/2;
			int[][] input = new int[n][n];
			int[] cols = new int[n];
			int rowRep = 0;
			int colRep = 0;
			int trace = 0;
			for (int i=0; i<n; i++){
				String[] rowInp = (br.readLine()).trim().split("\\s+");
				trace += Integer.parseInt(rowInp[i]);
				for (int x=0; x<n; x++)
					input[i][x] = Integer.parseInt(rowInp[x]);
			}
			
			
			for (int i=0; i<n; i++){
				int rowSum = 0;
				for (int j=0; j<n; j++){	
					rowSum+=input[i][j];
					cols[j]+=input[i][j];
				}
				// check rows
				if (rowSum!=sum)	rowRep++;
				else{
					boolean[] el = new boolean[n];
					for (int x=0; x<n; x++){
						if (el[input[i][x]-1]==false)	el[input[i][x]-1]=true;
						else {
							rowRep++;
							break;
						}
					}
				}
			}
			for (int i=0; i<n; i++){
				if (cols[i]!=sum)	colRep++;
				else{
					boolean[] el = new boolean[n];
					for (int x=0; x<n; x++){
						if (el[input[x][i]-1]==false) el[input[x][i]-1]=true;
						else{
							colRep++;
							break;
						}
					}
				}
			}

			sb.append("Case #"+(k-tc)+": "+trace+" "+rowRep+" "+colRep+"\n");
			// System.out.println("Case #"+(k-tc)+": "+trace+" "+rowRep+" "+colRep+"\n");
		}
		System.out.print(sb);
	}
}