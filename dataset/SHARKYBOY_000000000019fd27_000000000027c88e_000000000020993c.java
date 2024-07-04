import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
 		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 		int t = Integer.parseInt(bf.readLine());
 		int[][] answers = new int[t][3];
 		for(int i = 0;i<t;i++){
 			int n = Integer.parseInt(bf.readLine());
 			int[][] array = new int[n][n];
 			int trace = 0;
 			for(int j = 0;j<n;j++){
 				StringTokenizer st = new StringTokenizer(bf.readLine());
 				for(int k = 0;k<n;k++){
 					array[j][k] = Integer.parseInt(st.nextToken());
 					if (k == j)
 						trace+= array[j][k];
 				}
 			}
 			
 			int rows = 0;
 			Set<Integer> asdf = new HashSet<Integer>();
 			for(int st = 0;st<n;st++){
 				asdf.clear();
	 			for(int l = 0;l<n;l++){
	 				if (asdf.contains(array[st][l])){
	 					rows++;
	 					break;
	 				}
	 				else{
	 					asdf.add(array[st][l]);
	 				}
	 			}
 			}
 			
 			int cols = 0;
 			Set<Integer> fdsa = new HashSet<Integer>();
 			for(int st = 0;st<n;st++){
 				fdsa.clear();
	 			for(int l = 0;l<n;l++){
	 				if (fdsa.contains(array[l][st])){
	 					cols++;
	 					break;
	 				}
	 				else{
	 					fdsa.add(array[l][st]);
	 				}
	 			}
 			}
 			
 			answers[i][0] = trace;
 			answers[i][1] = rows;
 			answers[i][2] = cols;
 			
 			
 			
 		}
 		
 		for(int i = 0;i<t;i++){
 			System.out.println("Case #"+ (i+1) + ": " + answers[i][0] + " " + answers[i][1] + " " + answers[i][2]);
 		}
 		
	}

}
