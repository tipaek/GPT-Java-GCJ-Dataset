import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int trace ,rowsRepeated,colsRepeated;
        Set<Integer> setForRows,setForCols;
        for (int i = 1 ; i <= T ; i++) {
            int N = sc.nextInt();
            int [][] M = new int[N][N];
            trace = 0;rowsRepeated = 0;colsRepeated = 0;
            for (int j = 0 ; j < N ; j++) {
                setForRows = new HashSet<>();
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
                setForCols = new HashSet<>();
                for (int k = 0 ; k < N ; k++){
                    setForCols.add( M[k][j]);
                }
                if(setForCols.size() != N)
                    colsRepeated++;
            }
            System.out.println();
            System.out.print("Case #"+i+": "+trace + " " + rowsRepeated + " " + colsRepeated);
        }
    }
}
