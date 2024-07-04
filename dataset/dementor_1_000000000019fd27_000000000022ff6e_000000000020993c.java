
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ayush1 on 10-05-2017.
 */
class Solution {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        int n,trace,r,c,a[][],check[];
        String s[];
        for (int i = 1; i <=test ; i++) {
            n = Integer.parseInt(br.readLine());
            a = new int[n][n];
            for (int j = 0; j < n; j++) {
                s = br.readLine().split(" ");
                for (int k = 0; k < n; k++) {
                    a[j][k] = Integer.parseInt(s[k]);
                }
            }
            trace=0;
            for (int j = 0; j < n; j++)
                trace+=a[j][j];
            r=0;
            for (int j = 0; j < n; j++) {
                check = new int[n+1];
                for (int k = 0; k < n; k++) {
                    if(check[a[j][k]]==1)
                    {
                        r++;
                        break;
                    }
                    else
                        check[a[j][k]]=1;
                }
            }
            c=0;
            for (int j = 0; j < n; j++) {
                check = new int[n+1];
                for (int k = 0; k < n; k++) {
                    if(check[a[k][j]]==1)
                    {
                        c++;
                        break;
                    }
                    else
                        check[a[k][j]]=1;
                }
            }
            System.out.printf("Case #%d: %d %d %d\n",i,trace,r,c);
        }
    }
}
