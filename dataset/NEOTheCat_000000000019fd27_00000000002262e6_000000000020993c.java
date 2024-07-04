
import java.util.Scanner;

public class Solution {

    private static String PATTEN = "Case #%d: %d %d %d";

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int p =1;p<=t;p++){
            int N = sc.nextInt();
            int[][] a = new int[N][N];
            int k=0,r=0,c=0;
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    a[i][j] = sc.nextInt();
                    if (i==j){
                        k = k+a[i][j];
                    }
                }
            }
            int[][] rr = new int[N][N+1];
            int[][] cc = new int[N][N+1];
            for (int i=0;i<N;i++){
                boolean flag = false;
                for (int j =0;j<N;j++){
                    rr[i][a[i][j]]++;
                    if (rr[i][a[i][j]]>1){
                        flag= true;
                    }
                }
                if (flag){
                    r++;
                }
            }
            for (int i=0;i<N;i++){
                boolean flag = false;
                for (int j =0;j<N;j++){
                    cc[i][a[j][i]]++;
                    if (cc[i][a[j][i]]>1){
                        flag= true;
                    }
                }
                if (flag){
                    c++;
                }
            }
            System.out.println(String.format(PATTEN, p, k, r,c));
        }
    }
}
