
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    enum FLUX {COMPLEMENT, REVERSE, COMPLEMENT_REVERSE, NOTHING}

    public static FLUX determineFLux(boolean bo1, boolean bo2, boolean bn1, boolean bn2, boolean bo3, boolean bo4, boolean bn3, boolean bn4) {
        if (!bo1 == bn1 && !bo2 == bn2 && bn3 == !bo3 && bn4 == !bo4) {
            return FLUX.COMPLEMENT;
        } else if (bn1 == !bo1 && bn2 == !bo2 && bn3 == bo3 && bn4 == bo4) {
            return FLUX.REVERSE;
        } else if (bn1 == bo1 && bn2 == bo2 && bn3 == !bo3 && bn4 == !bo4) {
            return FLUX.COMPLEMENT_REVERSE;
        } else if (bn1 == bo1 && bn2 == bo2 && bn3 == bo3 && bn4 == bo4) {
            return FLUX.NOTHING;
        }
        System.err.println("Error");
        return FLUX.NOTHING;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int b = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int remainingAttempts = 150;

            Boolean[] arr = new Boolean[b];
            Arrays.fill(arr, 0, b - 1, null);

            Boolean bo1 = null, bo2 = null;
            Boolean bn1 = null, bn2 = null;
            Boolean bo3 = null, bo4 = null;
            Boolean bn3 = null, bn4 = null;

            boolean foundB1B2 = false, foundB3B4 = false;

            int p1i = -1, p2i = -2, currI = 0;
            while (remainingAttempts > 0) {

                System.out.println(currI + 1); //ask
                int ans = in.nextInt(); //receive

                arr[currI] = ans == 1 ? true : false;

                if (currI >= b - 1) {
                    StringBuffer r = new StringBuffer(b);
                    Arrays.stream(arr).forEach(x -> {
                        if (x) {
                            r.append("1");
                        } else r.append("0");
                    });
                    System.out.println(r.toString());

                    String v = in.next();
                    if (v.compareTo("N") == 0) {
                        System.exit(0);
                    } else{
                        break;
                    }
                }
                currI++;
            }
        }
    }
}