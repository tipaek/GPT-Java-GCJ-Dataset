import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int c=1; c<= T; c++) {  // each case

            int N = scanner.nextInt();
            int[][] m = new int[N][N];

            for(int i=0; i<N; i++) {    // each row
                for(int j=0; j<N; j++) {    // each column

                    m[i][j] = scanner.nextInt();
                }
            }

            // diagonal summation
            int k = 0;

            for(int i=0; i<N; i++) {

                k += m[i][i];
            }

            Map<Integer,Integer> map = new HashMap<>(N);

            // row check
            int row = 0;

            for(int i=0; i<N; i++) {    // each row

                map.clear();

                for (int j = 0; j < N; j++) {    // each column

                    if(map.containsKey(m[i][j])) {
                        row++;
                        break;
                    }
                    else {
                        map.put(m[i][j],1);
                    }
                }
            }

            // column check
            int col = 0;

            for(int i=0; i<N; i++) {    // each row

                map.clear();

                for (int j = 0; j < N; j++) {    // each column

                    if(map.containsKey(m[j][i])) {
                        col++;
                        break;
                    }
                    else {
                        map.put(m[j][i],1);
                    }
                }
            }

            System.out.println("Case #" + c + ": " + k + " " + row+ " " + col);
        }
    }
}
