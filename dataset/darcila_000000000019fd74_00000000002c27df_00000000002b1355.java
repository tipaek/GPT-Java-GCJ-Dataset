import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t =1; t<=T; t++) {
            int r, c;
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            int[][] matrix = new int[r][c];
            int[][] nb = new int[r][c];
            int[][] sum = new int[r][c];

            int ans = 0;
            int matrixTotal = 0;
            int removedTotal = 0;

            for(int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j =0; j<c; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    matrixTotal += matrix[i][j];
                }
            }

            ans = matrixTotal;

            boolean removed = true;
            while(removed) {
                removed = false;

                for(int i = 0; i < r; i++) {
                    Arrays.fill(nb[i], 0);
                    Arrays.fill(sum[i], 0);
                }

                int last, x, y;
                for(int i = 0; i < r; i++) {
                    last = -1;
                    x = 0;
                    y =0;
                    for(int j=0; j<c; j++) {
                        if(matrix[i][j] > 0) {
                            if( last > 0) {
                                nb[x][y]++;
                                nb[i][j]++;
                                sum[x][y]+=matrix[i][j];
                                sum[i][j]+=last;
                            }
                            last = matrix[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }

                for(int j = 0; j < c; j++) {
                    last = -1;
                    x = 0;
                    y =0;
                    for(int i=0; i<r; i++) {
                        if(matrix[i][j] > 0) {
                            if( last > 0) {
                                nb[x][y]++;
                                nb[i][j]++;
                                sum[x][y]+=matrix[i][j];
                                sum[i][j]+=last;
                            }
                            last = matrix[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }


                for(int i = 0; i < r; i++) {
                    for(int j=0; j<c; j++) {
                       if(matrix[i][j] > 0)  {
                           if(matrix[i][j]*nb[i][j] < sum[i][j]) {
                               removedTotal += matrix[i][j];
                               removed = true;
                               matrix[i][j] = -1;
                           }
                       }
                    }
                }
                if(removed) ans += matrixTotal - removedTotal;

            }

            System.out.println("Case #" + t + ": " + ans);

        }
    }
}
