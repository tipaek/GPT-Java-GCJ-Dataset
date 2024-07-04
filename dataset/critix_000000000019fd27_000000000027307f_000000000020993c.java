import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int tests = s.nextInt();

		for (int i = 0; i < tests; i++) {
			int n = s.nextInt();
			int rows = 0;
			int columns = 0;
			int trace = 0;
			boolean[][] rset = new boolean[n][n];
			boolean[][] cset = new boolean[n][n];
			boolean[] countedRows = new boolean[n];
			boolean[] countedColumns = new boolean[n];


			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					int tmp = s.nextInt();  //Integer.parseInt(row[k]);

					if (k == j)
						trace += tmp;



					if (rset[j][tmp - 1] && !countedRows[j]){
						rows++;
						countedRows[j]=true;
					}


					if (cset[k][tmp - 1] && !countedColumns[k]){
						columns++;
						countedColumns[k]=true;
					}

					rset[j][tmp-1]=true;
					cset[j][tmp-1]=true;
				}

			}
			System.out.println("Case #" + (i + 1) + ": " + trace + " " + rows + " " + columns);
		}


	}
}
