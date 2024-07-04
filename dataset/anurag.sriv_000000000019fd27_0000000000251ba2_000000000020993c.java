import java.util.Scanner;
public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int k=1;k<=T;k++) {

            int N = sc.nextInt();
            int traces = 0, rows=0, columns = 0;
            int matrix[][] = new int[N][N];
            int other[][] = new int[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    int num = sc.nextInt();

                    if(matrix[i][num-1] !=0) {
                        matrix[i][N-1] = -1;
                    }

                    if(other[num-1][j] !=0) {
                        other[N-1][j] = -1;
                    }

                    if(i == N-1) {
                        if(other[i][j] == -1) {
                            columns++;
                        }
                    }

                    if(i==j) {
                        traces = traces + num;
                    }

                    matrix[i][num-1] = num;
                    other[num-1][j] = num;
                }
                if(matrix[i][N-1] == -1) {
                    rows++;
                }
            }

            System.out.println("Case #" + k+ ": " + traces + " " + rows + " " + columns);
        }
    }
}
