import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(s.nextLine());
            int[][] m = new int[n][n];
            int[][] r = new int[n][n+1];
            int[][] c = new int[n][n+1];

            int trace = 0;
            for (int j = 0; j < n; j++) {
                String[] str = s.nextLine().split(" ");
                for (int k = 0; k < n; k++) {
                    m[j][k] = Integer.parseInt(str[k]);
                    if(j==k){
                        trace+=m[j][k];
                        //System.out.println("Trace="+trace);
                    }
                    r[j][m[j][k]] +=1;
                    c[k][m[j][k]] +=1;
                }
            }
            int rCnt = 0;
            int cCnt = 0;
            for (int j=0; j<n; j++){
                boolean skipRow =false;
                boolean skipCol=false;
                for(int k =1; k<=n;k++){
                    if(r[j][k] > 1 && !skipRow){
                        rCnt++;
                        skipRow = true;
                    }
                    if(c[j][k] > 1 && !skipCol){
                        skipCol = true;
                        cCnt++;
                    }
                }
            }
            System.out.println(String.format("Case #%d: %d %d %d",t,trace,rCnt, cCnt));

        }

    }

}
