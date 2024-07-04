
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
			int mint = Integer.MAX_VALUE;
			int maxt = Integer.MIN_VALUE;
			
			for (int j=0; j<N; j++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int t1 = Integer.parseInt(st.nextToken());
				int t2 = Integer.parseInt(st.nextToken());
				times[j][0] = t1;
				times[j][1] = t2;
				times[j][2] = j;//ith activity
				if (t1<mint){
					mint = t1;
				}
				if (t2>maxt){
					maxt = t2;
				}
			}
			//sort
			Arrays.sort(times, new Comparator<int[]>() {
			   	@Override  
				public int compare(int[] o1, int[] o2) {
			   		if (o1[0]==o2[0]){
			   			return o1[1]-o2[1];
			   		}
				    return (o1[0]-o2[0]);
				}
			});
			
			//assume all J
			String sol = "";
			for (int c=0; c<N; c++){
				sol += "C";
			}
			
			//overlap, replace J with C
			for (int a=0; a<N; a++){
				for (int b=a+1; b<N; b++){
					if (times[a][1]>times[b][0] && sol.charAt(a)==sol.charAt(b)){
						sol = sol.substring(0,b) + "J" + sol.substring(b+1);
					}
				}
				

				
			}
			
			//triple overlap impossible
			for (double w=mint-0.5; w<maxt+0.5; w++){//go through every time and see if 3 overlap
				int o=0;
				for (int e=0; e<N; e++){
					if (times[e][0]<w && w<times[e][1]){
						o++;
					}
				}
				if (o>2){//if overlap twice then 2 people is impossible
					System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
					f = false;
					break;
				}
			}
			
			if (f){//possible
				//order back
		        char temp[] = new char[sol.length()]; 
		        
		        for (int q=0; q<sol.length(); q++) 
		            temp[times[q][2]] = sol.charAt(q); 
		        sol = String.valueOf(temp);
				
				System.out.println("Case #" + (i+1) + ": " + sol);	
			}
			
			
			
			
		}
		
		
		
//		out.close();
		br.close();
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " ns");
	}

}
