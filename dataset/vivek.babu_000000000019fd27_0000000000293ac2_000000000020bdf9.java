import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		int tcase = 1;
		while(t-- > 0) {
			int n = Integer.valueOf(br.readLine());
			int[] allocationCam = new int[1440];
			int[] allocationJam = new int[1440];
			Arrays.fill(allocationCam, 0);
			Arrays.fill(allocationJam, 0);
			StringBuilder out = new StringBuilder();
			int start,end,j;
			for(int i=0; i<n; i++) {
				boolean assignToJam = false, assignFail = false;
				String[] s = br.readLine().split(" ");
				start = Integer.valueOf(s[0]);
				end = Integer.valueOf(s[1]);
				for(j = start; j<end; j++) {
					if(allocationCam[j]==1) {
						assignToJam = true;
						break;
					}
				}
				if(assignToJam) {
					for(j = start; j<end; j++) {
						if(allocationJam[j]==1) {
							assignFail = true;
							break;
						}
					}
					if(assignFail){
						out = new StringBuilder();
						out.append("IMPOSSIBLE");
						break;
					}else {
						out.append("J");
						for(j = start; j<end; j++) {
							allocationJam[j]=1;
						}
					}
				}else {
					out.append("C");
					for(j = start; j<end; j++) {
						allocationCam[j]=1;
					}
				}
			}
			System.out.println("Case #"+tcase+": "+out.toString());
			tcase++;
		}
	}
}
