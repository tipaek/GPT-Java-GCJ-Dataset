import java.util.*;

class Trace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int r = 0;
        int c = 0;
        int k = 0;
        
        for(int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int matrix[][] = new matrix[N][N];
            for(int j = 0; j < N; j++) {
                for(int l = 0; l < N; l++) {
                    matrix[j][l] = sc.nextInt();
                    if(j == l) {
                        k += value;
                    }
                }
            }
            
            boolean checkRow[] = new boolean[N];
            boolean checkCol[] = new boolean[N];
            for(int j = 0; j < N; j++) {
                checkRow[j] = false;
                checkCol[j] = false;
            }
            
            for(int j = 0; j < N; j++) {
                HashSet<Integer> row = new HashSet<>();
                HashSet<Integer> col = new HashSet<>();
                for(int l = 0; l < N; l++) {
                    int value = matrix[j][l];
                    if(row.containsKey(value) && !checkRow[j]) {
                        checkRow[j] = true;
                        r++;
                    } else {
                        row.put(value);
                    }
                    value = matrix[l][j];
                    if(col.containsKey(value) && !checkCol[j]) {
                        checkCol[j] = true;
                        c++;
                    } else {
                        col.put(value);
                    }
                }
            }
        }
    }
}