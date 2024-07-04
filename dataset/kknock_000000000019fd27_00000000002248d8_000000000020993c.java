import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();

        String []res = new String[cases];
        for (int i = 1; i <= cases; i++) {
            int N = in.nextInt();

            int [][]matrix = new int[N][N];

            int dia = 0;
            for(int m = 0; m < N; m++) {
                for(int n = 0; n < N; n++) {
                    matrix[m][n] = in.nextInt();
                    if(m == n) {
                        dia += matrix[m][n];
                    }
                }
            }

            int row = 0;
            int col = 0;

            Set<Integer> set = new HashSet<Integer>();

            for(int m = 0; m < N; m++) {
                for(int n = 0; n < N; n++) {
                    if(!set.add(matrix[m][n])) {
                        row++;
                        break;
                    }
                }
                set = new HashSet<Integer>();
            }
            set = new HashSet<Integer>();

            for(int m = 0; m < N; m++) {
                for(int n = 0; n < N; n++) {
                    if(!set.add(matrix[n][m])) {
                        col++;
                        break;
                    }
                }
                set = new HashSet<Integer>();
            }
            res[i-1] = "Case #"+i+": "+" "+dia+" "+row+" "+col;
        }
        in.close();
        for (String s: res) {
            System.out.println(s);
        }
    }
}
