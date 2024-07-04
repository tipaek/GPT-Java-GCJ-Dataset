import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		int T = Integer.parseInt(scanner.nextLine());
		
		for(int i = 1; i<=T; i++){
			
			int t = 0, c = 0, r = 0;
			int N = Integer.parseInt(scanner.nextLine());
			int[][] A = new int[N][N];
			
			for(int j = 0; j<N; j++){
				ArrayList<Integer> thisRow = new ArrayList<Integer>();
				StringTokenizer st = new StringTokenizer(scanner.nextLine());
				boolean isLatin = true;
				
				for(int k=0; k<N; k++){
					A[j][k] = Integer.parseInt(st.nextToken());
					if(thisRow.contains(A[j][k])){
						isLatin = false;
					}
					else{
						thisRow.add(A[j][k]);
					}
				}
				if(!isLatin){
					r++;
				}
				
				t += A[j][j];
			}
			
			for(int j = 0; j<N; j++){
				ArrayList<Integer> thisColumn = new ArrayList<Integer>();
				boolean isLatin = true;
				for(int k = 0; k<N; k++){
					if(thisColumn.contains(A[k][j])){
						isLatin = false;
					}
					else{
						thisColumn.add(A[k][j]);
					}
				}
				if(!isLatin){
					c++;
				}
			}
			
			System.out.println("Case #" + i + ": " + t + " " + r + " " + c);
			
		}
	}
}
