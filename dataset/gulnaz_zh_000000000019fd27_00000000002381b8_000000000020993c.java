import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CodeJam {

	public static int[] row (Integer mat[][]) {
		int[] res = new int[2];
		
		for (int i=0; i<mat.length; i++) {
			List<Integer> temp1 = new ArrayList<>();
			List<Integer> temp2 = new ArrayList<>();
			temp1.add(mat[i][0]);
			temp2.add(mat[0][i]);
			for (int j=1; j<mat.length; j++) {
				if (temp1.contains(mat[i][j]) == true && temp2.contains(mat[j][i]) == true) {
					res[0]++;
					res[1]++;
					break;
				} 
				else if (temp1.contains(mat[i][j]) == true) {
					res[0]++;
					break;
				}
				else if (temp2.contains(mat[j][i]) == true) {
					res[1]++;
					break;
				}
				temp1.add(mat[i][j]);
				temp2.add(mat[j][i]);
			}
			temp1.clear();
			temp2.clear();
		}		
		return res;
	}
	
	public static int trace (Integer mat[][]) {
		int res = 0;
		for (int j=0; j<mat.length; j++) {
			res += mat[j][j];
		}
		return res;
	}
	
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		
		List<Integer[][]> mat = new ArrayList<>();
		for (int i=0; i<cases; i++) {
			int n = scanner.nextInt();
			scanner.skip("[\r\n]+");
			Integer[][] m = new Integer[n][n];
			for (int j=0; j<n; j++) {
				String[] res = scanner.nextLine().split(" ");
				for (int k=0; k<n; k++) {
					m[j][k] = Integer.parseInt(res[k]);
				}
			}
		    mat.add(m);
		}
		
        for (int i=0; i<cases; i++) {
        	int k=i+1;
        	int [] r = row(mat.get(i));
            System.out.println("Case #" +k+": "+ trace(mat.get(i))+ " " +
        	r[0] + " "+ r[1]);
        }        
	}

}
