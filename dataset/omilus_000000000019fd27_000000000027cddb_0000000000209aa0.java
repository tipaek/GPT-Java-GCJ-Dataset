
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {


    static void printLatin(int n, int start) {
        int k = start - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int var = ((k + j) % n) + 1;
                if (j == n - 1) {
                    System.out.println(var);
                    k = var - 1;
                } else
                    System.out.print(var+" ");
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int cs = 1; cs <= cases; cs++) {
            int n = in.nextInt();
            int k = in.nextInt();

            if (k < n || (k % n != 0)) {
                System.out.println("Case #" + cs + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + cs + ": POSSIBLE");
                printLatin(n, k / n);
            }
        }


    }

}
