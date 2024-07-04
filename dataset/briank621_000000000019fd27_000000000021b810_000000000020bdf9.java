import java.util.*;
import java.io.*;

class Solution{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for(int numCases = 1; numCases <= tc; numCases++){
			int n = Integer.parseInt(br.readLine());
			int[] times = new int[1441];

			boolean valid = true;
			ArrayList<List<Integer>> t = new ArrayList<List<Integer>>();

			for(int i = 1; i <= n; i++){
				String[] l = br.readLine().split(" ");
				int start = Integer.parseInt(l[0]);
				int end = Integer.parseInt(l[1]);

				for(int j = start; j < end; j++)
					times[j]++;

				t.add(Arrays.asList(start, end));
			}

			for(int i = 0; i < times.length; i++){
				if(times[i] > 2)
					valid = false;
			}

			int[] assign = new int[n];
			for(int i = 0; i < n; i++){
				int p = 0;
				int s1 = t.get(i).get(0);
				int e1 = t.get(i).get(1);
				for(int j = i - 1; j >= 0; j--){
					int s2 = t.get(j).get(0);
					int e2 = t.get(j).get(1);
					if(! (s1 >= e2 || s2 >= e1)){
						if(assign[j] == 0)
							p = 1;
						else
							p = 0;
					}
				}
				assign[i] = p;
			}


			if(! valid){
				System.out.printf("Case #%d: IMPOSSIBLE\n", numCases);
			}
			else{
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < n; i++){
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