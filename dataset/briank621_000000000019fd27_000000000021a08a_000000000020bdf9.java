import java.util.*;
import java.io.*;

class Solution{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int numCases = 1; numCases <= t; numCases++){
			int n = Integer.parseInt(br.readLine());
			int[] times = new int[2441];
			int[] assign = new int[n + 1];
			System.out.println("n: " + n);

			boolean valid = true;

			outer:
			for(int i = 1; i <= n; i++){
				String[] l = br.readLine().split(" ");
				int start = Integer.parseInt(l[0]);
				int end = Integer.parseInt(l[1]);

				for(int j = start; j < end; j++){
					if(times[j] == -1){
						valid = false;
						// System.out.println("j: " + j);
					}
					else if(times[j] != 0){
						if(assign[times[j]] == 0)
							assign[i] = 1;
						else
							assign[i] = 0;
						times[j] = -1;
					}
					else{
						times[j] = i;
					}
				}

			}

			if(! valid){
				System.out.printf("Case #%d: IMPOSSIBLE\n", numCases);
			}
			else{
				StringBuilder sb = new StringBuilder();
				for(int i = 1; i <= n; i++){
					if(assign[i] == 0)
						sb.append("C");
					else
						sb.append("J");
				}
				System.out.printf("Case #%d: %s\n", numCases, sb.toString());
			}
		}

		
		br.close();
	}

}