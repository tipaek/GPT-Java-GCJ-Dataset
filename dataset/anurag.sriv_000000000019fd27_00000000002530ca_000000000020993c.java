
import java.util.Scanner;
import java.util.HashSet;
public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int k=1;k<=T;k++) {

            int N = sc.nextInt();
            int traces = 0, rows=0, columns = 0;
            //int up[][] = new int[N][N];
            int matrix[][] = new int[N][N];
            int other[][] = new int[N][N];
            for(int i=0;i<N;i++) {
                int flag = 0;
                HashSet<Integer> set = new HashSet<>();
                for(int j=0;j<N;j++) {
                    int num = sc.nextInt();
                    if(i==j) {
                        traces = traces + num;
                    }
                    set.add(num);
                    matrix[i][j] = num;
                }
                if(set.size()!=N) {
                    rows++;
                }
            }

            for(int i=0;i<N;i++) {
                HashSet<Integer> set = new HashSet<>();
                for(int j=0;j<N;j++) {
                    set.add(matrix[j][i]);
                }
                if(set.size()!=N) {
                    columns++;
                }
            }

            System.out.println("Case #" + k+ ": " + traces + " " + rows + " " + columns);
        }
    }
}
