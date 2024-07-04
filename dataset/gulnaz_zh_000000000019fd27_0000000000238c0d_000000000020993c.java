package codeJam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeJam {
	
	public static String[] foregone(String n) {
		String[] res = new String[2];
		res[0] = "";
		res[1] = "";
		boolean b = false;
		for (int i=0; i<n.length(); i++) {
			if (n.charAt(i) == '4') {
				res[0] = res[0].concat("2");
				res[1] = res[1].concat("2");
				b = true;
			} else {
				res[0] = res[0].concat(n.substring(i, i+1));
				if (b == true)
				res[1] = res[1].concat("0");
			}
		}
		return res;
	}

	public static int row (Integer mat[][]) {
		int cR = 0;
		
		for (int i=0; i<mat.length; i++) {
			List<Integer> temp = new ArrayList<>();
			temp.add(mat[i][0]);
			for (int j=1; j<mat.length; j++) {
				if (temp.contains(mat[i][j]) == true) {
					cR++;
					break;
				}
				temp.add(mat[i][j]);
			}
			temp.clear();
		}		
		return cR;
	}
	
	public static int col (Integer mat[][]) {
		int cC = 0;
		
		for (int i=0; i<mat.length; i++) {
			List<Integer> temp = new ArrayList<>();
			temp.add(mat[0][i]);
			for (int j=1; j<mat.length; j++) {
				if (temp.contains(mat[j][i]) == true) {
					cC++;
					break;
				}
				temp.add(mat[j][i]);
			}
			temp.clear();
		}
		return cC;
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
            System.out.println("Case #" +k+": "+ trace(mat.get(i))+ " " +
        	row(mat.get(i)) + " "+ col(mat.get(i)));
        }        
	}

}
