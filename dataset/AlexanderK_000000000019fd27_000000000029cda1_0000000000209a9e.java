
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author alexk
 */
public class Solution {

    public static void main(String[] args) throws IOException, InterruptedException {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            process(r);
        }
    }

    public static void process(BufferedReader r) throws IOException, InterruptedException {
        String[] line = r.readLine().split(" ");
        int t = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
//        System.err.println("t = " + t + ", b = " + b);
        for (int i = 0; i < t; i++) {
//            System.err.println("Case #" + (i + 1));
            new Interaction().solve(r, b);
        }
    }

    static class Interaction {

        BufferedReader r;

        int qq = 0;

        char query(int q) throws IOException, InterruptedException {
            qq++;
            System.out.println(q + 1);
//            System.err.print("Query (" + qq + ") " + (q + 1) + "? ");
            String answer = r.readLine();
//            System.err.println(answer);
            return answer.charAt(0);
        }

        void solve(BufferedReader r, int b) throws IOException, InterruptedException {
            this.r = r;
            // [diffChanged, sameChanged]
            // -1 - unknown
            // 1 - inverted
            // 0 - same
            List<int[]> transforms = new ArrayList<>();
            char[] f = new char[b];
            int[] ti = new int[b]; // transform index for each bit
            int diffPos = -1, samePos = -1;
            char diffVal = 0, sameVal = 0;
            // First round, collect all data going from both ends
            for (int i = 0; i < b; i++) {
                if (qq % 10 == 0) {
                    if (i > 0) {
                        int[] t = {-1, -1};
                        int oldQQ = qq;
                        if (diffPos != -1) {
                            char v = query(diffPos);
                            t[0] = v == diffVal ? 0 : 1;
                            diffVal = v;
//                            System.err.println("diffVal = " + diffVal);
                        }
                        if (samePos != -1) {
                            char v = query(samePos);
                            t[1] = v == sameVal ? 0 : 1;
                            sameVal = v;
//                            System.err.println("sameVal = " + sameVal);
                        }
                        if ((qq - oldQQ) % 2 == 1) {
                            query(0); // to always have even checks
                        }
                        transforms.add(t);
                    }
                }
                int q = i % 2 == 0 ? i / 2 : b - (i / 2) - 1;
                f[q] = query(q);
                ti[q] = transforms.size();
                if (i % 2 == 1) {
                    if (diffPos == -1) {
                        // Can check if the new pair contains different values
                        if (f[q] != f[b - q - 1]) {
                            diffPos = b - q - 1;
                            diffVal = f[diffPos];
//                            System.err.println("diffPos = " + (diffPos + 1) + ", diffVal = " + diffVal);
                        }
                    }
                    if (samePos == -1) {
                        // Can check if the new pair contains the same value
                        if (f[q] == f[b - q - 1]) {
                            samePos = b - q - 1;
                            sameVal = f[samePos];
//                            System.err.println("samePos = " + (samePos + 1) + ", sameVal = " + sameVal);
                        }
                    }
                }
            }
//            System.err.println("Transforms:");
//            for (int[] tr : transforms) {
//                System.err.println("diffChanged = " + tr[0] + ", sameChanged = " + tr[1]);
//            }
//            System.err.println("f = " + new String(f));
//            System.err.println("ti = " + Arrays.toString(ti));
            char[] res = new char[b];
            for (int i = 0; i < b; i++) {
                char[] vv = {f[i / 2], f[b - i / 2 - 1]};
                for (int j = ti[i / 2]; j < transforms.size(); j++) {
                    int[] tr = transforms.get(j);
                    int diffChanged = tr[0];
                    int sameChanged = tr[1];
                    if (sameChanged == -1) {
                        sameChanged = diffChanged;
                    }
                    if (diffChanged == -1) {
                        diffChanged = sameChanged;
                    }
                    if (sameChanged == 1) {
                        // compl
                        vv[0] = vv[0] == '0' ? '1' : '0';
                        vv[1] = vv[1] == '0' ? '1' : '0';
                    }
                    if (diffChanged != sameChanged) {
                        // reverse
                        char t = vv[1];
                        vv[1] = vv[0];
                        vv[0] = t;
                    }
                }
                res[i / 2] = vv[0];
                res[b - i / 2 - 1] = vv[1];
            }
            String answer = new String(res);
            System.out.println(answer);
            String feedback = r.readLine();
//            System.err.println("Answer: " + answer + "? " + feedback);
            if (!feedback.equals("Y")) {
                System.exit(-1);
            }
        }
    }
}
