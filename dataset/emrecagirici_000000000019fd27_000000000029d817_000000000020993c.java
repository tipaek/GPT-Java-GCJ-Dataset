import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int totalCase = scan.nextInt();
		for(int i=0; i<totalCase; i++) {
			System.out.print("Case #" + (i+1) + ": ");
			int nsize = scan.nextInt();
			int[][] numbers = new int[nsize][nsize];
			int diagonalSum = 0;
			int repeatRow = 0;
			int repeatCol = 0;
			for(int j=0; j<nsize; j++) {
				for(int k=0; k<nsize; k++) {
					numbers[j][k] = scan.nextInt();
				}
			}
			
			for(int j=0; j<nsize; j++) {
				diagonalSum += numbers[j][j];
			}
			
			for(int j=0; j<nsize; j++) {
				Set<Integer> row = new HashSet<Integer>();
				boolean checkRow = false;
				for(int k=0; k<nsize; k++) {
					if(row.contains(numbers[j][k])) {
						checkRow = true;
					}
					else {
						row.add(numbers[j][k]);
					}
				}
				
				if(checkRow) {
					repeatRow++;
				}
			}
			
			for(int j=0; j<nsize; j++) {
				Set<Integer> row = new HashSet<Integer>();
				boolean checkRow = false;
				for(int k=0; k<nsize; k++) {
					if(row.contains(numbers[k][j])) {
						checkRow = true;
					}
					else {
						row.add(numbers[k][j]);
					}
				}
				
				if(checkRow) {
					repeatCol++;
				}
			}
			
			System.out.println(diagonalSum + " " + repeatRow + " " + repeatCol);
		}
	}
}
