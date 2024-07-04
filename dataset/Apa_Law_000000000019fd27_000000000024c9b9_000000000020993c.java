import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer pruebas = Integer.parseInt(sc.nextLine());
		for(int i=0;i<pruebas;i++) {
			Integer matrixSize = Integer.parseInt(sc.nextLine());
			int[][] matrix = new int[matrixSize][matrixSize];
			for(int i2=0;i2<matrixSize;i2++) {
				String[] saux = sc.nextLine().split(" ");
				for(int i3=0;i3<matrixSize;i3++) {
					matrix[i3][i2] = Integer.parseInt(saux[i3]);
				}
			}
			
			Integer repetidoscolumnas = 0;
			for(int c=0;c<matrixSize;c++) {
				Set<Integer> lc = new HashSet<>();
				for(int f=0;f<matrixSize;f++) {
					if(lc.contains(matrix[c][f])) {
						repetidoscolumnas = repetidoscolumnas + 1;
						break;
					}else {
						lc.add(matrix[c][f]);
					}
				}
			}
			
			Integer repetidosfilas = 0;
			for(int f=0;f<matrixSize;f++) {
				Set<Integer> lf = new HashSet<>();
				for(int c=0;c<matrixSize;c++) {
					if(lf.contains(matrix[c][f])) {
						repetidosfilas = repetidosfilas + 1;
						break;
					}else {
						lf.add(matrix[c][f]);
					}
				}
			}
			
			Integer diagonal = 0;
			
			for(int d=0;d<matrixSize;d++) {
				diagonal = diagonal + matrix[d][d];
			}
			
				System.out.println("Case #" + (i+1) + ": " + diagonal + " " + repetidosfilas + " " + repetidoscolumnas);
			
		}
		sc.close();

	}

}
