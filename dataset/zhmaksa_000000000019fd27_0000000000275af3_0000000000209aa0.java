import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int line = scanner.nextInt();

        parentloop:
        for(int i= 0; i<line; i++){
            int n = scanner.nextInt();
            BigInteger k = new BigInteger(scanner.next());

            if(n == 0){
                System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
                continue parentloop;
            }
            if(n == 1){
                System.out.println("Case #" + (i+1) + ": " + "POSSIBLE");
                System.out.println(k);
                continue parentloop;
            }

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

            BigInteger lr = lr(m);
            if(lr.equals(k)){
                System.out.println("Case #" + (i+1) + ": " + "POSSIBLE");
                printLr(m);
                continue parentloop;
            }
            BigInteger rl = rl(m);
            if (rl.equals(k)){
                System.out.println("Case #" + (i+1) + ": " + "POSSIBLE");
                printRl(m);
                continue parentloop;
            }

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
                    continue parentloop;
                }

                rl = rl(m);
                if (rl.equals(k)){
                    System.out.println("Case #" + (i+1) + ": " + "POSSIBLE");
                    printRl(m);
                    continue parentloop;
                }
            }

            System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
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
