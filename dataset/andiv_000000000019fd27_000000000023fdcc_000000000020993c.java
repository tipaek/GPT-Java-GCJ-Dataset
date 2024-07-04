import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = scanner.nextInt();

        boolean wasPrevNextLine = false;

        for (int i = 1; i <= totalTests; i++) {
            if(!wasPrevNextLine) scanner.nextLine();
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            scanner.nextLine();
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    matrix[j][k] = scanner.nextInt();
                }
                scanner.nextLine();
            }
            wasPrevNextLine = true;
            int[] result = solve(matrix, N);
            System.out.println("Case #"+i+": "+result[0] + " " + result[1] + " " + result[2]);
        }

    }

    public static int[] solve(int[][] matrix, int N){
        int diagonal = 0, rows = 0, cols = 0;
        int[] result = new int[3];

        for(int i=0; i<N; i++){
            diagonal += matrix[i][i];
        }
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<N; i++){
            visited.clear();
            for(int j=0;j<N; j++){
                if(visited.contains(matrix[i][j])){
                    rows ++;
                    break;
                }
                visited.add(matrix[i][j]);
            }
        }

        for(int i=0; i<N; i++){
            visited.clear();
            for(int j=0;j<N; j++){
                if(visited.contains(matrix[j][i])){
                    cols ++;
                    break;
                }
                visited.add(matrix[j][i]);
            }
        }


        result[0] = diagonal;
        result[1] = rows;
        result[2] = cols;

        return result;
    }

}