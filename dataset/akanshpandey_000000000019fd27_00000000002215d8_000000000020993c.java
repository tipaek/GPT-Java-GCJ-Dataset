import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=1;i<=T;i++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N+1][N+1];

            int k=0;
            int r=0;
            int c=0;
            for(int p=1;p<=N;p++) {
                for(int q=1;q<=N;q++) {
                    int g = sc.nextInt();
                    matrix[p][q] = g;
                    if(p==q) {
                        k+=g;
                    }
                }
            }

            for(int p=1;p<=N;p++) {
                HashSet<Integer> row = new HashSet<>();
                HashSet<Integer> columnn = new HashSet<>();
                for (int q = 1; q <= N; q++) {
                    row.add(matrix[p][q]);
                    columnn.add(matrix[q][p]);
                }
                if(row.size() != N) r++;
                if(columnn.size() != N) c++;
            }

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}
