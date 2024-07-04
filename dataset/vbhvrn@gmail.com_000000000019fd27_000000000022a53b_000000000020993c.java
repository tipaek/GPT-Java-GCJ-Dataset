import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int f = 0;
        while (f++<t){
            long k = 0;
            long r = 0;
            long c = 0;

            int n = scan.nextInt();
            long[][] ar = new long[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ar[i][j] = scan.nextLong();
                }
            }

            //diagonal sum
            for (int i = 0; i < n; i++) {
                k+=ar[i][i];
            }

            boolean[] rC = new boolean[n];
            boolean[] cC = new boolean[n];

            //duplicate values for col
            for (int i = 0; i < ar.length; i++) {
                if(rC[i]){
                    continue;
                }
                for (int j = 0; j < ar.length; j++) {
                    long p = ar[i][j];
                    for (int l = j+1; l < ar.length; l++) {
                        if(p == ar[i][l]){
                            rC[i] = true;
                            break;
                        }
                    }
                    if(cC[j]){
                        continue;
                    }

                    for (int l = i+1; l < ar.length; l++) {
                        if(p == ar[l][j]){
                            cC[j] = true;
                            break;
                        }
                    }
                }
            }

            for (int i = 0; i < rC.length; i++) {
                if(rC[i]){
                    r++;
                }
            }

            for (int i = 0; i <cC.length; i++) {
                if(cC[i]){
                    c++;
                }
            }

            System.out.println("Case #"+f+": " + k +" " +r + " " + c);
        }
    }
}
