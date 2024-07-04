import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		
		for (int i=0;i<cases;i++){
			int rC = scanner.nextInt();
			int rD=0;
			int cD=0;
			int diagSum=0;
			int mat[][] = new int[rC][rC];
			for(int j=0;j<rC;j++){
				for(int k=0;k<rC;k++) {
					mat[j][k] = scanner.nextInt();
//					System.out.print(mat[j][k]+" ");
				}
//				System.out.println();
			}
			
			//diag sum
			for(int j=0;j<rC;j++){
				diagSum+=mat[j][j];
			}
			
			//row dups
			for(int j=0;j<rC;j++){
				Set<Integer> s = new HashSet<>();
				for(int k=0;k<rC;k++){
					s.add(mat[j][k]);
				}
				if (s.size()!=rC) {
					rD++;
				}
			}
			
			//col dups
			for(int j=0;j<rC;j++){
				Set<Integer> s = new HashSet<>();
				for(int k=0;k<rC;k++){
					s.add(mat[k][j]);
				}
				if (s.size()!=rC) {
					cD++;
				}
			}
			
			
			System.out.println("Case #"+(i+1)+": "+diagSum+" "+rD+" "+cD);
			
		}
		scanner.close();

	}

}
