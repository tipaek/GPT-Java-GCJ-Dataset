import java.io.*;
import java.util.Scanner;

/**
 * @author Holenko I.
 * @since 2020-04-04
 */
public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
                Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner in = new Scanner(new BufferedReader(new FileReader(new File("/home/illia/Workspace/java_examples/java_simple/src/main/resources/jam1.txt"))));
        int     t  = in.nextInt();

        for (int tCase = 1; tCase <= t; tCase++) {

            int wCol = 0, wRow = 0;

            int   n       = in.nextInt();
            int[] cols    = new int[n];
            int   perfect = 0;
            int   trace   = 0;

            for (int i = 0; i < n; i++) {
                int row = 0;
                for (int j = 0; j < n; j++) {
                    final int current = in.nextInt();

                    if (i == 0)
                        perfect ^= (j + 1);

                    row ^= current;
                    cols[j] ^= current;

                    if (i == n - 1 && cols[j] != perfect)
                        wCol++;

                    if (i == j)
                        trace += current;

                }
                if (perfect != row)
                    wRow++;
            }
            System.out.println("Case #" + tCase + ": " + trace + " " + wRow + " " + wCol);
        }


    }
}


