import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        int testCases = 0;
        int N = 0;
        int diagonalSum = 0;
        Set<Integer> columns = new HashSet<>();
        Set<Integer> rows = new HashSet<>();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        testCases = in.nextInt();
        for(int t = 0; t < testCases; t++){//testCases
            N = in.nextInt();
            int[][] matrix = new int[N][N];
            for(int i = 0; i < N; i++){ //getting the input array
                for(int j = 0; j < N; j++){
                    matrix[i][j] = in.nextInt();
                }
            }
            for(int d = 0; d < N; d++){
                diagonalSum += matrix[d][d];
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    int pivot = matrix[i][j];
                    for(int k = i + 1; k < N; k++){
                        if(matrix[k][j] == pivot) {
                            columns.add(j);
                        }
                    }
                    for(int c = j + 1; c < N; c++){
                        if(matrix[i][c] == pivot) {
                            rows.add(i);
                        }
                    }
                }
            }
            System.out.print("#"+(t+1)+": " + diagonalSum + " "+ rows.size()+" "+ columns.size()+"\n");
            diagonalSum = 0;
            columns.clear();
            rows.clear();
        }
    }
}

