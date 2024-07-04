import java.util.Scanner;

public class Solution {

    public static Long product(int n){
        Long s=1l;
        for (int i=1; i<=n; i++) {
            s*=i;
        }
        return s;
    }



    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
       int t = in.nextInt();

        for(int i = 1; i<=t; i++) {
            int n = in.nextInt(), k = 0, r = 0, c = 0;
            int s = (n*(n+1))/2;
            Long p = product(n);
            int[][] m = new int[n][n];
            // fulfilling the matrix
            for(int j= 0; j< n ; j++) {
                for (int x = 0; x < n ; x++) {
                    m[j][x] = in.nextInt();
                    if(j == x) {
                        k+=m[j][x];
                    }
                }
            }

            for(int j=0; j< n; j++) {
                int sommeR = 0;
                int sommeC = 0;
                Long prodR = 1l;
                Long prodC = 1l;
                for(int x=0; x <n; x++) {
                    sommeR+= m[j][x];
                    prodR*= m[j][x];
                    sommeC+= m[x][j];
                    prodC*= m[x][j];
                }
                if(sommeR != s || prodR != p) {
                    r++;
                }
                if(sommeC != s || prodC != p) {
                    c++;
                }
            }

            System.out.println("Case #" + i +" :" + " " + k + " " + r + " " + c);
        }
    }
}
