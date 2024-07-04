import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.Scanner;

import static java.lang.System.exit;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        int half = b/2;

        for (int i=1; i<=t; i++) {
            StringBuilder out = new StringBuilder(b);
            out.setLength(b);
            StringBuilder sameToReverse = new StringBuilder(half);
            sameToReverse.setLength(half);
            StringBuilder sameToBefore = new StringBuilder(half);
            sameToBefore.setLength(half);

            Boolean before = null;
            int counter = 1;

            int end = (int) Math.ceil(b/2.0);
            for (int j=0; j < end; j++) {

                if (counter % 10 == 0) {
                    System.out.println(j);
                    counter++;
                    before = in.next().charAt(0) == '0';
                    
                    System.out.println(j);
                    counter++;
                    before = in.next().charAt(0) == '0';
                }

                System.out.println(j+1);
                counter++;
                boolean front = in.next().charAt(0) == '0';

                if (j + 1 != b -j) {
                    System.out.println(b - j);
                    counter++;
                    boolean back = in.next().charAt(0) == '0';

                    // fill intermediate arrays
                    sameToReverse.setCharAt(j, front == back ? '0' : '1');
                }

                if (before != null) {
                    sameToBefore.setCharAt(j-1, front == before ? '0' : '1');
                }

                before = front;
                if (counter > 150)
                    exit(1);
            }

            System.out.println(1);
            boolean current = in.next().charAt(0) == '0';

            for (int j=0; j < half; j++) {
                out.setCharAt(j, current ? '0' : '1');
                if (sameToReverse.charAt(j) == '1')
                    out.setCharAt(b-j-1, current ? '1' : '0');
                else
                    out.setCharAt(b-j-1, current ? '0' : '1');

                if (sameToBefore.charAt(j) == '1')
                    current = !current;
            }

            if (end != half) {
                out.setCharAt(half, current ? '0' : '1');
            }

            System.out.println(out);
            // Reading N / Y
            if (in.next().charAt(0) == 'N')
                exit(1);
        }
    }

}
