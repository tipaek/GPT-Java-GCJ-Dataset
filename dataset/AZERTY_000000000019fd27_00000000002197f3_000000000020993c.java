   import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nb_test = in.nextInt();
        int mes_matrix[][][] = new int[nb_test][][];
        for (int i = 0; i < nb_test; i++) {
            int N = in.nextInt();
            int matrix[][] = new int[N][N];
            for ( int j = 0; j < N; j++)
		    {
				for (int k = 0; k < N; k++) {
					matrix[j][k] = in.nextInt();
				}
			}
			int trace = 0;
			int out_lin = 0;
			int out_col = 0;
			boolean my_lin[] = new boolean[N];
			boolean my_col[] = new boolean[N];
			for (int j = 0; j < N; j++) {
				for (int z = 0; z < N; z++) {
					my_lin[z] = false;
					my_col[z] = false;
				}
				boolean check_l = false;
				boolean check_c = false;
				for (int k = 0; k < N; k++) {
					int index_l = (matrix[j][k]-1);
					if (!my_lin[index_l]) {
						my_lin[index_l] = true;
					}
					else {
						check_l = true;
					}
					int index_c = (matrix[k][j]-1);
					if (!my_col[index_c]) {
						my_col[index_c] = true;
					}
					else {
						check_c = true;
					}
					if (j == k) {trace += matrix[k][j];}
				}
				if (check_l) { out_lin++;}
				if (check_c) { out_col++;}
			}
			System.out.println("Case #"+(i+1)+": "+trace+" "+out_lin+" "+out_col);
		}
    }
}