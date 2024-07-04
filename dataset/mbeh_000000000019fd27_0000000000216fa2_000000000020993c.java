import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int k, r, c, n, arg;
        int cas = 1;
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        arg = scan.nextInt();
        while (cas<=arg){
            n = scan.nextInt();
            int m[][] = new int[n][n];
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    m[i][j]=scan.nextInt();
                }
            }

            k=0;
            r=0;
            c=0;
            for (int i=0; i<n; i++) {
                k+= m[i][i];
                if (compareRow(m, n, i)){
                    r++;
                }
                if (compareColumn(m, n, i)){
                    c++;
                }
            }
            System.out.println("Case #"+ cas +": " + k + " " + r + " " + c);
            cas++;
        }
    }
    private static boolean compareRow(int m[][], int n, int i){
        boolean resp= false;
            for (int j = 0; j<n-1 && !resp; j++){
                for (int l=j+1; l<n && !resp; l++){
                    if (m[i][j]==m[i][l]){
                        resp=true;
                    }
                }
            }
        return resp;
    }
    private static boolean compareColumn(int m[][], int n, int i){
        boolean resp= false;
        for (int j = 0; j<n-1 && !resp; j++){
            for (int l=j+1; l<n && !resp; l++){
                if (m[j][i]==m[l][i]){
                    resp=true;
                }
            }
        }
        return resp;
    }
}
