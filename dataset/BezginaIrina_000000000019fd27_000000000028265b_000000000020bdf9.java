import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());

        MainLoop:
        for(int a=0; a < T; a++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] M = new int[N][3];

            int[][] result = new int[N][2];

            int C = 0;
            int J = 0;

            for(int b=0; b < N; b++) {
                M[b] = Arrays.stream((scanner.nextLine()+" "+Integer.toString(b)).split(" ")).mapToInt(Integer::parseInt).toArray();

                if(M[b][0]>1440||M[b][1]>1440) {
                    System.out.println("Case #"+(a+1)+": IMPOSSIBLE");
                    continue MainLoop;
                }
            }

            java.util.Arrays.sort(M, java.util.Comparator.<int[]>comparingDouble(x -> x[0]).thenComparingDouble(x -> x[1]));

            result[0][1] = 1;
            result[0][0] = M[0][2];
            C = M[0][1];

            for(int j=1; j < N; j++) {
                if(M[j][0]>=M[j-1][1]&&result[j-1][1]==1) {
                    result[j][1] = result[j-1][1];
                    result[j][0] = M[j][2];
                    C = M[j][1];
                }
                else if(M[j][0]>=M[j-1][1]&&result[j-1][1]==2) {
                    result[j][1] = result[j-1][1];
                    result[j][0] = M[j][2];
                    J = M[j][1];
                }
                else if(M[j][0]<M[j-1][1]&&result[j-1][1]==1&&M[j][0]>=J) {
                    result[j][1] = 2;
                    result[j][0] = M[j][2];
                    J = M[j][1];
                }
                else if(M[j][0]<M[j-1][1]&&result[j-1][1]==2&&M[j][0]>=C) {
                    result[j][1] = 1;
                    result[j][0] = M[j][2];
                    C = M[j][1];
                }
                else {
                    System.out.println("Case #"+(a+1)+": IMPOSSIBLE");
                    continue MainLoop;
                }
            }

            java.util.Arrays.sort(result, java.util.Comparator.<int[]>comparingDouble(x -> x[0]));

            StringBuilder stringBuilder = new StringBuilder();
            for(int z=0; z<N; z++) {
                stringBuilder.append(Integer.toString(result[z][1]).replace("1","C").replace("2","J"));
            }

            System.out.println("Case #"+(a+1)+": "+stringBuilder.toString());

        }
    }
}
