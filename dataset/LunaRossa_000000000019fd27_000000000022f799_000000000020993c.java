import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		final boolean STD_IO = true;
		final String INPUT_FILE = "A-small-attempt0.in";
		InputStream inStream = STD_IO ? System.in : new FileInputStream(new File(INPUT_FILE));
		OutputStream outStream = STD_IO ? System.out : new FileOutputStream(new File("GCJ.out"));
		Scanner input = new Scanner(inStream);
		PrintWriter out = new PrintWriter(outStream);

		while (input.hasNext()) {
			int T = input.nextInt();

			for (int t = 1; t <= T; ++t) {
				int N = input.nextInt();
				int[][] M = new int[N][N];
				
				for (int i = 0; i < M.length; ++i) {
					for (int j = 0; j < M[i].length; ++j) {
						M[i][j] = input.nextInt(); 	
					}					
				}
				
				int k = 0;
				int r = 0;
				int c = 0;
				boolean[] exist = new boolean[N + 1];
				for (int i = 0; i < M.length; ++i) {
					k += M[i][i];
					
					Arrays.fill(exist, false);
					for (int j = 0; j < M[i].length; ++j) {
						if (exist[M[i][j]]) {
							++r;
							break;
						} else {
							exist[M[i][j]] = true;
						}
					}
					
					Arrays.fill(exist, false);
					for (int j = 0; j < M.length; ++j) {
						if (exist[M[j][i]]) {
							++c;
							break;
						} else {
							exist[M[j][i]] = true;
						}
					}
				}		
				
				out.printf("Case #%d: %d %d %d\n", t, k, r, c);
			}
		}

		out.close();
		input.close();
	}
}
