import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 0; i < t; i++){
			String ret = "";
			boolean[] ctime = new boolean[1440];
			boolean[] jtime = new boolean[1440];
			int[] timeline = new int[1440];
			int n = in.nextInt();
			int[] start = new int[n];
			int[] end = new int[n];
			for(int j = 0; j < n; j++){
				start[j] = in.nextInt();
				end[j] = in.nextInt();
				
			}
			for(int j = 0; j < n; j++){
				for(int k = start[j]; k < end[j]; k++){
					timeline[k]++;
					if(timeline[k] >= 3){
						ret = "IMPOSSIBLE";
						break;
					}
				}
			}
			
			//System.out.println(timeline[100]);
			boolean trip = false;
			if(!ret.equals("IMPOSSIBLE")){
				for(int j = 0; j < n; j++){
					for(int k = start[j]; k < end[j]; k++){
						if(ctime[k]){
							for(int l = start[j]; l < end[j]; l++){
								jtime[l] = true;
							}
							ret += "J";
							trip = true;
							break;
						}
					}
					if(trip == false){
						for(int k = start[j]; k < end[j]; k++){
							ctime[k] = true;
						}
						ret += "C";
					}
					trip = false;
				}
			}
			System.out.printf("Case #%d: %s\n",i+1,ret);
		}
	}

}
