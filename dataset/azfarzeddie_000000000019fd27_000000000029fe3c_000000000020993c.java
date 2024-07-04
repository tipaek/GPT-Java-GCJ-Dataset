import java.io.IOException;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=1;i<=T;i++) {
            int N = sc.nextInt();
            int[][] M = new int[N][N];
            for(int k=0;k<N;k++) {
                for(int j=0;j<N;j++) {
                    M[k][j] = sc.nextInt();
                }
            }
            //System.out.println("calling T="+i);
            System.out.println(vestigium(i, M, N));
        }
    }

    private static String vestigium(int T, int[][] M, int len) {
        int diaSum = 0, rowFlag = 0, colFlag = 0, rowCount = 0, colCount = 0;
        for(int i=0;i<len;i++) {
            diaSum += M[i][i];
            for(int j=0;j<len;j++) {
                for(int k=j+1;k<len;k++) {
                    if(M[i][j] == M[i][k])
                        rowFlag = 1;
                    if(M[j][i] == M[k][i])
                        colFlag = 1;
                }
            }
            if(rowFlag==1)
                rowCount++;
            if(colFlag==1)
                colCount++;
        }
        //System.out.println("result for Case #"+T+" "+diaSum+" "+rowCount+" "+colCount);
        String res = "Case #"+T+" "+diaSum+" "+rowCount+" "+colCount;
        return res;
    }
}
