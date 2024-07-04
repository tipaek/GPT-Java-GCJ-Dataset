import java.util.Scanner;

public class Vestigium {
	public static void print (int[][] x) {
		for (int i = 0; i < x.length; i ++) {
			for (int j = 0; j < x[0].length; j ++) {
				System.out.print(x[i][j]+" ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		for (int i = 0; i < num; i++) {
			int sum = 0;
			int size = in.nextInt();
			
			int rowcount = 0; 
			int colcount = 0; 
			
			int[][] x = new int[size][size];
			for(int j = 0; j < size; j++) {
				for(int k = 0; k < size; k++) {
					x[j][k] = in.nextInt(); 
					if (j == k) {
						sum += x[j][k];
					}
				}
				
			}
			for (int l = 0; l < size; l++) {
				outer: 
				for (int m = 0; m < size; m++) {
					int rowcheck = x[l][m];
					//System.out.println(rowcheck); 
					for (int n = m + 1; n < size; n++) {
						if (rowcheck == x[l][n]) {
							rowcount ++; 
							break outer; 
						}
					}
				}
			}
			for (int l = 0; l < size; l++) {
				outer:
				for (int m = 0; m < size; m++) {
					int colcheck = x[m][l];
					//System.out.println(rowcheck); 
					for (int n = m + 1; n < size; n++) {
						if (colcheck == x[n][l]) {
							colcount ++; 
							break outer; 
						}
					}
				}
			}
			System.out.println("Case # "+ i+1 +": "+sum+" "+rowcount+" " +colcount); 
		}

	}

}
