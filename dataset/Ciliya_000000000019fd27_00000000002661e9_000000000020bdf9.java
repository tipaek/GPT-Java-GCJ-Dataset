import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		int T, N, i, j;
		Scanner br = new Scanner(System.in);
		T = br.nextInt();
		StringBuffer output = new StringBuffer();
		for (int k = 1; k <= T; k++) {
			output.delete(0, output.length());
		
			N = br.nextInt();
			int arr[][] = new int[N][2];
		
			List<Integer> c = new ArrayList<Integer>();
			List<Integer> ja = new ArrayList<Integer>();
			for (i = 0; i < N; i++) {
				for (j = 0; j < 2; j++) {
					arr[i][j] = br.nextInt();					
				}	
				if(i==0){
					c.add(arr[i][0]);
					c.add(arr[i][1]);
					output.append("C");
				}
				else if(c.get(0)>= arr[i][1] || c.get(c.size()-1)<= arr[i][0] ){
					c.add(arr[i][0]);
					c.add(arr[i][1]);
					Collections.sort(c);
					output.append("C");
				}else if(ja.size() == 0 || ja.get(0)>= arr[i][1] || ja.get(ja.size()-1)<= arr[i][0]){
					ja.add(arr[i][0]);
					ja.add(arr[i][1]);
					Collections.sort(ja);
					output.append("J");
				}else if(c.get(0)<= arr[i][0] || c.get(c.size()-1)>= arr[i][1]){
					for (int p = 0; p < c.size() - 1; p++) {
			            if(arr[i][0] >= c.get(p) && arr[i][1]<=c.get(p + 1)){
			            	c.add(arr[i][0]);
							c.add(arr[i][1]);
							Collections.sort(c);
							output.append("C");
							break;
			            }
			        }
				}else if(ja.get(0)<= arr[i][0] || ja.get(ja.size()-1)>= arr[i][1]){
					for (int p = 0; p < ja.size() - 1; p++) {
			            if(arr[i][0] >= ja.get(p) && arr[i][1]<=ja.get(p + 1)){
			            	ja.add(arr[i][0]);
							ja.add(arr[i][1]);
							Collections.sort(ja);
							output.append("J");
							break;
			            }
			        }
				}
			}
			if(output.length() != N){
				output.delete(0, output.length());
				output.append("IMPOSSIBLE");
			}
			System.out.println("Case #" + k + ": " + output);
		}
		
	}

}
