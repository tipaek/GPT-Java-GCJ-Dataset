import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            for(int j=0;j<N;j++){
            matrix[j] = IntStream.range(0,N).map(e->scanner.nextInt()).toArray();
            }

            int sum=0;
            int rows=0;
            int cols=0;
            for(int k=0;k<N;k++){

                sum+=matrix[k][k];
                rows+= checkrow(k,matrix,N);
                cols+= checkcol(k,matrix,N);
            }

            System.out.println("Case #"+i+": "+sum+" "+rows+" "+cols);

        }
    }

    private static int checkrow(int k, int[][] matrix,int N) {

        boolean[] aux  = new boolean[N];

        for(int i=0;i<N;i++){
            if(aux[matrix[k][i]-1])
                return 1;
            else aux[matrix[k][i]-1]=true;
        }
        return 0;

    }

    private static int checkcol(int k, int[][] matrix, int N) {
        boolean[] aux  = new boolean[N];

        for(int i=0;i<N;i++){
            if(aux[matrix[i][k]-1])
                return 1;
            else aux[matrix[i][k]-1]=true;
        }
        return 0;
    }
}
