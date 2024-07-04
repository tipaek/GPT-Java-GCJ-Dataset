import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

            int       n     = in.nextInt();
            Set[]     cols  = new Set[n];
            boolean[] wCols = new boolean[n];
            int       trace = 0;

            for (int i = 0; i < n; i++) {
                Set row = new HashSet();

                boolean wr = false;
                for (int j = 0; j < n; j++) {
                    final int current = in.nextInt();

                    if (!row.add(current) && !wr) {
                        wRow++;
                        wr = true;
                    }


                    if (cols[j] == null)
                        cols[j] = new HashSet();

                    if (!cols[j].add(current) && !wCols[j]) {
                        wCol++;
                        wCols[j] = true;
                    }

                    if (i == j)
                        trace += current;

                }
            }
            System.out.println("Case #" + tCase + ": " + trace + " " + wRow + " " + wCol);
        }
    }
}

