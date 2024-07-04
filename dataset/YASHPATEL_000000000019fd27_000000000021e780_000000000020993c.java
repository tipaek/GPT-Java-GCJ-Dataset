import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int h = 0; h < n; h++) {
			System.out.print("Case #" + (h + 1) + ": ");
			int k =sc.nextInt();
			int sum=0;
			int row=0;
			int col=0;
			int[][] mat = new int[k][k];
			for (int i = 0; i < k; i++){
				for (int j = 0; j < k; j++){
					mat[i][j] = sc.nextInt(); 
				}
			}
			for (int i = 0; i < k; i++){
				HashSet<Integer> hs = new HashSet<>();
	            HashSet<Integer> hsc = new HashSet<>();
				for (int j = 0; j < k; j++){
					if(i==j){
						sum =sum + mat[i][j];
					}
					hs.add(mat[i][j]);
	                hsc.add(mat[j][i]);
				}
				if (hs.size() <  k){ 
	                row++; 
	            	
	            }
	            if(hsc.size() < k){
	            	col++;
	            }
				
			}
			System.out.print(sum + " ");	  
			System.out.print(row + " ");
			System.out.print(col + "");
			System.out.println();
	    } 
			
		}
	}


