import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int line = scanner.nextInt();

        for(int i= 0; i<line; i++){
            int n = scanner.nextInt();
            BigInteger k = new BigInteger(scanner.next());

            int[][] m = new int[n][n];

            int curr = 1;
            for(int r=0; r<n;r++){
                for(int j=0; j<n;j++){
                    if(r-1<0){
                        m[r][j] = curr++;
                    } else {
                        m[r][j] = m[r-1][j+1==n?0:j+1];
                    }
                }
            }

            boolean possible = false;

            BigInteger lr = lr(m);
            if(lr.equals(k)){
                System.out.println("Case #" + (i+1) + ": " + "POSSIBLE");
                printLr(m);
                possible = true;
            }
            BigInteger rl = rl(m);
            if (rl.equals(k)){
                System.out.println("Case #" + (i+1) + ": " + "POSSIBLE");
                printRl(m);
                possible = true;
            }

            if(!possible){
                for(int t=0;t<n;t++){
                    int[] tmp = new int[n];
                    for(int r=0; r<n;r++){
                        for(int j=0; j<n;j++){
                            if(r==0){
                                tmp[j] = m[r][j];
                            }
                            if(r+1 < n){
                                m[r][j] = m[r+1][j];
                            } else if(r+1 == n){
                                m[r][j] = tmp[j];
                            }
                        }
                    }

                    lr = lr(m);
                    if(lr.equals(k)){
                        System.out.println("Case #" + (i+1) + ": " + "POSSIBLE");
                        printLr(m);
                        possible = true;
                        break;
                    }

                   rl = rl(m);
                    if (rl.equals(k)){
                        System.out.println("Case #" + (i+1) + ": " + "POSSIBLE");
                        printRl(m);
                        possible = true;
                    }
                }
            }

            if(!possible){
                System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
            }
        }
    }

    public static BigInteger lr(int[][] a){
        BigInteger result = BigInteger.valueOf(0);
        for(int r=0; r<a.length;r++){
            for(int j=0; j<a[r].length;j++){
                if(r == j){
                    result = result.add(BigInteger.valueOf(a[r][j]));
                }
            }
        }
        return result;
    }

    public static BigInteger rl(int[][] a){
        BigInteger result = BigInteger.valueOf(0);
        int counter = a.length -1;
        for(int r=0; r<a.length;r++){
            for(int j=0; j<a[r].length;j++){
                if(j == counter){
                    result = result.add(BigInteger.valueOf(a[r][j]));
                    counter--;
                }
            }
        }
        return result;
    }

    public static void printLr(int[][] a){
        for(int r=0; r<a.length;r++){
            for(int j=0; j<a[r].length;j++){
                System.out.print(a[r][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printRl(int[][] a){
        int[][] b = new int[a.length][a.length];

        for(int r=a.length-1; r>=0;r--){
            for(int j=0; j<a[r].length;j++){
                b[a.length-1-r][j] = a[r][j];
            }
        }

        for(int r=0; r<b.length;r++){
            for(int j=0; j<b[r].length;j++){
                System.out.print(b[r][j] + " ");
            }
            System.out.println();
        }
    }
}

