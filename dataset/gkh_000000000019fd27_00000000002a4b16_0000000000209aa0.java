import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		
		for(int x = 1; x <= t; ++x) {
			int n = in.nextInt();
			int k = in.nextInt();

			String output = "";
			if(n!=2 && k!=(n*(1+n)/2) || k%n>n){
				output = "IMPOSSIBLE";
				System.out.println("Case #"+x+": "+output);
			} else {
				if(n==2){
					output = "IMPOSSIBLE";
					System.out.println("Case #"+x+": "+output);
				} else {
					output = "POSSIBLE";
					System.out.println("Case #"+x+": "+output);

					int[][] m = new int[n][n];
					String str = new String("");
					for(int i=1; i<=n; i++){
						str += i;
					}
					for(int i=0; i<n; i++){
						for(int j=0; j<n; j ++){
							m[i][j] = Integer.parseInt(str.charAt(j)+"");
						}
						str = str.substring(1)+str.substring(0, 1);
					}
					for(int i=0; i<n; i++){
						for(int j=0; j<n; j ++){
							System.out.print(m[i][j]+" ");
						}
						System.out.println();
					}
				}
			}
		}
		
		in.close();
	}


}