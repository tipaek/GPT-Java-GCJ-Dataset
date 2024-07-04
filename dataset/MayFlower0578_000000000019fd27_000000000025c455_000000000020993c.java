import java.util.Scanner;
import java.util.Arrays;   
                 
public class Solution{
     public static void main(String[] args) {		 
     Scanner in = new Scanner(System.in);
     int T = in.nextInt();
     for(int cas = 1; cas <= T; cas++){
		 int n = in.nextInt();
		 int[][] m = new int[n][n];
		 int k = 0, c = 0, r = 0;
		 for(int i = 0; i < n; i++){
			 for(int j = 0; j < n; j++)
				 m[i][j] = in.nextInt();
			 k += m[i][i];				 
		 }
		 
		 boolean[] occur = new boolean[n+1];
		 for(int i = 0; i < n; i++){
			 Arrays.fill(occur, false);
			 for(int j = 0; j < n; j++){
				 if(occur[m[i][j]]){
					 r++;
					 break;
				 }
				 else
					 occur[m[i][j]] = true;
			 }
		 }
		 
		 for(int i = 0; i < n; i++){
			 Arrays.fill(occur, false);
			 for(int j = 0; j < n; j++){
				 if(occur[m[j][i]]){
					 c++;
					 break;
				 }
				 else
					 occur[m[j][i]] = true;
			 }
		 }
 
		System.out.println("Case #"+cas+": "+k+" "+r+" "+c);
	 }
	 }
}
	 
	 