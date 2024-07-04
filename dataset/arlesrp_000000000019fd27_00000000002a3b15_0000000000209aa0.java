
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Arles
 */
public class Solution {

    static LinkedList<Integer> rotate(LinkedList<Integer> qb) {
        //System.out.println("qb:" + qb);
        qb.addLast(qb.removeFirst());
        return qb;
        //System.out.println("qb rotated:" + qb);
    }

    static void rotatel(LinkedList<Integer> qb, int rotaciones) {
        //System.out.println("qb:" + qb);
        for (int i = 0; i < rotaciones; i++) {
            qb.addFirst(qb.removeLast());
        }
        //System.out.println("qb rotated:" + qb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int cases = 1;

        while (cases <= T) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);

            LinkedList<Integer> fil = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                fil.add(i);
            }

            if (n == 1 && k != 1) {
                System.out.println("Case #" + cases + ": IMPOSSIBLE");

            } else {
                if (k % n == 0) {
                    System.out.println("Case #" + cases + ": POSSIBLE");
                    int val = k / n;
                    for (int r = 0; r < n; r++) {
                        while (fil.get(r) != val) {
                            //                           System.out.println(fil);
                            fil = rotate(fil);
                        }
                        StringBuffer sb = new StringBuffer();
                        for (Integer num : fil) {
                            sb.append(num).append(" ");
                        }
                       // sb.delete(sb.length() - 1, sb.length());
                        System.out.println(sb.toString());
                    }
                } else {
                    System.out.println("Case #" + cases + ": IMPOSSIBLE");
                }
            }
            cases++;
        }

    }

}

