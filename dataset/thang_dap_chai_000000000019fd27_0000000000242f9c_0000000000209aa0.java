import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author thangbq
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nTestCase = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= nTestCase; ++i) {
            sb.setLength(0);
            sb.append("Case #").append(i).append(": ");
            int N = in.nextInt();
            int K = in.nextInt();
            int sumTrace = 0;
            for (int j = 1; j <= N; j++) {
                sumTrace += j;
            }

            if (K % N != 0 && K != sumTrace) {
                sb.append("IMPOSSIBLE");
                System.out.println(sb.toString());
                continue;
            }

            boolean isSum = K % N != 0;
            if (isSum && N == 2) {
                sb.append("IMPOSSIBLE");
                System.out.println(sb.toString());
                continue;
            }
            sb.append("POSSIBLE");
            int central = K / N;
            HashSet<Integer> DEFAULT_VALS = new HashSet<>(N);
            for (int j = 0; j < N; j++) {
                DEFAULT_VALS.add(j + 1);
            }
//            if (!isSum) {
//                DEFAULT_VALS.remove(central);
//            }

            List<HashSet<Integer>> colVals = new ArrayList(N);
            List<HashSet<Integer>> rowVals = new ArrayList(N);
            for (int j = 0; j < N; j++) {
                colVals.add((HashSet<Integer>) DEFAULT_VALS.clone());
                rowVals.add((HashSet<Integer>) DEFAULT_VALS.clone());
            }
            Integer last = -1;
            for (int j = 0; j < N; j++) {
                sb.append("\n");
                HashSet<Integer> row = rowVals.get(j);
                for (int k = 0; k < N; k++) {
                    HashSet<Integer> col = colVals.get(k);

                    if (j == k) {
                        if (isSum) {
                            sb.append(j + 1).append(" ");
                            col.remove(j + 1);
                            row.remove(j + 1);
                        } else {
                            sb.append(central).append(" ");
                            col.remove(central);
                            row.remove(central);
                        }
                        continue;
                    }

                    if (col.contains(last) && row.contains(last)) {
                        sb.append(last).append(" ");
                        col.remove(last);
                        row.remove(last);
                        continue;
                    }
                    Iterator<Integer> iterator = row.iterator();
                    Integer it = -1;
                    while (iterator.hasNext()) {
                        it = iterator.next();
                        if (col.contains(it)) {
                            iterator.remove();
                            col.remove(it);
                            break;
                        }
                    }
                    last = it;
                    sb.append(it).append(" ");
                }
                sb.setLength(sb.length() - 1);
            }
            System.out.println(sb.toString());
        }
    }
}
