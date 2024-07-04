import java.util.Scanner;

public class Solution {

    public static void computeTrace(int[][] arr, int n, int cnt){
        int rcnt = 0;
        int ccnt = 0;
        int trace = 0;
        for(int i=0;i<n;i++){
            int[] row = new int[n+1];
            int[] col = new int[n+1];
            int f = 0;
            int g = 0;
            for(int j=0;j<n;j++){
                row[arr[i][j]]++;
                col[arr[j][i]]++;
                if(row[arr[i][j]]>1){
                    f=1;
                }
                if(col[arr[j][i]]>1){
                    g=1;
                }
                if(i==j) {
                    trace += arr[i][j];
                }
            }
            if(f==1){
                rcnt++;
            }
            if(g==1){
                ccnt++;
            }
        }

        System.out.println("Case #"+ cnt +": " + trace + " " + rcnt + " " + ccnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cnt = 1;
        while(cnt <= t) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j] = sc.nextInt();
                }
            }
            computeTrace(mat, n, cnt);
            cnt++;
        }
    }
}