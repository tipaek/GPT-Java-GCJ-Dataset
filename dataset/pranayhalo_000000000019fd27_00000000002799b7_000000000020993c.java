import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;

public class A {
    public static void main(String[] args) throws IOException {
        Scanner std = new Scanner(System.in);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        //log.write() //log.flush()
        int t = std.nextInt();
        int caseN = 0;
        while (caseN++ < t) {
            int n = std.nextInt();
            HashSet<Integer>[] rc = new HashSet[2*n];
            boolean[] rcuniq = new boolean[2*n];
            int trace = 0;

            for (int i = 0; i < 2*n; i++) {
                rc[i] = new HashSet<>();
                rcuniq[i] = true;
            }

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int elem = std.nextInt();

                    if (r == c) {
                        trace += elem;
                    }

                    int curr = r*n + c;
                    int ind_set1 = curr / n;
                    int ind_set2 = n + (curr % n);

                    if (!rc[ind_set1].contains(elem)) {
                        rc[ind_set1].add(elem);
                    } else if (rcuniq[ind_set1]) {
                        rcuniq[ind_set1] = false;
                    }

                    if (!rc[ind_set2].contains(elem)) {
                        rc[ind_set2].add(elem);
                    } else if (rcuniq[ind_set2]) {
                        rcuniq[ind_set2] = false;
                    }
                }
            }
            int r_tot = 0;
            int c_tot = 0;
            for (int i = 0; i < 2*n; i++) {
                if (i < n && !rcuniq[i]) {
                    r_tot++;
                } else if (i >= n && !rcuniq[i]) {
                    c_tot++;
                }
            }
            log.write("Case #" + caseN + ": " + trace + " " + r_tot + " " + c_tot + "\n");
        }
        log.flush();
    }
}