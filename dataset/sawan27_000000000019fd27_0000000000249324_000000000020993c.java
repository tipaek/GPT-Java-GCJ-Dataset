import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1 ; i <= T ; i++) {
            int N = sc.nextInt();
            int [][] M = new int[N][N];
            int trace = 0;
            int rowsRepeated = 0;
            int colsRepeated = 0;
            for (int j = 0 ; j < N ; j++) {
                Set<Integer> setForRows = new HashSet<Integer>();
                for (int k = 0 ; k < N ; k++){
                    M[j][k] = sc.nextInt();
                    setForRows.add( M[j][k]);
                    if(j == k)
                        trace += M[j][k];
                }
                if(setForRows.size() != N)
                    rowsRepeated++;
            }
            for (int j = 0 ; j < N ; j++) {
                Set<Integer> setForCols = new HashSet<Integer>();
                for (int k = 0 ; k < N ; k++){
                    setForCols.add( M[k][j]);
                }
                if(setForCols.size() != N)
                    colsRepeated++;
            }
            System.out.println("Case #"+i+": "+trace + " " + rowsRepeated + " " + colsRepeated);
        }
    }
}
