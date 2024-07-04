
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

	public static void main( String[] argv ) throws Exception {
		InputStream inputStream = System.in;
		String response = doJob(inputStream);
		System.out.print(response);
	}

	public static String doJob(InputStream inputStream) {
		Scanner sc = new Scanner(inputStream);
		StringBuilder solution = new StringBuilder();
		int testCaseNumber = Integer.valueOf(sc.nextLine());
		for(int i = 0; i< testCaseNumber; i++) {
			int matrixSize = Integer.valueOf(sc.nextLine());
			int[][] matrice = new int[matrixSize][matrixSize];
			for (int j = 0; j< matrixSize; j++){
    			for (int k = 0; k< matrixSize; k++){
    			    matrice[j][k] = sc.nextInt();
    			}
    			sc.nextLine();
			}
			String result = solve(matrice);
			solution.append("Case #"+i+": "+result+"\n");
		}
		
		return solution.toString();
	}

	private static String solve(int[][] matrice) {
        int size = matrice.length;
        int k = 0;
        int r = 0;
        int c = 0;
		for (int j = 0; j< size; j++){
		    k += matrice[j][j];
		}
		for (int j = 0; j< size; j++){
    		if(Arrays.stream(matrice[j]).distinct().toArray().length != size) {
    			r++;
    		}
		}
		for (int j = 0; j< size; j++){
			Set<Integer> set = new HashSet<>();
			for (int l = 0; l < size; l++){
				set.add(matrice[j][l]);
			}
			if( set.size() != size) {
				c++;
			}
		}
		return k+" "+r+" "+c;
	}
}