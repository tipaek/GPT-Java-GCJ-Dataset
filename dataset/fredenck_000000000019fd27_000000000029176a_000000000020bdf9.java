
import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0; i<T; i++){
			int N = Integer.parseInt(br.readLine());
			int[][] times = new int[N][3];
			boolean f = true;
			
			for (int j=0; j<N; j++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int t1 = Integer.parseInt(st.nextToken());
				int t2 = Integer.parseInt(st.nextToken());
				times[j][0] = t1;
				times[j][1] = t2;
				times[j][2] = j;//ith activity
			}
			//sort
			Arrays.sort(times, new Comparator<int[]>() {
			   	@Override  
				public int compare(int[] o1, int[] o2) {
				    return (o1[0]+o1[1])-(o2[0]+o2[1]);
				}
			});
			
			//assume all J
			String sol = "";
			for (int c=0; c<N; c++){
				sol += "J";
			}
			
			//overlap, replace J with C
			//triple overlap impossible
			for (int a=0; a<N; a++){
				int o = 0;
				for (int b=a+1; b<N; b++){
					if (times[a][1]>times[b][0]){
						o++;
						sol = sol.substring(0,b) + "C" + sol.substring(b+1);
					}
				}
				if (o>=2){//if overlap twice then 2 people is impossible
					System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
					f = false;
					break;
				}
			}
			
			if (f){//possible
				//order back
				
				
				System.out.println("Case #" + (i+1) + ": " + sol);	
			}
			
			
			
			
		}
		
		
		
//		out.close();
		br.close();
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " ns");
	}

}
